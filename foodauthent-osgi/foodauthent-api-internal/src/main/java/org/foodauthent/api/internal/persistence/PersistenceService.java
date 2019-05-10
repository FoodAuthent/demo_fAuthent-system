package org.foodauthent.api.internal.persistence;

import static java.util.Arrays.stream;

import java.util.ArrayList;
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
    Product getProductById(UUID id);

    /**
     * Queries a fa-model by uuid.
     * 
     * @param uuid
     * @param modelType
     * @return
     * @throws NoSuchElementException if no model for the given id and type can be found
     */
    <T extends FaModel> T getFaModelByUUID(UUID uuid, Class<T> modelType) throws NoSuchElementException;
    
    /**
     * @param uuid
     */
    void removeFaModelByUUID(UUID uuid) throws NoSuchElementException;
    
    /**
     * Queries all fa-models filtered by the given keywords.
     * 
     * @param modelType
     * @param keywordSuperSet
	 *            a list of lists of keywords, if all lists are empty or no list is
	 *            given, all models are considered. Otherwise at least one keyword
	 *            from each list must match in order to be selected.
     * @return
     */
	<T extends FaModel> List<T> findByKeywords(Class<T> modelType, String[]... keywordSuperSet);

    /**
	 * Queries a limited number of the specified fa-model, filtered by the given
	 * keywords.
	 * 
	 * @param modelType
	 * @param pageNumber
	 * @param pageSize
	 * @param keywordSuperSet
	 *            a list of lists of keywords, if all lists are empty or no list is
	 *            given, all models are considered. Otherwise at least one keyword
	 *            from each list must match in order to be selected.
	 * 
	 * @return pair of the list of results and the number of available pages
	 */
	<T extends FaModel> ResultPage<T> findByKeywordsPaged(Class<T> modelType, int pageNumber, int pageSize,
			String[]... keywordSuperSet);

    /**
     * TODO
     * 
     * Important note: uuid's of blobs do intentionally overlap with uuid's of fa-models!!
     * 
     * @param uuid
     * @return
     * @throws NoSuchElementException if there is no blob for the given id
     */
    //TODO rename to getFileByUUID??
    Blob getBlobByUUID(UUID uuid) throws NoSuchElementException;
    
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

	<T extends FaModel> long getModelCount(Class<T> modelType);

	long getBlobCount();
   
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
    
    /**
     * Shortcut to turn a list of keywords into an array.
     */
	public static String[] toArray(List<String> keywords) {
		return keywords.toArray(new String[keywords.size()]);
	}
	
	/**
	 * Shortcut to create an array of keywords.
	 */
	public static String[] toArray(String... keywords) {
		return keywords;
	}
	
	/**
	 * 
	 * @param keywordSuperSet
	 * @return
	 */
	public static String[][] removeEmptyListsAndKeywords(String[]... keywordSuperSet) {
		// Remove empty keywords
		List<String[]> res = new ArrayList<String[]>(keywordSuperSet.length);
		for (String[] keywords : keywordSuperSet) {
			String[] newList = stream(keywords).filter(item -> !(item == null || "".equals(item))).toArray(l -> new String[l]);
			if (newList.length > 0) {
				res.add(newList);
			}
		}
		return res.toArray(new String[0][]);
	}

	public void removeBlobByUUID(UUID faId);

}
