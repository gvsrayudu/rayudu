package com.example.Clinic.Clinic.dao;

import java.util.List;

import com.example.Clinic.Clinic.model.Patient;

public interface PatientDAO {
	
	public void addPatien(Patient p);
	public void updatePatien(Patient p);
	public List<Patient> listPatiens();
	public Patient getPatienById(int id);
	public void removePatienn(int id);

}
