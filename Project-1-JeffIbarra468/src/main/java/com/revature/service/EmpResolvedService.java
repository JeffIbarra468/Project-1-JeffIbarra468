package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.model.Reimbursement;

public class EmpResolvedService {

	ReimbursementDAO reimbursementDAO;
	
	// Dependency injection
	public EmpResolvedService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	
	public Reimbursement employeeResolved(long remId) {
		
		Reimbursement reimbursement = reimbursementDAO.employeeResolved(remId);
		return reimbursement;
	}	
}
