package org.foodauthent.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.foodauthent.model.FileMetadata;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;

public class OpenChromTest extends AbstractITTest {

    @Test
    public void test01() throws Exception {

	WebTarget wt = TestUtils.newWebTarget();

	// Create metadata
	FileMetadata fileMeta = FileMetadata.builder().setName("Bruker NMR Testdata").setDate(LocalDate.now())
		.setDescription("Bruker NMR Testdata")
		.setType(org.foodauthent.model.FileMetadata.TypeEnum.FINGERPRINTS_BRUKER)
		.setVersion(0).build();

	// Upload metadata
	UUID fileMetaID = wt.path("file").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(fileMeta, MediaType.APPLICATION_JSON), UUID.class);

	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
	FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("files/bruker-nmr/1.zip"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);
	Response response = wt.path("/file/" + fileMetaID + "/data").request()
		.put(Entity.entity(multiPart, multiPart.getMediaType()));
	assertNotNull(response);
	System.err.println(response.getStatus());
	System.err.println(response.getStatusInfo());
	assertEquals(200, response.getStatus());

    }
}
