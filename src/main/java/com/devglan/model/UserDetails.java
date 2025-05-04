package com.devglan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class representing the user details in the system.
 * This class is mapped to the database table using JPA annotations.
 */
@Entity  // Marks this class as a JPA entity (a persistent domain object)
@Table   // Specifies the primary table for this entity (uses class name as table name by default)
public class UserDetails {

	/**
	 * Primary key of the user details entity.
	 * The ID is automatically generated using auto-increment strategy.
	 */
	@Id  // Marks this field as the primary key
	@Column  // Maps this field to a column in the database table
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Specifies auto-increment generation strategy
	private int id;

	/**
	 * First name of the user.
	 */
	@Column  // Maps this field to a column in the database table
	private String firstName;
	
	/**
	 * Last name of the user.
	 */
	@Column  // Maps this field to a column in the database table
	private String lastName;
	
	/**
	 * Email address of the user.
	 */
	@Column  // Maps this field to a column in the database table
	private String email;
	
	/**
	 * Password of the user.
	 */
	@Column  // Maps this field to a column in the database table
	private String password;

	/**
	 * Gets the user's ID.
	 * 
	 * @return The user's ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the user's ID.
	 * 
	 * @param id The ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the user's first name.
	 * 
	 * @return The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the user's first name.
	 * 
	 * @param firstName The first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the user's last name.
	 * 
	 * @return The user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the user's last name.
	 * 
	 * @param lastName The last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the user's email address.
	 * 
	 * @return The user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user's email address.
	 * 
	 * @param email The email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the user's password.
	 * 
	 * @return The user's password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the user's password.
	 * 
	 * @param password The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}