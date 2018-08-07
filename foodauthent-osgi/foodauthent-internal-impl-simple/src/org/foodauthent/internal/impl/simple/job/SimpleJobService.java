package org.foodauthent.internal.impl.simple.job;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.foodauthent.internal.api.job.JobService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.StatusEnum;
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
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service=JobService.class)
public class SimpleJobService implements JobService {

    private static final Logger logger = LoggerFactory.getLogger(SimpleJobService.class);

    private static PersistenceService persistenceService;
    
    @Reference
    void bindPersistenceService(PersistenceService persistenceService) {
    	SimpleJobService.persistenceService = persistenceService;
    }
    @Override
    public PredictionJob createNewPredictionJob(final Workflow workflow, final FingerprintSet fingerprintSet, Model model) {
	final UUID predictionId = UUID.randomUUID();
	final PredictionJob job = PredictionJob.builder().setStatus(StatusEnum.SUCCESS).setPredictionId(predictionId)
		.build();
	if (logger.isDebugEnabled()) {
	    logger.debug(job + " persisted");
	}
	// store the prediction result into the DB (for a real job this is done when the
	// job is finished)
	Map<String, Float> confidences = new HashMap<String, Float>();
	confidences.put("fingerprint-id", 0.5f);
	persistenceService.save(Prediction.builder().setFaId(predictionId).setConfidenceMap(confidences).build());
	return job;
    }

    @Override
    public TrainingJob createNewTrainingJob(final Workflow workflow, final FingerprintSet fingerprintSet) {
	final UUID predictionWorkflowId = UUID.randomUUID();
	final TrainingJob job = TrainingJob.builder().setFaId(UUID.randomUUID())
		.setStatus(org.foodauthent.model.TrainingJob.StatusEnum.SUCCESS).build();
	if (logger.isDebugEnabled()) {
	    logger.debug(job + " persisted");
	}
	// a real job would do this after the job is finished
	persistenceService.save(Workflow.builder().setFaId(predictionWorkflowId).build());
	return job;
    }

}
