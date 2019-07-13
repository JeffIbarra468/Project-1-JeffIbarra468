package com.revature.service;

import com.revature.data.UserDAO;
import com.revature.model.User;

public class LoginService {

	UserDAO userDAO;

	// dependency injection!
	public LoginService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean validate(String username, String password) {

		User user = null;
//		System.out.println("V:" + username + "\nV:" + password);

		try {
			// get the user from our DAO
			user = userDAO.getUser(username, password);
		} catch (NullPointerException e) {
			System.err.println("Invalid Username and Password");			
			String un = user.getUsername();
			String pw = user.getPassword();
			System.err.println("Invalid Username: " + un + " or Password: " + pw);
		}
		
		return user == null ? false : true;
		
/*		
		// fake check
		if(username.equals("jilrm") && password.equals("pass"))
			return true;
		else
			return false;
		// return false or true based on successfully getting the user
*/

	}
	
	public User getUser(String username, String password) {
		User user = userDAO.getUser(username, password);
		return user;
	}
}
