/**
 * Data Access Object (DAO) interface for User-related database operations.
 * This interface defines the contract for database operations that can be performed on User entities.
 * Following the DAO pattern, it separates the application/business layer from the persistence layer.
 */
package com.devglan.dao;

import java.util.List;

import com.devglan.model.UserDetails;

public interface UserDao {
	
    /**
     * Retrieves all user details from the database.
     * 
     * @return A list of UserDetails objects containing all users stored in the database
     */
	List<UserDetails> getUserDetails();
}