package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.model.Reimbursement;

public class OneEmployeeService {

	ReimbursementDAO reimbursementDAO;
	
	// Dependency injection
	public OneEmployeeService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	
	
	// Pass in the EmpID to retrieve all their reimbursements
	public Reimbursement employeeRequests(long userId) {
		
		Reimbursement reimbursement = reimbursementDAO.employeeRequests(userId);
		return reimbursement;
	}
}
