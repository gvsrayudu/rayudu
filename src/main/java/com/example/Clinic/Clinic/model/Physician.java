package com.example.Clinic.Clinic.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Physician")
public class Physician {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    private String name;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
