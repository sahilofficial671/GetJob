package com.getjob.controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.getjob.dao.UserDao;
import com.getjob.database.DBConnection;
import com.getjob.helpers.Flash;
import com.getjob.model.User;

public class UserController implements UserDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection con = null;
	
	public UserController() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
		}
	}
	
	@Override
	public Boolean validateRegistration(HttpServletRequest request) {
		String name, email, password, phone;
		name = email =  password = phone = "";
		Integer age, type;
		age = type = null;
		
		if(request.getParameter("name") != null) {
			name = request.getParameter("name");
		}
		
		if(request.getParameter("email") != null) {
			email = request.getParameter("email");
		}
		
		if(request.getParameter("password") != null) {
			password = request.getParameter("password");
		}

		if(request.getParameter("type") != null 
				&& (Integer.valueOf(request.getParameter("type")) == 1 
				|| Integer.valueOf(request.getParameter("type")) == 2)){
			type = Integer.valueOf(request.getParameter("type"));
		}
		
		if(request.getParameter("phone") != null) {
			phone = request.getParameter("phone");
		}
		
		if(request.getParameter("age") != null) {
			age = Integer.valueOf(request.getParameter("age"));
		}
		
		// Validate
		if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || type == null || age == null || password.isEmpty()) {
			Flash.error(request, Flash.error_fill_all_fields);
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean add(User user) {
		try {
			pstmt = con.prepareStatement("insert into users (name, email, password, type, phone, age) values (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getType());
			pstmt.setString(5, user.getPhone());
			pstmt.setInt(6, user.getAge());
			Boolean status = pstmt.executeUpdate() == 1;
			pstmt.close();
			return status;
		} catch (SQLException e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public User getNewUserFromValidatedRequest(HttpServletRequest request) {
		return new User(request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("password"),
				Integer.valueOf(request.getParameter("type")),
				request.getParameter("phone"),
				Integer.valueOf(request.getParameter("age"))
		);
	}
	
	@Override
	public Boolean validateLogin(HttpServletRequest request) {
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
			Flash.error(request, Flash.error_fill_all_fields);
			return false;
		}
		
		return true;
	}
	
	@Override
	public Boolean authenticate(HttpServletRequest request) {
		Integer count = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from users where email = '"+request.getParameter("email")+"' And password = '"+request.getParameter("password")+"'");
			
			while(rs.next()) {
				count++;
			}
			
			rs.close(); 
			stmt.close();
			return (count == 1 && bindUserToSession(request, request.getParameter("email"))) ? true : false;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
	
	@Override
	public Boolean bindUserToSession(HttpServletRequest request, String email) {
		try {
			// Set session span to 2 hours
			request.getSession().setMaxInactiveInterval(7200);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id, name, email, type, phone, age from users where email = '"+email+"'");
			User user = new User();
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setType(rs.getInt(4));
				user.setPhone(rs.getString(5));
				user.setAge(rs.getInt(6));
			}

			request.getSession(false).setAttribute("user", user);
			rs.close(); 
			stmt.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean checkAuth(HttpServletRequest request) {
		if(request.getSession().getAttribute("logged") != null && (boolean) request.getSession().getAttribute("logged")) {
			return true;
		}
		Flash.error(request, "Please log in first.");
		request.getSession().setAttribute("redirect_to", request.getRequestURI());
		return false;
	}
	

	@Override
	public Boolean update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getAuthUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
