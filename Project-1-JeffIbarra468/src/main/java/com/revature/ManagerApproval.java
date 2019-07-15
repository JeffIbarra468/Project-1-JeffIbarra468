package com.revature;

import java.io.IOException;
import java.util.function.LongPredicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.data.ReimbursementDAOImpl;
import com.revature.service.ManagerApprovalService;

/**
 * Servlet implementation class ManagerApproval
 */
public class ManagerApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ManagerApprovalService MangAppService = new ManagerApprovalService(new ReimbursementDAOImpl());
	
	
	// GETs the html page user is requesting
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.getWriter().append("ManagerApproval Served at: ").append(req.getContextPath());

		// redirects session to appropiate html
//		resp.sendRedirect("/Project-1-JeffIbarra468/advanced-pages/resRem.html");
		
		// forwards session to appropriate html 
//		req.getRequestDispatcher("/advanced-pages/resRem.html").forward(req, resp);
	}

	// Manager's choice for reimbursement request
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long remId = Long.parseLong(req.getParameter("remId"));
		String status = req.getParameter("status");
		
		System.out.println("remId: " + remId + " Status: " + status);
		
		if(MangAppService.managerApproval(status, remId))
			{
				System.out.println("Success resolving reimbursment");
				resp.sendRedirect("/WEB-INF/employeeHomePage.html");
			}
		else
			{
				System.out.println("Manager approval/rejection Failed");
				resp.getWriter()
				.write("<html><h1>Manager approval/rejection Failed</h1>" + "<a href=\"/Project-1-JeffIbarra468\">Go back</a></html>");
			}
	}

}
