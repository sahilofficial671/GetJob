package com.getjob.servlets.job;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getjob.controllers.JobController;
import com.getjob.controllers.UserController;
import com.getjob.helpers.Flash;
import com.getjob.model.Job;
import com.getjob.model.User;

/**
 * Servlet implementation class JobDeleteServlet
 */
@WebServlet("/job/apply")
public class JobApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobController jobController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplyServlet() {
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
			
			User user = (User) request.getSession().getAttribute("user");
			
			if(request.getParameter("jobId") == null) {
				Flash.error(request, "Job not found.");
				response.sendRedirect(request.getContextPath()+"/jobs");
				return;
			}
			
			Integer jobId = Integer.valueOf(request.getParameter("jobId"));
			
			// Check if Job Exists
			if(!jobController.exists(jobId)) {
				Flash.error(request, "Job not found.");
				response.sendRedirect(request.getContextPath()+"/jobs");
				return;
			}
			
			// Check if haven't applied before
			if(jobController.checkIfAppliedBefore(jobId, user.getId())) {
				Flash.error(request, "You have applied for this job already.");
				response.sendRedirect(request.getContextPath()+"/jobs");
				return;
			}
			
			// Validations Passed now user can apply
			if(jobController.apply(jobId, user.getId())) {
				Flash.success(request, "Successfully Applied.");
			}else {
				Flash.error(request, "Something went wrong!");
			}
			
			response.sendRedirect(request.getContextPath()+"/jobs");
			return;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			Flash.error(request, "Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			response.sendRedirect(request.getContextPath()+"/jobs");
			return;
		}
	}
}
