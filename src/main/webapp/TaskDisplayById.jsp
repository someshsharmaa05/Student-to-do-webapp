<%@page import="java.time.LocalDate"%>
<%@page import="com.tcs.to_do_student.dto.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.tcs.to_do_student.dao.TaskDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int sid;
LocalDate tdate;
	try{
		sid = (int)request.getAttribute("studentid");
		tdate =(LocalDate)request.getAttribute("taskdate");
	}catch(Exception e){
		sid = Integer.parseInt(request.getParameter("studentid"));
		tdate =LocalDate.parse(request.getParameter("taskdate"));
	}
	TaskDao tdao = new TaskDao();
	List<Task> tasks = tdao.getTasksByStudentIdAndDate(sid, tdate);
%>
<div>
        <table border="2" cellpadding="5px">
            <thead style="background-color: black; color:white; ">
                <tr>
                    <th>Id</th>
                    <th>Task Name</th>
                    <th>Task Discription</th>
                    <th>Task Date</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody style="background-color: aquamarine;">
            <%for(Task task : tasks){ %>
                <tr>
                    <th><%=task.getTid() %></th>
                    <th><%=task.getTname() %></th>
                    <th><%=task.getTdiscription() %></th>
                    <th><%=task.getTdate() %></th>
                    <th><a href="DeleteTask?taskid=<%= task.getTid() %>"><button style='background-color:red; color:white; padding:5px 10px'>Delete</button></a></th>
                    <th><a href="UpdateTask.jsp?taskid=<%= task.getTid() %>"><button style='background-color:blue; color:white; padding:5px 10px'>Update</button></a></th>
                </tr>
                <%} %>
            </tbody>
        </table>
    </div>
</body>
</html>