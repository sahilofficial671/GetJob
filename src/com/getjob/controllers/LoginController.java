package com.getjob.controllers;

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

import com.getjob.database.DBConnection;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login/submit")
public class LoginController extends HttpServlet {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			System.out.println("Error Catch Message While Creating Connection from LoginController: " + e.getMessage());
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(login(request)) {
			response.sendRedirect("../dashboard");
		}else {
			response.sendRedirect("../");
		}	
	}
	protected Boolean login(HttpServletRequest request) 
	{
		try {
			String email, password;
			email = password = "";
			
			if(request.getParameter("email") != null) {
				email = request.getParameter("email");
			}
			if(request.getParameter("password") != null) {
				password = request.getParameter("password");
			}
			
			// Validate
			if(email.isEmpty() || password.isEmpty()) {
				request.getSession().setAttribute("status", "error");
				request.getSession().setAttribute("message", "Fill all the mandatory fields (*).");
				return false;
			}
			
			// Validation passed
			try {
				stmt = con.createStatement();
			} catch (SQLException e) {
				System.out.println("Connection Catch Message While Creating Statement from login: " + e.getMessage());
			};
			
			try {
				rs = stmt.executeQuery("select * from users where email = '"+email+"' And password = '"+password+"'");
			} catch (SQLException e) {
				System.out.println("Connection Catch Message While Executing from getUser in login: " + e.getMessage());
			}
			
			Integer count = 0;
			Boolean status = false;
			String message = "";
			String alert_status = "";
			try {
				while(rs.next()) {
					count++;
				}
			} catch (SQLException e) {
				System.out.println("Error Catch Message While Executing from getstudent in StudentDaoImpl: " + e.getMessage());
				return false;
			}
			
			if(count == 1) {
				status = true;
				alert_status = "success";
				message = "You have logged in.";
			}else {
				status = false;
				alert_status = "error";
				message = "Email & Password don't match out records.";
			}
			request.getSession().setAttribute("status", alert_status);
			request.getSession().setAttribute("logged", status);
			request.getSession().setAttribute("message", message);
			rs.close();
			stmt.close();
			return status;
			
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Executing from getstudent in createJob: " + e.getMessage());
			return false;
		}
	}
}
