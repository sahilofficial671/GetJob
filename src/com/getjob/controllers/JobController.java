package com.getjob.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.getjob.dao.JobDao;
import com.getjob.database.DBConnection;
import com.getjob.model.Job;
import com.getjob.model.JobApplication;


public class JobController implements JobDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection con = null;
	
	public JobController() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
		}
	}
	
	@Override
	public Boolean add(Job job) {
		try {
			pstmt = con.prepareStatement("insert into jobs (title, description, company, location, salary_offered, min_exp, max_exp) values (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, job.getTitle());
			pstmt.setString(2, job.getDescription());
			pstmt.setString(3, job.getCompany());
			pstmt.setString(4, job.getLocation());
			pstmt.setInt(5, job.getSalaryOffered());
			pstmt.setInt(6, job.getMin_exp());
			pstmt.setInt(7, job.getMax_exp());
			Boolean status = pstmt.executeUpdate() == 1;
			pstmt.close();
			return status;
			
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
	
	@Override
	public Boolean update(Job job) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Boolean delete(Integer id) {
		try {
			return con.createStatement().executeUpdate("DELETE FROM jobs WHERE id= "+id) == 1;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName()+", Message: "+ e.getMessage());
			return false;
		}
	}
	
	@Override
	public Job getJob(Integer id) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select id, title, description, company, location, salary_offered, min_exp, max_exp from jobs where id = "+id);
			
			Job job = new Job();
			while(rs.next()) {
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescription(rs.getString(3));
				job.setCompany(rs.getString(4));
				job.setLocation(rs.getString(5));
				job.setSalaryOffered(rs.getInt(6));
				job.setMin_exp(rs.getInt(7));
				job.setMax_exp(rs.getInt(8));
			}

			rs.close();
			stmt.close();
			return job;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Job> getJobs() {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from jobs");
			List<Job> jobs = new ArrayList<>();
			while(rs.next()) {
				jobs.add(new Job(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), 
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			rs.close();
			stmt.close();
			return jobs;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return null;
		}
	}

	@Override
	public Boolean exists(Integer id) {
		Integer count = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from jobs where id = "+id);
			while(rs.next()) {
				count++;
			}			
			rs.close(); 
			stmt.close();
			return count == 1 ? true : false;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean apply(Integer jobId, Integer userId) {
		try {
		    Date utilDate = new Date();
			Timestamp sqlTS = new Timestamp(utilDate.getTime());
			
			pstmt = con.prepareStatement("insert into job_users (jobId, userId, appliedAt, status) values (?, ?, ?, ?)");
			pstmt.setInt(1, jobId);
			pstmt.setInt(2, userId);
			pstmt.setTimestamp(3, sqlTS);
			pstmt.setBoolean(4, true);

			Boolean status = pstmt.executeUpdate() == 1;
			pstmt.close();
			return status;
			
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean checkIfAppliedBefore(Integer jobId, Integer userId) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from job_users where jobId = "+jobId+" And userId = "+userId);
			if (rs.isBeforeFirst() && rs.next() && rs.isFirst() && rs.isLast() && rs.getInt(1) == 1) {
				return true;
			}
			rs.close();
			stmt.close();
			return false;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}

	@Override
	public List<JobApplication> getApplicationsByUser(Integer userId) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select id, jobId, userId, appliedAt, status from job_users where userId = "+userId);
			List<JobApplication> applications = new ArrayList<>();
			
			while(rs.next()) {
				JobApplication jobApplication = new JobApplication();
				jobApplication.setId(rs.getInt(1));
				jobApplication.setJobId(rs.getInt(2));
				jobApplication.setUserId(rs.getInt(3));
				jobApplication.setAppliedAt(rs.getTimestamp(4));
				jobApplication.setStatus(rs.getBoolean(5));
				applications.add(jobApplication);
			}
			
			rs.close();
			stmt.close();
			
			// Bind Job
			for(JobApplication application : applications) {
				application.setJob(getJob(application.getJobId()));;
			}
			
			// Bind User
			for(JobApplication application : applications) {
				application.setJob(getJob(application.getUserId()));
			}
			
			return applications;
		} catch (Exception e) {
			System.out.println("Error from: " + this.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return null;
		}
	}
}
