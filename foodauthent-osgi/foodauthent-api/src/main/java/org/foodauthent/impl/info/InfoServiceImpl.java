package org.foodauthent.impl.info;

import org.foodauthent.api.InfoService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Model;
import org.foodauthent.model.Prediction;
import org.foodauthent.model.Product;
import org.foodauthent.model.SOP;
import org.foodauthent.model.Sample;
import org.foodauthent.model.SystemInfo;
import org.foodauthent.model.Workflow;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service = InfoService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class InfoServiceImpl implements InfoService {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

    public InfoServiceImpl() {
    }

    @Override
    public SystemInfo getInfo() {
	PersistenceService ps = persistenceService;
	return SystemInfo.builder()
	.setNumFiles(ps.getBlobCount())
	.setNumFingerprints(ps.getModelCount(Fingerprint.class))
	.setNumFingerprintsets(ps.getModelCount(FingerprintSet.class))
	.setNumModels(ps.getModelCount(Model.class))
	.setNumPredictions(ps.getModelCount(Prediction.class))
	.setNumProducts(ps.getModelCount(Product.class))
	.setNumSamples(ps.getModelCount(Sample.class))
	.setNumSops(ps.getModelCount(SOP.class))
	.setNumWorkflows(ps.getModelCount(Workflow.class))
	.build();
    }
}
