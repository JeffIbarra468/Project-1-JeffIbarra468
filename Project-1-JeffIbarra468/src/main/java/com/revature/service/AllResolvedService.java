package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.model.Reimbursement;

public class AllResolvedService {

	ReimbursementDAO reimbursementDAO;
	
	// Dependency injection
	public AllResolvedService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	
	public Reimbursement allResolved() {
		
		Reimbursement reimbursement = reimbursementDAO.allResolved();
		return reimbursement;
	}
}
