package org.foodauthent.elasticsearch.impl;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.foodauthent.elasticsearch.ClientService;
import org.osgi.service.component.annotations.Component;

@Component(service=ClientService.class)
public class ClientServiceImpl implements ClientService {
	
	private final RestHighLevelClient client;

	public ClientServiceImpl() {
		client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200, "http")));
	}

	@Override
	public RestHighLevelClient getClient() {
		return client;
	}

}
