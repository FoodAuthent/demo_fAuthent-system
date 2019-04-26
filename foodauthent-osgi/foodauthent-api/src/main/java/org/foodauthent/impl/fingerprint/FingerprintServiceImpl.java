package org.foodauthent.impl.fingerprint;

import static org.foodauthent.api.internal.persistence.PersistenceService.toArray;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.FingerprintService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSetPageResult;
import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service=FingerprintService.class)
public class FingerprintServiceImpl implements FingerprintService {

    @Reference(cardinality=ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

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
	ResultPage<FingerprintSet> res = persistenceService.findByKeywordsPaged(FingerprintSet.class,
		pageNumber, pageSize, toArray(keywords));
	return FingerprintSetPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public UUID createFingerprint(Fingerprint fingerprint) {
	persistenceService.save(fingerprint);
	return fingerprint.getFaId();
    }

    @Override
    public Fingerprint getFingerprintById(UUID fingerprintId) {
	return persistenceService.getFaModelByUUID(fingerprintId, Fingerprint.class);
    }

}
