package org.foodauthent.impl.model;

import static org.foodauthent.impl.fingerprint.util.PersistenceUtil.saveBlob;

import java.io.InputStream;
import java.util.UUID;

import org.foodauthent.api.ModelService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.Model;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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

    @Override
    public UUID saveModelFile(UUID modelId, InputStream upfile, FormDataContentDisposition upfileDetail) {
	UUID blobId = saveBlob(upfile, upfileDetail, persistenceService);

	// get workflow metadata, set blobid and override it
	Model m = persistenceService.getFaModelByUUID(modelId);
	Model newWf = Model.builder(m).setModelFileId(blobId).build();
	persistenceService.replace(newWf);
	return blobId;
    }

}
