package org.foodauthent.impl.model;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.ModelService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.WorkflowPageResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
@Component(service=ModelService.class)
public class ModelServiceImpl implements ModelService {

    private PersistenceService persistenceService;

    public ModelServiceImpl() {
    }

    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
	this.persistenceService = persistenceService;
    }

    @Override
    public UUID createModel(Model model) {
	persistenceService.save(model);
	return model.getFaId();
    }

    @Override
    public Model getModelById(UUID modelId) {
	return persistenceService.getFaModelByUUID(modelId, Model.class);
    }

    @Override
    public ModelPageResult findModelByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public WorkflowPageResult findWorkflowByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }
}
