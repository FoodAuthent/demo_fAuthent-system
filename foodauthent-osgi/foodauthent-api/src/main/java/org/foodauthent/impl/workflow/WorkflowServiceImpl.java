package org.foodauthent.impl.workflow;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJobPageResult;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJobPageResult;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.WorkflowPageResult;
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

    private PersistenceService persistenceService;

    private JobService jobService;

    public WorkflowServiceImpl() {
    }

    @Reference
    void bindJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @Reference
    void bindPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }
    
    @Override
    public PredictionJob createPredictionJob(final UUID workflowId, final UUID fingerprintSetId, UUID modelId)
	    throws InitJobException {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId, Workflow.class);
	final FingerprintSet fingerprint = persistenceService.getFaModelByUUID(fingerprintSetId, FingerprintSet.class);
	final Model model = persistenceService.getFaModelByUUID(modelId, Model.class);
	final PredictionJob job = jobService.createNewPredictionJob(workflow, fingerprint, model);
	return job;
    }

    @Override
    public TrainingJob createTrainingJob(final UUID workflowId, final UUID fingerprintSetId) throws InitJobException {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId, Workflow.class);
	final FingerprintSet fingerprintSet = persistenceService.getFaModelByUUID(fingerprintSetId, FingerprintSet.class);
	final TrainingJob job = jobService.createNewTrainingJob(workflow, fingerprintSet);
	return job;
    }

    @Override
    public PredictionJob getPredictionJob(final UUID jobId) {
	return persistenceService.getFaModelByUUID(jobId, PredictionJob.class);
    }

    @Override
    public Prediction getPredictionResult(final UUID predictionId) {
	return persistenceService.getFaModelByUUID(predictionId, Prediction.class);
    }

    @Override
    public TrainingJob getTrainingJob(final UUID jobId) {
	return persistenceService.getFaModelByUUID(jobId, TrainingJob.class);
    }

    @Override
    public Workflow getWorkflowById(final UUID workflowId) {
	return persistenceService.getFaModelByUUID(workflowId, Workflow.class);
    }

    @Override
    public UUID createWorkflow(final Workflow workflow) {
	persistenceService.save(workflow);
	return workflow.getFaId();
    }

    @Override
    public PredictionPageResult findModelByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PredictionJobPageResult findPredictionJobs(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public WorkflowPageResult findPredictionWorkflows(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public TrainingJobPageResult findTrainingJobs(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public WorkflowPageResult findTrainingWorkflows(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }
}
