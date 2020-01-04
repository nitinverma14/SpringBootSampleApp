package com.jarvis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jarvis.enums.TemplateEnum;

@Entity
@Table(name = "templates")
public class Template extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6702320472197555842L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "temp_no")
	private String tempNo;

	@Column(name = "temp_type")
	@Enumerated(EnumType.STRING)
	private TemplateEnum tempType;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTempNo() {
		return tempNo;
	}

	public void setTempNo(String tempNo) {
		this.tempNo = tempNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TemplateEnum getTempType() {
		return tempType;
	}

	public void setTempType(TemplateEnum tempType) {
		this.tempType = tempType;
	}

}
