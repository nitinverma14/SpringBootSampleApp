package com.jarvis.enums;

public enum PreferenceEnum {
	
	EMAIL("EMAIL"),
	SMS("SMS"),
	BOTH("BOTH");
	
	private final String attribute;

	private PreferenceEnum(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return this.attribute;
	}

}
