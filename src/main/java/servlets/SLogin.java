package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuarioDAO;
import model.UsuarioVO;
import utils.Validaciones;

/**
 * Servlet implementation class SLogin
 */
@WebServlet("/SLogin")
public class SLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int NUM_INTENTOS = 3;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Recuperamos la sesion
		HttpSession sesion = request.getSession();
		
		//Recuperamos los parametros que nos pasa el jsp
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String snumIntentos = request.getParameter("numIntentos");
		PrintWriter out = response.getWriter();
		
		//Cargamos el numero de intentos
		int numIntentos=0;
		if (Validaciones.isNumeric(snumIntentos))
			numIntentos = Integer.parseInt(snumIntentos);
		
		
			
		
		//Cargarmos el usuario desde BD asociado a dicho email
		UsuarioVO usuario = UsuarioDAO.cargarUsuario(email);
		
		if (usuario==null || !usuario.getPassword().equals(password))
		{
			//Si ha fallado volvemos al login mostrando el error
			//Decrementamos el numero de intentos
			numIntentos--;
			if (numIntentos==0)
			{
				out.println("Ha fallado tres veces en el login, espere 3 minutos");
			
				//Reiniciamos el numero de intentos
				numIntentos = NUM_INTENTOS;
				
			}
			request.setAttribute("numIntentos", numIntentos);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else
		{
			//Si entra aqui es que ha introducido un usuario y una contraseña
			//Correctas
			
			//Guardamos en la sesion el nombre del usuario y el tipo
			sesion.setAttribute("nomUsuario", usuario.getNombre());
			sesion.setAttribute("tipoUsuario", usuario.getTipo());
			
			//Metemos en el request las variables
			request.setAttribute("nomUsuario", usuario.getNombre());
			request.setAttribute("tipoUsuario", usuario.getTipo());
			
			//Dependiendo del tipo de usuario
			//Lo redireccionamos a distintas partes del nuestra webapp
			switch (usuario.getTipo())
			{
			case UsuarioDAO.TIPO_ADMIN:
				//Reenviamos a la lista de montaditos del administrador
				request.getRequestDispatcher("SMostrarMontaditos").forward(request, response);
				break;

			case UsuarioDAO.TIPO_CLIENTE:
				//Reenviamos a la lista de montaditos del administrador
				request.getRequestDispatcher("pedido.jsp").forward(request, response);
				break;

			default:
				//Reenviamos a la lista de montaditos del administrador
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
				
			
			}
			

		}
	
		
		
		
		//Cerramos el writer
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
