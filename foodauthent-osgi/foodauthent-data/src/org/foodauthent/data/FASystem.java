package org.foodauthent.data;

import java.io.File;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.foodauthent.api.WorkflowService;
import org.foodauthent.model.FileMetadata;
import org.foodauthent.rest.api.service.FileRestService;
import org.foodauthent.rest.api.service.ProductRestService;
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
public class FASystem {

    private static final WebTarget WEB_TARGET = newWebTarget();

    private FASystem() {
	// utility class
    }

    public static ProductRestService products() {
	return createClientProxy(ProductRestService.class);
    }

    public static WorkflowRestService workflows() {
	return createClientProxy(WorkflowRestService.class);
    }

    public static FileRestService files() {
	return createClientProxy(FileRestService.class);
    }

    private static WebTarget newWebTarget() {
	Client client = ClientBuilder.newClient().register(JacksonJSONWriter.class, Integer.MAX_VALUE)
		.register(JacksonJSONReader.class, Integer.MAX_VALUE).register(MultiPartFeature.class);
	return client.target("http://localhost:9090/v0/foodauthent/");
    }

    private static <S> S createClientProxy(Class<S> serviceClass) {
	Client client = ClientBuilder.newClient().register(JacksonJSONWriter.class, Integer.MAX_VALUE)
		.register(JacksonJSONReader.class, Integer.MAX_VALUE).register(MultiPartFeature.class);
	WebTarget wt = client.target("http://localhost:9090");
	return WebResourceFactory.newResource(serviceClass, wt);
    }

    public static Response uploadFileData(UUID fileMetaID, File file) {
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("filedata", file, MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	return WEB_TARGET.path("/file/" + fileMetaID + "/data").request()
		.put(Entity.entity(multiPart, multiPart.getMediaType()));
    }

}
