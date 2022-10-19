package pw.usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import pw.fichero.*;

public class GestorUsuario {
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public GestorUsuario() {
		usuarios.clear();
		this.usuarios = this.cargarUsuarios();
	}
	

	/* 
	 * @Resumen Pide los datos para un nuevo usuario y lo añade a la lista
	 */
	public void altaUsuario () {
		Scanner esc = new Scanner(System.in);
	
		Usuario nuevoUsuario = new Usuario();
		System.out.println("Introduzca el email");
		String nuevoEmail = esc.nextLine();
		for (Usuario u : usuarios) {
			if (u.getEmail() == nuevoEmail) {
				System.out.println("Usuario ya registrado.");
				esc.close();
			}
		}
		System.out.println("Introduzca el nombre");
		String nuevoNombre = esc.nextLine();
		System.out.println("Introduzca los apellidos");
		String nuevoApellidos = esc.nextLine();
		System.out.println("Introduzca la fecha de nacimiento (AAAA-MM-DD)");
		String nuevaFechaNacimiento = esc.nextLine();
		nuevoUsuario.setFechaInscripcion(LocalDate.now());
		nuevoUsuario.setIDusuario(nuevoUsuario.generarIdUnico());
		nuevoUsuario.setEmail(nuevoEmail);
		nuevoUsuario.setNombre(nuevoNombre);
		nuevoUsuario.setApellidos(nuevoApellidos);
		nuevoUsuario.setFechaNacimiento(convertirFechas(nuevaFechaNacimiento));
		
		
		usuarios.add(nuevoUsuario);
		System.out.println("Usuario registrado correctamente.");
		
	}


	/* 
	 * @Resumen Pide el email para encontrar al usuario, si lo encuentra, imprime
	 * 			un menú con todas las opciones que se pueden modificar
	 */
	public void modificarUsuario () {
		Scanner esc = new Scanner(System.in);
		System.out.println("Introduzca el email del usuario a modificar");
		String email = esc.nextLine();
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email)) {
				
				String opcion = "3";
				System.out.println("Introduzca el campo a modificar");
				System.out.println("1. Email");
				System.out.println("2. Nombre");
				System.out.println("3. Apellidos");
				System.out.println("4. Fecha de nacimiento");
				System.out.println("5. Salir");
				while(!opcion.equals("5")) {
					System.out.println("Que campo desea modificar?");
					opcion = esc.nextLine();
					switch (opcion) {
						case "1":
							System.out.println("Introduzca el nuevo email");
							String nuevoEmail = esc.nextLine();
							u.setEmail(nuevoEmail);
							break;
						case "2":
							System.out.println("Introduzca el nuevo nombre");
							String nuevoNombre = esc.nextLine();
							u.setNombre(nuevoNombre);
							break;
						case "3":
							System.out.println("Introduzca los nuevos apellidos");
							String nuevoApellidos = esc.nextLine();
							u.setApellidos(nuevoApellidos);
							break;
						case "4":
							System.out.println("Introduzca la nueva fecha de nacimiento (AAAA-MM-DD)");
							String nuevaFechaNacimiento = esc.nextLine();
							u.setFechaNacimiento(convertirFechas(nuevaFechaNacimiento));
							break;
						case "5":
							System.out.println("Usuario modificado correctamente.");
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					
				}
			}
		}
	}
	/* 
	 * @Resumen Introduces una cadena, que contiene una fecha y la convierte al tipo LocalDate
	 * @param fecha = cadena con la fecha
	 * @return fechaDate = LocalDate con la fecha
	 */
	public LocalDate convertirFechas(String fecha){
		LocalDate fechaDate = null;
		fechaDate = LocalDate.parse(fecha);
		return fechaDate;
	}

	/* 
	 * @Resumen Imprime en pantalla todos los usuarios y su informacion 
	 */
	public void listarUsuarios() {
		for (Usuario u : usuarios) {
			System.out.println(u.toString());
		}
	}
	
	/* 
	 * @Resumen Busca un usuario en la lista segun su email
	 * @param email = cadena con el string
	 * @return u = devuelve un usuario
	 * @return null = si no lo encuentra
	 */
	public Usuario buscarUsuario(String email) {
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}

	public ArrayList<Usuario> cargarUsuarios() {
		Ficheros fichero = new Ficheros();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios = fichero.leerFicheroUsuario();
		return usuarios;
	}
	
	public void guardarUsuarios() {
        Ficheros fichero = new Ficheros();
        fichero.almacenarFicheroUsuario(usuarios);
    }

	/* 
	 * @Resumen Se obtiene la lista con los usuarios
	 * @return usuarios = vector con todos los usuarios guardados
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}

