package org.foodauthent.impl.relation;

import java.util.UUID;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.PredictionPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

@Component(service = RelationDelegate.class, immediate = true, scope = ServiceScope.SINGLETON)
public class WorkflowRelationDelegate implements RelationDelegate{
    
    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Override
    public String getEntityName() {
	return RelationDelegate.WORKFLOW;
    }

    @Override
    public Object getRelations(String referencedEntity, UUID faId, Integer pageNumber, Integer pageSize) {
	if (RelationDelegate.MODEL.equals(referencedEntity)) {
	    ResultPage<Model> res = persistenceService.findByRelationPaged(Model.class, pageNumber, pageSize,
		    "workflow-id.keyword", faId);
	    return ModelPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		    .setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
	}else if (RelationDelegate.PREDICTION.equals(referencedEntity)) {
	    ResultPage<Prediction> res = persistenceService.findByRelationPaged(Prediction.class, pageNumber, pageSize,
		    "workflow-id.keyword", faId);
	    return PredictionPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		    .setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
	}else {
	return null;
	}
    }

}
