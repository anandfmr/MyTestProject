package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Doctor;

public interface DoctorService {
	
	public List<Doctor> findByLocationAndSpeciality(String location, String 
		      speciality);

}
