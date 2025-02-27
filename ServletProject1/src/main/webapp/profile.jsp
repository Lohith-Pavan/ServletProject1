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
        String name = (String)session.getAttribute("username");
        String email = (String)session.getAttribute("email");
        Integer phonenumber = (Integer)session.getAttribute("tel");
   %>
 <h1>name : <%=name %></h1><br>
 <h1>email: <%=email %></h1><br>
 <h1>phone number: <%=phonenumber %></h1>
 <a href = "profile2.jsp">go to next page</a>
</body>
</html>