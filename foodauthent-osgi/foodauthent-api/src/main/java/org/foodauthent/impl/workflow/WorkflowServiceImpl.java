package org.foodauthent.impl.workflow;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.job.JobServiceProvider;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class WorkflowServiceImpl implements WorkflowService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    private final PersistenceService persistenceService;

    private final JobService jobService;

    public WorkflowServiceImpl() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
	this.jobService = JobServiceProvider.getInstance().getService();
    }

    @Override
    public PredictionJob createPredictionJob(final UUID workflowId, final UUID fingerprintId) {
	final Workflow workflow = persistenceService.getByUUID(workflowId);
	final Fingerprint fingerprint = persistenceService.getByUUID(fingerprintId);
	final PredictionJob job = jobService.createNewPredictionJob(workflow, fingerprint);
	return job;
    }

    @Override
    public TrainingJob createTrainingJob(final UUID workflowId, final UUID fingerprintSetId) {
	final Workflow workflow = persistenceService.getByUUID(workflowId);
	final FingerprintSet fingerprintSet = persistenceService.getByUUID(fingerprintSetId);
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
	return persistenceService.getByUUID(jobId);
    }

    @Override
    public List<Prediction> getPredictionResult(final UUID predictionId) {
	return persistenceService.getByUUID(predictionId);
    }

    @Override
    public TrainingJob getTrainingJob(final UUID jobId) {
	return persistenceService.getByUUID(jobId);
    }

    @Override
    public Workflow getWorkflowById(final UUID workflowId) {
	return persistenceService.getByUUID(workflowId);
    }

    @Override
    public UUID createWorkflow(final Workflow workflow) {
	persistenceService.save(workflow);
	return workflow.getFaId();
    }

}
