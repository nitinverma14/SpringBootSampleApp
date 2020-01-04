package com.jarvis.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureMessagingSendMessageResponse extends SecureMessagingCommonError{
	
	@JsonProperty("id")
	private String response_unique_id;
	
	@JsonProperty("body")
	private String sms_body;
	
	private SecureMessagingResponseVars vars;
	
	@JsonProperty("phone-id")
	private String phone_id;
	
	@JsonProperty("program-id")
	private String program_id;

	@JsonProperty("adapter-id")
	private String adapter_id;
	

	@JsonProperty("send-immediately")
	private String send_immediatly_flag;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("deliver-on")
	private Timestamp deliver_on;
	
	@JsonProperty("expire-at")
	private Timestamp expire_at;
	
	@JsonProperty("created-at")
	private Timestamp create_date;
	
	@JsonProperty("updated-at")
	private Timestamp updated_date;
	
	public String getResponse_unique_id() {
		return response_unique_id;
	}

	public void setResponse_unique_id(String response_unique_id) {
		this.response_unique_id = response_unique_id;
	}

	public String getSms_body() {
		return sms_body;
	}

	public void setSms_body(String sms_body) {
		this.sms_body = sms_body;
	}

	public SecureMessagingResponseVars getVars() {
		return vars;
	}

	public void setVars(SecureMessagingResponseVars vars) {
		this.vars = vars;
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

	public String getAdapter_id() {
		return adapter_id;
	}

	public void setAdapter_id(String adapter_id) {
		this.adapter_id = adapter_id;
	}

	public String getSend_immediatly_flag() {
		return send_immediatly_flag;
	}

	public void setSend_immediatly_flag(String send_immediatly_flag) {
		this.send_immediatly_flag = send_immediatly_flag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	

}
