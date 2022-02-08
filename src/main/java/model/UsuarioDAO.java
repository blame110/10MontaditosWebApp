package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class UsuarioDAO {
	
	
	public static final String ERROR_LOGIN = "ERROR";
	public static final String LOGIN_CORRECTO = "LOGINOK";

	
	/**
	 * La funcion carga un usuarioVO que tenga el email que recibe
	 * @param email del usuario
	 * @return null si no existe ese email en bd y el usuarioVO con los datos en caso contrario
	 */
	public static UsuarioVO cargarUsuario(String email)
	{
		// Definimos la variable que guardara los datos de la BD
		UsuarioVO usuario = null;

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {
			
			String query = "SELECT * FROM usuarios WHERE email=?";

			// Creamos el PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//Añadimos el parametro al preparedstatement
			pstmt.setString(1, email);

			// Recuperamos de la BD el montadito
			res = pstmt.executeQuery();

			// Cargamos el registro
			if (res.next()) {
				//Creamos un usuario si hay un registro en bd que coincida
				usuario = new UsuarioVO(email, res.getString("nombre"), res.getString("password"),res.getString("nif"),res.getString("direccion"),res.getString("telefono"));

			} 

			con.close();
			res.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

}
