<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/10MontaditosWebApp/css/style.css" />
<%@page import="model.MontaditoDAO"%>
<%@page import="javax.servlet.http.HttpSession"%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/10MontaditosWebApp/SEliminarMontadito">

<input type="text" name="idMontadito" />
<input type="submit" value="borrar"/>

</form>

</body>
</html>