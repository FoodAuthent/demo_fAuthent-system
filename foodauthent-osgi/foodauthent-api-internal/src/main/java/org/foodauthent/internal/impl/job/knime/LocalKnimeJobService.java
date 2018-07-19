package org.foodauthent.internal.impl.job.knime;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

import javax.json.Json;
import javax.json.JsonValue;

import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.PredictionWorkflowInput;
import org.foodauthent.model.PredictionWorkflowOutput;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
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
	Blob wfFile = persistenceService.getBlobByUUID(workflow.getWorkflowFileId());

	try {
	    // extract workflow to a temporary location
	    File wfDir = unzipToTempDir(wfFile.getData(), wfFile.getFaId(), "fa_workflow");
	    
	    //TODO get fingerprint set file(s)
	    
	    //check whether the model is compatible with the workflow
	    assert workflow.getType().toString().equals(model.getWorkflowType().toString());
	    //TODO otherwise throw proper exception
	    
	    //TODO get actual model file
	    //persistenceService.getBlobByUUID(model.getModelFileId());

	    // assemble workflow input
	    PredictionWorkflowInput workflowInput = PredictionWorkflowInput.builder()
		    .setFingerprintSetURI("TODO:fingerprintURI").setModelURI("TODO:modelURI")
		    .setFingerprintSetMetadata(fingerprintSet).setParameters(workflow.getParameters())
		    //pass module's parameters
		    .setModules(workflow.getModules()).build();
	    // TODO doesn't work, but should
	    // JsonValue jsonInput =
	    // ObjectMapperUtil.getObjectMapper().convertValue(workflowInput,
	    // JsonValue.class);
	    String jsonString = ObjectMapperUtil.getObjectMapper().writerWithDefaultPrettyPrinter()
		    .writeValueAsString(workflowInput);
	    JsonValue jsonInput = Json.createReader(new StringReader(jsonString)).readObject();
	    ExternalNodeData data = ExternalNodeData.builder("predictionWorkflowInput").jsonValue(jsonInput).build();
	    Map<String, ExternalNodeData> inputMap = new HashMap<String, ExternalNodeData>();
	    inputMap.put(data.getID(), data);

	    // load workflow
	    WorkflowManager wfm = loadWorkflow(wfDir, null);
	    wfm.setInputNodes(inputMap);

	    // start and save actual prediction job
	    PredictionJob predictionJob = PredictionJob.builder().setStatus(StatusEnum.RUNNING).build();
	    executionService.submit(() -> {
		StatusEnum status;
		if (wfm.executeAllAndWaitUntilDone()) {
		    status = StatusEnum.SUCCESS;
		} else {
		    status = StatusEnum.FAILED;
		}

		String statusMessage = wfm.getNodeMessages(Type.ERROR, Type.WARNING).stream()
			.map(p -> p.getSecond().getMessage()).collect(Collectors.joining("\n"));

		// get prediction result and write to DB
		if (status == StatusEnum.SUCCESS) {
		    JsonValue jsonOutput = wfm.getExternalOutputs().values().stream()
			    .filter(o -> o.getID().equals("predictionWorkflowOutput")).findFirst().get().getJSONValue();
		    // TODO use objectMapper.convertValue instead
		    try {
			PredictionWorkflowOutput predictionOutput = ObjectMapperUtil.getObjectMapper()
				.readValue(jsonOutput.toString(), PredictionWorkflowOutput.class);
			Prediction prediction = Prediction.builder().setFingerprintSetId(fingerprintSet.getFaId())
				.setWorkflowId(workflow.getFaId()).setModelId(model.getFaId())
				.setConfidenceMap(predictionOutput.getConfidenceMap()).build();
			persistenceService.save(prediction);

			// change the status and prediction id of the prediction job and replace
			// prediction job in DB
			persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(status)
				.setStatusMessage(statusMessage).setPredictionId(prediction.getFaId()).build());
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} else {
		    // write fail status to DB
		    persistenceService.replace(PredictionJob.builder(predictionJob).setStatus(status)
			    .setStatusMessage(statusMessage).build());
		}

		// TODO delete the workflow(s), fingerprint and models from the temp-dir
	    });
	    // create prediction job
	    persistenceService.save(predictionJob);
	    return predictionJob;
	} catch (IOException | InvalidSettingsException | CanceledExecutionException
		| UnsupportedWorkflowVersionException | LockFailedException e) {
	    // TODO Auto-generated catch block
	    throw new RuntimeException(e);
	}
    }

    @Override
    public TrainingJob createNewTrainingJob(Workflow workflow, FingerprintSet fingerprintSet) {
	// TODO Auto-generated method stub
	return null;
    }

    private static WorkflowManager loadWorkflow(final File workflowDir, File workflowRoot)
	    throws IOException, InvalidSettingsException, CanceledExecutionException,
	    UnsupportedWorkflowVersionException, LockFailedException {
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
	    throw new RuntimeException("Loading workflow failed: " + loadRes.getMessage());
	}
	return loadRes.getWorkflowManager();
    }

    private static File unzipToTempDir(final byte[] workflowBlob, UUID blobId, String prefix) throws IOException {
	ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(workflowBlob));
	File destDir = new File(KNIMEConstants.getKNIMETempPath().toFile(), prefix + blobId.toString());
	FileUtil.unzip(zipStream, destDir, 0);
	// go to workflow level
	destDir = new File(destDir, destDir.list()[0]);
	return destDir;
    }

}
