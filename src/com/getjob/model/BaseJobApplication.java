package com.getjob.model;

import java.sql.Timestamp;

public class BaseJobApplication {
	public Timestamp appliedAt, seenAt, approvedAt, rejectedAt;
	
	public String getApplicationStatus() {
		if(this.appliedAt != null && this.seenAt == null && this.approvedAt == null && this.rejectedAt == null) {
			return "Applied";
		}
		
		if(this.appliedAt == null && this.seenAt != null && this.approvedAt == null && this.rejectedAt == null) {
			return "Seen";
		}
		
		if(this.appliedAt == null && this.seenAt == null && this.approvedAt != null && this.rejectedAt == null) {
			return "Approved";
		}
		
		if(this.appliedAt == null && this.seenAt == null && this.approvedAt == null && this.rejectedAt != null) {
			return "Rejected";
		}
		
		return "NA";
	}
	
	public Timestamp getApplicationStatusTimeStamp() {
		if(this.appliedAt != null && this.seenAt == null && this.approvedAt == null && this.rejectedAt == null) {
			return this.appliedAt;
		}
		
		if(this.appliedAt == null && this.seenAt != null && this.approvedAt == null && this.rejectedAt == null) {
			return this.seenAt;
		}
		
		if(this.appliedAt == null && this.seenAt == null && this.approvedAt != null && this.rejectedAt == null) {
			return this.approvedAt;
		}
		
		if(this.appliedAt == null && this.seenAt == null && this.approvedAt == null && this.rejectedAt != null) {
			return this.rejectedAt;
		}
		
		return null;
	}
}
