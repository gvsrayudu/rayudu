package com.example.Clinic.Clinic.model;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "Patient")

public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	public Patient() {
		super();
	}
	
	public Patient(Long id, String name,int age,String gender,Date createdDate) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.createdDate=createdDate;
	}
	
	@Column(name = "name",nullable = false)
    private String name;
	
	@Column(name = "age",nullable = false)
    private int age;
	
	@Column(name = "gender",nullable = false)
    private String gender;
	
	@Column(name = "createdDate",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	

	
	
	
	
	
	

}
