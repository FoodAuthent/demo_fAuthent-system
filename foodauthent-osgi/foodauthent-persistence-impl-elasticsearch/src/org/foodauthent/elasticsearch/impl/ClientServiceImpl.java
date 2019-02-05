package org.foodauthent.elasticsearch.impl;

import java.util.List;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.foodauthent.config.ConfigurationService;
import org.foodauthent.elasticsearch.ClientService;
import org.foodauthent.elasticsearch.ClientServiceListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.typesafe.config.Config;

/**
 * Service providing Client for Elasticsearch
 *
 * @author Sven Böckelmann
 *
 */
@Component(service = ClientService.class, immediate = true)
public class ClientServiceImpl implements ClientService {

	public static final String CONFIG_LIST_ROOT = "persistence.elasticsearch.hosts";

	private RestHighLevelClient client;

	private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Reference(service = ConfigurationService.class, bind = "bindConfigurationService", unbind = "unbindConfigurationService")
	private ConfigurationService configurationService;

	public ClientServiceImpl() {
		client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
	}

	@Override
	public RestHighLevelClient getClient() {
		return client;
	}

	public void bindConfigurationService(ConfigurationService configurationService) throws Exception {
		this.configurationService = configurationService;
		try {
			final List<? extends Config> configHosts = configurationService.getConfigList(CONFIG_LIST_ROOT);
			final RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(configHosts.stream().map(cfg -> {
						return new HttpHost(cfg.getString("hostname"), cfg.getInt("port"), cfg.getString("scheme"));
					}).toArray(HttpHost[]::new)));
			this.client = client;
			notifyClientListeners();
		} catch (Exception e) {
			LOG.error("unable to configure client", e);
			throw e;
		}
	}

	public void unbindConfigurationService(ConfigurationService configurationService) {
		this.configurationService = null;
		this.client = null;
		notifyClientListeners();
	}

	private void notifyClientListeners() {
		final BundleContext ctx = FrameworkUtil.getBundle(getClass()).getBundleContext();
		try {
			ctx.getServiceReferences(ClientServiceListener.class, null).stream().map(ref -> ctx.getService(ref))
					.forEach(s -> {
						s.clientChanged(getClient());
					});
		} catch (InvalidSyntaxException e) {
			LOG.error("unable to notify ClientServiceListeners", e);
		}

	}
}
