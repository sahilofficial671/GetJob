package com.getjob.model;

public class User {
	Integer id;
	String name, email, password;
	Integer phone, age;
	public User() {
		
	}
	// with Id
	public User(Integer id, String name, String email, String password, Integer phone, Integer age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.age = age;
	}
	// without id
	public User(String name, String email, String password, Integer phone, Integer age) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.age = age;
	}
	
	// without password
	public User(Integer id, String name, String email, Integer phone, Integer age) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", age=" + age + "]";
	}


}
