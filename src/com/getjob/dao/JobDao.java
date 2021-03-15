package com.getjob.dao;

import java.util.List;

import com.getjob.model.Job;

public interface JobDao {
	Boolean add(Job job);
	Boolean exists(Integer id);
	Boolean update(Job job);
	Boolean delete(Integer id);
	Job getJob(Integer id);
	List<Job> getJobs();
	Boolean apply(Integer userId);
}
