package com.revature;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.UserDAO;
import com.revature.data.UserDAOImpl;
import com.revature.model.User;
import com.revature.service.LoginService;

//import com.revature.data.UserDAO;
//import com.revature.service.LoginService;

public class LoginServlet extends HttpServlet {

	// setting up a few constants to test our user and pass
	// from the client against. Later we'll replace
	// this with a DB call.

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
//		System.out.println("JSON " + jsonRepUser);
		
		// setting content type tells browser what to expect in body of response
		resp.setContentType("application/json");
		resp.getWriter().write(jsonRepUser);
		
		// Commits response
		resp.flushBuffer();
	}
	
	
	// Get the username and password
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		log.trace("hello");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");

//		System.out.println("UN:" + username + "\nPW:" + password);

		// If credentials are correct
		if (loginService.validate(username, password)) {

			log.trace("Client authentication success");
			
			//gets session
			HttpSession session = req.getSession();

			// Attach user account to session
			session.setAttribute("user", loginService.getUser(username, password));
		
			// Employee role
			String role = loginService.getUser(username, password).getRole();
			log.trace("EMP Role: " + role);
			
			// switch direction based on role of employee
			switch(role) {
				case "Associate":
					// Forward credentials and user to the welcome page
					req.getRequestDispatcher("/WEB-INF/employeeHomePage.html").forward(req, resp);
					break;
				case "Manager":
					// Forward credentials and user to the welcome page
					req.getRequestDispatcher("/WEB-INF/managerHomePage.html").forward(req, resp);
					break;
				default:
					log.trace("Client authorization failure");
			}
		} else { // Failed Login
			log.trace("Client login failed");
			resp.getWriter()
					.write("<html><h1>Failed login!</h1>" + "<a href=\"/Project-1-JeffIbarra468\">Go back</a></html>");
		}
	}
}
