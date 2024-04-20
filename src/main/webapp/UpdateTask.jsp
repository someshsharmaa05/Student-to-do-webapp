<%@page import="com.tcs.to_do_student.dto.Task"%>
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
	int tid = Integer.parseInt(request.getParameter("taskid"));
	TaskDao tdao = new TaskDao();
	Task task = tdao.getTasksByTAskId(tid);
%>
	<div >
		<div>
			<h3>UPDATE TASK.....</h3>
		</div>
        <div >
        	<form action="taskupdate" method="post">   
            <fieldset>
                <legend>About Task..</legend>
                <br>
                <label for="tname" >Task Name :</label>
                <input type="text" id="tname" placeholder="Enter Your Name " name="taskname" value="<%=task.getTname()%>">
                <br><br>

                <label for="" >Task Date :</label>
                <input type="date" name="taskdate" value="<%=task.getTdate()%>">
                <br><br>

                <label for="">Task Discricption :</label>
                <textarea name="taskinfo" id="" cols="50" rows="1" placeholder="About the Task :" ><%=task.getTdiscription()%></textarea><br><br>
                <br><br>
                <input type="text"  name="tid" hidden="true" value="<%=request.getParameter("taskid")%>">
				<button type="reset">Clear All</button>
                <button type="submit">Update Task</button>
            </fieldset>
        </form>
        </div>
    </div>
</body>
</html>