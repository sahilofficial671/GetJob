package com.getjob.servlets.job;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getjob.controllers.JobController;
import com.getjob.model.Job;


@WebServlet("/jobs/submit")
public class JobSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobController jobController;
       
    public JobSubmitServlet() {
		jobController = new JobController();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Add Job
		if(handle(request)) {
			response.sendRedirect("../");
		}
	}
	protected Boolean handle(HttpServletRequest request) 
	{
		try {
			
			String title, description, company, location;
			title = description =  company = location = "";
			Integer salary_offered, min_exp, max_exp;
			salary_offered = min_exp = max_exp = 0;
			
			// Initialize Variables
			if(request.getParameter("title") != null) {
				title = request.getParameter("title");	
			}
			
			if(request.getParameter("description") != null) {
				description = request.getParameter("description");
			}
			
			if(request.getParameter("company") != null) {
				company = request.getParameter("company");
			}
			
			if(request.getParameter("location") != null) {
				location = request.getParameter("location");
			}
			
			if(request.getParameter("salary_offered") != null) {
				salary_offered = Integer.valueOf(request.getParameter("salary_offered"));
			}
			
			if(request.getParameter("min_exp") != null) {
				min_exp = Integer.valueOf(request.getParameter("min_exp"));
			}
			if(request.getParameter("max_exp") != null) {
				max_exp = Integer.valueOf(request.getParameter("max_exp"));
			}

			// Validate
			if(title.isEmpty() || description.isEmpty() || location.isEmpty() 
				|| company.isEmpty() || salary_offered == 0 || min_exp == 0 || max_exp == 0
			) {
				request.getSession().setAttribute("status", "error");
				request.getSession().setAttribute("message", "Fill all the mandatory fields (*).");
				return false;
			}
			
			Boolean status = jobController.add(new Job(title, description, company, location, salary_offered, min_exp, max_exp));
			
			if(status) {
				request.getSession().setAttribute("status", "success");
				request.getSession().setAttribute("message", "Account Successfully Created.");
				return status;
			}
			
			return status;
			
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
}
