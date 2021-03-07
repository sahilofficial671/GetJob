package com.getjob.servlets.job;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getjob.controllers.JobController;
import com.getjob.controllers.UserController;

/**
 * Servlet implementation class JobDeleteServlet
 */
@WebServlet("/job/delete")
public class JobDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobController jobController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDeleteServlet() {
    	jobController = new JobController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!new UserController().checkAuth(request)) {
			response.sendRedirect(request.getContextPath()+"/login");
			return ;
		}
		
		String message = "";
		String alert_status = "";
		
		if(request.getParameter("id") != null) {
			Integer id = Integer.valueOf(request.getParameter("id"));
			
			if(jobController.exists(id) && jobController.delete(id)) {
				message = "Successfully deleted.";
				alert_status = "success";
			}else {
				message = "Job not found."; alert_status = "error";
			}
		}else {
			message = "Job not found."; alert_status = "error";
		}
		
		request.getSession().setAttribute("status", alert_status);
		request.getSession().setAttribute("message", message);
		response.sendRedirect(request.getContextPath()+"/jobs");
	}
}
