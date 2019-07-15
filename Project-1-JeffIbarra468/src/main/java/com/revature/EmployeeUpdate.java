package com.revature;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.data.UserDAOImpl;
import com.revature.model.User;
import com.revature.service.EmpUpdateService;

/**
 * Servlet implementation class EmployeeUpdate
 */
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static EmpUpdateService EmpUpService = new EmpUpdateService(new UserDAOImpl());
       
	// Handles fetch requests
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("EmployeeUpdate Served at: ").append(req.getContextPath());
	}

	// Handles Updating Employee
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute("user");
	
		String fName, lName, uName, passW;
		
		try {
			// From HTML file's user input 
			fName = req.getParameter("fName");
			lName = req.getParameter("lName");
			uName = req.getParameter("uName");
			passW = req.getParameter("passW");
		
			System.out.println("FN: " + fName + "\nLN: " + lName 
				+ "\nUN: " + uName + "\nPW: " + passW);
		
		} catch(NullPointerException e) {
			// Catches any NULL and assigns user's session variables
			// THIS MIGHT OVERWRITE ANY USER INPUT IN THIS CASE - KINDA ERROR
			
			fName = user.getFirstName();
			lName = user.getLastName();
			uName = user.getUsername();
			passW = user.getPassword();
			
			System.out.println("IN CATCH\nFN: " + fName + "\nLN: " + lName 
					+ "\nUN: " + uName + "\nPW: " + passW);
		}
		
		// Put all user inputs into object
		user.setFirstName(fName);
		user.setLastName(lName);
		user.setUsername(uName);
		user.setPassword(passW);
		
		if(EmpUpService.updateEmployee(user)) {
			System.out.println("Sucess updating Employee");
			resp.sendRedirect("/Project-1-JeffIbarra468/advanced-pages/empView.html");
		}
		else {
			System.out.println("Employee Update Failed");
			resp.getWriter()
			.write("<html><h1>Employee Update Failed</h1>" + "<a href=\"/Project-1-JeffIbarra468/advanced-pages/empUpD.html\">Go back</a></html>");
		}
		
	}

}
