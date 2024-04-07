<%@page import="com.jsp.Shopping_Cart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%Merchant  m=(Merchant)session.getAttribute("merchantinfo") ; %>
<% if(m!=null) { %>
  <h1 style = color:green>${message}</h1>
  <h1>
  <a href ="addProduct">addProduct</a>
  </h1>
  <h1> 
  <a href ="Viewallproducts.jsp">View all products</a> 
  </h1>
  <% }
  else{
  %>
  <h1> <a href="Merchantloginform.jsp">please login first</a></h1>
  <%
  }
  %>
</body>
</html>
