package com.getjob.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getjob.controllers.UserController;
import com.getjob.database.DBConnection;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login/submit")
public class LoginServlet extends HttpServlet {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private static final long serialVersionUID = 1L;
	private UserController userController; 
       
    public LoginServlet() {
		try {
			con = DBConnection.getConnection();
			userController = new UserController();
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(login(request)) {
			if(request.getSession().getAttribute("redirect_to") != null) {
				String redirect_to = (String)request.getSession().getAttribute("redirect_to");
				request.getSession().setAttribute("redirect_to", null);
				response.sendRedirect(redirect_to);
				return ;
			}
			
			response.sendRedirect(request.getContextPath()+"/dashboard");
		}else {
			response.sendRedirect("../");
		}	
	}
	protected Boolean login(HttpServletRequest request) 
	{
		try {
			// Validate
			if(userController.validateLogin(request)) {
				Boolean status = false;
				Boolean logged = null;
				String message = "";
				String alert_status = "";
				
				// Login
				if(userController.authenticate(request)) {
					logged = status = true;
					alert_status = "success";
					message = "You have logged in.";
				}else {
					status = false;
					status = false;
					alert_status = "error";
					message = "Email & Password don't match out records.";
				}
				
				request.getSession().setAttribute("status", alert_status);
				request.getSession().setAttribute("logged", logged);
				request.getSession().setAttribute("message", message);

				return status;
			}
			
			return false;
			
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
}
