package com.tcs.to_do_student.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.to_do_student.dao.TaskDao;
import com.tcs.to_do_student.dto.Task;
@WebServlet(value="/DeleteTask")
public class DeleteTaskController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tid = Integer.parseInt(req.getParameter("taskid"));
		TaskDao tdao = new TaskDao();
		Task task = tdao.getTasksByTAskId(tid);
		int result = tdao.deleteTask(tid);
		PrintWriter pw = resp.getWriter();
		req.setAttribute("studentid", task.getSid());
		req.getRequestDispatcher("TaskDisplay.jsp").include(req, resp);
		if (result!=0) {
			pw.write("<html><body><h3>Task Deleted Successfully !!</h3></body></html>");
		} else {
			pw.write("<html><body><h3>Failed to Delete Task !!</h3></body></html>");
		}
	}
}
