package com.tcs.to_do_student.Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value=("/taskdisplaybydate"))
public class DisplayTaskByDateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("studentid"));
		LocalDate tdate = LocalDate.parse(req.getParameter("taskdate"));
		System.out.println(sid);
		System.out.println(tdate);
		req.setAttribute("studentid", sid);
		req.setAttribute("taskdate", tdate);
		req.getRequestDispatcher("TaskDisplayById.jsp").forward(req, resp);
	}
}
