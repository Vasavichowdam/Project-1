<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action ="saveCustomer" modelAttribute ="Customerobj">
Enter name :<form:input path="name"/> <br>
Enter address:<form:input path="address"/> <br>
Enter mobilenum :<form:input path="mobilenum"/> <br>
Enter email :<form:input path="email"/> <br>
Enter pswrd :<form:input path="pswrd"/> <br>

<input type = "submit" value ="Register">
</form:form>
</body>
</html>
