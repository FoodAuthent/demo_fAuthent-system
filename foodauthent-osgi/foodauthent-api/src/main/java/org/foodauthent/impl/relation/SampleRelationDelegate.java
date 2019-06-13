package org.foodauthent.impl.relation;

import java.util.UUID;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

@Component(service = RelationDelegate.class, immediate = true, scope = ServiceScope.SINGLETON)
public class SampleRelationDelegate implements RelationDelegate {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;
    
    @Override
    public String getEntityName() {
	return RelationDelegate.SAMPLE;
    }

    @Override
    public Object getRelations(String referencedEntity, UUID faId, Integer pageNumber, Integer pageSize) {
	if (RelationDelegate.FINGERPRINT.equals(referencedEntity)) {
	    ResultPage<Fingerprint> res = persistenceService.findByRelationPaged(Fingerprint.class, pageNumber, pageSize,
		    "sample-id.keyword", faId);
	    return FingerprintPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		    .setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
	}
	return null;
    }

}
