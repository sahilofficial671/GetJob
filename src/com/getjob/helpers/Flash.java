package com.getjob.helpers;

import javax.servlet.http.HttpServletRequest;

public class Flash {
	public static String error_fill_all_fields = "Fill all the mandatory fields (*).";
	public static void success(HttpServletRequest request, String message) {
		request.getSession().setAttribute("status", "success");
		request.getSession().setAttribute("message", message);
	}
	
	public static void error(HttpServletRequest request, String message) {
		request.getSession().setAttribute("status", "error");
		request.getSession().setAttribute("message", message);
	}
	
	public static void info(HttpServletRequest request, String message) {
		request.getSession().setAttribute("status", "info");
		request.getSession().setAttribute("message", message);
	}
	
	public static void warning(HttpServletRequest request, String message) {
		request.getSession().setAttribute("status", "warning");
		request.getSession().setAttribute("message", message);
	}
}
