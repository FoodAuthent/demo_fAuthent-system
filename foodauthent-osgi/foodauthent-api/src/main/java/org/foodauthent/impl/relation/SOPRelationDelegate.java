package org.foodauthent.impl.relation;

import java.util.UUID;

import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintPageResult;
import org.foodauthent.model.Sample;
import org.foodauthent.model.SamplePageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

@Component(service = RelationDelegate.class, immediate = true, scope = ServiceScope.SINGLETON)
public class SOPRelationDelegate implements RelationDelegate {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Override
    public String getEntityName() {
	return RelationDelegate.SOP;
    }

    @Override
    public Object getRelations(String referencedEntity, UUID faId, Integer pageNumber, Integer pageSize) {
	if (RelationDelegate.FINGERPRINT.equals(referencedEntity)) {
	    ResultPage<Fingerprint> res = persistenceService.findByRelationPaged(Fingerprint.class, pageNumber,
		    pageSize, "sop-id.keyword", faId);
	    return FingerprintPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		    .setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
	} else if (RelationDelegate.SAMPLE.equals(referencedEntity)) {
	    ResultPage<Sample> res = persistenceService.findByRelationPaged(Sample.class, pageNumber, pageSize,
		    "sop-id.keyword", faId);
	    return SamplePageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		    .setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
	} else {
	    return null;
	}
    }

}
