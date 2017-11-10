package com.example.demo.domain;

public class Doctor {
	
	private String id;
	private String firstName;
	private String lastName;
	private String specialityCode;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String id, String firstName, String lastName, String specialityCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialityCode = specialityCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSpecialityCode() {
		return specialityCode;
	}
	public void setSpecialityCode(String specialityCode) {
		this.specialityCode = specialityCode;
	}
	
	

}
