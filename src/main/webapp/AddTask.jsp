<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
body{
    margin: auto;
    padding: auto;
    font-family: 'Times New Roman', Times, serif;
}
.outercontainer{
    width: 100vw;
    height: 100vh;
    margin: auto;
    display: flex;
    align-items: center;
    justify-content: center;
    /* background-image: linear-gradient(to top, #37ecba 0%, #72afd3 100%); */
    background-color: #F2F4FF;
    background-image: url("./NEWBG@2x.png");
    background-position: center center;
    background-size: 100% 100%;
}
.innercontainer{
    width: 65%;
    height: 50%;
    display: flex;
    border-radius: 15px;
    box-shadow: 5px 5px 10px rgb(180, 180, 225);
}
.box1{
    width: 45%;
    float: left;
    background-image: url("./Asset\ 5@2x.png");
    background-size: cover;
    background-position: center center;
    background-repeat: no-repeat;
    border-radius: 15px 0px 0px 15px ;
}
.box2{
    /* background-image: linear-gradient(to right, #92fe9d 0%, #00c9ff 100%); */
    /* background-color: floralwhite; */
    background-color: white;
    width: 55%;
    float: right;
    padding: 10px 0px 0px 50px;
    font-size: 18px;
    border-radius: 0px 15px 15px 0px ;
}
button{
    margin-top: 30px;
    border: none;
    border-radius: 15px;
    padding: 15px 75px;
    font-size: 15px;
    cursor: pointer;
    font-weight: bold;
    color: white;
    /* background-image: linear-gradient(to right, #FF5F6D, #FFC371); Gradient Background */
    /* background-color: #D9AFD9; */

    /* background-image: linear-gradient(0deg, #D9AFD9 0%, #97D9E1 100%); */
    transition: background-color 0.8s ease;
}
#btn1{
    background-color: #a3a0a0;
}
#btn2{
    background-color: #F2B200;
    margin-left: 20px;
}
#btn1:hover{
    background-color: #858282;
}
#btn2:hover{
    background-color:#c69205;
}
h3{
    margin-top: 50px;
    font-size: 28px;
    line-height: 0%;
    margin-bottom: 50px;
}
input,textarea,option,select{
    /* background-color: #D0F0C0; */
}
	
</style>
</head>
<body>
    <div class="outercontainer">
        <div class="innercontainer">
          <div class="box1"></div>
          <div class="box2">
            <center>
              <h3>Add Task !!</h3>
            </center>
            <form action="taskadd" method="get">   
                    <label for="tname" >Task Name :</label>
                    <input type="text" id="tname" placeholder="Enter Task Name " name="taskname">
                    <br><br>
    
                    <label for="" >Task Date :</label>
                    <input type="date" name="taskdate">
                    <br><br>
    
                    <label for="">Task Discricption :</label><br>
                    <textarea name="taskinfo" id="" cols="50" rows="1" placeholder="About the Task :"></textarea>
                    <input type="text"  name="studentid" hidden="true" value="<%=request.getParameter("studentid")%>">
              <button type="reset" id="btn1">Clear All</button>
              <button type="submit" id="btn2">Add Task</button>
            </form>
          </div>
        </div>
      </div>
</body>
</html>