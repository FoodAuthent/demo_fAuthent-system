package org.foodauthent.impl.sop;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.SopService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.SOP;
import org.foodauthent.model.SOPPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service=SopService.class)
public class SopServiceImpl implements SopService {

    private static final Logger logger = LoggerFactory.getLogger(SopServiceImpl.class);

    private static PersistenceService persistenceService;

    public SopServiceImpl() {
    }

    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
	SopServiceImpl.persistenceService = persistenceService;
    }
    
    @Override
    public UUID createNewSOP(final SOP sop) {
	persistenceService.save(sop);
	return sop.getFaId();
    }

    @Override
    public SOP getSOPById(final UUID sopId) {
	return persistenceService.getFaModelByUUID(sopId, SOP.class);
    }
    
    @Override
    public void removeSOPById(UUID sopId) {
	persistenceService.removeFaModelByUUID(sopId, SOP.class);
    }

    @Override
    public SOPPageResult findSOPByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<SOP> res = persistenceService.findByKeywordsPaged(keywords, SOP.class, pageNumber, pageSize);
	return SOPPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

}
