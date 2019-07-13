package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.model.Reimbursement;

public class AllPendingService {

	ReimbursementDAO reimbursementDAO;
	
	// Dependency injection
	public AllPendingService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	
	public Reimbursement allPending() {
		
		Reimbursement reimbursement = reimbursementDAO.allPending();
		return reimbursement;
	}
}
