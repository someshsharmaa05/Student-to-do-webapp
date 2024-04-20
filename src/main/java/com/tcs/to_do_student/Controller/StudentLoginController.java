package com.tcs.to_do_student.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.to_do_student.dao.StudentDao;
import com.tcs.to_do_student.dto.Student;

@WebServlet(value="/student-login")
public class StudentLoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("studentemialid");
		String pass = req.getParameter("studentepassword");
		System.out.println(username);
		System.out.println(pass);
		StudentDao stdao = new StudentDao();
		Student student = stdao.getStudentByEmail(username);
//		System.out.println(student.getId());
		if (student != null) {
			if (student.getPassword().equals(pass)) {
				req.setAttribute("studentid", student.getId());
				PrintWriter pw= resp.getWriter();
				pw.write("<html><body><h3>Login Successfully !!</h3></body></html>");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("TaskHome.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
				requestDispatcher.include(req, resp);
				PrintWriter pw= resp.getWriter();
				pw.write("<html><body><h3>Wrong Password !!</h3></body></html>");
			}
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
			requestDispatcher.include(req, resp);
			PrintWriter pw= resp.getWriter();
			pw.write("<html><body><h3>Wrong User-Name  !!</h3></body></html>");
		}
	}
}
