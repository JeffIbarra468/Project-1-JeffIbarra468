package com.revature.data;

import com.revature.model.User;

public interface UserDAO {

	public User getUser(String username, String password);
	
	public User getEmployee(long id);
	
	public boolean createUser(User user);
	
	public boolean updateEmployee(User user);
	
	public User getAllEmployees();
}
