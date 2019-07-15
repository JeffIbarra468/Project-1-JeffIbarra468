package com.revature;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.ReimbursementDAOImpl;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.EmpPendingService;

/**
 * Servlet implementation class EmployeePending
 */
public class EmployeePending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// set up our Logger:
	private static Logger log = Logger.getLogger(EmployeePending.class);

	private static EmpPendingService EmpPendService = new EmpPendingService(new ReimbursementDAOImpl());

	
	// Handles Fetch requests
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute("user");
		
		// Gets remID from session 
		long remId = user.getRemId();
			
		// Gets reimbursement object from database via DAO via Serivce
		Reimbursement reimbursement = EmpPendService.employeePending(remId);
		
		// Using Object Mapper to turn Java Objects into JSON
		ObjectMapper om = new ObjectMapper();
				
		// Proactively checks to see if user is null
		// If not stringfy the object User as a String jsonRepUser
		String jsonRepUser = reimbursement == null ? "" : om.writeValueAsString(reimbursement);
		
		log.trace("JSON " + jsonRepUser);
//		System.out.println("JSON " + jsonRepUser);
		
		// setting content type tells browser what to expect in body of response
		resp.setContentType("application/json");
		resp.getWriter().write(jsonRepUser);
		
		// Commits response
		resp.flushBuffer();
	}

	// Goes to Fetch
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("EmpPend: IN POST, GOES TO doGet");
		doGet(req, resp);
	}

}
