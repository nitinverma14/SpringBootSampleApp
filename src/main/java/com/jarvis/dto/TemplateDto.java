package com.jarvis.dto;

public class TemplateDto {

	private String idr;
	private String ops;
	private String title;
	private String template;
	private Boolean active;
	
	public String getIdr() {
		return idr;
	}
	public void setIdr(String idr) {
		this.idr = idr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getOps() {
		return ops;
	}
	public void setOps(String ops) {
		this.ops = ops;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
