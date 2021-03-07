package com.getjob.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getjob.controllers.JobController;
import com.getjob.database.DBConnection;

@WebServlet("/")
public class AppServlet extends HttpServlet {
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	private static final long serialVersionUID = 1L;
	
	private JobController jobController;

    public AppServlet() {
		try {
			con = DBConnection.getConnection();
			jobController = new JobController();
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getSession().getAttribute("logged") != null && (boolean) request.getSession().getAttribute("logged")) {
//			response.sendRedirect("./dashboard");
//			return ;
//		}
		request.setAttribute("jobs", jobController.getJobs());
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}
}
