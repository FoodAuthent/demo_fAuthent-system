package org.foodauthent.internal.impl.job.knime;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.json.JsonValue;

import org.foodauthent.api.internal.persistence.Blob;
import org.foodauthent.model.FileMetadata;

/**
 * Interface to separate fa-system knime-job logic from the pure execution of
 * workflows. Implementations can, e.g., do the execution locally or, e.g.,
 * delegate it to a 'remote' knime executor.
 * 
 * Implementations should be the only classes that have KNIME-dependencies.
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public interface KnimeExecutor {

    /**
     * Loads the given workflow.
     * 
     * @param workflowId
     *            id of the workflow to load
     * @param workflowMetadata
     *            metadata of the workflow file
     * @param workflowData
     *            the workflow binaries
     * @throws LoadingFailedException
     *             if the workflow couln't be loaded
     */
    void loadWorkflow(UUID workflowId, FileMetadata workflowMetadata, Blob workflowData) throws LoadingFailedException;

    /**
	 * TODO - also pass the data (fingerprints, models etc.) along!!
	 * 
	 * Asynchronously runs (i.e. returns immediately) the workflow. The workflow for
	 * the given id need to be loaded first!
	 * 
	 * @param workflowId
	 *            id of the workflow to run
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
	 * @param async
	 *            whether to run the workflow asynchronously. If false, method will
	 *            block till workflow is finished
	 * @throws IllegalStateException
	 *             if the workflow for the id hasn't been loaded, yet.
	 */
    //return a CompletableFuture instead?
    void runWorkflow(UUID workflowId, JsonValue input, String inputName, String outputName,
	    Consumer<JsonValue> successCallback, BiConsumer<String, Exception> failCallback, boolean async)
	    throws IllegalStateException;
    
	File saveWorklfow(UUID workflowId) throws IOException;
    
    /**
     * When a workflow couldn't be loaded.
     */
    public class LoadingFailedException extends Exception {

	public LoadingFailedException(String message, Throwable cause) {
	    super(message, cause);
	}

	public LoadingFailedException(String message) {
	    super(message);
	}

    }

}
