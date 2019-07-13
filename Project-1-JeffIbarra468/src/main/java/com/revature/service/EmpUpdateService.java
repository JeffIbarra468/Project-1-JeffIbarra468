package com.revature.service;

import com.revature.data.UserDAO;
import com.revature.model.User;

public class EmpUpdateService {

	UserDAO userDAO;
	
	public EmpUpdateService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	// Updates employee to DAOIMPl and return true if successful
	public boolean updateEmployee(User user) {
	
		boolean check = false;
		
		check = userDAO.updateEmployee(user);
		
		if(check == true)
			return true;
		else
			return false;
	}
}
