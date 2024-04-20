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
    height: 80%;
    display: flex;
    border-radius: 15px;
    box-shadow: 5px 5px 10px rgb(180, 180, 225);
}
.box1{
    width: 45%;
    float: left;
    background-image: url("./smiling-happy-indian-student-with-backpack-pointing-his-finger-wall.jpg");
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
    font-size: 28px;
    line-height: 0%;
    margin-bottom: 40px;
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
            <h3>Student Registration !!</h3>
          </center>
          <form action="insertstudent" method="get">
            <label for="stid">Student Id :</label>
            <input
              class="myinput"
              type="number"
              id="stid"
              placeholder="Enter your id"
              name="studentid"
            />
            <br /><br />
            <label for="stname">Student Name :</label>
            <input
              class="myinput"
              type="text"
              id="stname"
              placeholder="Enter Your Name "
              name="studentname"
            />
            <br /><br />
            <label for="stfather">Father Name :</label>
            <input
              class="myinput"
              type="text"
              id="stfather"
              placeholder="Enter Your Father Name "
              name="studentfathername"
            />

            <br /><br />
            <label for="stphone">Phone no. :</label>
            <input
              class="myinput"
              type="tel"
              id="stphone"
              placeholder="Enter Your Phone no. "
              name="studentphoneno"
            />

            <br /><br />
            <label for="stemail">Email Id :</label>
            <input
              class="myinput"
              type="email"
              id="stemail"
              placeholder="Enter Your Email id "
              name="studentemialid"
            />
            <br><br>
            <label for="stpass" >Password :</label>
                <input type="password" id="stpass" placeholder="Enter Your Password " name="studentepassword">

            <br /><br />
            <label for="">Gender:</label>
            <input type="radio" name="studentgender" value="male" />Male
            <input type="radio" name="studentgender" value="female" />Female
            <input type="radio" name="studentgender" value="other" />Other
            <br /><br />

            <label for="">DOB :</label>
            <input type="date" name="studentdob" />
            <br /><br />

            <label for="">Address :</label>
            <textarea
              class="myinput"
              name="studentaddress"
              id=""
              cols="50"
              rows="1"
              placeholder="Enter your Address :"
            ></textarea
            ><br /><br />

            <label for="">Blood Group :</label>
            <select name="studentbloodgroup" id="">
              <option value="">Select Your Blood Group</option>
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="AB">AB</option>
              <option value="O">O</option>
            </select>
            <br /><br />
            <button type="reset" id="btn1">Clear All</button>
            <button type="submit" id="btn2">Sign Up</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>