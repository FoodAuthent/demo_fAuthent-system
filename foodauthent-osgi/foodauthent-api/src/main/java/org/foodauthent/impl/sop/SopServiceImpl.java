package org.foodauthent.impl.sop;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.SopService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.SOP;
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
    public List<UUID> findSOPByKeyword(final List<String> keywords) {
	if (logger.isDebugEnabled()) {
	    logger.debug("Seaching fields: name, descrption");
	}
	final List<SOP> result = persistenceService.findByKeywords(keywords, SOP.class);
	return result.stream().map(e -> e.getFaId()).collect(Collectors.toList());
    }

    @Override
    public SOP getSOPById(final UUID sopId) {
	return persistenceService.getFaModelByUUID(sopId);
    }

}
