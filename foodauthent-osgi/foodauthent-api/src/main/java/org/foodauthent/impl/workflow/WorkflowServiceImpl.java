package org.foodauthent.impl.workflow;

import static org.foodauthent.api.internal.persistence.PersistenceService.toArray;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.api.internal.job.JobService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJobPageResult;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJobPageResult;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.TypeEnum;
import org.foodauthent.model.WorkflowPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service = WorkflowService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class WorkflowServiceImpl implements WorkflowService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private JobService jobService;

    public WorkflowServiceImpl() {
    }

    @Override
    public PredictionJob createPredictionJob(final UUID workflowId, final UUID fingerprintSetId, UUID modelId,
	    Boolean async) throws InitJobException {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId, Workflow.class);
	final FingerprintSet fingerprint = persistenceService.getFaModelByUUID(fingerprintSetId, FingerprintSet.class);
	final Model model = persistenceService.getFaModelByUUID(modelId, Model.class);
	final PredictionJob job = jobService.createNewPredictionJob(workflow, fingerprint, model, async);
	return job;
    }

    @Override
    public TrainingJob createTrainingJob(final UUID workflowId, final List<UUID> fingerprintSetIds, Boolean async)
	    throws InitJobException {
	final Workflow workflow = persistenceService.getFaModelByUUID(workflowId, Workflow.class);
	List<FingerprintSet> fingerprintSets = fingerprintSetIds.stream()
		.map(uuid -> persistenceService.getFaModelByUUID(uuid, FingerprintSet.class))
		.collect(Collectors.toList());
	final TrainingJob job = jobService.createNewTrainingJob(workflow, fingerprintSets, async);
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
    public WorkflowPageResult findWorkflowByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Workflow> res = persistenceService.findByKeywordsPaged(Workflow.class, pageNumber, pageSize,
		toArray(keywords));
	return WorkflowPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public PredictionPageResult findPredictionByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Prediction> res = persistenceService.findByKeywordsPaged(Prediction.class, pageNumber, pageSize,
		toArray(keywords));
	return PredictionPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public PredictionJobPageResult findPredictionJobs(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<PredictionJob> res = persistenceService.findByKeywordsPaged(PredictionJob.class,
		pageNumber, pageSize, toArray(keywords));
	return PredictionJobPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public WorkflowPageResult findPredictionWorkflows(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Workflow> res = persistenceService.findByKeywordsPaged(Workflow.class, pageNumber, pageSize,
		toArray(keywords), toArray(TypeEnum.PREDICTION_WORKFLOW_E680F8C1.toString()));
	return WorkflowPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public TrainingJobPageResult findTrainingJobs(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<TrainingJob> res = persistenceService.findByKeywordsPaged(TrainingJob.class, pageNumber, pageSize,
		toArray(keywords));
	return TrainingJobPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public WorkflowPageResult findTrainingWorkflows(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Workflow> res = persistenceService.findByKeywordsPaged(Workflow.class, pageNumber, pageSize,
		toArray(keywords), toArray(TypeEnum.TRAINING_WORKFLOW_64B046CB.toString()));
	return WorkflowPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }
  
    @Override
    public PredictionPageResult findPredictionsByFingerprintSetId(UUID fingerprintsetId, Integer pageNumber,
	    Integer pageSize, List<String> keywords) {
	ResultPage<Prediction> res = persistenceService.findByKeywordsPaged(Prediction.class, pageNumber, pageSize,
		toArray(keywords), toArray(fingerprintsetId.toString()));
	return PredictionPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }
}
