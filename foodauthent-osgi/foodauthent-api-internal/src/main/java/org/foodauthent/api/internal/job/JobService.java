package org.foodauthent.api.internal.job;


import java.util.List;
import java.util.UUID;

import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;

public interface JobService {

	PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet, Model model, List<UUID> objecteventIds, boolean async)
			throws InitJobException;

	TrainingJob createNewTrainingJob(Workflow workflow, List<FingerprintSet> fingerprintSets, boolean async)
			throws InitJobException;

}
