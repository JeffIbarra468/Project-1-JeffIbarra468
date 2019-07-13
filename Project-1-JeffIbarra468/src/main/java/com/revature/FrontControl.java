package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.UserDAOImpl;
import com.revature.model.User;
import com.revature.service.LoginService;
import com.revature.service.StringService;

/**
 * Servlet implementation class FrontControl
 */
public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(FrontControl.class);
	
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		
		log.trace("FrontController received URI: " + req.getRequestURI());
		
		
		String[] tokens = req.getRequestURI().split("/");
		
		log.trace("tokens received: " + Arrays.toString(tokens));

		// May not need this given LoginServlet
		/*	
		if(tokens.length == 3) {
			req.getRequestDispatcher("/index.html").forward(req, resp);;
			return;
		}
		*/
		
		System.out.println("t0 " + tokens[0]);
		System.out.println("t1 " + tokens[1]);
		System.out.println("t2 " + tokens[2]);
		System.out.println("t3 " + tokens[3]);
		
		PrintWriter writer = resp.getWriter();
		
		
		// THIS GIVES ME NULL POINT EXCEPTION ERROR 
		// token[3] == fetchEmpRes.js
		// There maybe a problem with the clicker EVENT
		// IF THE REQUEST IS A POST LEAVE AS .HTML FILE
		// OTHERWISE WRITE AS FILENAME.JS
		// OTHERWISE KEEP IN MIND OF THE POST STUFF FOR
		// REIMBURSEMENT IT MAY NEED TO REFERENCE THE EMPLOYEE ID
		// AND WE MAY NOT HAVE IT AKA HAVE TO CHANGE THE TABLE AGAIN
		//
		/*
		// Every GET request will forward session information
		try {
			switch(tokens[3]) {
			case "allPen.html":
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/AllPending").forward(req, resp);
				break;
			case "allRes.html":
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/AllResolved").forward(req, resp);
				break;
			case "empPen.html":
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/EmployeePending").forward(req, resp);
				break;
			case "empRes.html":
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/EmployeeResolved").forward(req, resp);
				break;
			case "empUpD.html":
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/EmployeeUpdate").forward(req, resp);
				break;
//			case "empView.html":
//				// to forward to a Servlet, use the Servlet's mapping
//				System.out.println("IN EMPVIEW");
//				req.getRequestDispatcher("/empView").forward(req, resp);
//				break;
			case "newRmb.html":
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/ReimbursementView").forward(req, resp);
				break;
			case "oneEmp.html":
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/OneEmployee").forward(req, resp);
				break;
			case "resRem.html":
				// 	MANAGER APPROVE DENY SERVLET - NOT FINISHED
				// to forward to a Servlet, use the Servlet's mapping
				req.getRequestDispatcher("/resRem").forward(req, resp);
				break;
			default:
				resp.sendError(404);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			resp.sendError(400, "No argument given to String method url");
		}
		*/
	}

}