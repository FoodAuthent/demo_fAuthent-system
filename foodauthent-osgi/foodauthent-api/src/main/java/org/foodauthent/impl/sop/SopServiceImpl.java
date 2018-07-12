package org.foodauthent.impl.sop;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.SopService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.SOP;
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
    
    @Reference
    void bindPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
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
    public byte[] getSOPFile(final UUID sopId) {
	final SOP sop = persistenceService.getFaModelByUUID(sopId);
	if (logger.isWarnEnabled()) {
	    logger.warn("NOT IMPLEMENTED (Got sop " + sop + ")");
	}
	return null;
    }

    @Override
    public SOP getSOPById(final UUID sopId) {
	return persistenceService.getFaModelByUUID(sopId);
    }

}
