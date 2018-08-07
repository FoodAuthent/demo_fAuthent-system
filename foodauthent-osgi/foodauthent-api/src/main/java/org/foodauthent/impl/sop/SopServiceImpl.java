package org.foodauthent.impl.sop;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.SopService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.SOP;
import org.foodauthent.model.SOPPageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class SopServiceImpl implements SopService {

    private static final Logger logger = LoggerFactory.getLogger(SopServiceImpl.class);

    private final PersistenceService persistenceService;

    public SopServiceImpl() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
    }

    @Override
    public UUID createNewSOP(final SOP sop) {
	persistenceService.save(sop);
	return sop.getFaId();
    }

    @Override
    public SOP getSOPById(final UUID sopId) {
	return persistenceService.getFaModelByUUID(sopId);
    }

    @Override
    public SOPPageResult findSOPByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }


}
