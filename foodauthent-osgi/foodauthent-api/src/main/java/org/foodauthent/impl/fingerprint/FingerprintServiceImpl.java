package org.foodauthent.impl.fingerprint;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.foodauthent.api.FingerprintService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.FingerprintSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class FingerprintServiceImpl implements FingerprintService {

    private static final Logger logger = LoggerFactory.getLogger(FingerprintServiceImpl.class);

    private final PersistenceService persistenceService;

    public FingerprintServiceImpl() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
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
}
