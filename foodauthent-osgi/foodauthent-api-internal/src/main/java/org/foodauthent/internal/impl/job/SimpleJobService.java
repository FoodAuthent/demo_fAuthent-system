package org.foodauthent.internal.impl.job;

import java.time.LocalDate;
import java.util.UUID;

import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 * @author Martin Horn, University of Konstanz
 *
 */
public class SimpleJobService implements JobService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleJobService.class);

    private final PersistenceService persistenceService;

    public SimpleJobService() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
    }

    @Override
    public PredictionJob createNewPredictionJob(final Workflow workflow, final FingerprintSet fingerprintSet) {
	final UUID predictionId = UUID.randomUUID();
	final PredictionJob job = PredictionJob.builder().setFingerprintSetId(fingerprintSet.getFaId())
		.setWorklfowId(workflow.getFaId()).setStatus(StatusEnum.SUCCESS).setPredictionId(predictionId).build();
	final long jobPersistenceId = persistenceService.save(job);
	job.setPersisenceId(jobPersistenceId);
	if (logger.isDebugEnabled()) {
	    logger.debug(job + " persisted");
	}
	// store the prediction result into the DB (for a real job this is done when the
	// job is finished)
	persistenceService.save(Prediction.builder().setFaId(predictionId).setConfidence(.5f).build());
	return job;
    }

    @Override
    public TrainingJob createNewTrainingJob(final Workflow workflow, final FingerprintSet fingerprintSet) {
	final UUID predictionWorkflowId = UUID.randomUUID();
	final TrainingJob job = TrainingJob.builder().setFaId(UUID.randomUUID())
		.setPredictionWorkflowId(predictionWorkflowId).setWorklfowId(workflow.getFaId())
		.setFingerprintsetId(fingerprintSet.getFaId())
		.setStatus(org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS).build();
	final long jobPersistenceId = persistenceService.save(job);
	job.setPersisenceId(jobPersistenceId);
	if (logger.isDebugEnabled()) {
	    logger.debug(job + " persisted");
	}
	// a real job would do this after the job is finished
	persistenceService.save(Workflow.builder().setFaId(predictionWorkflowId).setDate(LocalDate.now()).build());
	return job;
    }

}
