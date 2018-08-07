package org.foodauthent.impl.product;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.ProductService;
import org.foodauthent.internal.api.persistence.PersistenceService;
import org.foodauthent.internal.api.persistence.PersistenceServiceProvider;
import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
public class ProductServiceImpl implements ProductService {

    private final PersistenceService persistenceService;

    public ProductServiceImpl() {
	this.persistenceService = PersistenceServiceProvider.getInstance().getService();
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

    @Override
    public ProductPageResult findProductByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	// TODO Auto-generated method stub
	return null;
    }

}
