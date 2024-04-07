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
 <form:form action="saveProduct" modelAttribute ="ProductObj">
Enter brand: <input type="brand" name="brand"/> <br>
Enter model: <input type="model" name="model"/> <br>
Enter category:<input type="category" name ="category"/> <br>
Enter price: <input type="price" name = "price"/> <br>
Enter stock: <input type="stock" name="stock"/> <br>
<input type = "submit">
</form:form>
</body>
</html>
