package org.foodauthent.internal.impl.job.knime;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

import javax.json.Json;
import javax.json.JsonValue;

import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.internal.impl.job.knime.KnimeExecutor.LoadingFailedException;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Model.TypeEnum;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.PredictionWorkflowInput;
import org.foodauthent.model.PredictionWorkflowOutput;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingWorkflowInput;
import org.foodauthent.model.TrainingWorkflowOutput;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.WorkflowModule;
import org.foodauthent.model.WorkflowModuleInput;
import org.foodauthent.model.WorkflowModuleInput.ModuleTypeEnum;
import org.foodauthent.model.json.ObjectMapperUtil;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.KNIMEConstants;
import org.knime.core.node.dialog.ExternalNodeData;
import org.knime.core.node.workflow.FileWorkflowPersistor.LoadVersion;
import org.knime.core.node.workflow.NodeMessage.Type;
import org.knime.core.node.workflow.UnsupportedWorkflowVersionException;
import org.knime.core.node.workflow.WorkflowContext;
import org.knime.core.node.workflow.WorkflowLoadHelper;
import org.knime.core.node.workflow.WorkflowManager;
import org.knime.core.node.workflow.WorkflowPersistor.LoadResultEntry.LoadResultEntryType;
import org.knime.core.node.workflow.WorkflowPersistor.WorkflowLoadResult;
import org.knime.core.util.FileUtil;
import org.knime.core.util.LockFailedException;
import org.knime.core.util.Version;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Martin Horn, University of Konstanz
 */
public class LocalKnimeJobService implements JobService {

    private PersistenceService persistenceService;

    private KnimeExecutor knimeExecutor;

    public LocalKnimeJobService() {
	persistenceService = PersistenceServiceProvider.getInstance().getService();
	knimeExecutor = new LocalKnimeExecutor();
    }

