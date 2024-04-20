package com.tcs.to_do_student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.to_do_student.connection.StudentConnection;
import com.tcs.to_do_student.dto.Student;

public class StudentDao {
	static Connection connection = StudentConnection.getStudentConnection();
	public Student insertStudent(Student student) {
		String query = "insert into student values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getFathername());
			ps.setObject(4, student.getDob());
			ps.setLong(5, student.getPhone());
			ps.setString(6, student.getPassword());
			ps.setString(7, student.getGender());
			ps.setString(8, student.getBloodgroup());
			ps.setString(9, student.getEmail());
			ps.execute();
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Student getStudentByEmail(String username) {
		String query = "select * from student where email=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Student(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("fathername"),
						rs.getDate("dob").toLocalDate(),
						rs.getLong("phone"),
						rs.getString("password"),
						rs.getString("gender"),
						rs.getString("bloodgroup"),
						rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Student getStudentById(int studentid) {
		String query = "select * from student where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, studentid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Student(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("fathername"),
						rs.getDate("dob").toLocalDate(),
						rs.getLong("phone"),
						rs.getString("password"),
						rs.getString("gender"),
						rs.getString("bloodgroup"),
						rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
