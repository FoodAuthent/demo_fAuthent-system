package org.foodauthent.impl.model;

import java.util.UUID;

import org.foodauthent.api.ModelService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.Model;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class ModelServiceImpl implements ModelService {

    private final PersistenceService persistenceService;

    public ModelServiceImpl() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
    }

    @Override
    public UUID createModel(Model model) {
	persistenceService.save(model);
	return model.getFaId();
    }

    @Override
    public Model getModelById(UUID modelId) {
	return persistenceService.getFaModelByUUID(modelId);
    }
}
