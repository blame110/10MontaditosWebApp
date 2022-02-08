package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;
import model.UsuarioVO;

/**
 * Servlet implementation class SLogin
 */
@WebServlet("/SLogin")
public class SLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		//Recuperamos los parametros que nos pasa el jsp
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String falloLogin = UsuarioDAO.LOGIN_CORRECTO;
		
		//Cargarmos el usuario desde BD asociado a dicho email
		UsuarioVO usuario = UsuarioDAO.cargarUsuario(email);
		
		if (usuario==null || !usuario.getPassword().equals(password))
		{
			//Si ha fallado volvemos al login mostrando el error
			falloLogin= UsuarioDAO.ERROR_LOGIN;
			request.setAttribute("falloLogin", falloLogin);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else
		{
			//Reenviamos a la lista de montaditos del administrador
			request.getRequestDispatcher("mostrarMontaditos.jsp").forward(request, response);

		}
	
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
