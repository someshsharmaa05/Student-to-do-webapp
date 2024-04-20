package com.tcs.to_do_student.dto;

import java.time.LocalDate;

public class Task {

	private int tid;
	private String tname;
	private String tdiscription;
	private LocalDate tdate;
	private int sid;
	public Task() {
		super();
	}
	public Task(int tid, String tname, String tdiscription, LocalDate tdate, int sid) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tdiscription = tdiscription;
		this.tdate = tdate;
		this.sid = sid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTdiscription() {
		return tdiscription;
	}
	public void setTdiscription(String tdiscription) {
		this.tdiscription = tdiscription;
	}
	public LocalDate getTdate() {
		return tdate;
	}
	public void setTdate(LocalDate tdate) {
		this.tdate = tdate;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
