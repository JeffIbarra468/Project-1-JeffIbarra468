package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Reimbursement;
import com.revature.util.CloseStreams;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	/*
	 * SQL Table
	 * uId | descrip | cost | status
	 */
	
	// Employee submits a reimbursement request - INSERT
	@Override
	public boolean submitReimbursement(long uId, String descrip, Double cost) {
		
		PreparedStatement statement = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement("INSERT INTO Reimbursement VALUES(?,?,?,'Pending')");
			statement.setLong(1, uId);
			statement.setString(2, descrip);
			statement.setDouble(3, cost);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			CloseStreams.close(statement);
		}
		
		return true;	
	}
	
	
	// Employee views their pending requests - get
	@Override
	public Reimbursement employeePending(long remId) {
		
		Reimbursement reimbursement = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		// Seperate SQL command from code - prevent SQL inject
		try (Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Reimbursement WHERE rem_Id = ? AND rem_status = 'Pending'");
			statement.setLong(1, remId);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();
			reimbursement = new Reimbursement(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}

		return reimbursement;
	}
	
	
	// Employee views their resolved requests - get 
	@Override
	public Reimbursement employeeResolved(long remId) {
		
		Reimbursement reimbursement = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		// Seperate SQL command from code - prevent SQL inject
		try (Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Reimbursement WHERE rem_Id = ? AND rem_status != 'Pending'");
			statement.setLong(1, remId);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();
			reimbursement = new Reimbursement(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}

		return reimbursement;

	}
	
	
	// Manager approves or deny request - update
	@Override
	public boolean managerApproval(String status, long uId) {
		
		final String SQL_UPDATE = "UPDATE Reimbursement SET rem_status = ? WHERE rem_Id = ?";
		PreparedStatement statement = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(SQL_UPDATE);
			statement.setString(1, status);
			statement.setLong(2, uId);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			CloseStreams.close(statement);
		}
		
		return true;
	}
	
	
	// Manager views all pending requests - get
	@Override
	public Reimbursement allPending() {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Reimbursement reimbursement = null;

		// Seperate SQL command from code - prevent SQL inject
		try (Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Reimbursement WHERE rem_status = 'Pending'");
//			statement.setString(1, reimbursement.getStatus());
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();
			reimbursement = new Reimbursement(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}

		return reimbursement;
	}
	
	
	// Manager views all resolved requests - get
	@Override
	public Reimbursement allResolved() {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Reimbursement reimbursement = null;

		// Seperate SQL command from code - prevent SQL inject
		try (Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Reimbursement WHERE rem_status != 'Pending'");
//			statement.setString(1, reimbursement.getStatus());
			statement.execute();
			resultSet = statement.getResultSet();
			while(resultSet.next()) {
			reimbursement = new Reimbursement(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}

		return reimbursement;

	}
	
	
	// Manager views request from specific employee - get
	@Override
	public Reimbursement employeeRequests(long userId) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Reimbursement reimbursement = null;

		// Seperate SQL command from code - prevent SQL inject
		try (Connection conn = ConnectionUtil.getConnection()) {

			statement = conn.prepareStatement("SELECT * FROM Reimbursement WHERE rem_Id = ?");
			statement.setLong(1, userId);
			statement.execute();
			resultSet = statement.getResultSet();
			resultSet.next();
			reimbursement = new Reimbursement(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseStreams.close(statement);
			CloseStreams.close(resultSet);
		}

		return reimbursement;

	}
	
	
	/*
	 * VIEW ALL EMPLOYEES - CAN BE DONE BY UNION PENDING AND RESOLVED
	 * REIMBURSMENTS TABLE
	 */
	
}
