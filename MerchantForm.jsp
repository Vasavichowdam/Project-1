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
<form:form action="saveMerchant" modelAttribute="merchantobj">
enter name :<form:input path ="name"/>
enter mobilenumber :<form:input path ="mobilenum"/>
enter email :<form:input path ="email"/>
enter pswrd :<form:input path ="pswrd"/>

<input type = "submit">
 </form:form>
</body>
</html>
