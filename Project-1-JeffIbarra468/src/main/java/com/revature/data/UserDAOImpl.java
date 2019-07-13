package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.util.CloseStreams;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	// Getting user from login - role can be associate or employee
	@Override
	public User getUser(String username, String password) {
		
//		System.out.println("getUser ");
//		System.out.println("getUN:" + username + "\ngetPW:" + password);
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		
		//  Seperate SQL command from code - prevent SQL inject 
		try(Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Employees WHERE emp_userN = ? AND emp_passW = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();
			user = new User(resultSet);
			
		} catch (SQLException e) {
			System.err.println("Invalid Username & Password, Goodbye");
//			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}
		
		return user;
	}
		
	
	// Get a specific employee's information based on id and role
	@Override
	public User getEmployee(long id) {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		
		//  Seperate SQL command from code - prevent SQL inject 
		try(Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Employees WHERE emp_id = ? and emp_role = 'Associate'");
			statement.setLong(1, id);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();
			user = new User(resultSet);
			
		} catch (SQLException e) {
//			System.out.println("Invalid Username & Password, Goodbye");
//			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}
		
		return user;
	}
	
	public boolean createUser(User user) {
		
		return user==null ? false : true;
	}

	
	// User may update their personal information - may not change role
	@Override
	public boolean updateEmployee(User user) {
		
		final String SQL_UPDATE = "UPDATE Employees SET emp_firstN =?, emp_lastN =?, emp_userN = ?, emp_passW = ? WHERE emp_id =? and emp_role = 'Associate'";
		PreparedStatement statement = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(SQL_UPDATE);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getPassword());
			statement.setLong(5, user.getUserId());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			CloseStreams.close(statement);
		}
		
		return true;
	}
	
	
	// Manager can received a list of all employees
	public User getAllEmployees() {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		
		//  Seperate SQL command from code - prevent SQL inject 
		try(Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Employees WHERE emp_role = 'Associate'");
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();
			user = new User(resultSet);
			
		} catch (SQLException e) {
//			System.out.println("Invalid Username & Password, Goodbye");
//			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}
		
		return user;
	}
	
	
}
