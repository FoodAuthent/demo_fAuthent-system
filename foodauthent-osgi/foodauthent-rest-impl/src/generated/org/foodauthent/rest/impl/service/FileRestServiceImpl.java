/*
 * TODO	
 */
package org.foodauthent.rest.impl.service;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.Response;

import org.foodauthent.api.FileService;
import org.foodauthent.common.exception.FAExceptions;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.rest.api.service.FileRestService;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * FoodAuthent Swagger API
 *
 * <p>This is the FoodAuthent API Description [www.foodauthent.net]
 *
 * <p> 
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
@Component(service = FileRestService.class, immediate = true)
public class FileRestServiceImpl implements FileRestService, Feature {

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
    private FileService service;


    /**
     * Creates a new file by posting the file metadata first.
     *
     * @param fileMetadata The actual metadata object.
     * @return the response
     */
    public Response createFileMetadata(FileMetadata fileMetadata) {
        
            Object res = service.createFileMetadata(fileMetadata);
            return Response.ok(res).build();
    }

    /**
     * Let one download the actual file data.
     *
     * @param fileId 
     * @return the response
     */
    public Response getFileData(java.util.UUID fileId) {
        
            Object res = service.getFileData(fileId);
            return Response.ok(res).build();
    }

    /**
     * Returns the file metadata.
     *
     * @param fileId 
     * @return the response
     */
    public Response getFileMetadata(java.util.UUID fileId) {
        
            Object res = service.getFileMetadata(fileId);
            return Response.ok(res).build();
    }

    /**
     * Uploads (and replaces) the actual file-data for the given file id
     *
     * @param fileId 
     * @param filedata The binary file data.
     * @return the response
     */
    public Response saveFileData(java.util.UUID fileId, java.io.InputStream filedata, org.glassfish.jersey.media.multipart.FormDataContentDisposition filedataDetail) {
        try { 
            Object res = service.saveFileData(fileId, filedata, filedataDetail);
            return Response.ok(res).build();
         } 
        catch(FAExceptions.InvalidDataException e) {
           return Response.status(433).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.InvalidInputException e) {
           return Response.status(434).entity(e.getMessage()).build();
        }
        
        catch(FAExceptions.FAException e) {
           return Response.status(500).entity(e.getMessage()).build();
        }
    }
    
	@Override
	public boolean configure(FeatureContext context) {
		context.register(MultiPartFeature.class);
		return true;
	}
    
}

