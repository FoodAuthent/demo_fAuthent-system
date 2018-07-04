package org.foodauthent.test;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.foodauthent.model.SOP;
import org.foodauthent.model.Workflow;
import org.foodauthent.rest.json.JacksonJSONReader;
import org.foodauthent.rest.json.JacksonJSONWriter;
import org.junit.Test;

public class ITTestSandbox {

	@Test
	public void test() {
		Client client = ClientBuilder.newClient().register(JacksonJSONWriter.class).register(JacksonJSONReader.class);
		WebTarget wt = client.target("http://localhost:9090/v0/foodauthent");

		SOP sop = SOP.builder().setName("sopname").setProductId(UUID.randomUUID()).setDescription("sop_desc").build();
		UUID sopId = wt.path("sop").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(sop, MediaType.APPLICATION_JSON), UUID.class);
		List<UUID> sopIds = wt.path("sop").queryParam("keywords", "sopname").request(MediaType.APPLICATION_JSON)
				.get(List.class);
		SOP newSop = wt.path("sop/" + sopIds.get(0)).request(MediaType.APPLICATION_JSON).get(SOP.class);

		Workflow wf = Workflow.builder().setName("name").build();
		UUID wfId = wt.path("workflow").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(wf, MediaType.APPLICATION_JSON), UUID.class);
	}

}
