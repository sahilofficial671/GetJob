package com.getjob.model;

public class Job {
	Integer id;
	String title, description, company, location;
	Integer salaryOffered, minExp, maxExp;
	
	public Job(String title, String description, String company, String location, Integer salaryOffered,
			Integer min_exp, Integer max_exp) {
		this.title = title;
		this.description = description;
		this.company = company;
		this.location = location;
		this.salaryOffered = salaryOffered;
		this.minExp = min_exp;
		this.maxExp = max_exp;
	}
	public Job(Integer id, String title, String description, String company, String location, Integer salaryOffered,
			Integer min_exp, Integer max_exp) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.company = company;
		this.location = location;
		this.salaryOffered = salaryOffered;
		this.minExp = min_exp;
		this.maxExp = max_exp;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSalaryOffered() {
		return salaryOffered;
	}

	public void setSalaryOffered(Integer salaryOffered) {
		this.salaryOffered = salaryOffered;
	}

	public Integer getMin_exp() {
		return minExp;
	}

	public void setMin_exp(Integer min_exp) {
		this.minExp = min_exp;
	}

	public Integer getMax_exp() {
		return maxExp;
	}

	public void setMax_exp(Integer max_exp) {
		this.maxExp = max_exp;
	}

	@Override
	public String toString() {
		return "Job [title=" + title + ", description=" + description + ", company=" + company
				+ ", location=" + location + ", salary_offered=" + salaryOffered + ", min_exp=" + minExp
				+ ", max_exp=" + maxExp + "]";
	}
}
