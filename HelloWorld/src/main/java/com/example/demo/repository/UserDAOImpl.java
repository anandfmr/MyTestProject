package com.example.demo.repository;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;

@Repository
@Transactional

public class UserDAOImpl {

	@Autowired private SessionFactory sessionFactory;
	
	 public List<User> findByEmail(String email) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Query query = session.getNamedQuery("findByEmail"); 
	        query.setString("email", email); 
	        return query.list();   
	      }
}
