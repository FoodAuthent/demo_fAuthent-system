package org.foodauthent.api.internal.job;


import java.util.List;

import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;

public interface JobService {

<<<<<<< HEAD
	PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet, Model model,boolean async)
=======
	PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet, Model model, boolean async)
>>>>>>> ff5442a7cd8441c7cc88c0b6c4bd0b410cb5b020
			throws InitJobException;

	TrainingJob createNewTrainingJob(Workflow workflow, List<FingerprintSet> fingerprintSets, boolean async)
			throws InitJobException;

}
