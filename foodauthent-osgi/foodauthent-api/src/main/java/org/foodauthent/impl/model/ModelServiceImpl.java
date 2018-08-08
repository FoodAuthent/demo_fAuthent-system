package org.foodauthent.impl.model;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.ModelService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Model;
import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.SOP;
import org.foodauthent.model.SOPPageResult;
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

    private static PersistenceService persistenceService;

    public ModelServiceImpl() {
    }

    @Reference
    void setPersistenceService(PersistenceService persistenceService) {
	ModelServiceImpl.persistenceService = persistenceService;
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
	ResultPage<Model> res = persistenceService.findByKeywordsPaged(keywords, Model.class, pageNumber, pageSize);
	return ModelPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }
}
