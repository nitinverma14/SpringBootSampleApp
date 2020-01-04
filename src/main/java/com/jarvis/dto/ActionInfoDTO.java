package com.jarvis.dto;

public class ActionInfoDTO {

private Long id;
	
	private String actionIDName;
	private String description;
	private String actionIDPreference;
	private String templeteSMSPreference;
	private String templeteEMAILPreference;
	private Boolean active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getActionIDName() {
		return actionIDName;
	}
	public void setActionIDName(String actionIDName) {
		this.actionIDName = actionIDName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActionIDPreference() {
		return actionIDPreference;
	}
	public void setActionIDPreference(String actionIDPreference) {
		this.actionIDPreference = actionIDPreference;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getTempleteSMSPreference() {
		return templeteSMSPreference;
	}
	public void setTempleteSMSPreference(String templeteSMSPreference) {
		this.templeteSMSPreference = templeteSMSPreference;
	}
	public String getTempleteEMAILPreference() {
		return templeteEMAILPreference;
	}
	public void setTempleteEMAILPreference(String templeteEMAILPreference) {
		this.templeteEMAILPreference = templeteEMAILPreference;
	}
	
	
	
	
}
