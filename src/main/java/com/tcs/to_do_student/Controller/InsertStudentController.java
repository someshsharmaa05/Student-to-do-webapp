package com.tcs.to_do_student.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.to_do_student.dao.StudentDao;
import com.tcs.to_do_student.dto.Student;
@WebServlet(value="/insertstudent")
public class InsertStudentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("studentid"));
		String name = req.getParameter("studentname");
		String fathername = req.getParameter("studentfathername");
		Long phone = Long.parseLong(req.getParameter("studentphoneno"));
		String email = req.getParameter("studentemialid");
		String password = req.getParameter("studentepassword");
		String gender = req.getParameter("studentgender");
		String bloodgroup = req.getParameter("studentbloodgroup");
		LocalDate dob = LocalDate.parse(req.getParameter("studentdob"));
		System.out.println(id);
		System.out.println(name);
		System.out.println(fathername);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(password);
		System.out.println(gender);
		System.out.println(bloodgroup);
		System.out.println(dob);
		Student student = new Student(id, name, fathername, dob, phone, password, gender, bloodgroup,email);
		StudentDao stdao = new StudentDao();
		Student student2 = stdao.insertStudent(student);
		if (student2!=null) {
			PrintWriter pw = resp.getWriter();
			pw.write("<html><body><h3>Registered Successfully !!</h3></body></html>");
			RequestDispatcher requestdispatcher = req.getRequestDispatcher("home.jsp");
			requestdispatcher.include(req, resp);
		} else {
			RequestDispatcher requestdispatcher = req.getRequestDispatcher("studentRegister.jsp");
			requestdispatcher.forward(req, resp);
		}
	}
}
