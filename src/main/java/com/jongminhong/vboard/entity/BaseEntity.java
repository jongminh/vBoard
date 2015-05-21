package com.jongminhong.vboard.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity<ID> {

	// resolve concurrency issue
	@Version
	private Long version;
	
	@Column(name = "created_date", nullable = false)
	private Date creaedDate;
	
	@Column(name = "last_modified_date" , nullable = false)
	private Date lastModifiedDate;
	
	public abstract ID getId();
	
	public Long getVersion(){
		return version;
	}
	
	public void setVersion(Long version){
		this.version = version;
	}

	public Date getCreaedDate() {
		return creaedDate;
	}

	public void setCreaedDate(Date creaedDate) {
		this.creaedDate = creaedDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@PrePersist
	public void prePersist(){
		
		this.creaedDate = new Date();
		this.lastModifiedDate = new Date();
	}
	
	@PreUpdate
	public void preUpdate(){
		this.lastModifiedDate = new Date();
	}
}
