package com.jarvis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IDCard")
public class IDCard {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name = "ID")
    private Long id;
	
	@Column(name = "EventType")
	private String eventType;
	@Column(name = "ChangeType")
	private String changeType;
	@Column(name = "MemberID")
	private String memberID;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

}
