/**
 * Controller class that handles HTTP requests related to User operations.
 * This class acts as the entry point for user-related API endpoints.
 * The @Controller annotation marks this class as a Spring MVC controller.
 */
package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devglan.model.UserDetails;
import com.devglan.service.UserService;

@Controller
public class UserController {
	
    /**
     * Autowired instance of UserService to handle business logic for user operations.
     * Spring injects the appropriate implementation of UserService interface through dependency injection.
     */
	@Autowired
	private UserService userService;
	
    /**
     * Handles HTTP GET requests to the "/list" endpoint.
     * Retrieves a list of all user details from the service layer.
     * 
     * @return ResponseEntity containing a list of UserDetails objects and an HTTP status code
     */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> userDetails() {
        // Call the service layer to retrieve user details
		List<UserDetails> userDetails = userService.getUserDetails();
        // Return the user details with HTTP 200 OK status
		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
	}
}