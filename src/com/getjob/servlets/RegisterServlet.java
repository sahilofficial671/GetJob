package com.getjob.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
@WebServlet("/register/submit")
public class RegisterServlet extends HttpServlet {
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private static final long serialVersionUID = 1L;
	private UserController userController; 
       
    public RegisterServlet() {
		try {
			con = DBConnection.getConnection();
			userController = new UserController();
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Validate & Register User
		if(userController.validateRegistration(request) 
				&& userController.add(userController.getNewUserFromValidatedRequest(request))) {
			Flash.success(request, "Account Successfully Created.");
		}
		
		response.sendRedirect("../");
	}
}
