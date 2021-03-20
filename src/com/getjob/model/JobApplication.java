package com.getjob.model;

import java.sql.Timestamp;

public class JobApplication extends BaseJobApplication{
	Integer id;
	Integer jobId, userId;
	Timestamp appliedAt, seenAt, approvedAt, updatedAt, rejectedAt;
	Boolean status;
	Job job;
	User user;
	public JobApplication() {
		// TODO Auto-generated constructor stub
	}
	public JobApplication(Integer id, Integer jobId, Integer userId, Timestamp appliedAt, Timestamp seenAt,
			Timestamp approvedAt, Timestamp updatedAt, Timestamp rejectedAt, Boolean status) {
		this.id = id;
		this.jobId = jobId;
		this.userId = userId;
		this.appliedAt = appliedAt;
		this.seenAt = seenAt;
		this.approvedAt = approvedAt;
		this.updatedAt = updatedAt;
		this.rejectedAt = rejectedAt;
		this.status = status;
	}
	public JobApplication(Integer jobId, Integer userId, Timestamp appliedAt, Timestamp seenAt, Timestamp approvedAt,
			Timestamp updatedAt, Timestamp rejectedAt, Boolean status) {
		this.jobId = jobId;
		this.userId = userId;
		this.appliedAt = appliedAt;
		this.seenAt = seenAt;
		this.approvedAt = approvedAt;
		this.updatedAt = updatedAt;
		this.rejectedAt = rejectedAt;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Timestamp getAppliedAt() {
		return appliedAt;
	}
	public void setAppliedAt(Timestamp appliedAt) {
		super.appliedAt = appliedAt;
		this.appliedAt = appliedAt;
	}
	public Timestamp getSeenAt() {
		return seenAt;
	}
	public void setSeenAt(Timestamp seenAt) {
		this.seenAt = seenAt;
	}
	public Timestamp getApprovedAt() {
		return approvedAt;
	}
	public void setApprovedAt(Timestamp approvedAt) {
		this.approvedAt = approvedAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Timestamp getRejectedAt() {
		return rejectedAt;
	}
	public void setRejectedAt(Timestamp rejectedAt) {
		this.rejectedAt = rejectedAt;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Job getJob() {
		return job;
	}
	
	public void setJob(Job job) {
		this.job = job;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "JobApplication [id=" + id + ", jobId=" + jobId + ", userId=" + userId + ", appliedAt=" + appliedAt
				+ ", seenAt=" + seenAt + ", approvedAt=" + approvedAt + ", updatedAt=" + updatedAt + ", rejectedAt="
				+ rejectedAt + ", status=" + status + ", job=" + job + ", user=" + user + "]";
	}
}
