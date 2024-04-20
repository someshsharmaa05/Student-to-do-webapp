package com.tcs.to_do_student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tcs.to_do_student.connection.StudentConnection;
import com.tcs.to_do_student.dto.Task;

public class TaskDao {
	static Connection connection = StudentConnection.getStudentConnection();
	public Task InsertTask(Task task) {
		String query = "insert into task(tname,tdiscription,tdate,sid) values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, task.getTname());
			ps.setString(2, task.getTdiscription());
			ps.setObject(3, task.getTdate());
			ps.setInt(4, task.getSid());
			ps.execute();
			return task;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Task> getTasksByStudentId(int sid){
		List<Task> tasks = new ArrayList<Task>();
		String query="select * from task where sid =?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tasks.add(
						new Task(rs.getInt("tid"),
								rs.getString("tname"),
								rs.getString("tdiscription"),
								rs.getDate("tdate").toLocalDate(),
								rs.getInt("sid")));
			}
			return tasks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	public List<Task> getTasksByStudentIdAndDate(int sid,LocalDate date){
		List<Task> tasks = new ArrayList<Task>();
		String query="select * from task where sid =? and tdate=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, sid);
			ps.setObject(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tasks.add(
						new Task(rs.getInt("tid"),
								rs.getString("tname"),
								rs.getString("tdiscription"),
								rs.getDate("tdate").toLocalDate(),
								rs.getInt("sid")));
			}
			return tasks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	public Task getTasksByTAskId(int tid){
		String query="select * from task where tid =?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return(
						new Task(rs.getInt("tid"),
								rs.getString("tname"),
								rs.getString("tdiscription"),
								rs.getDate("tdate").toLocalDate(),
								rs.getInt("sid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Task updateTask(Task task) {
		String query = "update task set tname=?,tdiscription=?,tdate=? where tid =?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, task.getTname());
			ps.setString(2, task.getTdiscription());
			ps.setObject(3, task.getTdate());
			ps.setInt(4, task.getTid());
			ps.execute();
			return task;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int deleteTask(int tid) {
		String query = "delete from task where tid=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, tid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
