package com.example.Clinic.Clinic.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "notes")
public class Visit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitedDate;
	
	@Column(nullable = false)
	private Long PhysicianId;
	
	@NotBlank
    private String resion;
	
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
	

}
