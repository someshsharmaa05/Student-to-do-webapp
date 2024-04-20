<%@page import="com.tcs.to_do_student.dto.Student"%>
<%@page import="com.tcs.to_do_student.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body{
        margin: auto;
        width: 100%;
        height: 100%;
        font-family: 'Times New Roman', Times, serif;
    }
    .container{
        width: 100vw;
        height: 100vh;
        display: flex;
        flex-direction: column;
        /* justify-content: center; */
        align-items: center;
    }
    button{
        padding: 20px 30px;
        height: 80px;
        width: 350px;
        font-size: 24px;
        font-family: 'Times New Roman', Times, serif;
    }
    .container>:first-child{
        margin-top: 80px;
    }
    .container>:nth-child(2){
        margin-top: 50px;
    }
    .container>:last-child{
        margin-top: 50px;
    }
    .greet{
        margin: 60px 0px 0px 200px;
        text-shadow: 5px 5px 10px rebeccapurple;
    }
    .dateform{
        border: 2px solid gray;
        height: 80px;
        width: 280px;
        padding-left: 80px;
        padding-bottom: 20px;
        background-color: rgba(128, 128, 128, 0.76));
    }
</style>
<body>


<%
	int id = (int)request.getAttribute("studentid");
	StudentDao sdao = new StudentDao();
	Student student = sdao.getStudentById(id);
%>
	
 	<h3 class="greet">Hello Somesh !!</h3>
    <div class="container">
        <div>
            <a href="AddTask.jsp?studentid=<%= student.getId() %>"><button id="b1" type="button">Add Your Task </button></a>
        </div>
        <div>
        	<a href="TaskDisplay.jsp?studentid=<%= student.getId() %>"><button id="b2" type="button"> Display Your Task </button></a>
        </div>
        <div>
            <div class="dateform">
                <h3>Disaply Task By Date</h3>
                <form action="taskdisplaybydate" method="get">
                    <input type="date" name="taskdate">
                    <input type="text" hidden="true" name="studentid" value="<%= student.getId() %>">
                    <input type="submit">
                </form>
            </div>
        </div>

    </div>
    <script type="text/javascript">
    let greet = document.querySelector('.greet');
    greet.innerHTML = "<h3>Hello <%=student.getName()%></h3>";
    </script>
</body>
</html>