    @Override
    public PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet, Model model)
	    throws InitJobException {
	if (workflow.getType() != org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW) {
	    throw new InitJobException("Referenced workflow is not a prediction workflow");
	}

	if (workflow.getRepresentation() != RepresentationEnum.KNIME) {
	    throw new InitJobException("Referenced workflow is not a knime workflow");
	}

	List<WorkflowModuleInput> moduleInputs;
	try {
	    moduleInputs = loadWorkflowAndPrepareInputs(workflow);
	} catch (LoadingFailedException e1) {
	    throw new InitJobException("Problem initializing job", e1);
	}

	// TODO get fingerprint set file(s)

	// check whether the model is compatible with the workflow
	assert workflow.getModelType().toString().equals(model.getType().toString());
	// TODO otherwise throw proper exception

	// TODO get actual model file
	// persistenceService.getBlobByUUID(model.getModelFileId());

	// assemble workflow input
	PredictionWorkflowInput workflowInput = PredictionWorkflowInput.builder()
		.setFingerprintsetURI("TODO:fingerprintURI").setModelURI("TODO:modelURI")
		.setFingerprintsetMetadata(fingerprintSet).setParameters(workflow.getParameters())
		.setModuleInputs(moduleInputs).build();
	// TODO doesn't work, but should
	// JsonValue jsonInput =
	// ObjectMapperUtil.getObjectMapper().convertValue(workflowInput,
	// JsonValue.class);
	String jsonString;
	try {
	    jsonString = ObjectMapperUtil.getObjectMapper().writerWithDefaultPrettyPrinter()
		    .writeValueAsString(workflowInput);
	} catch (JsonProcessingException e) {
	    throw new InitJobException("Problem while creating workflow input", e);
	}
	JsonValue jsonInput = Json.createReader(new StringReader(jsonString)).readObject();

	// start and save current prediction job
	PredictionJob predictionJob = PredictionJob.builder().setStatus(StatusEnum.RUNNING).build();
	persistenceService.save(predictionJob);
	//TODO dispose worklfow!
	knimeExecutor.asyncRunWorkflow(workflow.getFaId(), jsonInput, "predictionWorkflowInput",
		"predictionWorkflowOutput", jsonValue -> {
		    // TODO use objectMapper.convertValue instead
		    PredictionWorkflowOutput predictionOutput;
		    try {
			predictionOutput = ObjectMapperUtil.getObjectMapper()
			    .readValue(jsonValue.toString(), PredictionWorkflowOutput.class);
		    } catch (IOException e) {
			persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(StatusEnum.FAILED)
				.setStatusMessage("Failed to read workflow output: " + e.getMessage()).build());
			return;
		    }
		    Prediction prediction = Prediction.builder().setFingerprintSetId(fingerprintSet.getFaId())
			    .setWorkflowId(workflow.getFaId()).setModelId(model.getFaId())
			    .setConfidenceMap(predictionOutput.getConfidenceMap()).build();
		    persistenceService.save(prediction);

		    // change the status and prediction id of the prediction job and replace
		    // prediction job in DB
		    persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(StatusEnum.SUCCESS)
			    .setPredictionId(prediction.getFaId()).build());
		}, (message, exception) -> {
		    // write fail status to DB
		    persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(StatusEnum.FAILED)
			    .setStatusMessage(message).build());

		});
	return predictionJob;
    }

    @Override
    public TrainingJob createNewTrainingJob(Workflow workflow, FingerprintSet fingerprintSet) throws InitJobException {
	if (workflow.getType() != org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW) {
	    // TODO throw appropriate exception
	    throw new InitJobException("Referenced workflow is not a prediction workflow");
	}

	if (workflow.getRepresentation() != RepresentationEnum.KNIME) {
	    throw new InitJobException("Referenced workflow is not a knime workflow");
	}

	List<WorkflowModuleInput> moduleInputs;
	try {
	    moduleInputs = loadWorkflowAndPrepareInputs(workflow);
	} catch (LoadingFailedException e1) {
	    throw new InitJobException("Problem initializing job", e1);
	}

	// TODO get fingerprint set file(s)

	// assemble workflow input
	TrainingWorkflowInput workflowInput = TrainingWorkflowInput.builder()
		.setFingerprintsetURI("TODO:fingerprintURI").setFingerprintsetMetadata(fingerprintSet)
		.setParameters(workflow.getParameters()).setModuleInputs(moduleInputs).build();
	// TODO doesn't work, but should
	// JsonValue jsonInput =
	// ObjectMapperUtil.getObjectMapper().convertValue(workflowInput,
	// JsonValue.class);
	String jsonString;
	try {
	    jsonString = ObjectMapperUtil.getObjectMapper().writerWithDefaultPrettyPrinter()
		    .writeValueAsString(workflowInput);
	} catch (JsonProcessingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}
	JsonValue jsonInput = Json.createReader(new StringReader(jsonString)).readObject();

	// start and save current training job
	TrainingJob trainingJob = TrainingJob.builder().setStatus(org.foodauthent.model.TrainingJob.StatusEnum.RUNNING)
		.build();

	knimeExecutor.asyncRunWorkflow(workflow.getFaId(), jsonInput, "trainingWorkflowInput", "trainingWorkflowOutput",
		jsonValue -> {
		    // TODO use objectMapper.convertValue instead
		    TrainingWorkflowOutput trainingOutput;
		    try {
			trainingOutput = ObjectMapperUtil.getObjectMapper().readValue(jsonValue.toString(),
				TrainingWorkflowOutput.class);
		    } catch (IOException e) {
			persistenceService.replace(TrainingJob.builder(trainingJob)
				.setStatus(org.foodauthent.model.TrainingJob.StatusEnum.FAILED)
				.setStatusMessage("Failed to read workflow output: " + e.getMessage()).build());
			return;
		    }
		    // TODO: store model file!
		    String modelUri = trainingOutput.getModelUri();
		    UUID modelFileId = UUID.randomUUID();
		    
		    // store new model (metadata and file) to the data base
		    Model model = Model.builder().setName("generated model by " + workflow.getName())
			    .setDate(LocalDate.now())
			    .setType(TypeEnum.valueOf(workflow.getModelType().toString().toUpperCase()))
			    .setFileId(modelFileId).build();
		    persistenceService.save(model);

		    // change the status and model id of the training job and replace
		    // training job in DB
		    persistenceService.replace(TrainingJob.builder(trainingJob)
			    .setStatus(org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS).setModelId(model.getFaId())
			    .build());
		}, (message, exception) -> {
		    // write fail status to DB
		    persistenceService.replace(TrainingJob.builder(trainingJob)
			    .setStatus(org.foodauthent.model.TrainingJob.StatusEnum.FAILED).setStatusMessage(message)
			    .build());
		});
	persistenceService.save(trainingJob);
	return trainingJob;
    }

    private List<WorkflowModuleInput> loadWorkflowAndPrepareInputs(Workflow workflow) throws LoadingFailedException {
	Blob wfFile = persistenceService.getBlobByUUID(workflow.getFileId());
	FileMetadata fileMeta = persistenceService.getFaModelByUUID(workflow.getFileId());
	List<WorkflowModuleInput> moduleInputs = null;
	if (workflow.getModules().isEmpty()) {
	    knimeExecutor.loadWorkflow(workflow.getFaId(), fileMeta, wfFile);
	} else {
	    FileMetadata[] mMetadata = workflow.getModules().stream()
		    .map(m -> persistenceService.getFaModelByUUID(m.getFileId()))
		    .toArray(size -> new FileMetadata[size]);
	    Blob[] mData = workflow.getModules().stream().map(m -> persistenceService.getBlobByUUID(m.getFileId()))
		    .toArray(size -> new Blob[size]);
	    String[] moduleRefs = knimeExecutor.loadWorkflowWithModules(workflow.getFaId(), fileMeta, wfFile, mMetadata,
		    mData);
	    moduleInputs = new ArrayList<WorkflowModuleInput>();
	    for (int i = 0; i < moduleRefs.length; i++) {
		WorkflowModule m = workflow.getModules().get(i);
		moduleInputs.add(WorkflowModuleInput.builder().setModuleParameters(m.getModuleParameters())
			.setModuleType(ModuleTypeEnum.valueOf(m.getModuleType().toString().toUpperCase()))
			.setWorkflowURI(moduleRefs[i]).build());
	    }
	}
	return moduleInputs;
    }
}
