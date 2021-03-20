package com.getjob.model;

public class BaseUser {
	// User Types
	public static Integer jobSeeker = 1;
	public static Integer recruiter = 2;
	
	public Integer type;
	
	public Boolean isJobSeeker() {
		return this.type == jobSeeker;
	}
	
	public Boolean isRecruiter() {
		return this.type == recruiter;
	}
}
