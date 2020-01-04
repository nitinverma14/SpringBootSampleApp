package com.jarvis.enums;

public enum CountryEnum {
	
	IN("IN"),
	US("US");
	
	private final String attribute;

	private CountryEnum(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return this.attribute;
	}

}
