package com.tcs.to_do_student.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.to_do_student.dao.TaskDao;
import com.tcs.to_do_student.dto.Task;
@WebServlet(value="/taskupdate")
public class UpdateTaskController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskname = req.getParameter("taskname");
		String taskinfo = req.getParameter("taskinfo");
		LocalDate tdate = LocalDate.parse(req.getParameter("taskdate"));
		int tid = Integer.parseInt(req.getParameter("tid"));
		System.out.println(taskname);
		System.out.println(taskinfo);
		System.out.println(tdate);
		System.out.println(tid);
		TaskDao tdao = new TaskDao();
		Task task =  tdao.getTasksByTAskId(tid);
		task.setTname(taskname);
		task.setTdate(tdate);
		task.setTdiscription(taskinfo);
		Task task2 = tdao.updateTask(task);
		PrintWriter pw = resp.getWriter();
		req.setAttribute("studentid", task2.getSid());
		req.setAttribute("taskdate", task2.getTdate());
		req.getRequestDispatcher("TaskDisplay.jsp").include(req, resp);
		if (task2 != null) {
			pw.write("<html><body><h3>Task did not update !!</h3></body></html>");
		} else {
			pw.write("<html><body><h3>Task did not update !!</h3></body></html>");
		}
	}
}
