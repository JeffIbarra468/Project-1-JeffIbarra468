package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.model.Reimbursement;

public class EmpResolvedService {

	ReimbursementDAO reimbursementDAO;
	
	// Dependency injection
	public EmpResolvedService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	
	public Reimbursement employeeResolved(Reimbursement reimbursement) {
		
		reimbursement = reimbursementDAO.employeeResolved(reimbursement);
		return reimbursement;
	}	
}
