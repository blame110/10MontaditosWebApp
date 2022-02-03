<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/10MontaditosWebApp/css/style.css" />
<%@page import="model.MontaditoDAO"%>
<%@page import="model.MontaditoVO"%>
<%@page import="utils.Validaciones"%>
<%@page import="javax.servlet.http.HttpSession"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//Recuperamos los parametros que nos pasan desde el listado
String sidMontadito = request.getParameter("idMontadito");
String snombre = request.getParameter("nombre");
String sprecio = request.getParameter("precio");
String stamano = request.getParameter("tamano");
String spremium = request.getParameter("premium");


%>
<form method="post" action="/10MontaditosWebApp/SModificarMontadito">

			<label for="fname">Nombre</label> 
			<input type="text" id="fname" name="nombre" value="<%out.print(snombre); %>" /> 

			<label for="fprice">Precio</label> 
			<input type="text" id="fprice" name="precio" value="<%out.print(sprecio); %>" /> 
			
			<label	for="tamano">Country</label> 
			<select id="tamano" name="tamano">
				<option value="P" <% if (stamano.equals("P")) out.print(" selected='true'"); %>>Pequeño</option>
				<option value="N" <% if (stamano.equals("N")) out.print(" selected='true'"); %>>Normal</option>
				<option value="G" <% if (stamano.equals("G")) out.print(" selected='true'"); %>>Grande</option>
			</select> 
		
			<label for="fpremium">Premium</label> 
			<input type="checkbox" id="fpremium" name="premium" <% if (spremium.equals("1")) 
				out.print("checked value='1'"); else out.print("value='0'"); 
				%> /> 
			<input type="hidden" name="idMontadito" value=<% out.println(sidMontadito); %>">
			<input type="submit" value="Modificar">

</form>


</body>
</html>