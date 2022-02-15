<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/10MontaditosWebApp/css/style.css" />
<%@page import="model.MontaditoDAO"%>
<%@page import="servlets.SMostrarMontaditos"%>
<%@page import="model.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MontaditoVO"%>
<%@page import="javax.servlet.http.HttpSession"%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%!
public static String mostrarPaginacion(int numPagina)
{
	String paginacion="";
	
	paginacion+= "<a href='/10MontaditosWebApp/SMostrarMontaditos?numPagina=" + (numPagina-1) + "'>Anterior</a>";
	paginacion+= "<a href='/10MontaditosWebApp/SMostrarMontaditos?numPagina=" + (numPagina-1) + "'>" + (numPagina-1) + "</a>";
	paginacion+= " " + numPagina + " ";
	paginacion+= "<a href='/10MontaditosWebApp/SMostrarMontaditos?numPagina=" + (numPagina+1) + "'>Posterior</a>";

	return paginacion;
}

%>

<%
//Recuperamos el tipo de usuario y el nombre
int tipoUsuario=-1;
if (request.getAttribute("tipoUsuario")!=null )
	tipoUsuario = (int) request.getAttribute("tipoUsuario");

String nombre=null;
if (request.getAttribute("nomUsuario")!=null)
	nombre = (String) request.getAttribute("nomUsuario");

//Recuperamos el tipo de pagina
int numPagina=1;
if (request.getAttribute("numPagina")!=null)
	numPagina= (int) request.getAttribute("numPagina");


//Si el tipo de usuario no es admin lo expulsamos al login
if (tipoUsuario!=UsuarioDAO.TIPO_ADMIN)
	response.sendRedirect("index.jsp");
%>
</head>
<body>
<%
//Escribimos la cabecera de la paginación



if (nombre!=null)
	out.println("<h4>Bienvenido " + nombre + ", puedes acceder a tu perfil</h4>");

out.println("<br>"+mostrarPaginacion(numPagina)+"<br>");
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
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>

<%

//Array de montaditos
ArrayList<MontaditoVO> listaMontadito = new ArrayList<MontaditoVO>();
//Cargamos el listado de montaditos desde BD
if (request.getAttribute("listaMontaditos")!=null)
	listaMontadito = (ArrayList<MontaditoVO>) request.getAttribute("listaMontaditos");


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
	
	//Para eliminar el montadito creamos un formulario con un boton
	//Que llama al servlet eliminarmontadito pasandole el idmontadito a eliminar
	out.println("</td>");
	out.println("<td>");
	out.println("<form method='post' action='/10MontaditosWebApp/SEliminarMontadito'>");
	out.println("<input type='submit' value='Borrar'/>");
	out.println("<input type='hidden' value='" + listaMontadito.get(i).getIdMontadito() + "' name='idMontadito' />");
	out.println("</form></td>");
	
	//Para modificar el montadito llamamos a otro jsp pasandole el id de montadito
	out.println("</td>");
	out.println("<td>");
	out.println("<form method='post' action='/10MontaditosWebApp/modificarMontadito.jsp'>");
	out.println("<input type='submit' value='Modificar'/>");
	out.println("<input type='hidden' value='" + listaMontadito.get(i).getIdMontadito() + "' name='idMontadito' />");
	out.println("<input type='hidden' value='" + listaMontadito.get(i).getNombre() + "' name='nombre' />");
	out.println("<input type='hidden' value='" + listaMontadito.get(i).getPrecio() + "' name='precio' />");
	out.println("<input type='hidden' value='" + listaMontadito.get(i).getTamano() + "' name='tamano' />");
	out.println("<input type='hidden' value='" + listaMontadito.get(i).getPremium() + "' name='premium' />");


	out.println("</form></td>");
	out.println("</tr>");
	
	

}
%>
</tbody>
</table>
</div>
<%out.println("<br>"+mostrarPaginacion(numPagina)+"<br>"); %>
</body>
</html>