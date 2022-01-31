package utils;

public class Validaciones {

	public static boolean isNumeric(String numeroComp)
	{
		try {
			//Si el string se puede convertir a numero se devuelve cierto
			int numero = Integer.parseInt(numeroComp);
			return true;
		}
		catch (NumberFormatException ne)
		{
			//Si salta la excepcion implica que algun caracter no númerico existe
			return false;
		}
	}
	
}
