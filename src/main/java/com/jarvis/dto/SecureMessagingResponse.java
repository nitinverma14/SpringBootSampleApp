package com.jarvis.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureMessagingResponse {
	
	@JsonProperty("access_token")
	private String access_token;
	
	@JsonProperty("token_type")
	private String token_type;
	
	@JsonProperty("code")
	private String error_code;
	
	@JsonProperty("description")
	private String error_description;
	
	@JsonProperty("id")
	private String response_unique_id;
	
	@JsonProperty("number")
	private String number;
	
	@JsonProperty("country-code")
	private String country_code;
	
	@JsonProperty("created-at")
	private Timestamp create_date;
	
	@JsonProperty("updated-at")
	private Timestamp updated_date;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("phone-id")
	private String phone_id;
	
	@JsonProperty("program-id")
	private String program_id;

	@JsonProperty("performed-at")
	private Timestamp performed_date;

	@JsonProperty("body")
	private Timestamp sms_body;
	
	@JsonProperty("adapter-id")
	private Timestamp adapter_id;
	
	@JsonProperty("send-immediately")
	private String send_immediatly_flag;
	
	@JsonProperty("deliver-on")
	private Timestamp deliver_on;
	
	@JsonProperty("expire-at")
	private Timestamp expire_at;
	
	
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

	public String getResponse_unique_id() {
		return response_unique_id;
	}

	public void setResponse_unique_id(String response_unique_id) {
		this.response_unique_id = response_unique_id;
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

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Timestamp getPerformed_date() {
		return performed_date;
	}

	public void setPerformed_date(Timestamp performed_date) {
		this.performed_date = performed_date;
	}

	public Timestamp getSms_body() {
		return sms_body;
	}

	public void setSms_body(Timestamp sms_body) {
		this.sms_body = sms_body;
	}

	public Timestamp getAdapter_id() {
		return adapter_id;
	}

	public void setAdapter_id(Timestamp adapter_id) {
		this.adapter_id = adapter_id;
	}

	public String getSend_immediatly_flag() {
		return send_immediatly_flag;
	}

	public void setSend_immediatly_flag(String send_immediatly_flag) {
		this.send_immediatly_flag = send_immediatly_flag;
	}

	public Timestamp getDeliver_on() {
		return deliver_on;
	}

	public void setDeliver_on(Timestamp deliver_on) {
		this.deliver_on = deliver_on;
	}

	public Timestamp getExpire_at() {
		return expire_at;
	}

	public void setExpire_at(Timestamp expire_at) {
		this.expire_at = expire_at;
	}
	
}
