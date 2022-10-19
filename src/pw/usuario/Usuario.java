package pw.usuario;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;
public class Usuario {
	
	private String idUsuario;
	private String nombre;
	private String apellidos;
	private String email;
	private LocalDate fechaNacimiento;
	private LocalDate fechaInscripcion;
	
	public Usuario(String nombre, String apellidos, String email, LocalDate fechaNacimiento, LocalDate fechaInscripcion) {
		super();
		this.idUsuario=generarIdUnico();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = fechaInscripcion;
	}
	
		
	
	public Usuario() {
		super();
		
	}
	public String generarIdUnico(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	public long CalcularAntiguedad() throws ParseException {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate fecha = this.fechaNacimiento;

		LocalDate hoy = LocalDate.now();

		long antiguedad = ChronoUnit.YEARS.between(fecha, hoy);

		return antiguedad;
	}


	public String getIDusuario() {
		return idUsuario;
	}

	public void setIDusuario(String iDusuario) {
		this.idUsuario = iDusuario;
	}

	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", fechaNacimiento=" + fechaNacimiento + ", fechaInscripcion=" + fechaInscripcion + "]";
	}


	//metodo para buscar usuario por email en el arraylist
	public boolean buscarUsuario(String email) {
		boolean encontrado = false;
		if (this.email.equals(email)) {
			encontrado = true;
		}
		return encontrado;
	}

}
	
	
