package com.example.demo.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Doctor;
@Repository
@Transactional
public class DoctorDAOImpl implements DoctorDAO{
	private SessionFactory sessionFactory;
	
	@Autowired
	public DoctorDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> findByLocationAndSpeciality(String location, String speciality) {
		
		Session session=this.sessionFactory.getCurrentSession();
		TypedQuery<Doctor> query=(TypedQuery<Doctor>) session.getNamedQuery("findByLocationAndSpeciality");
		query.setParameter("location", location);
		query.setParameter("speciality", speciality);
		List<Doctor> doctors=query.getResultList();
		return doctors;
	}

}
