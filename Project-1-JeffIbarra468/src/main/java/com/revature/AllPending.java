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
import com.revature.service.AllPendingService;
import com.revature.service.EmpPendingService;

/**
 * Servlet implementation class AllPending
 */
public class AllPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// set up our Logger:
	private static Logger log = Logger.getLogger(AllPending.class);

	private static AllPendingService AllPendService = new AllPendingService(new ReimbursementDAOImpl());

	
	// Gets All Pending Reimbursements from Employees
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Retrives the session
		User user = (User) req.getSession().getAttribute("user");
		
		Reimbursement reimbursement = AllPendService.allPending();
		
		// Using Object Mapper to turn Java Objects into JSON
		ObjectMapper om = new ObjectMapper();
						
		// Proactively checks to see if user is null
		// If not stringfy the object User as a String jsonRepUser
		String jsonRepUser = reimbursement == null ? "" : om.writeValueAsString(reimbursement);
				
		log.trace("JSON " + jsonRepUser);
		System.out.println("JSON " + jsonRepUser);
				
		// setting content type tells browser what to expect in body of response
		resp.setContentType("application/json");
		resp.getWriter().write(jsonRepUser);
				
		// Commits response
		resp.flushBuffer();

	}

	// Goes to doGet
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AllPend: IN POST, GOES TO doGet");
		doGet(req, resp);
	}

}
