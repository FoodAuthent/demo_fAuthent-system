package org.foodauthent.internal.impl.job.knime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

import javax.json.JsonValue;

import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.model.FileMetadata;
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
 * 
 * Only class that has knime dependencies!
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class LocalKnimeExecutor implements KnimeExecutor {

	private ExecutorService executionService;

	private final Map<UUID, WorkflowManager> m_workflowMap;

	public LocalKnimeExecutor() {
		executionService = Executors.newCachedThreadPool();
		m_workflowMap = new HashMap<UUID, WorkflowManager>();
	}

	@Override
	public void loadWorkflow(UUID workflowId, FileMetadata workflowMetadata, Blob workflowData)
			throws LoadingFailedException {
		WorkflowManager wfm = loadWorkflowInternal(workflowId, workflowMetadata, workflowData);
		m_workflowMap.put(workflowId, wfm);
	}

	private void disposeWorkflow(UUID workflowId) {
		m_workflowMap.remove(workflowId);
		// TODO
		// remove tmp-directories etc.
		// dipose workflow modules, too
	}

	@Override
	public void asyncRunWorkflow(UUID workflowId, JsonValue input, String inputName, String outputName,
			Consumer<JsonValue> successCallback, BiConsumer<String, Exception> failCallback)
			throws IllegalStateException {
		WorkflowManager wfm = m_workflowMap.get(workflowId);
		if (wfm == null) {
			throw new IllegalStateException("Workflow not available. Please load first.");
		}
		CompletableFuture.runAsync(() -> {
			ExternalNodeData data = ExternalNodeData.builder(inputName).jsonValue(input).build();
			Map<String, ExternalNodeData> inputMap = new HashMap<String, ExternalNodeData>();
			inputMap.put(data.getID(), data);
			try {
				wfm.setInputNodes(inputMap);
			} catch (InvalidSettingsException e) {
				failCallback.accept("Problem setting workflow inputs", e);
			}

			if (wfm.executeAllAndWaitUntilDone()) {
				Optional<ExternalNodeData> output = wfm.getExternalOutputs().values().stream()
						.filter(o -> o.getID().equals(outputName)).findFirst();
				if (output.isPresent()) {
					successCallback.accept(output.get().getJSONValue());
				} else {
					failCallback.accept("No output with name " + outputName + " available!", null);
				}
			} else {
				String statusMessage = wfm.getNodeMessages(Type.ERROR, Type.WARNING).stream()
						.map(p -> p.getSecond().getMessage()).collect(Collectors.joining("\n"));
				failCallback.accept(statusMessage, null);
			}
		}, executionService).thenRun(() -> disposeWorkflow(workflowId));
	}

	private static WorkflowManager loadWorkflowInternal(UUID workflowId, FileMetadata workflowMetadata,
			Blob workflowData) throws LoadingFailedException {
		File workflowDir;
		try {
			workflowDir = unzipToTempDir(workflowId, workflowData.getData(), workflowMetadata.getName());
		} catch (IOException e) {
			throw new LoadingFailedException("Problem unzipping workflow", e);
		}
		WorkflowLoadHelper loadHelper = new WorkflowLoadHelper() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public WorkflowContext getWorkflowContext() {
				WorkflowContext.Factory fac = new WorkflowContext.Factory(workflowDir);
				// fac.setMountpointRoot(workflowRoot);
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
		WorkflowLoadResult loadRes;
		try {
			loadRes = WorkflowManager.loadProject(workflowDir, new ExecutionMonitor(), loadHelper);
		} catch (IOException | InvalidSettingsException | CanceledExecutionException
				| UnsupportedWorkflowVersionException | LockFailedException e) {
			throw new LoadingFailedException("Problem loading workflow", e);
		}
		if ((loadRes.getType() == LoadResultEntryType.Error)
				|| ((loadRes.getType() == LoadResultEntryType.DataLoadError)
						&& loadRes.getGUIMustReportDataLoadErrors())) {
			throw new LoadingFailedException("Loading workflow failed: " + loadRes.getMessage());
		}
		return loadRes.getWorkflowManager();
	}

	private static File unzipToTempDir(UUID blobId, final InputStream workflowBlob, String workflowName) throws IOException {
		String prefix = "fa_workflow_";
		ZipInputStream zipStream = new ZipInputStream(workflowBlob);
		File destDir = new File(KNIMEConstants.getKNIMETempPath().toFile(), prefix + blobId.toString());
		FileUtil.unzip(zipStream, destDir, 0);
		// go to workflow level
		destDir = new File(destDir, workflowName);
		return destDir;
	}

}
