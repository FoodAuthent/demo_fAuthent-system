package org.foodauthent.internal.api.persistence;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;

/**
 * Persistence Service. Implementations persist entities to a database, for
 * example.
 *
 *
 * @author Alexander Kerner
 *
 */
public interface PersistenceService {

    /**
     * Save given entity.
     *
     * @param entity
     *            Entity to save
     * @return the database Id
     */
    long save(FaModel entity);

    long save(Blob blob);

    /**
     * Returns a {@link Product} that is associated to given GTIN.
     *
     * @param gtin
     *            the GTIN
     * @return a {@link Product} that is associated to given GTIN
     * @throws NoSuchElementException
     *             if there is no product matching given GTIN
     */
    Product findProductByGtin(String gtin);

    <T extends FaModel> T getFaModelByUUID(UUID uuid);

    <T extends FaModel> List<T> findByKeywords(Collection<String> keywords, Class<T> modelType);

    Blob getBlobByUUID(UUID uuid);

}
