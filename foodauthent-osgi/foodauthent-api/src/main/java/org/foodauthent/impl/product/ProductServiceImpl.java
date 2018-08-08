package org.foodauthent.impl.product;

import java.util.List;
import java.util.UUID;

import org.foodauthent.api.ProductService;
import org.foodauthent.api.internal.persistence.PersistenceService;
import org.foodauthent.api.internal.persistence.PersistenceService.ResultPage;
import org.foodauthent.model.Product;
import org.foodauthent.model.ProductPageResult;
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
	ProductServiceImpl.persistenceService = persistenceService;
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
	ResultPage<Product> res = persistenceService.findByKeywordsPaged(keywords, Product.class, pageNumber, pageSize);
	return ProductPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

}
