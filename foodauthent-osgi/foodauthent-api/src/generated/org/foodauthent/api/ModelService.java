/*
 * TODO	
 */
package org.foodauthent.api;

import java.io.File;
import org.foodauthent.model.Model;

/**
 * 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ModelService {

    /**
     * Creates/adds a new model.
     *
     * @param model TODO
     *
     * @return the result
     */
    java.util.UUID createModel(Model model);
        
    /**
     * TODO
     *
     * @param modelId 
     *
     * @return the result
     */
    Model getModelById(java.util.UUID modelId);
        
    /**
     * Uploads the model file associated with the model of the given model-id.
     *
     * @param modelId 
     * @param upfile The file to upload.
     *
     * @return the result
     */
    java.util.UUID saveModelFile(java.util.UUID modelId, java.io.InputStream upfile, org.glassfish.jersey.media.multipart.FormDataContentDisposition upfileDetail);
        
}
