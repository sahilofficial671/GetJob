package com.getjob.dao;

import java.util.List;
import java.util.Map;

import com.getjob.model.Job;
import com.getjob.model.JobApplication;

public interface JobDao {
	Boolean add(Job job);
	Boolean exists(Integer id);
	Boolean update(Job job);
	Boolean delete(Integer id);
	Job getJob(Integer id);
	List<Job> getJobs();
	
	// Applications
	Boolean apply(Integer jobId, Integer userId);
	Boolean checkIfAppliedBefore(Integer jobId, Integer userId);
	List<JobApplication> getApplicationsByUser(Integer userId);	
}
