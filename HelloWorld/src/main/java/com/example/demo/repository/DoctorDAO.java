package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Doctor;

public interface DoctorDAO{
	
	public List<Doctor> findByLocationAndSpeciality(String location, String speciality);
		
	

}
