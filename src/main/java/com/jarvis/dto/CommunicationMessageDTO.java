package com.jarvis.dto;

public class CommunicationMessageDTO {

	String memberId;
	
	String memberName;
	
	String member_preference;
	
	String member_phone;
	
	String member_email;
	
	String template_name;
	
	String complete_message_sms;
	
	String complete_message_email;
	
	String member_phone_country_code;
	
	String member_phone_secure_messaging_id;
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMember_preference() {
		return member_preference;
	}

	public void setMember_preference(String member_preference) {
		this.member_preference = member_preference;
	}

	public String getTemplate_name() {
		return template_name;
	}

	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
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

	public String getMember_phone_country_code() {
		return member_phone_country_code;
	}

	public void setMember_phone_country_code(String member_phone_country_code) {
		this.member_phone_country_code = member_phone_country_code;
	}

	public String getMember_phone_secure_messaging_id() {
		return member_phone_secure_messaging_id;
	}

	public void setMember_phone_secure_messaging_id(String member_phone_secure_messaging_id) {
		this.member_phone_secure_messaging_id = member_phone_secure_messaging_id;
	}
	
}