package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.model.Reimbursement;

public class EmpPendingService {

	ReimbursementDAO reimbursementDAO;
	
	// Dependency injection
	public EmpPendingService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	
	public Reimbursement employeePending(Reimbursement reimbursement) {
		
		reimbursement = reimbursementDAO.employeePending(reimbursement);
		return reimbursement;
	}
}
