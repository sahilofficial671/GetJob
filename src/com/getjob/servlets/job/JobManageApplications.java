package com.getjob.servlets.job;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getjob.controllers.JobController;
import com.getjob.controllers.UserController;
import com.getjob.helpers.Flash;
import com.getjob.model.JobApplication;
import com.getjob.model.User;

/**
 * Servlet implementation class JobDeleteServlet
 */
@WebServlet("/job/applications")
public class JobManageApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobController jobController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobManageApplications() {
    	jobController = new JobController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Check Auth
			if(!new UserController().checkAuth(request)) {
				response.sendRedirect(request.getContextPath()+"/login");
				return ;
			}
			
			// Check if only job seeker
			if(!((User)request.getSession().getAttribute("user")).isJobSeeker()) {
				Flash.error(request, Flash.code_403);
				response.sendRedirect(request.getContextPath()+"/login");
				return ;
			}
			
			List<JobApplication> applications = jobController.getApplicationsByUser(((User)request.getSession().getAttribute("user")).getId());

			request.setAttribute("applications", applications);
			request.getRequestDispatcher("/pages/job/applications.jsp").forward(request, response);
			return ;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			Flash.error(request, "Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			response.sendRedirect(request.getContextPath()+"/jobs");
			return;
		}
	}
}
