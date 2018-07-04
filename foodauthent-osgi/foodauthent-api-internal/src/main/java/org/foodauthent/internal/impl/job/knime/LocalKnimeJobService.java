package org.foodauthent.internal.impl.job.knime;

import java.io.File;
import java.io.IOException;

import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.ExecutionMonitor;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.workflow.FileWorkflowPersistor.LoadVersion;
import org.knime.core.node.workflow.UnsupportedWorkflowVersionException;
import org.knime.core.node.workflow.WorkflowContext;
import org.knime.core.node.workflow.WorkflowLoadHelper;
import org.knime.core.node.workflow.WorkflowManager;
import org.knime.core.node.workflow.WorkflowPersistor.LoadResultEntry.LoadResultEntryType;
import org.knime.core.node.workflow.WorkflowPersistor.WorkflowLoadResult;
import org.knime.core.util.LockFailedException;
import org.knime.core.util.Version;

/**
 * @author Martin Horn, University of Konstanz
 */
public class LocalKnimeJobService implements JobService {
	
	private PersistenceService persistenceService;

	public LocalKnimeJobService() {
		persistenceService = PersistenceServiceProvider.getInstance().getService();
	}

	@Override
	public PredictionJob createNewPredictionJob(Workflow workflow, Fingerprint fingerprint) {
		Blob wfFile = persistenceService.getBlobByUUID(workflow.getFaId());
		//extract workflow to a temporary location
		
		//load workflow
		
		//run workflow
		return null;
	}

	@Override
	public TrainingJob createNewTrainingJob(Workflow workflow, FingerprintSet fingerprintSet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static WorkflowManager loadWorkflow(final File workflowDir, File workflowRoot) throws IOException, InvalidSettingsException,
			CanceledExecutionException, UnsupportedWorkflowVersionException, LockFailedException {
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
			//TODO
			throw new RuntimeException("Loading workflow failed!");
		}
		return loadRes.getWorkflowManager();
	}

}
