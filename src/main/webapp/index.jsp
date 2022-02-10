<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/10MontaditosWebApp/css/style.css" />
<%@page import="model.MontaditoDAO"%>
<%@page import="model.UsuarioDAO"%>
<%@page import="servlets.SLogin"%>
<%@page import="javax.servlet.http.HttpSession"%>

<meta charset="ISO-8859-1">
<title>Login</title>

<%
//Inicializamos a 3 el número de intentos
int numIntentos = SLogin.NUM_INTENTOS;

//recuperamos el numero de intentos
if (request.getAttribute("numIntentos")!=null){
 numIntentos = (int) request.getAttribute("numIntentos");
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
//Si los intentos no son 3 se ha fallado en el login
    if (numIntentos != SLogin.NUM_INTENTOS){
%>
		<label>Hubo un error en los datos, intentelo de nuevo. Te quedan <%out.print(numIntentos); %> intentos </label> 
<%
};
%>
			<input type="hidden" name="numIntentos" value="<%out.print(numIntentos); %>">
			<input type="submit" value="Ingresar">
		
</form>

</body>
</html>