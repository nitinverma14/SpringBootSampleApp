package com.jarvis.dto;

public class EventMessage {

	private String eventType;
	private String changeType;
	private String memberID;
	private String actionID;
	private String dob;
	private Enroll enroll;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getActionID() {
		return actionID;
	}
	public void setActionID(String actionID) {
		this.actionID = actionID;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Enroll getEnroll() {
		return enroll;
	}
	public void setEnroll(Enroll enroll) {
		this.enroll = enroll;
	}
	


}
