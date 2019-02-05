package org.foodauthent.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;

public interface ClientServiceListener {

	public void clientChanged(RestHighLevelClient client);
	
}
