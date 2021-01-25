package com.example.Clinic.Clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Clinic.Clinic.repository.ClinicRepository;

@Controller
public class AppController {
	
	@Autowired
	private ClinicRepository clinicRepository;
	
	

}
