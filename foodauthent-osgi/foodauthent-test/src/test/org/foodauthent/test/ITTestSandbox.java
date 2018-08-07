package org.foodauthent.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.foodauthent.model.SOP;
import org.foodauthent.model.Workflow;
import org.foodauthent.rest.api.service.WorkflowRestService;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;
import org.osgi.framework.BundleException;

public class ITTestSandbox extends AbstractITTest {

    public void test() throws FileNotFoundException, BundleException, InterruptedException {
	WebTarget wt = webTarget();

	SOP sop = SOP.builder().setName("sopname").setProductId(UUID.randomUUID()).setDescription("sop_desc").build();
	UUID sopId = wt.path("sop").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(sop, MediaType.APPLICATION_JSON), UUID.class);
	List<UUID> sopIds = wt.path("sop").queryParam("keywords", "sopname").request(MediaType.APPLICATION_JSON)
		.get(List.class);
	SOP newSop = wt.path("sop/" + sopIds.get(0)).request(MediaType.APPLICATION_JSON).get(SOP.class);

	// workflow upload and execution
	Workflow wf = Workflow.builder().setName("name").build();
	UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);

	MultiPart multiPart = new MultiPart();
	multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

	FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("/home/hornm/test.file"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE);
	multiPart.bodyPart(filePart);

	wt.path("workflow/" + wfId + "/file").request().put(Entity.entity(multiPart, multiPart.getMediaType()));
    }

}
