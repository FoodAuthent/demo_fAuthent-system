package org.foodauthent.rest.client;

import java.io.File;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.foodauthent.rest.api.service.CustomMetadataRestService;
import org.foodauthent.rest.api.service.EntityRestService;
import org.foodauthent.rest.api.service.FileRestService;
import org.foodauthent.rest.api.service.FingerprintRestService;
import org.foodauthent.rest.api.service.InfoRestService;
import org.foodauthent.rest.api.service.ModelRestService;
import org.foodauthent.rest.api.service.ProductRestService;
import org.foodauthent.rest.api.service.SampleRestService;
import org.foodauthent.rest.api.service.SopRestService;
import org.foodauthent.rest.api.service.WorkflowRestService;
import org.foodauthent.rest.impl.json.JacksonJSONReader;
import org.foodauthent.rest.impl.json.JacksonJSONWriter;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

/**
 * 
 * @author Martin Horn, University of Konstanz
 */
public class FASystemClientUtil {


    private FASystemClientUtil() {
	// utility class/singleton
    }
    
    public static FingerprintRestService fingerprints(FASystemClient client) {
	return client.createClientProxy(FingerprintRestService.class);
    }

    public static ProductRestService products(FASystemClient client) {
	return client.createClientProxy(ProductRestService.class);
    }

    public static WorkflowRestService workflows(FASystemClient client) {
	return client.createClientProxy(WorkflowRestService.class);
    }
    
    public static SampleRestService samples(FASystemClient client) {
	return client.createClientProxy(SampleRestService.class);
    }

    public static FileRestService files(FASystemClient client) {
	return client.createClientProxy(FileRestService.class);
    }
    
    public static InfoRestService info(FASystemClient client) {
	return client.createClientProxy(InfoRestService.class);
    }
    
    public static CustomMetadataRestService customMetadata(FASystemClient client) {
	return client.createClientProxy(CustomMetadataRestService.class);
    }
    
    public static ModelRestService models(FASystemClient client) {
	return client.createClientProxy(ModelRestService.class);
    }
    
    public static SopRestService sops(FASystemClient client) {
	return client.createClientProxy(SopRestService.class);
    }
    
    public static EntityRestService entities(FASystemClient client) {
	return client.createClientProxy(EntityRestService.class);
    }
   
    public static <T> T handleResp(Response response, Class<T> entityType) {
	if (response.getStatusInfo().getFamily() == Status.Family.SUCCESSFUL) {
	    return response.readEntity(entityType);
	} else {
	    throw new IllegalStateException(response.readEntity(String.class));
	}
    }
   
    public static Response uploadFileData(UUID fileMetaID, File file, FASystemClient client) {
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("filedata", file, MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	return client.getWebTarget().path("/v0/foodauthent/file/" + fileMetaID + "/data").request()
		.put(Entity.entity(multiPart, multiPart.getMediaType()));
    }

}
