<html>
<head><title>Role</title>
</head>
<body>
    <% if(request.getParameter("role").equals("Teacher")){
       response.sendRedirect("TeacherLogin.html");
       }else{
       response.sendRedirect("StudentLogin.html");
       }
    %>
</body>
</html>