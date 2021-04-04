import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 
 * @author Unai Pérez, Iñaki Tiraplegui, Enrique Lafraya.
 *
 */

public class Personal extends Contacto {
LocalDate fecha;
private static String firma;
Relacion relacion;
	public Personal(String nombre, String apellidos, String telefono,String email,String fecha,Relacion rel) {
		super(nombre,apellidos,telefono,email);
		this.fecha = LocalDate.parse(fecha,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		relacion = rel;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Relacion getRelacion() {
		return relacion;
	}
	public void setRelacion(Relacion relacion) {
		this.relacion = relacion;
	}
	
	public String crearFirma() {
		firma = "Un abrazo!";
		return firma;
	}
	
	public boolean esCumpleaños() {
		LocalDate hoy = LocalDate.now();
		boolean resultado = false;
		if(hoy.equals(fecha)) {
			resultado = true;
		}
		return resultado;
	}
	
	private String formatearFecha() {
		String formateada = "";
		String mes = "";
		switch(fecha.getMonthValue()) {
		case 1: mes = "ener.";
			break;
		case 2: mes = "febr.";
			break;
		case 3: mes = "mar.";
			break;
		case 4: mes = "abr.";
			break;
		case 5: mes = "may.";
			break;
		case 6: mes = "jun";
			break;
		case 7: mes = "jul.";
			break;
		case 8: mes = "agost.";
			break;
		case 9: mes = "sept.";
			break;
		case 10: mes = "oct.";
			break;
		case 11: mes = "nov.";
			break;
		case 12: mes = "dic.";
			break;
		}
		String dia = "" + fecha.getDayOfMonth();
		String año = "" + fecha.getYear();
		formateada = dia + " " + mes + " " + año;
		return formateada;
	}
	public String toString() {
		String resul = "";
		resul = super.toString() + "Fecha nacimiento: " +  formatearFecha() + "\n" +"Relacion: " + relacion + "\n\n" + crearFirma();
		return resul;
	}
}
