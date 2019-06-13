package org.foodauthent.impl.relation;

import java.util.UUID;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJobPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

@Component(service = RelationDelegate.class, immediate = true, scope = ServiceScope.SINGLETON)
public class ModelRelationDelegate implements RelationDelegate{

    
    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;
    
    @Override
    public String getEntityName() {
	return RelationDelegate.MODEL;
    }

    @Override
    public Object getRelations(String referencedEntity, UUID faId, Integer pageNumber, Integer pageSize) {
	if (RelationDelegate.PREDICTION.equals(referencedEntity)) {
	    ResultPage<Prediction> res = persistenceService.findByRelationPaged(Prediction.class, pageNumber,
		    pageSize, "model-id.keyword", faId);
	    return PredictionPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		    .setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
	} else if (RelationDelegate.TRAINING_JOB.equals(referencedEntity)) {
	    ResultPage<TrainingJob> res = persistenceService.findByRelationPaged(TrainingJob.class, pageNumber, pageSize,
		    "model-id.keyword", faId);
	    return TrainingJobPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		    .setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
	} else {
	    return null;
	}
    }

}
