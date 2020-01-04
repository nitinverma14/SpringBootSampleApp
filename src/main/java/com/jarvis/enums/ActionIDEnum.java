package com.jarvis.enums;

public enum ActionIDEnum {
	
	IDCARD1("IDCARD1"),
	BDAY1("BDAY1"),
	MEMCHG1("MEMCHG1"),
	ENROLL1("ENROLL1");
	
	private final String attribute;

	private ActionIDEnum(String attribute) {
		this.attribute = attribute;
	}

	public String getAttribute() {
		return this.attribute;
	}

}
