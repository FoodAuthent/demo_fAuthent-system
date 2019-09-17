package org.foodauthent.epcis.ftrace.config;

import java.util.ArrayList;
import java.util.List;

import org.foodauthent.config.ConfigObject;

public class FTraceConfig implements ConfigObject {

	private static final long serialVersionUID = -5977394228749198193L;

	private List<Endpoint> endpoints = new ArrayList<Endpoint>();
	
	public FTraceConfig() {}
	
	public static final class Endpoint {
		
		public Endpoint() {
		}
		
		private String url;
		
		private String token;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
		
	}

	public List<Endpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}
}
