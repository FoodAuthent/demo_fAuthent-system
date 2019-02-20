package org.foodauthent.impl.objectevent;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.ObjectEventService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.ObjectEvent;
import org.foodauthent.model.ObjectEventPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 *
 * @author Massimo Bevilacqua, Benelog GmbH
 *
 */
@Component(service = ObjectEventService.class)
public class ObjectEventServiceImpl implements ObjectEventService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    @Override
    public ObjectEventPageResult findObjectEventByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<ObjectEvent> res = persistenceService.findByKeywordsPaged(keywords, ObjectEvent.class, pageNumber, pageSize);
	return ObjectEventPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public UUID createObjectEvent(ObjectEvent objectEvent) {
	persistenceService.save(objectEvent);
	return objectEvent.getFaId();
    }

    @Override
    public ObjectEvent getObjectEventById(UUID objecteventId) {
	return persistenceService.getFaModelByUUID(objecteventId, ObjectEvent.class);
    }

  

}
