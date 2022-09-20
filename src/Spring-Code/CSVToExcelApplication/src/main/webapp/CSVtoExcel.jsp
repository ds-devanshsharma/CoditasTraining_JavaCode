<html>
<body>
<h1 style="text-align:center">CSV to EXCEL</h1><hr>
<div style="font-size:20px">
<Marquee> Converting your File</Marquee>
</div>
<%@page import="javax.servlet.http.Part"%>
<%@page import="java.io.*"%>
<%  Part part= request.getPart("file");
    String fileName = part.getSubmittedFileName();

%>
</body>
</html>
