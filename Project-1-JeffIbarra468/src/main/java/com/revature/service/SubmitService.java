package com.revature.service;

import com.revature.data.ReimbursementDAO;
import com.revature.model.Reimbursement;

public class SubmitService {

	ReimbursementDAO reimbursementDAO;
	
	// Dependency injection
	public SubmitService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}

	// Pass reimbursment object to DAOIMPL and return true if created successful
	public boolean submitReimbursement(Reimbursement reimbursement) {
		
		//Is false at first
		boolean check = false;
		
		check = reimbursementDAO.submitReimbursement(reimbursement);
		
		if(check == true)
			return true;
		else
			return false;
	}
}
