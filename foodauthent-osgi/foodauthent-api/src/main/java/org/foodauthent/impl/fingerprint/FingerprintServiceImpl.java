package org.foodauthent.impl.fingerprint;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.FingerprintService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.MetadataEntries;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service=FingerprintService.class)
public class FingerprintServiceImpl implements FingerprintService {

    private static final Logger logger = LoggerFactory.getLogger(FingerprintServiceImpl.class);

    private static PersistenceService persistenceService;

    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public UUID createFingerprintSet(final FingerprintSet fingerprintSet) {
	persistenceService.save(fingerprintSet);
	return fingerprintSet.getFaId();
    }

    @Override
    public FingerprintSet getFingerprintSetById(UUID fingerprintsetId) {
	return persistenceService.getFaModelByUUID(fingerprintsetId);
    }

    @Override
    public List<UUID> findFingerprintSetByKeyword(List<String> keywords) {
	if (logger.isDebugEnabled()) {
	    logger.debug("Seaching fields: name, descrption");
	}
	final List<FingerprintSet> result = persistenceService.findByKeywords(keywords, FingerprintSet.class);
	return result.stream().map(e -> e.getFaId()).collect(Collectors.toList());
    }

    @Override
    public void addFingerprintRawData(UUID fingerprintId, byte[] data) {
	if (logger.isWarnEnabled()) {
	    logger.warn("NOT IMPLEMENTED addFingerprintRawData(" + fingerprintId + ")");
	}
    }

    @Override
    public void addMetaData(UUID fingerprintId, MetadataEntries metadata) {
	if (logger.isWarnEnabled()) {
	    logger.warn("NOT IMPLEMENTED addMetaData(" + fingerprintId + ")");
	}
    }
}
