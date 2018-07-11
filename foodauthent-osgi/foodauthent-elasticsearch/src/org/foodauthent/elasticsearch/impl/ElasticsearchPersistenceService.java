package org.foodauthent.elasticsearch.impl;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.internal.exeption.EntityExistsException;
import org.foodauthent.elasticsearch.ClientService;
import org.foodauthent.internal.api.persistence.Blob;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service=PersistenceService.class)
public class ElasticsearchPersistenceService implements PersistenceService {
	
	private ElasticsearchOperation op;
	
	@Reference
	public void bindClientService(ClientService clientService) {
		op = new ElasticsearchOperation(clientService.getClient());
	}

	@Override
	public long save(FaModel entity) throws EntityExistsException {
		return 0;
	}

	@Override
	public long replace(FaModel entity) throws NoSuchElementException {
		return 0;
	}

	@Override
	public long save(Blob blob) throws EntityExistsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product findProductByGtin(String gtin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends FaModel> T getFaModelByUUID(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends FaModel> List<T> findByKeywords(Collection<String> keywords, Class<T> modelType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob getBlobByUUID(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
