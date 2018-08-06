package org.foodauthent.internal.api.job;

import org.foodauthent.common.exception.FAExceptions.InitJobException;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.Workflow;

public interface JobService {

    PredictionJob createNewPredictionJob(Workflow workflow, FingerprintSet fingerprintSet, Model model)
	    throws InitJobException;

    TrainingJob createNewTrainingJob(Workflow workflow, FingerprintSet fingerprintSet) throws InitJobException;

}
