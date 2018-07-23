package org.foodauthent.impl.product;

import java.util.UUID;

import org.foodauthent.api.ProductService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.model.Product;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service=ProductService.class)
public class ProductServiceImpl implements ProductService {

    private static PersistenceService persistenceService;

    
    @Reference
    void bindPersistenceService(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public UUID createProduct(final Product product) {
	persistenceService.save(product);
	return product.getFaId();
    }

    @Override
    public Product findProductByGtin(final String gtin) {
	return persistenceService.findProductByGtin(gtin);
    }

}
