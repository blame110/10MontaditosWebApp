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
<%@page import="javax.servlet.http.HttpSession"%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
		out.print("<input type='checkbox' disabled=true checked=true/>");
	else 
		out.print("<input type='checkbox' disabled=true />");
	
	out.println("</td>");
	out.println("<td>&nbsp;</td>");
	out.println("<td>&nbsp;</td>");
	out.println("</tr>");

}

%>
</tbody>
</table>
</div>
</body>
</html>