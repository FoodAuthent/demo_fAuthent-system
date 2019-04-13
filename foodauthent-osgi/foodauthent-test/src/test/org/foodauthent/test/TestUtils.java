package org.foodauthent.test;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FileMetadata;
import org.foodauthent.rest.impl.json.JacksonJSONReader;
import org.foodauthent.rest.impl.json.JacksonJSONWriter;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

public class TestUtils {

    public static FileMetadata createNewMetadata(String name, String description) {
	return FileMetadata.builder().setName(name).setDate(LocalDate.now()).setDescription(description)
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINT_BRUKER).setVersion(0).build();
    }

    @Deprecated
    public static WebTarget newWebTarget() {
	Client client = ClientBuilder.newClient().register(JacksonJSONWriter.class, Integer.MAX_VALUE)
		.register(JacksonJSONReader.class, Integer.MAX_VALUE).register(MultiPartFeature.class);
	return client.target("http://localhost:9090/v0/foodauthent/");
    }
    
    public static <S> S createClientProxy(Class<S> serviceClass) {
	Client client = ClientBuilder.newClient().register(JacksonJSONWriter.class, Integer.MAX_VALUE)
		.register(JacksonJSONReader.class, Integer.MAX_VALUE).register(MultiPartFeature.class);
	WebTarget wt = client.target("http://localhost:9090");
	return WebResourceFactory.newResource(serviceClass, wt);
    }

    public static UUID uploadMetadata(WebTarget wt, FileMetadata fileMeta) {
	return wt.path("file").request(MediaType.APPLICATION_JSON).post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON), UUID.class);
    }

    public static Response uploadFileData(WebTarget wt, UUID fileMetaID, File file) {
	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("filedata", file, MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	return wt.path("/file/" + fileMetaID + "/data").request().put(Entity.entity(multiPart, multiPart.getMediaType()));

    }
}
