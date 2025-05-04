package com.devglan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devglan.dao.UserDao;
import com.devglan.model.UserDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * Implementation of the UserDao interface that provides database operations for user details.
 * Updated for Hibernate 6 compatibility.
 */
@Component
public class UserDaoImpl implements UserDao {

    /**
     * EntityManager injected by Spring.
     * This replaces the EntityManagerFactory injection in Hibernate 5.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Retrieves all user details from the database using JPA Criteria API.
     * Updated to use EntityManager directly as recommended in Hibernate 6.
     * 
     * @return List of UserDetails objects containing user information
     */
    @Override
    public List<UserDetails> getUserDetails() {
        // Create a CriteriaBuilder directly from EntityManager
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        
        // Create a typed CriteriaQuery for UserDetails class
        CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);
        
        // Define the root entity (FROM clause) for the query
        Root<UserDetails> userRoot = criteria.from(UserDetails.class);
        
        // Select the root entity (SELECT clause)
        criteria.select(userRoot);
        
        // Execute the query and return the results
        return entityManager.createQuery(criteria).getResultList();
    }
}