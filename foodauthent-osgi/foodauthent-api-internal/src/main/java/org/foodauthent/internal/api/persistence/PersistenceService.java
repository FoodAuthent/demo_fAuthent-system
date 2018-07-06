package org.foodauthent.internal.api.persistence;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.internal.exeption.EntityExistsException;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;

/**
 * Persistence Service. Implementations persist entities to a database, for
 * example.
 * 
 * NOTE: implementations need to be thread-safe!
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
     * @throws EntityExistsException
     *             if an entity with the same fa-id already exists
     */
    long save(FaModel entity) throws EntityExistsException;

    /**
     * Replaces an existing entity with the passed one.
     * 
     * @param entity
     *            the new entity
     * @return the database id
     * @throws NoSuchElementException
     *             if there is no entity with the same fa-id to replace
     */
    long replace(FaModel entity) throws NoSuchElementException;

    long save(Blob blob) throws EntityExistsException;

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
