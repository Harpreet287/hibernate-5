/**
 * Implementation of the UserDao interface that uses Hibernate/JPA for database operations.
 * This class handles the actual database interactions for User-related operations.
 * The @Component annotation registers this class as a bean in Spring's application context.
 */
package com.devglan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devglan.dao.UserDao;
import com.devglan.model.UserDetails;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Component
public class UserDaoImpl implements UserDao {

    /**
     * Autowired EntityManagerFactory which provides access to JPA/Hibernate's persistence context.
     * Spring Boot automatically configures and injects this factory based on application properties.
     */
	@Autowired
	private EntityManagerFactory entityManagerFactory;

    /**
     * Retrieves all user details from the database using JPA Criteria API.
     * This implementation uses the JPA Criteria API for type-safe queries.
     * 
     * @return A list of all UserDetails objects stored in the database
     */
	@Override
	public List<UserDetails> getUserDetails() {
		// Unwrap the EntityManagerFactory to get the Hibernate SessionFactory and open a new session
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		
		// Create a CriteriaBuilder which is used to construct criteria queries
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		// Create a CriteriaQuery targeting the UserDetails entity
		CriteriaQuery criteria = builder.createQuery(UserDetails.class);
		
		// Define the root entity from which the query starts
		Root contactRoot = criteria.from(UserDetails.class);
		
		// Select all attributes from the root entity
		criteria.select(contactRoot);
		
		// Execute the query and return the result list
		return session.createQuery(criteria).getResultList();
	}
}