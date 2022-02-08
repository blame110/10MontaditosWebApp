<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/10MontaditosWebApp/css/style.css" />
<%@page import="model.MontaditoDAO"%>
<%@page import="model.UsuarioDAO"%>
<%@page import="javax.servlet.http.HttpSession"%>

<meta charset="ISO-8859-1">
<title>Login</title>

<%
//La primera vez que carga el login ponemos a nulo el error de login
String error="";

if (request.getAttribute("falloLogin")!=null)
{
	//Recuperamos el error
	
	error = (String) request.getAttribute("falloLogin");
}


%>
</head>
<body>

<form method="post" action="/10MontaditosWebApp/SLogin" >

			<label for="femail">Email</label> 
			<input type="email" id="femail" name="email" placeholder="Introduce el email.." /> 

			<label for="fpassword">Password</label> 
			<input type="password" id="fpassword" name="password" placeholder="Introduce el password.." /> 

<%
    if (error.equals(UsuarioDAO.ERROR_LOGIN)){
%>
		<label>Hubo un error en los datos, intentelo de nuevo</label> 
<%
};
%>
			<input type="submit" value="Ingresar">
		
</form>

</body>
</html>