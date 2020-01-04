package com.jarvis.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

/**
 * @author haritkumar
 */
@MappedSuperclass
public class BaseEntity {

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@OneToOne
	@JoinColumn(name = "CREATED_BY")
	private AppUser createdBy;

	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	@OneToOne
	@JoinColumn(name = "LAST_MODIFIED_BY")
	private AppUser lastModifiedBy;

	@Column(columnDefinition = "TINYINT", name = "ACTIVE", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;

	public AppUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(AppUser createdBy) {
		this.createdBy = createdBy;
	}

	public AppUser getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(AppUser lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
