package com.example.Clinic.Clinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "holiday")
public class Holidays {

@Column(name = "holidayName",nullable = false)	
private String  holidayName;

@Column(name = "holidaydDate",nullable = false)
@Temporal(TemporalType.TIMESTAMP)
private Date holidaydDate;

@Column(nullable = false)
@Temporal(TemporalType.TIMESTAMP)
private Date createdDate;

@Column(nullable = false)
@Temporal(TemporalType.TIMESTAMP)
private Date modifiedDate;

@NotBlank
private String createdBy;

@NotBlank
private String modifiedBy;

	
	public Holidays() {
		super();
	}
	
	public Holidays(String holidayName,Date holidayDate,Date createdDate,Date modifiedDate,String createdBy,String modifiedBy) {
		this.holidayName=holidayName;
		this.holidaydDate=holidayDate;
		this.createdDate=createdDate;
		this.modifiedDate=modifiedDate;
		this.createdBy=createdBy;
		this.modifiedBy=modifiedBy;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public Date getHolidaydDate() {
		return holidaydDate;
	}

	public void setHolidaydDate(Date holidaydDate) {
		this.holidaydDate = holidaydDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
