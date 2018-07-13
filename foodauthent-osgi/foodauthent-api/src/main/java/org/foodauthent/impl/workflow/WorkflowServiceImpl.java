package org.foodauthent.impl.workflow;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.job.JobServiceProvider;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.DataMetaData;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service=WorkflowService.class)
public class WorkflowServiceImpl implements WorkflowService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    private final PersistenceService persistenceService;

    private JobService jobService;

    public WorkflowServiceImpl() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
	//TODO remove
	this.jobService = JobServiceProvider.getInstance().getService();
    }

    @Reference
    void bindJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public PredictionJob createPredictionJob(final UUID workflowId, final UUID fingerprintSetId) {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId);
	final FingerprintSet fingerprint = persistenceService.getFaModelByUUID(fingerprintSetId);
	final PredictionJob job = jobService.createNewPredictionJob(workflow, fingerprint);
	return job;
    }

    @Override
    public TrainingJob createTrainingJob(final UUID workflowId, final UUID fingerprintSetId) {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId);
	final FingerprintSet fingerprintSet = persistenceService.getFaModelByUUID(fingerprintSetId);
	final TrainingJob job = jobService.createNewTrainingJob(workflow, fingerprintSet);
	return job;
    }

    @Override
    public List<UUID> findPredictionWorkflows(final List<String> keywords) {
	final List<Workflow> workflows = persistenceService.findByKeywords(keywords, Workflow.class);
	return workflows.stream().map(e -> e.getFaId()).collect(Collectors.toList());
    }

    @Override
    public List<UUID> findTrainingWorkflows(final List<String> keywords) {
	final List<Workflow> result = persistenceService.findByKeywords(keywords, Workflow.class);
	return result.stream().map(e -> e.getFaId()).collect(Collectors.toList());
    }

    @Override
    public PredictionJob getPredictionJob(final UUID jobId) {
	return persistenceService.getFaModelByUUID(jobId);
    }

    @Override
    public List<Prediction> getPredictionResult(final UUID predictionId) {
	return persistenceService.getFaModelByUUID(predictionId);
    }

    @Override
    public TrainingJob getTrainingJob(final UUID jobId) {
	return persistenceService.getFaModelByUUID(jobId);
    }

    @Override
    public Workflow getWorkflowById(final UUID workflowId) {
	return persistenceService.getFaModelByUUID(workflowId);
    }

    @Override
    public UUID createWorkflow(final Workflow workflow) {
	persistenceService.save(workflow);
	return workflow.getFaId();
    }
    
    @Override
    public UUID saveWorkflowFile(UUID workflowId, InputStream upfile, FormDataContentDisposition upfileDetail) {
	// TODO check whether there is already a workflow-model entry for the workflow
	// id - otherwise refuse the request
	// TODO it should be possible to store multiple files per UUID, e.g. multiple
	// versions or a data set

	// new uuid for the blob
	UUID blobId = UUID.randomUUID();
	try {
	    persistenceService
		    .save(new Blob(blobId, new DataMetaData(upfileDetail.getFileName()), toByteArray(upfile)));

	    // get workflow metadata, set blobid and override it
	    Workflow wf = persistenceService.getFaModelByUUID(workflowId);
	    Workflow newWf = Workflow.builder(wf).setWorkflowFileId(blobId).build();
	    persistenceService.replace(newWf);
	} catch (IOException e) {
	    // TODO throw appropriate exception
	    throw new RuntimeException(e);
	}
	return workflowId;
    }

    private static byte[] toByteArray(InputStream in) throws IOException {
	// would be cool to be able to use apache's IOUtils
	ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	int nRead;
	byte[] data = new byte[1024];
	while ((nRead = in.read(data, 0, data.length)) != -1) {
	    buffer.write(data, 0, nRead);
	}

	buffer.flush();
	return buffer.toByteArray();
    }

}
