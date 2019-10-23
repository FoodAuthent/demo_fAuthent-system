package org.foodauthent.gpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attribute {
	
	private String code;
	
	private Map<String, String> text = new HashMap<String, String>();
	
	private List<AttributeValue> values = new ArrayList<AttributeValue>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, String> getText() {
		return text;
	}

	public void setText(Map<String, String> text) {
		this.text = text;
	}

	public void putText(String key, String text) {
		this.text.put(key, text);
	}
	
	public List<AttributeValue> getValues() {
		return values;
	}

	public void setValues(List<AttributeValue> values) {
		this.values = values;
	}

}
