/**
 * Implementation of the UserService interface.
 * This class provides the business logic for user operations.
 */
package com.devglan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.UserDao;
import com.devglan.model.UserDetails;
import com.devglan.service.UserService;

/**
 * Implementation of the UserService interface that provides business logic for user operations.
 * This class acts as an intermediary between the controller and the DAO layer.
 */
@Service  // Marks this class as a Spring service component to be detected in component scanning
public class UserServiceImpl implements UserService {
	
	/**
	 * UserDao dependency injected by Spring.
	 * Used to perform database operations related to users.
	 */
	@Autowired  // Enables dependency injection of the UserDao
	private UserDao userDao;

	/**
	 * Retrieves a list of all user details by delegating to the DAO layer.
	 * This method serves as a pass-through to the UserDao's getUserDetails method.
	 * 
	 * @return List of UserDetails objects containing user information
	 */
	@Override
	public List<UserDetails> getUserDetails() {
		// Delegate the call to the DAO layer and return the result
		return userDao.getUserDetails();
	}
}