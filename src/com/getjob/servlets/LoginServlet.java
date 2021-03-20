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
import com.getjob.helpers.Flash;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login/submit")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserController userController; 
       
    public LoginServlet() {
		try {
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
		}
		
		response.sendRedirect(request.getContextPath());
	}
	protected Boolean login(HttpServletRequest request) 
	{
		try {
			// Validate
			if(userController.validateLogin(request)) {
				Boolean status = false;
				
				// Login
				if(userController.authenticate(request)) {
					status = true;
					Flash.success(request, "You have logged in.");
				}else {
					Flash.error(request, "Email & Password don't match out records.");
				}
				
				request.getSession().setAttribute("logged", status);
				return status;
			}
			
			return false;
			
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
}
