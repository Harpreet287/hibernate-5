package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.UserDetails;
import com.devglan.service.UserService;

/**
 * REST controller class that handles HTTP requests related to User operations.
 * Updated to use modern Spring annotations.
 */
@RestController  // Combined @Controller and @ResponseBody
public class UserController {
    
    private final UserService userService;
    
    /**
     * Constructor injection for UserService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * Handles HTTP GET requests to the "/list" endpoint.
     * Updated to use @GetMapping instead of @RequestMapping
     * 
     * @return ResponseEntity containing a list of UserDetails objects
     */
    @GetMapping("/list")
    public ResponseEntity<List<UserDetails>> userDetails() {
        List<UserDetails> userDetails = userService.getUserDetails();
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}