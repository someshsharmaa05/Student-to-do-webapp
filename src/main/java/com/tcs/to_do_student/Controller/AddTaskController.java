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

import com.tcs.to_do_student.dao.TaskDao;
import com.tcs.to_do_student.dto.Task;
@WebServlet(value="/taskadd")
public class AddTaskController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskname= req.getParameter("taskname");
		System.out.println(taskname);
		String taskinfo = req.getParameter("taskinfo");
		System.out.println(taskinfo);
		LocalDate taskdate = LocalDate.parse(req.getParameter("taskdate"));
		System.out.println(taskdate);
		int sid = Integer.parseInt(req.getParameter("studentid"));
		System.out.println(sid);
		Task task = new Task(0, taskname, taskinfo, taskdate, sid);
		TaskDao tdao = new TaskDao();
		Task task2 = tdao.InsertTask(task);
		PrintWriter pw = resp.getWriter();
		if (task2!=null) {
			req.setAttribute("studentid", sid);
			req.getRequestDispatcher("TaskHome.jsp").include(req, resp);
			pw.write("<html><body><h3>Task Added Successfully !!</h3></body></html>");
		} else {
			pw.write("<html><body><h3>Task Not Added !!</h3></body></html>");
		}
	}
}
