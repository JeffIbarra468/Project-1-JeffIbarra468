package com.revature;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.pattern.IntegerPatternConverter;

import com.revature.data.ReimbursementDAOImpl;
import com.revature.data.UserDAOImpl;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.LoginService;
import com.revature.service.SubmitService;

/**
 * Servlet implementation class ReimbursementView
 */
public class ReimbursementView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static SubmitService SubmitService = new SubmitService(new ReimbursementDAOImpl());
	

	// Handle fetch requests
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("ReimbursementView Served at: ").append(req.getContextPath());
	}

	
	// Handle submitting Reimbursement
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute("user");
		
		// Gets remID from session 
		long uId = user.getRemId();
		
		// Sets reimbursement ID
		if(uId == 0L)
			uId = 1;
		else
			uId++;
			
		String descrip = req.getParameter("description");
		Double cost = Double.parseDouble(req.getParameter("cost"));

		System.out.println("DES: " + descrip + "\nCost: " + cost);
		
		
		// Call submitReimb service to pass descrip and cost (String descrip, Double cost)
		if(SubmitService.submitReimbursement(uId, descrip, cost))
			{
				System.out.println("Success submitting reimbursment");
				resp.sendRedirect("/WEB-INF/employeeHomePage.html");
			}
		else 
		{
			System.out.println("Reimbursement Failed");
			resp.getWriter()
			.write("<html><h1>Reimbursement Failed</h1>" + "<a href=\"/Project-1-JeffIbarra468\">Go back</a></html>");
		}
		
	}

}
