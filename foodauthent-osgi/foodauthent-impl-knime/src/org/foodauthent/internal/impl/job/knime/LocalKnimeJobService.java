package org.foodauthent.internal.impl.job.knime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.json.Json;
import javax.json.JsonValue;

import org.apache.commons.io.IOUtils;
import org.foodauthent.api.internal.job.JobService;
import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.internal.impl.job.knime.KnimeExecutor.LoadingFailedException;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelType;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.PredictionWorkflowInput;
import org.foodauthent.model.PredictionWorkflowOutput;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingWorkflowInput;
import org.foodauthent.model.TrainingWorkflowInputFingerprint;
import org.foodauthent.model.TrainingWorkflowOutput;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.json.ObjectMapperUtil;
import org.knime.core.util.FileUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Martin Horn, University of Konstanz
 */
@Component(service = JobService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class LocalKnimeJobService implements JobService {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private PersistenceService persistenceService;

	private KnimeExecutor knimeExecutor;

	public LocalKnimeJobService() {
		knimeExecutor = new LocalKnimeExecutor();
	}

	@Override
	public PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet, Model model)
			throws InitJobException {
		if(workflow == null) {
			throw new InitJobException("No workflow given");
		}
		if(fingerprintSet == null) {
			throw new InitJobException("No fingerprint set given");
		}
		if(model == null) {
			throw new InitJobException("No model given");
		}
		if (workflow.getType() != org.foodauthent.model.Workflow.TypeEnum.PREDICTION_WORKFLOW) {
			throw new InitJobException("Referenced workflow is not a prediction workflow");
		}

		if (workflow.getRepresentation() != RepresentationEnum.KNIME) {
			throw new InitJobException("Referenced workflow is not a knime workflow");
		}

		try {
			loadWorkflow(workflow);
		} catch (LoadingFailedException e1) {
			throw new InitJobException("Problem initializing job: " + e1.getMessage(), e1);
		}

		// check whether the model is compatible with the workflow
		assert workflow.getInputTypes().getModelType().getName().toString()
				.equals(model.getType().getName().toString());
		// TODO otherwise throw proper exception

		// get fingerprint set file(s)
		List<String> tempFingerprintFileURIs = fingerprintSet.getFingerprintIds().stream()
				.map(id -> saveTemporaryFingerprintFile(id).toString()).collect(Collectors.toList());

		// TODO get actual model file
		// persistenceService.getBlobByUUID(model.getModelFileId());

		// assemble workflow input
		PredictionWorkflowInput workflowInput = PredictionWorkflowInput.builder()
				.setFingerprintURIs(tempFingerprintFileURIs).setModelURI("TODO:modelURI")
				.setFingerprintset(fingerprintSet).setParameters(workflow.getParameters()).build();

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
		// TODO dispose worklfow!
		knimeExecutor.asyncRunWorkflow(workflow.getFaId(), jsonInput, "predictionWorkflowInput",
				"predictionWorkflowOutput", jsonValue -> {
					// TODO use objectMapper.convertValue instead
					PredictionWorkflowOutput predictionOutput;
					try {
						predictionOutput = ObjectMapperUtil.getObjectMapper().readValue(jsonValue.toString(),
								PredictionWorkflowOutput.class);
					} catch (IOException e) {
						persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(StatusEnum.FAILED)
								.setStatusMessage("Failed to read workflow output: " + e.getMessage()).build());
						return;
					}
					Prediction prediction = Prediction.builder().setFingerprintsetId(fingerprintSet.getFaId())
							.setWorkflowId(workflow.getFaId()).setModelId(model.getFaId())
							.setClassLabels(model.getClassLabels())
							.setPredictionMap(predictionOutput.getPredictionMap()).build();
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
	public TrainingJob createNewTrainingJob(final Workflow workflow, final List<FingerprintSet> fingerprintSets) throws InitJobException {
		if(workflow == null) {
			throw new InitJobException("No workflow given");
		}
		if(fingerprintSets == null) {
			throw new InitJobException("No fingerprint set given");
		}
		if (workflow.getType() != org.foodauthent.model.Workflow.TypeEnum.TRAINING_WORKFLOW) {
			// TODO throw appropriate exception
			throw new InitJobException("Referenced workflow is not a prediction workflow");
		}

		if (workflow.getRepresentation() != RepresentationEnum.KNIME) {
			throw new InitJobException("Referenced workflow is not a knime workflow");
		}

		try {
			loadWorkflow(workflow);
		} catch (LoadingFailedException e1) {
			throw new InitJobException("Problem initializing job: " + e1.getMessage(), e1);
		}
		
		

		List<TrainingWorkflowInputFingerprint> fpInputs = new ArrayList<>();
		for(FingerprintSet fps : fingerprintSets) {
			for(UUID fpId : fps.getFingerprintIds()) {
				fpInputs.add(TrainingWorkflowInputFingerprint.builder()
					.setClassLabel(fps.getClassLabel())
					.setFingerprintId(fpId)
					.setURI(saveTemporaryFingerprintFile(fpId).toString()).build());
			}
		}

		// assemble workflow input
		TrainingWorkflowInput workflowInput = TrainingWorkflowInput.builder()
				.setFingerprints(fpInputs)
				.setParameters(workflow.getParameters()).build();
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
					ModelType modelType = ModelType.builder()
							.setName(ModelType.NameEnum.valueOf(
									workflow.getOutputTypes().getModelType().getName().toString().toUpperCase()))
							.build();
					Model model = Model.builder().setName("generated model by " + workflow.getName())
							.setDate(LocalDate.now())
							.setType(modelType)
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
	
	private URI saveTemporaryFingerprintFile(UUID fingerprintId) {
			Fingerprint fp = persistenceService.getFaModelByUUID(fingerprintId, Fingerprint.class);
			Blob fingerprintFile = persistenceService.getBlobByUUID(fp.getFileId());
			try {
				File tmpFile = File.createTempFile("fa_fingerprint_" + fingerprintFile.getFaId(), ".zip");
				FileOutputStream out = new FileOutputStream(tmpFile);
				IOUtils.copy(fingerprintFile.getData(), out);
				out.flush();
				out.close();
				Path tmpDir = Files.createTempDirectory("fa_fingerprint_" + fingerprintFile.getFaId());
				FileUtil.unzip(tmpFile, tmpDir.toFile());
				tmpFile.delete();
				// TODO delete tmp files
				tmpDir.toFile().deleteOnExit();
				return tmpDir.toUri();
			} catch (IOException e1) {
				// TODO
				throw new RuntimeException(e1);
			}
	}

	private void loadWorkflow(Workflow workflow) throws LoadingFailedException {
		Blob wfFile = persistenceService.getBlobByUUID(workflow.getFileId());
		FileMetadata fileMeta = persistenceService.getFaModelByUUID(workflow.getFileId(), FileMetadata.class);
		knimeExecutor.loadWorkflow(workflow.getFaId(), fileMeta, wfFile);
	}
}
