package com.jarvis.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureMessagingConfirmPhoneResponse {
	
	@JsonProperty("id")
	private String response_unique_id;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("phone-id")
	private String phone_id;
	
	@JsonProperty("program-id")
	private String program_id;
	
	@JsonProperty("performed-at")
	private Timestamp performed_date;
	
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
