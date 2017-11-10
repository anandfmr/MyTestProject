package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Doctor;
import com.example.demo.repository.DoctorDAO;

public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDAO docDAO;
	
	@Override
	public List<Doctor> findByLocationAndSpeciality(String location, String speciality) {
		// TODO Auto-generated method stub
		return docDAO.findByLocationAndSpeciality(location, speciality);
	}
	

}
