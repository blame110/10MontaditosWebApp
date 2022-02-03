package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MontaditoDAO;
import utils.ConexionBD;
import utils.Validaciones;

/**
 * Servlet implementation class SEliminarMontadito
 */
@WebServlet("/SEliminarMontadito")
public class SEliminarMontadito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SEliminarMontadito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		int idMontadito =-1;
		String sidMontadito ="";
		
		
		if (request.getParameter("idMontadito")!=null)
		sidMontadito = request.getParameter("idMontadito");
		
		if (sidMontadito!=null && Validaciones.isNumeric(sidMontadito))
			idMontadito = Integer.parseInt(sidMontadito);
			
		
		//Borramos el montadito
		if (MontaditoDAO.borrarMontadito(idMontadito)==0)
		{
			try {
			//Si hemos podido borrar el montadito redireccionamos al listado
			response.sendRedirect("mostrarMontaditos.jsp");
				}catch (IOException ioe)
			{
					out.println("No se encontro la url destino");
					
			}
		}
		else
		{
			//Si no hemos podido borrarlos mostramos un mensaje de error
			out.println("Ha habido un problema al borrar el montadito");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
			//Si hemos podido borrar el montadito redireccionamos al listado
			response.sendRedirect("mostrarMontaditos.jsp");
				}catch (IOException ioe)
			{
					out.println("No se encontro la url destino");
					
			}

	
		}
		
		out.println("</body></html>");
		//Cerramos el printwriter
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
