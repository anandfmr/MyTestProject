package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.DoctorDAOImpl;
import com.example.demo.service.DoctorList;
import com.example.demo.service.DoctorService;

@RestController
public class DoctorSearchController {

	@Autowired
	DoctorService dserv;
	
	@Autowired
	DoctorDAOImpl docDAO;
	
	@RequestMapping(value="/doctors", method=RequestMethod.GET, produces="application/json")
	public DoctorList searchDoctor(
			@RequestParam(value="location",required=false) String location,
			@RequestParam(value="speciality",required=false) String speciality,DoctorService dserv
			)
	{
	
	DoctorList doclist=new DoctorList(dserv.findByLocationAndSpeciality(location, speciality));
	return doclist;
}
	
	
}