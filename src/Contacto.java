public abstract class Contacto{
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono,
			String email) {
		this.nombre = nombre.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.telefono = telefono;
		this.email = email.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return email.hashCode();

	}
	
	public char getPrimeraLetra() {
		
		return apellidos.charAt(0);
	}
	
	public boolean equals(Object c) {
		if(!(this instanceof Contacto)) {
			return false;
		}
		Contacto c1 = (Contacto) c;
		return this.email.equalsIgnoreCase(c1.email) && this.apellidos.equalsIgnoreCase(c1.apellidos) && this.nombre.equalsIgnoreCase(c1.nombre);
	}
	
	public int compareTo(Contacto c1) {
		if(this.apellidos.compareToIgnoreCase(c1.getApellidos()) < 0) {
			return -1;
		}
		if(this.apellidos.compareToIgnoreCase(c1.getApellidos()) > 0) {
			return 1;
		}
		if(this.apellidos.compareToIgnoreCase(c1.getApellidos()) == 0) {
				if(this.nombre.compareToIgnoreCase(c1.getNombre()) < 0) {
					return -1;
				}
				if(this.nombre.compareToIgnoreCase(c1.getNombre()) > 0) {
					return 1;
				}
		}
		return 0;
	}
	public abstract String crearFirma();

	@Override
	public String toString(){
		String mensaje = "";
		if(this instanceof Personal) {
			mensaje =  apellidos.toUpperCase() + ", " + nombre.toUpperCase() + " (PERSONAL)\n" + "Tfno: " + telefono + " | " + "email: " + email + "\n";
		}
		if(this instanceof Profesional) {
			mensaje =  apellidos.toUpperCase() + ", " + nombre.toUpperCase() + " (PROFESIONAL)\n" + "Tfno: " + telefono + " | " + "email: " + email + "\n";
		}
		return mensaje;
	}
	
}
