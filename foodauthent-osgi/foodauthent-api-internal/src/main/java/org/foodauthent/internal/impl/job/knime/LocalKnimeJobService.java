package org.foodauthent.internal.impl.job.knime;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.PredictionJobBuilder;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Prediction.PredictionBuilder;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.KNIMEConstants;
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
    public PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet) {
	Blob wfFile = persistenceService.getBlobByUUID(workflow.getWorkflowFileId());

	try {
	    // extract workflow to a temporary location
	    File wfDir = unzipToTempDir(wfFile.getData(), wfFile.getFaId());

	    // load workflow
	    WorkflowManager wfm = loadWorkflow(wfDir, null);

	    // create prediction job
	    PredictionJobBuilder predictionJobBuilder = PredictionJob.builder()
		    .setFingerprintSetId(fingerprintSet.getFaId())
		    .setPredictionId(UUID.randomUUID())
		    .setWorklfowId(workflow.getFaId())
		    .setStatus(StatusEnum.RUNNING);
	    PredictionJob predictionJob = predictionJobBuilder.build();
	    persistenceService.save(predictionJob);

	    // start actual prediction job
	    executionService.submit(() -> {
		StatusEnum status;
		if (wfm.executeAllAndWaitUntilDone()) {
		    status = StatusEnum.SUCCESS;
		} else {
		    status = StatusEnum.FAILED;
		}
		
		String statusMessage = wfm.getNodeMessages(Type.ERROR, Type.WARNING).stream()
			.map(p -> p.getSecond().getMessage()).collect(Collectors.joining("\n"));

		// change the status of the prediction job and replace prediction job in DB
		persistenceService
			.replace(predictionJobBuilder.setStatus(status).setStatusMessage(statusMessage).build());

		// TODO write prediction result to DB
		if (status == StatusEnum.SUCCESS) {

		}

		// TODO delete the workflow from the temp-dir
	
	    });
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
	    throw new RuntimeException("Loading workflow failed!");
	}
	return loadRes.getWorkflowManager();
    }

    public static File unzipToTempDir(final byte[] workflowBlob, UUID blobId) throws IOException {
	ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(workflowBlob));
	File destDir = new File(KNIMEConstants.getKNIMETempPath().toFile(), "fa_worklfow_" + blobId.toString());
	FileUtil.unzip(zipStream, destDir, 0);
	// go to workflow level
	destDir = new File(destDir, destDir.list()[0]);
	return destDir;
    }

}
