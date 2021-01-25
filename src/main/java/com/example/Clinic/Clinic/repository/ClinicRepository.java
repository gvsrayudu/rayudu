package com.example.Clinic.Clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Clinic.Clinic.model.Patient;

public interface  ClinicRepository extends JpaRepository<Patient,Long>{
	
	

}
