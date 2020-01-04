package com.jarvis.dto;

public class ReceivingMessageDTO {

	String memberName;
	
	String member_phone;
	
	String member_email;
	
	String complete_message_sms;
	
	String complete_message_email;
	
	String sms_sent_status;
	
	String sms_received_status;
	
	String sms_sent_uniqueId;
	
	String phone_id;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getComplete_message_sms() {
		return complete_message_sms;
	}

	public void setComplete_message_sms(String complete_message_sms) {
		this.complete_message_sms = complete_message_sms;
	}

	public String getComplete_message_email() {
		return complete_message_email;
	}

	public void setComplete_message_email(String complete_message_email) {
		this.complete_message_email = complete_message_email;
	}

	public String getSms_sent_status() {
		return sms_sent_status;
	}

	public void setSms_sent_status(String sms_sent_status) {
		this.sms_sent_status = sms_sent_status;
	}

	public String getSms_received_status() {
		return sms_received_status;
	}

	public void setSms_received_status(String sms_received_status) {
		this.sms_received_status = sms_received_status;
	}

	public String getSms_sent_uniqueId() {
		return sms_sent_uniqueId;
	}

	public void setSms_sent_uniqueId(String sms_sent_uniqueId) {
		this.sms_sent_uniqueId = sms_sent_uniqueId;
	}

	public String getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(String phone_id) {
		this.phone_id = phone_id;
	}
	
}