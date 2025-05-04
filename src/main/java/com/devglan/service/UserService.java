/**
 * Service interface for user operations.
 * This interface defines the business logic methods related to user management.
 */
package com.devglan.service;

import java.util.List;

import com.devglan.model.UserDetails;

/**
 * Service interface that defines operations for user management.
 * This interface acts as an abstraction layer between the controller and the DAO.
 * It defines methods that encapsulate business logic related to users.
 */
public interface UserService {

	/**
	 * Retrieves a list of all user details.
	 * 
	 * @return List of UserDetails objects containing user information
	 */
	List<UserDetails> getUserDetails();
}