<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>${msg}</h1>
 <form action ="CustomerloginValidation" method = "post">
enter email : <input type ="email" name="email"> <br>
enter pswrd : <input type ="pswrd" name="pswrd"> <br>
 <input type ="submit" value="login">
 </form>
</body>
</html>
