package com.revature;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.UserDAOImpl;
import com.revature.model.User;
import com.revature.service.LoginService;

public class EmployeeView extends HttpServlet {

	// set up our Logger:
	private static Logger log = Logger.getLogger(LoginServlet.class);

	// get our LoginService
	private static LoginService loginService = new LoginService(new UserDAOImpl());


	// Responses to Fetch GET requests
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
				
		// Gets attribute from session 
		User user = (User) req.getSession().getAttribute("user");

		// Using Object Mapper to turn Java Objects into JSON
		ObjectMapper om = new ObjectMapper();
				
		// Proactively checks to see if user is null
		// If not stringfy the object User as a String jsonRepUser
		String jsonRepUser = user == null ? "" : om.writeValueAsString(user);
		
		log.trace("JSON " + jsonRepUser);
		System.out.println("JSON " + jsonRepUser);
		
		// setting content type tells browser what to expect in body of response
		resp.setContentType("application/json");
		resp.getWriter().write(jsonRepUser);
		
		// Commits response
		resp.flushBuffer();		
	}
	
}
