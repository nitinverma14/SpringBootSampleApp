package com.jarvis.enums;

public enum TemplateEnum {
	
	SMS("SMS"),
	EMAIL("EMAIL");
	
	private final String attribute;

	private TemplateEnum(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return this.attribute;
	}

}
