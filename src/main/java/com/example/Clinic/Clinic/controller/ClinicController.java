package com.example.Clinic.Clinic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Clinic.Clinic.model.Patient;
import com.example.Clinic.Clinic.repository.ClinicRepository;
import com.example.Clinic.Clinic.repository.HolidayRepository;
import com.example.Clinic.Clinic.exception.ResourceNotFoundException;
import com.example.Clinic.Clinic.exception.DuplicateException;
import com.example.Clinic.Clinic.exception.HolidayException;
import com.example.Clinic.Clinic.model.Holidays;

import org.springframework.ui.Model;


@RestController
@RequestMapping("/api/patient")
public class ClinicController {
	List <Holidays> totalHolidays;
	@Autowired
	private ClinicRepository clinicRepository;
	
	@Autowired
	private HolidayRepository holidayRepository;
	
	//get holiday list
	 public List < Holidays > getHolidayList() {
	    	totalHolidays = this.holidayRepository.findAll();
	    	if(totalHolidays.size() >0) {
	    	 return totalHolidays;
	    	}else {
	    		return new ArrayList<Holidays>();
	    	}
	         
	    }
	
	
	// get all patients
   // @GetMapping
   // public List < Patient > getAllPatients() {
       //return this.clinicRepository.findAll();
    //}
	
    @GetMapping("/")
    public String getAllPatients(Model model) {
    	List<Patient> listPatients = this.clinicRepository.findAll();
    	model.addAttribute("listPatents",listPatients);
    	return "index";
    }
   
	
 /* get patient by id
   // @GetMapping("/api/patient/{id}")
    public Patient getPatientById(@PathVariable long id) {
    	
    	Optional<Patient> patient = this.clinicRepository.findById(id);
    	if (!patient.isPresent())
    		throw new ResourceNotFoundException("id-" + id);
            return patient.get();
    }*/
    
    
    
 // get patient by id
    @GetMapping("/api/patient/{id}")
    public Patient getPatientById(@PathVariable long id) {
    	
    	Optional<Patient> patient = this.clinicRepository.findById(id);
    	if (!patient.isPresent())
    		throw new ResourceNotFoundException("id-" + id);
            return patient.get();
    }
    
 // delete patient by id
    
    @DeleteMapping("/api/patient/{id}")
    public void deletePatientById(@PathVariable long id) {
    	 this.clinicRepository.deleteById(id);
    }
    
    //create patient
    @PostMapping("/api/patient")
    public ResponseEntity<Object> createPatient(@RequestBody Patient patient) {
    	
    	Optional<Patient>  existPatient = this.clinicRepository.findById(patient.getId()) ;
    	//duplicate records found
    	if (existPatient.isPresent()) {
    		throw new DuplicateException("id-" + patient.getId());
    	}else if(totalHolidays.size()>0) {
    		Date createDate =patient.getCreatedDate();
    		    if(totalHolidays.contains(createDate)) 
    		    	throw new HolidayException("Today ispublic holiday!! ");
    		        return ResponseEntity.notFound().build();
    	}else {	
    		
    		Patient savedPatient = clinicRepository.save(patient);
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPatient.getId()).toUri();
    		return ResponseEntity.created(location).build();
    	}
    }
    
    //update patient
    @PutMapping("/api/patient/{id}")
	public ResponseEntity<Object> updatePatient(@RequestBody Patient patient, @PathVariable long id) {

		Optional<Patient> patientOptional = clinicRepository.findById(id);

		if (!patientOptional.isPresent())
			return ResponseEntity.notFound().build();
         if(totalHolidays.size()>0) {
    		Date createDate =patient.getCreatedDate();
    		    if(totalHolidays.contains(createDate)) 
    		    	throw new HolidayException("Today ispublic holiday!! ");
    		        return ResponseEntity.notFound().build();
    	}else {
		    patient.setId(id);
		    clinicRepository.save(patient);
		    return ResponseEntity.noContent().build();
    	}
	}
}
