<html>
<head>
<style>

.parent-container{
height:50vh;
display:flex;
justify-content:center;
align-items:center;
}
 .container {
        width:50%;
        padding: 25px;
        background-color: lightblue;
    }
  form {
         border: 5px solid #f1f1f1;
         padding: 30px;
     }
  button {
         background-color: #4CAF50;
         width: 60%;
          color: black;
          padding: 10px;
          margin: 10px 0px;
          border: none;
          cursor: pointer;
          font-size:15px;
           }
</style>
</head>
<body>
<h2 align ="center" style="font-size:40px">Teacher-Student Portal</h2><hr><br>
<div class="parent-container">
    <div  class = "container"align="center">
    <form action="role.jsp">
        <p><h2>Please select your role :</h2></p>
        <input type="radio"  name="role" value="Teacher">
        <label >Teacher</label><br>
        <input type="radio"  name="role" value="Student">
        <label >Student</label><br><br>
        <button type="submit">Submit</button>
      </form>
    </div>
    </div>
</body>
</html>
