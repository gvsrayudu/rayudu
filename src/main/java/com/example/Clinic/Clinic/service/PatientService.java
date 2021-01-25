package com.example.Clinic.Clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Clinic.Clinic.repository.ClinicRepository;
import com.example.Clinic.Clinic.model.Patient;

@Service
@Transactional
public class PatientService {
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	public List<Patient> listAll() {
        return clinicRepository.findAll();
    }
     
    public void save(Patient patient) {
    	clinicRepository.save(patient);
    }
     
    public Patient get(long id) {
        return clinicRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	clinicRepository.deleteById(id);
    }
	

}
