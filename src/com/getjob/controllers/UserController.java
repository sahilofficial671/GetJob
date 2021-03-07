package com.getjob.controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.getjob.dao.UserDao;
import com.getjob.database.DBConnection;
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
	public Boolean add(User user) {
		// TODO Auto-generated method stub
		return null;
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
			request.getSession().setAttribute("status", "error");
			request.getSession().setAttribute("message", "Fill all the mandatory fields (*).");
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
			return count == 1 && bindUserToSession(request, rs) ? true : false;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
	
	@Override
	public Boolean bindUserToSession(HttpServletRequest request, ResultSet rs) {
		try {
			// Set session span to 2 hours
			request.getSession().setMaxInactiveInterval(7200);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select id, name, email, phone, age from users where email = '"+request.getParameter("email")+"' And password = '"+request.getParameter("password")+"'");
			User user = new User();
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getInt(4));
				user.setAge(rs.getInt(5));
			}
			request.getSession(false).setAttribute("name", user.getName());
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
	public User getAuthUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkAuth(HttpServletRequest request) {
		if(request.getSession().getAttribute("logged") != null && (boolean) request.getSession().getAttribute("logged")) {
			return true;
		}
		request.getSession().setAttribute("status", "error");
		request.getSession().setAttribute("message", "Please log in first.");
		request.getSession().setAttribute("redirect_to", request.getRequestURI());
		return false;
	}

}
