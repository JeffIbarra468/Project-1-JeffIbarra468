package com.revature.data;

import com.revature.model.Reimbursement;

public interface ReimbursementDAO {

	// Employee submits a reimbursement request
	public boolean submitReimbursement(Reimbursement reimbursement);

	// Employee views their pending requests
	public Reimbursement employeePending(Reimbursement reimbursement);

	// Employee views their resolved requests
	public Reimbursement employeeResolved(Reimbursement reimbursement);

	// Manager approves or deny request
	public boolean managerApproval(Reimbursement reimbursement);		

	// Manager views all pending requests
	public Reimbursement allPending();

	// Manager views all resolved requests
	public Reimbursement allResolved();

	// Manager views request from specific employee
	public Reimbursement employeeRequests(long userId);


	/*
	 * VIEW ALL EMPLOYEES - CAN BE DONE BY UNION PENDING AND RESOLVED
	 * REIMBURSMENTS TABLE
	 */
}
