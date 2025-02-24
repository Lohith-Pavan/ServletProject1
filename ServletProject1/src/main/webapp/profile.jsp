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
        String name = (String)request.getAttribute("username");
        String email = (String)request.getAttribute("email");
        String phonenumber = (String)request.getAttribute("tel");
   %>
 name : <%=name %>
 email: <%=email %>
 phone number: <%=phonenumber %>
</body>
</html>