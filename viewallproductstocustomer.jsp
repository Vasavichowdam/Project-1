<%@page import="com.jsp.Shopping_Cart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.Shopping_Cart.dto.Customer"%>
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
 List<Product> products =(List<Product>)request.getAttribute("productslist");
 %>
 <h1>
 <a href ="fetchitemsfromcart">view cart</a>
 </h1>
 <table cellPadding="20px" border ="1">
  <th>id</th>
  <th>brand</th>
  <th>model</th>
  <th>category</th>
  <th>price</th>
   <th>add to cart</th>
    
    
    <%
    for (Product p : products) {
    %>
    <tr>
       <td><%= p.getId() %></td>
       <td><%= p.getBrand() %></td>
       <td><%= p.getModel() %></td>
       <td><%= p.getCategory() %></td>
       <td><%= p.getPrice() %> </td>
       
       <td> <a href ="additem?id=<%=p.getId()%>">add</a> </td>
    </tr>
    <%
    }
    %>
    </table>
</body>
</html>
