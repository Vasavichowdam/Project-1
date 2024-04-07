<%@page import="com.jsp.Shopping_Cart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Customer c =(Customer)session.getAttribute("customerinfo") ;
if(c!=null) {
%>
  <h1 style=color:green>${msg}</h1>
  <h1>
  <a href="displayProducts">Display all products</a>
  </h1>
   <h1>
  <a href ="readbrandfromcustomer.jsp">Display all products by brand</a>
  </h1>
  
  <% } else { %>
    <h1><a href="CustomerLoginForm.jsp">LoginFirst</a></h1>
    <% } %>
</body>
</html>
