package com.revature.service;

import com.revature.data.ReimbursementDAO;

public class ManagerApprovalService {

	ReimbursementDAO reimbursementDAO;
	
	public ManagerApprovalService(ReimbursementDAO reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	
	
	// References Manager Approval in DAOIMPL
	public boolean managerApproval(String status, long uId) {
		
		boolean check = false;
		
		check = reimbursementDAO.managerApproval(status, uId);
		
		if(check == true)
			return true;
		else
			return false;
	}
	
}
