package com.getjob.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.getjob.model.User;

public interface UserDao {
	Boolean update(User user);
	Boolean delete(User user);
	User getUser(Integer id);
	List<User> getUsers();

	// Auth
	Boolean add(User user);
	Boolean validateRegistration(HttpServletRequest request);
	User getNewUserFromValidatedRequest(HttpServletRequest request);
	
	Boolean validateLogin(HttpServletRequest request);
	Boolean checkAuth(HttpServletRequest request);
	Boolean authenticate(HttpServletRequest request);
	Boolean bindUserToSession(HttpServletRequest request, String email);
	User getAuthUser(Integer id);
}
