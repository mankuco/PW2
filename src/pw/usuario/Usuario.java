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
	
	//CONSTRUCTOR PARAMETRIZADO
	public Usuario(String nombre, String apellidos, String email, LocalDate fechaNacimiento, LocalDate fechaInscripcion) {
		super();
		this.idUsuario=generarIdUnico();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = fechaInscripcion;
	}
	//CONSTRUCTOR
	public Usuario() {
		super();
		
	}
	
	/* 
	 * @Resumen Devuelve una cadena con un id random para un usuario
	 * @return uuid.toString() = cadena con id random 
	 */
	public String generarIdUnico(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/* 
	 * @Resumen Devuelve el nombre del usuario
	 * @return nombre = String 
	 */
	public String getNombre() {
		return nombre;
	}
	/* 
	 * @Resumen Cambia el nombre del usuario
	 * @param nombre = String 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/* 
	 * @Resumen Devuelve los apellidos del usuario
	 * @return apellidos = String 
	 */
	public String getApellidos() {
		return apellidos;
	}
	/* 
	 * @Resumen Cambia los apellidos del usuario
	 * @param apellidos = String 
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/* 
	 * @Resumen Devuelve el email del usuario
	 * @return email = String 
	 */
	public String getEmail() {
		return email;
	}
	/* 
	 * @Resumen Cambia el email del usuario
	 * @param email = String 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* 
	 * @Resumen Devuelve la fecha de nacimiento del usuario
	 * @return fechaNacimiento = LocalDate 
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	/* 
	 * @Resumen Cambia la fecha de nacimiento del usuario
	 * @param fechaNacimiento = LocalDate 
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/* 
	 * @Resumen Devuelve la fecha de inscripcion del usuario
	 * @return fechaInscripcion = LocalDate 
	 */
	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}
	/* 
	 * @Resumen Devuelve el identificador del usuario
	 * @return idUsuario = String 
	 */
	public String getIDusuario() {
		return idUsuario;
	}
	/* 
	 * @Resumen Cambia el identificador del usuario
	 * @param idUsuario = String 
	 */
	public void setIDusuario(String iDusuario) {
		this.idUsuario = iDusuario;
	}
	
	/* 
	 * @Resumen Devuelve la antiguedad -> Diferencia entre la fecha de ahora y la fecha de inscripcion
	 * @return antiguedad = long 
	 */
	public long CalcularAntiguedad() throws ParseException {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate fecha = this.fechaNacimiento;

		LocalDate hoy = LocalDate.now();

		long antiguedad = ChronoUnit.YEARS.between(fecha, hoy);

		return antiguedad;
	}

	/* 
	 * @Resumen Devuelve una cadena con la informacion del usuario
	 * @return string
	 */
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", fechaNacimiento=" + fechaNacimiento + ", fechaInscripcion=" + fechaInscripcion + "]";
	}
}