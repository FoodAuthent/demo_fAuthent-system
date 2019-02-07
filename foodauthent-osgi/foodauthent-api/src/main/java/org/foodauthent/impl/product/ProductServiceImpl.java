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
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 *
 * @author Alexander Kerner, Lablicate GmbH
 *
 */
@Component(service = ProductService.class)
public class ProductServiceImpl implements ProductService {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    private PersistenceService persistenceService;

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
    public Product findProductById(UUID id) {
	return persistenceService.findProductById(id);
    }

    @Override
    public ProductPageResult findProductByKeyword(Integer pageNumber, Integer pageSize, List<String> keywords) {
	ResultPage<Product> res = persistenceService.findByKeywordsPaged(keywords, Product.class, pageNumber, pageSize);
	return ProductPageResult.builder().setPageCount(res.getTotalNumPages()).setPageNumber(pageNumber)
		.setResultCount(res.getTotalNumEntries()).setResults(res.getResult()).build();
    }

    @Override
    public void removeProductByGtin(UUID gtin) {
	persistenceService.removeFaModelByUUID(gtin, Product.class);
    }

    @Override
    public void updatedProduct(Product product) {
	persistenceService.replace(product);
    }

}
