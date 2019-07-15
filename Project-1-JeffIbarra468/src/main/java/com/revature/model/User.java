package com.revature.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

	/*
	 * SQL TABLE - User
	 * uId | firstN | lastN | role | userN | passW
	 */
	
	private long userId;
	private String firstName;
	private String lastName;
	private String role;
	private String username;
	private String password;
	
	public User(ResultSet resultSet) throws SQLException {
		
		this(resultSet.getLong("emp_id"),
				resultSet.getString("emp_firstN"),
				resultSet.getString("emp_lastN"),
				resultSet.getString("emp_role"),
				resultSet.getString("emp_userN"),
				resultSet.getString("emp_passW")
				);		
	}

	
	// Getters and Setters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	// Field Constructor
	public User(long userId, String firstName, String lastName, String role, String username, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return "User ID: " + userId + "\nFirst Name: " + firstName 
				+ "\nLast Name: " + lastName + "\nRole: " + role
				+ "\nUsername: " + username + "\nPassword: " + password;
	}
	
}
