package com.getjob.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.getjob.model.User;

public interface UserDao {
	Boolean add(User user);
	Boolean update(User user);
	Boolean delete(User user);
	User getUser(Integer id);
	List<User> getUsers();
	
	// Auth
	Boolean validateLogin(HttpServletRequest request);
	Boolean authenticate(HttpServletRequest request);
	Boolean bindUserToSession(HttpServletRequest request, ResultSet rs);
	User getAuthUser(Integer id);
	User register(User user);
}
