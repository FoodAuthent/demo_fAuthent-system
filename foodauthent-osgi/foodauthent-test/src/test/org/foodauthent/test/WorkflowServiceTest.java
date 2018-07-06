package org.foodauthent.test;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.RepresentationEnum;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;

/**
 * 
 * @author Martin Horn, University of Konstanz
 *
 */
public class WorkflowServiceTest extends AbstractITTest {
	
	@Test
	public void testUploadAndRunPredictionWorkflow() {
		
		WebTarget wt = webTarget();

		/* upload workflow */
		
		//upload workflow metadata
		Workflow wf = Workflow.builder()
				.setName("name")
				.setDescription("desc")
				.setRepresentation(RepresentationEnum.KNIME).build(); //TODO set more (or even all) properties
		UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);

		//upload workflow file
		MultiPart multiPart = new MultiPart();
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		FileDataBodyPart filePart = new FileDataBodyPart("upfile", new File("files/PredictionWorkflow.knwf"),
				MediaType.APPLICATION_OCTET_STREAM_TYPE);
		multiPart.bodyPart(filePart);
		wt.path("workflow/" + wfId + "/file").request().put(Entity.entity(multiPart, multiPart.getMediaType()));
		
		
		/* upload fingerprint set */
		Fingerprint fp = Fingerprint.builder()
				.setMetadata("fp metadata").build();
		FingerprintSet fps = FingerprintSet.builder()
				.setName("myset")
				.setFingerprints(Arrays.asList(fp))
				.build();
		UUID fpsId = wt.path("fingerprints").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(fps, MediaType.APPLICATION_JSON), UUID.class);

		/* run prediction workflow */
		wt.path("workflow/prediction/job").queryParam("workflow-id", wfId).queryParam("fingerprintset-id", fpsId)
				.request(MediaType.APPLICATION_JSON).post(null);
	}

}
