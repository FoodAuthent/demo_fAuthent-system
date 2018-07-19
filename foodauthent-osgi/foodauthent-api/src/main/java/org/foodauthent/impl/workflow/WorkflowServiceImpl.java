package org.foodauthent.impl.workflow;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.job.JobServiceProvider;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
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
    public PredictionJob createPredictionJob(final UUID workflowId, final UUID fingerprintSetId, UUID modelId) {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId);
	final FingerprintSet fingerprint = persistenceService.getFaModelByUUID(fingerprintSetId);
	final Model model = persistenceService.getFaModelByUUID(modelId);
	final PredictionJob job = jobService.createNewPredictionJob(workflow, fingerprint, model);
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
    public Prediction getPredictionResult(final UUID predictionId) {
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
}
