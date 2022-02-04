package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MontaditoDAO;
import utils.Validaciones;

/**
 * Servlet implementation class SModificarMontadito
 */
@WebServlet("/SModificarMontadito")
public class SModificarMontadito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SModificarMontadito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Recuperamos los parametros que nos pasan desde el listado
		String sidMontadito = request.getParameter("idMontadito");
		String snombre = request.getParameter("nombre");
		String sprecio = request.getParameter("precio");
		String stamano = request.getParameter("tamano");
		String spremium = request.getParameter("premium");

		//Variables para guardar los datos numericos
		int idMontadito=0;
		int precio=0;
		short premium=0;
		
		//Definimos el printwriter para escribir en el navegador
		PrintWriter out = response.getWriter();
		

		//Convertimos a número los valores númericos
		if (Validaciones.isNumeric(sidMontadito))
			idMontadito = Integer.valueOf(sidMontadito);

		if (Validaciones.isNumeric(sprecio))
			precio = Integer.valueOf(sprecio);

		//Si premium no es nulo entonces el checkbox esta marcado
		if (spremium!=null)
			premium = 1;
		else
			premium =0;
		
		
		//Modificamos el montadito en la BD
		if (MontaditoDAO.actualizarMontaditoDB(idMontadito, snombre, precio, stamano, premium)==-1)
		{
			out.println("Hubo un fallo al modificar la bd");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//Redirecciono al listado
		response.sendRedirect("mostrarMontaditos.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
