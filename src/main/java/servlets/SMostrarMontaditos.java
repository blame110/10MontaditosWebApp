package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MontaditoDAO;
import model.MontaditoVO;

/**
 * Servlet implementation class SModificarMontaditos
 */
@WebServlet("/SMostrarMontaditos")
public class SMostrarMontaditos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static String mostrarPaginacion(int numPagina)
	{
		String paginacion="";
		
		paginacion+= "<a href='/10MontaditosWebApp/SMostrarMontaditos?numPagina='" + (numPagina-1) + "'>Anterior</a>";
		paginacion+= "<a href='/10MontaditosWebApp/SMostrarMontaditos?numPagina='" + (numPagina-1) + "'>" + (numPagina-1) + "</a>";
		paginacion+= " " + numPagina + " ";
		paginacion+= "<a href='/10MontaditosWebApp/SMostrarMontaditos?numPagina='" + (numPagina+1) + "'>Posterior</a>";

		return paginacion;
	}
	
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
		
		if (request.getParameter("numPagina")!=null)
			numPagina=Integer.valueOf(request.getParameter("numPagina"));
		
		ArrayList<MontaditoVO> listaMontaditos = new ArrayList<MontaditoVO>();
		
		listaMontaditos = MontaditoDAO.cargarMontaditosBD(numPagina,10);
		
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
