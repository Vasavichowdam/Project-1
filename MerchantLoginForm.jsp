<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1 style = color:red>${msg}</h1>
   
 <form action ="LoginValidation" method="post">
  enter email : <input type ="email" name="email"> <br>
  enter pswrd : <input type ="pswrd" name="pswrd"> <br>
  <input type ="submit" value ="Login">
  </form>
</body>
</html>
