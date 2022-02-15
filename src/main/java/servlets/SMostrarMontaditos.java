package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MontaditoDAO;
import model.MontaditoVO;

/**
 * Servlet implementation class SModificarMontaditos
 */
@WebServlet("/SMostrarMontaditos")
public class SMostrarMontaditos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMostrarMontaditos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int numPagina = 1;
		//Recuperamos la sesion
		HttpSession sesion = request.getSession();
		
		if (request.getParameter("numPagina")!=null)
			numPagina=Integer.valueOf(request.getParameter("numPagina"));
		
		ArrayList<MontaditoVO> listaMontaditos = new ArrayList<MontaditoVO>();
		
		listaMontaditos = MontaditoDAO.cargarMontaditosBD(numPagina,10);
		
		//Cargamos de la sesion el nombre del usuario y el tipo
		//Si no lo hacemos el jsp nos considera no logados
		String nomUsuario= (String) sesion.getAttribute("nomUsuario");
		int tipoUsuario = (int) sesion.getAttribute("tipoUsuario");
		
		//Metemos en el request las variables
		request.setAttribute("nomUsuario", nomUsuario);
		request.setAttribute("tipoUsuario", tipoUsuario);

		//Enviamos la lista de montaditos y la pagina actual para la paginacion
		request.setAttribute("listaMontaditos", listaMontaditos);
		request.setAttribute("numPagina", numPagina);
		
		request.getRequestDispatcher("mostrarMontaditosPag.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
