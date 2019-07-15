package com.revature.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reimbursement {

	/*
	 * SQL Table
	 * uId | descrip | cost | status
	 */
	
	private long uId;
	private long remId;
	private String descrip;
	private double cost;
	private String status;
	
	public Reimbursement(ResultSet resultSet) throws SQLException {
		
		this(resultSet.getLong("emp_Id"),
				resultSet.getLong("rem_Id"),
				resultSet.getString("rem_descrip"),
				resultSet.getDouble("rem_cost"),
				resultSet.getString("rem_status")
				);		
	}
	
	//Getters and Setters
	public long getuId() {
		return uId;
	}
	public void setuId(long uId) {
		this.uId = uId;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getRemId() {
		return remId;
	}
	public void setRemId(long remId) {
		this.remId = remId;
	}

	// Field Constructor
	public Reimbursement(long uId, long remId, String descrip, double cost, String status) {
		this.uId = uId;
		this.remId = remId;
		this.descrip = descrip;
		this.cost = cost;
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		
		return "User Id: " + uId + "\nDescription: " + descrip 
				+ "\nCost: " + cost + "\nStatus: " + status;
	}
}
