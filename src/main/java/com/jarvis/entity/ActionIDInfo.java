package com.jarvis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ActionInfo")
public class ActionIDInfo extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4866969389148547225L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name = "ID")
    private Long id;
	
	@Column(name = "ACTIONID_NAME")
	private String actionIDName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ACTION_ID_PREFERENCE")
	private String actionIDPreference;
	
	@Column(name = "TEMPLETE_SMS_PREFERENCE")
	private String templeteSMSPreference;
	
	@Column(name = "TEMPLETE_EMAIL_PREFERENCE")
	private String templeteEMAILPreference;

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
