package model;

public class UsuarioVO {

	private String email;
	private String nombre;
	private String password;
	private String nif;
	private String direccion;
	private String telefono;
	private int tipo;
	
		
	public UsuarioVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioVO(String email, String nombre, String password, String nif, String direccion, String telefono,
			int tipo) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "UsuarioVO [email=" + email + ", nombre=" + nombre + ", password=" + password + ", nif=" + nif
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", tipo=" + tipo + "]";
	}
	
	
	
	
}
