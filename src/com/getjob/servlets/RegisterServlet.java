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

import com.getjob.database.DBConnection;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/register/submit")
public class RegisterServlet extends HttpServlet {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			System.out.println("Error Catch Message While Creating Connection from RegisterController: " + e.getMessage());
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(createUser(request)) {
			response.sendRedirect("../");
		}
	}
	protected Boolean createUser(HttpServletRequest request) 
	{
		try {
			String name, email, password, phone;
			name = email =  password = phone = "";
			Integer age;
			pstmt = con.prepareStatement("insert into users (name, email, password, phone, age) values (?, ?, ?, ?, ?)");
			
			if(request.getParameter("name") != null) {
				name = request.getParameter("name");
				pstmt.setString(1, request.getParameter("name"));
			}
			
			if(request.getParameter("email") != null) {
				email = request.getParameter("email");
				pstmt.setString(2, request.getParameter("email"));
			}
			
			if(request.getParameter("password") != null) {
				password = request.getParameter("password");
				pstmt.setString(3, request.getParameter("password"));
			}
			
			if(request.getParameter("phone") != null) {
				phone = request.getParameter("phone");
				pstmt.setString(4, request.getParameter("phone"));
			}
			
			if(request.getParameter("age") != null) {
				age = Integer.valueOf(request.getParameter("age"));
				pstmt.setInt(5, Integer.valueOf(request.getParameter("age")));
			}
			
			// Validate
			if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
				request.getSession().setAttribute("status", "error");
				request.getSession().setAttribute("message", "Fill all the mandatory fields (*).");
				return false;
			}
			
			// Validation passed
			Boolean status = pstmt.executeUpdate() == 1;
			
			if(status) {
				request.getSession().setAttribute("status", "success");
				request.getSession().setAttribute("message", "Account Successfully Created.");
				pstmt.close();
				return status;
			}
			
			pstmt.close();
			return status;
			
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Executing from getstudent in createUser: " + e.getMessage());
			return false;
		}
	}
}
