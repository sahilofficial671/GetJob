package com.getjob.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginViewController
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("logged") != null) {
			
			// Empty Session Variables
			request.getSession().setAttribute("logged", null);
			request.getSession().setAttribute("user", null);
			request.getSession().invalidate();
			
			// Set Session Message
			request.getSession().setAttribute("status", "success");
			request.getSession().setAttribute("message", "Successfully logged out.");
			
			// Redirect to home page.
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("pages/error/404.jsp");
		rd.forward(request, response);
	}
}
