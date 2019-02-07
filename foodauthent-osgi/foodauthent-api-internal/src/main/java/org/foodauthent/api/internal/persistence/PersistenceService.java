package org.foodauthent.api.internal.persistence;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.foodauthent.api.internal.exception.ModelExistsException;
import org.foodauthent.model.FaModel;
import org.foodauthent.model.Product;

import com.fasterxml.jackson.databind.JsonNode;

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
     * Save given model.
     *
     * @param model
     *            model to save
     * @return the database Id
     * @throws ModelExistsException
     *             if an model with the same fa-id already exists
     */
    <T extends FaModel> T save(T model) throws ModelExistsException;

    /**
     * Replaces an existing model with the passed one.
     * 
     * @param model
     *            the new model
     * @return the database id
     * @throws NoSuchElementException
     *             if there is no model with the same fa-id to replace
     */
    <T extends FaModel> T replace(T model) throws NoSuchElementException;
    
    /**
     * 
     * Important note: uuid's of blobs do intentionally overlap with uuid's of fa-models!!
     * 
     * @param blob
     * @return
     * @throws ModelExistsException
     */
    UUID save(Blob blob) throws ModelExistsException;

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
     * Returns a {@link Product} that is associated to given ID.
     *
     * @param id
     *            the id
     * @return a {@link Product} that is associated to given id
     * @throws NoSuchElementException
     *             if there is no product matching given id
     */
    Product findProductById(UUID id);

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
     * Saves an entity represented by a {@link JsonNode} and a type id
     * @param model the actual entity instance
     * @param typeId an id uniquely describing the object type represented by the json node
     * @return the fa-id for later retrieval
     */
    void saveCustomModel(String modelId, String schemaId, UUID uuid, JsonNode model);
    
    /**
     * Returns the custom model for the given uuid.
     * 
     * @param uuid
     * @return
     */
    JsonNode getCustomModelByUUID(String modelId, String schemaId, UUID uuid);
    
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
