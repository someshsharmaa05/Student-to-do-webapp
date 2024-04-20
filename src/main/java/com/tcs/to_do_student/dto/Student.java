package com.tcs.to_do_student.dto;

import java.time.LocalDate;

public class Student {

	private int id;
	private String name;
	private String fathername;
	private LocalDate dob;
	private Long phone;
	private String password;
	private String gender;
	private String bloodgroup;
	private String email;
	public Student(int id, String name, String fathername, LocalDate dob, Long phone, String password, String gender,
			String bloodgroup ,String email) {
		super();
		this.id = id;
		this.name = name;
		this.fathername = fathername;
		this.dob = dob;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
		this.bloodgroup = bloodgroup;
		this.email = email;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
