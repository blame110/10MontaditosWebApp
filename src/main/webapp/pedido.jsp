<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/10MontaditosWebApp/css/style.css" />
<%@page import="model.MontaditoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MontaditoVO"%>
<%@page import="model.UsuarioDAO"%>
<%@page import="javax.servlet.http.HttpSession"%>

<meta charset="ISO-8859-1">
<title>Realice su pedido, los viernes son 2x1</title>
<%
//Recuperamos el tipo de usuario y el nombre
int tipoUsuario=-1;
if (request.getAttribute("tipoUsuario")!=null )
	tipoUsuario = (int) request.getAttribute("tipoUsuario");

String nombre=null;
if (request.getAttribute("nomUsuario")!=null)
	nombre = (String) request.getAttribute("nomUsuario");

//Si el tipo de usuario no es admin lo expulsamos al login
if (tipoUsuario!=UsuarioDAO.TIPO_CLIENTE)
	response.sendRedirect("index.jsp");
%>
</head>
<body>

<%
if (nombre!=null)
	out.println("<h4>Bienvenido " + nombre + ", puedes acceder a tu perfil</h4>");
%>
	<div class="container">
		<table class="styled-table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Tamaño</th>
					<th>Premiun</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>

<%

//Array de montaditos
ArrayList<MontaditoVO> listaMontadito;
//Cargamos el listado de montaditos desde BD
listaMontadito = MontaditoDAO.cargarMontaditosBD();

//Recorremos el arraylist
for (int i=0;i<listaMontadito.size();i++)
{
	//Generamos la fila con tr
	out.println("<tr>");
	//Mostramos en cada celda td los datos correspondientes a su columna
	out.println("<td>"+listaMontadito.get(i).getNombre()+"</td>");
	out.println("<td>"+listaMontadito.get(i).getPrecio()+"</td>");
	out.println("<td>");
	//Dependiendo de la letra escribimos el tamaño
	switch (listaMontadito.get(i).getTamano())
	{
	case "P":out.println("Pequeño");
			break;
	case "N":out.println("Normal");
	break;
	case "G":out.println("Grande");
	break;
	default:out.println("No definido");
	}
	out.println("</td>");
	
	out.println("<td>");
	
	//En premiun si es 1 ponemos un checkbox marcado
	if (listaMontadito.get(i).getPremium()==1)
		out.print("<input type='checkbox' name='premium' disabled=true checked=true/>");
	else 
		out.print("<input type='checkbox' name='premium' disabled=true />");
	
	
	//Para modificar el montadito llamamos a otro jsp pasandole el id de montadito
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' size='4' name='cantidad'/>");
	out.println("</td>");
	out.println("</tr>");
	

}

%>
</tbody>
</table>
</div>
</body>
</html>