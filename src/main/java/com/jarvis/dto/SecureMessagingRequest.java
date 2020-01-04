package com.jarvis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"number",
"country-code"
})
public class SecureMessagingRequest {
	
	@JsonProperty("client_id")
	private String client_id;
	
	@JsonProperty("client_secret")
	private String client_secret;
	
	@JsonProperty("grant_type")
	private String grant_type;
	
	@JsonProperty("number")
	private String number;
	
	@JsonProperty("country-code")
	private String country_code;
	
	@JsonProperty("phone-id")
	private String phone_id;
	
	@JsonProperty("program-id")
	private String program_id;
	
	@JsonProperty("body")
	private String sms_body;
	
	@JsonProperty("send-immediately")
	private String send_immediatly_flag;

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	
	public String getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(String phone_id) {
		this.phone_id = phone_id;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}
	
	public String getSms_body() {
		return sms_body;
	}

	public void setSms_body(String sms_body) {
		this.sms_body = sms_body;
	}

	public String getSend_immediatly_flag() {
		return send_immediatly_flag;
	}

	public void setSend_immediatly_flag(String send_immediatly_flag) {
		this.send_immediatly_flag = send_immediatly_flag;
	}

	public SecureMessagingRequest(String client_id, String client_secret, String grant_type) {
		super();
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.grant_type = grant_type;
	}

	public SecureMessagingRequest(String number, String country_code) {
		super();
		this.number = number;
		this.country_code = country_code;
	}

	public SecureMessagingRequest() {
		super();
	}
	
}
