package com.devglan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devglan.dao.UserDao;
import com.devglan.model.UserDetails;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * Implementation of the UserDao interface that provides database operations for user details.
 * This class uses Hibernate and JPA to interact with the database.
 * (Migrated to use jakarta.persistence instead of javax.persistence)
 */
@Component  // Marks this class as a Spring component to be detected in component scanning
public class UserDaoImpl implements UserDao {

	/**
	 * EntityManagerFactory dependency injected by Spring.
	 * Used to create EntityManager instances that provide persistence operations.
	 */
	@Autowired  // Enables dependency injection of the EntityManagerFactory
	private EntityManagerFactory entityManagerFactory;

	/**
	 * Retrieves all user details from the database using Hibernate Criteria API.
	 * 
	 * @return List of UserDetails objects containing user information
	 */
	@Override
	public List<UserDetails> getUserDetails() {
		// Unwrap the JPA EntityManagerFactory to get Hibernate's SessionFactory
		// and open a new Hibernate Session
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		
		// Create a CriteriaBuilder instance to build the query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		// Create a CriteriaQuery instance for the UserDetails class
		CriteriaQuery criteria = builder.createQuery(UserDetails.class);
		
		// Define the root entity (FROM clause) for the query
		Root contactRoot = criteria.from(UserDetails.class);
		
		// Select the root entity (SELECT clause)
		criteria.select(contactRoot);
		
		// Execute the query and return the results
		return session.createQuery(criteria).getResultList();
	}
}