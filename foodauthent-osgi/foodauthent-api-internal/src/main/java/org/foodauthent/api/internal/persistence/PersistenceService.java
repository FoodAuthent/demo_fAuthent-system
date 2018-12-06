package org.foodauthent.api.internal.persistence;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.internal.exception.EntityExistsException;
import org.foodauthent.api.internal.exception.EntityNotFoundException;
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
    <T extends FaModel> T save(T entity) throws EntityExistsException;

    /**
     * Update given entity.
     *
     * @param entity
     *            Entity to update
     * @return entity with new attributes
     * @throws EntityNotFoundException
     *             if entity with given fa-id does not exist
     */
    <T extends FaModel> T update(T entity) throws EntityNotFoundException;
    
    /**
     * Replaces an existing entity with the passed one.
     * 
     * @param entity
     *            the new entity
     * @return the database id
     * @throws NoSuchElementException
     *             if there is no entity with the same fa-id to replace
     */
    <T extends FaModel> T replace(T entity) throws NoSuchElementException;


    /**
     * 
     * Important note: uuid's of blobs do intentionally overlap with uuid's of fa-models!!
     * 
     * @param blob
     * @return
     * @throws EntityExistsException
     */
    UUID save(Blob blob) throws EntityExistsException;

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

    /**
     * Queries a fa-model by uuid.
     * 
     * @param uuid
     * @param modelType
     * @return
     */
    <T extends FaModel> T getFaModelByUUID(UUID uuid, Class<T> modelType);
    
    /**
     * @param uuid
     */
    void removeFaModelByUUID(UUID uuid, Class<?> modelType) throws NoSuchElementException;
    
    <T extends FaModel> List<T> findByKeywords(Collection<String> keywords, Class<T> modelType);

    /**
     * Queries a limited number of the specified fa-model, filtered by the given
     * keywords.
     * 
     * @param keywords if list is empty, all models are considered
     * @param modelType
     * @param pageNumber
     * @param pageSize
     * @return pair of the list of results and the number of available pages
     */
    <T extends FaModel> ResultPage<T> findByKeywordsPaged(Collection<String> keywords, Class<T> modelType,
	    int pageNumber, int pageSize);

    /**
     * TODO
     * 
     * Important note: uuid's of blobs do intentionally overlap with uuid's of fa-models!!
     * 
     * @param uuid
     * @return
     */
    //TODO rename to getFileByUUID??
    Blob getBlobByUUID(UUID uuid);
    
    /**
     * Result in pages.
     *
     * @param <T>
     */
    public interface ResultPage<T> {
	
	/**
	 * @return number of pages available in total
	 */
	int getTotalNumPages();
	
	/**
	 * @return total number of entries available
	 */
	int getTotalNumEntries();
	
	/**
	 * @return the actual entries for one page
	 */
	List<T> getResult();
	
    }

}