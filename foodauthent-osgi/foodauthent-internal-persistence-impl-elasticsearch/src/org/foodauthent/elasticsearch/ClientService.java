package org.foodauthent.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;

public interface ClientService {

	public RestHighLevelClient getClient();
	
}
