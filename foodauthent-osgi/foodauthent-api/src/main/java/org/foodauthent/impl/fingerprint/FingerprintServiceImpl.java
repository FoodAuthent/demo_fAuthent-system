package org.foodauthent.impl.fingerprint;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.FingerprintService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;
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

    private PersistenceService persistenceService;

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
	return persistenceService.getFaModelByUUID(fingerprintsetId, FingerprintSet.class);
    }

    @Override
    public FingerprintSetPageResult findFingerprintSetByKeyword(Integer pageNumber, Integer pageSize,
	    List<String> keywords) {
	return null;
    }

}
