package com.jarvis.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddPhoneResponse {
	
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


}
