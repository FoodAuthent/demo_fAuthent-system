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

import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Model.TypeEnum;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.Workflow.ModelTypeEnum;
import org.foodauthent.model.PredictionWorkflowInput;
import org.foodauthent.model.PredictionWorkflowOutput;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingWorkflowInput;
import org.foodauthent.model.TrainingWorkflowOutput;
import org.foodauthent.model.Workflow;
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

    private ExecutorService executionService;

    public LocalKnimeJobService() {
	persistenceService = PersistenceServiceProvider.getInstance().getService();
	executionService = Executors.newCachedThreadPool();
    }

    @Override
    public PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet, Model model) {
	Blob wfFile = persistenceService.getBlobByUUID(workflow.getFileId());
	FileMetadata fileMeta = persistenceService.getFaModelByUUID(workflow.getFileId());

	File wfDir;
	List<WorkflowModuleInput> moduleInputs = null;
	try {
	    // extract workflow to a temporary location
	    wfDir = unzipToTempDir(wfFile.getData(), wfFile.getFaId(), "fa_workflow", fileMeta.getName());
	    moduleInputs = prepareWorkflowModules(workflow.getModules(), wfFile.getFaId());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    throw new RuntimeException(e);
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
		.setModuleInputs(moduleInputs)
		.build();
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
	    throw new RuntimeException(e);
	}
	JsonValue jsonInput = Json.createReader(new StringReader(jsonString)).readObject();

	// start and save current prediction job
	PredictionJob predictionJob = PredictionJob.builder().setStatus(StatusEnum.RUNNING).build();
	persistenceService.save(predictionJob);
	asyncLoadAndRunWorkflow(wfDir, jsonInput, "predictionWorkflowInput", "predictionWorkflowOutput", jsonValue -> {
	    // TODO use objectMapper.convertValue instead
	    try {
		PredictionWorkflowOutput predictionOutput = ObjectMapperUtil.getObjectMapper()
			.readValue(jsonValue.toString(), PredictionWorkflowOutput.class);
		Prediction prediction = Prediction.builder().setFingerprintSetId(fingerprintSet.getFaId())
			.setWorkflowId(workflow.getFaId()).setModelId(model.getFaId())
			.setConfidenceMap(predictionOutput.getConfidenceMap()).build();
		persistenceService.save(prediction);

		// change the status and prediction id of the prediction job and replace
		// prediction job in DB
		persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(StatusEnum.SUCCESS)
			.setPredictionId(prediction.getFaId()).build());
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}, (message, exception) -> {
	    // write fail status to DB
	    persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(StatusEnum.FAILED)
		    .setStatusMessage(message).build());

	});
	return predictionJob;
    }

    @Override
    public TrainingJob createNewTrainingJob(Workflow workflow, FingerprintSet fingerprintSet) {
	Blob wfFile = persistenceService.getBlobByUUID(workflow.getFileId());
	FileMetadata fileMeta = persistenceService.getFaModelByUUID(workflow.getFileId());

	File wfDir;
	List<WorkflowModuleInput> moduleInputs = null;
	try {
	    // extract workflow to a temporary location
	    wfDir = unzipToTempDir(wfFile.getData(), wfFile.getFaId(), "fa_workflow", fileMeta.getName());
	    moduleInputs = prepareWorkflowModules(workflow.getModules(), wfFile.getFaId());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}

	// TODO get fingerprint set file(s)

	// assemble workflow input
	TrainingWorkflowInput workflowInput = TrainingWorkflowInput.builder()
		.setFingerprintsetURI("TODO:fingerprintURI").setFingerprintsetMetadata(fingerprintSet)
		.setParameters(workflow.getParameters())
		.setModuleInputs(moduleInputs)
		.build();
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
	asyncLoadAndRunWorkflow(wfDir, jsonInput, "trainingWorkflowInput", "trainingWorkflowOutput", jsonValue -> {
	    // TODO use objectMapper.convertValue instead
	    try {
		TrainingWorkflowOutput trainingOutput = ObjectMapperUtil.getObjectMapper()
			.readValue(jsonValue.toString(), TrainingWorkflowOutput.class);
		//store new model (metadata and file) to the data base
		Model model = Model.builder().setName("generated model by " + workflow.getName())
			.setDate(LocalDate.now())
			.setType(TypeEnum.valueOf(workflow.getModelType().toString().toUpperCase())).build();
		persistenceService.save(model);
		//TODO: store model file!
		//trainingOutput.getModelUri();

		// change the status and model id of the training job and replace
		// training job in DB
		persistenceService.replace(
			TrainingJob.builder(trainingJob).setStatus(org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS)
				.setModelId(model.getFaId()).build());
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}, (message, exception) -> {
	    // write fail status to DB
	    persistenceService.replace(TrainingJob.builder(trainingJob)
		    .setStatus(org.foodauthent.model.TrainingJob.StatusEnum.FAILED).setStatusMessage(message).build());
	});
	persistenceService.save(trainingJob);
	return trainingJob;
    }
    
    /**
     * Loads and asynchronously runs the workflow.
     * 
     * @param wfDir
     *            workflow to run
     * @param input
     *            workflow input as json object
     * @param inputName
     *            the name of the input parameter that takes the json object
     * @param outputName
     *            the name of the output parameter to get the result from
     * @param successCallback
     *            called with the result json object when execution has successfully
     *            finished
     * @param failCallback
     *            called when something failed with a message and an optional(!)
     *            exception
     */
    private void asyncLoadAndRunWorkflow(File wfDir, JsonValue input, String inputName, String outputName,
	    Consumer<JsonValue> successCallback, BiConsumer<String, Exception> failCallback) {
	executionService.submit(() -> {

	    ExternalNodeData data = ExternalNodeData.builder(inputName).jsonValue(input).build();
	    Map<String, ExternalNodeData> inputMap = new HashMap<String, ExternalNodeData>();
	    inputMap.put(data.getID(), data);

	    // load workflow
	    WorkflowManager wfm;
	    try {
		wfm = loadWorkflow(wfDir, null);
		wfm.setInputNodes(inputMap);
	    } catch (IOException | InvalidSettingsException | CanceledExecutionException
		    | UnsupportedWorkflowVersionException | LockFailedException | IllegalStateException e) {
		failCallback.accept("Loading workflow failed: " + e.getMessage(), e);
		return;
	    }

	    if (wfm.executeAllAndWaitUntilDone()) {
		Optional<ExternalNodeData> output = wfm.getExternalOutputs().values().stream()
			.filter(o -> o.getID().equals(outputName)).findFirst();
		if(output.isPresent()) {
		    successCallback.accept(output.get().getJSONValue());
		} else {
		    failCallback.accept("No output with name " + outputName + " available!", null);
		}
	    } else {
		String statusMessage = wfm.getNodeMessages(Type.ERROR, Type.WARNING).stream()
			.map(p -> p.getSecond().getMessage()).collect(Collectors.joining("\n"));
		failCallback.accept(statusMessage, null);
	    }
	});
    }

    private static WorkflowManager loadWorkflow(final File workflowDir, File workflowRoot)
	    throws IOException, InvalidSettingsException, CanceledExecutionException,
	    UnsupportedWorkflowVersionException, LockFailedException, IllegalStateException {
	WorkflowLoadHelper loadHelper = new WorkflowLoadHelper() {
	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public WorkflowContext getWorkflowContext() {
		WorkflowContext.Factory fac = new WorkflowContext.Factory(workflowDir);
		fac.setMountpointRoot(workflowRoot);
		return fac.createContext();
	    }

	    /**
	     * {@inheritDoc}
	     */
	    @Override
	    public UnknownKNIMEVersionLoadPolicy getUnknownKNIMEVersionLoadPolicy(
		    final LoadVersion workflowKNIMEVersion, final Version createdByKNIMEVersion,
		    final boolean isNightlyBuild) {
		return UnknownKNIMEVersionLoadPolicy.Try;
	    }
	};

	WorkflowLoadResult loadRes = WorkflowManager.loadProject(workflowDir, new ExecutionMonitor(), loadHelper);
	if ((loadRes.getType() == LoadResultEntryType.Error)
		|| ((loadRes.getType() == LoadResultEntryType.DataLoadError)
			&& loadRes.getGUIMustReportDataLoadErrors())) {
	    // TODO
	    throw new IllegalStateException("Loading workflow failed: " + loadRes.getMessage());
	}
	return loadRes.getWorkflowManager();
    }

    private static File unzipToTempDir(final byte[] workflowBlob, UUID blobId, String prefix, String workflowName)
	    throws IOException {
	ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(workflowBlob));
	File destDir = new File(KNIMEConstants.getKNIMETempPath().toFile(), prefix + blobId.toString());
	FileUtil.unzip(zipStream, destDir, 0);
	// go to workflow level
	destDir = new File(destDir, workflowName);
	return destDir;
    }
    
    private List<WorkflowModuleInput> prepareWorkflowModules(List<WorkflowModule> modules, UUID masterFileId)
	    throws IOException {
	List<WorkflowModuleInput> moduleInputs = null;
	// extract workflow modules to a temp location (if there are any)
	if (modules != null) {
	    moduleInputs = new ArrayList<WorkflowModuleInput>();
	    for (WorkflowModule m : modules) {
		Blob mFile = persistenceService.getBlobByUUID(m.getFileId());
		FileMetadata fileMeta = persistenceService.getFaModelByUUID(m.getFileId());
		//make sure to extract it at the very same location as the 'master' workflow
		File dir = unzipToTempDir(mFile.getData(), masterFileId, "fa_workflow", fileMeta.getName());
		moduleInputs.add(WorkflowModuleInput.builder().setModuleParameters(m.getModuleParameters())
			.setModuleType(ModuleTypeEnum.valueOf(m.getModuleType().toString().toUpperCase()))
			.setWorkflowURI("/" + dir.getName()).build());
	    }
	}
	return moduleInputs;
    }

}
