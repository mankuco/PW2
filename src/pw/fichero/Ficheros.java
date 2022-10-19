package pw.fichero;


import pw.reservas.ReservaAdultos;
import pw.reservas.ReservaFamiliar;
import pw.reservas.ReservaInfantil;
import pw.usuario.Usuario;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;


public class Ficheros {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<ReservaAdultos> reservasAdultos = new ArrayList<ReservaAdultos>();
	private ArrayList<ReservaInfantil> reservasInfantiles = new ArrayList<ReservaInfantil>();
	private ArrayList<ReservaFamiliar> reservasFamiliares = new ArrayList<ReservaFamiliar>();
	//public String ficheroUsuarios, ficheroReservas, ficheroKarts, ficheroPistas;



/*
	public void rutasProperties(){
	Properties prop = new Properties();
	String filename = "ficheros.properties";
	try {
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		prop.load(reader);

		this.ficheroUsuarios = prop.getProperty("ficherousuario");
		this.ficheroReservas = prop.getProperty("ficheroreservas");
		this.ficheroKarts = prop.getProperty("ficherokarts");
		this.ficheroPistas = prop.getProperty("ficheropistas");

	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
*/
	/* 
	 * @Resumen Lee de un fichero los usuarios
	 * @return usuarios = vector con los usuarios
	 */
	public ArrayList<Usuario> leerFicheroUsuario() {
		Properties prop = new Properties();
		String filename = "ficheros.properties";
		String ficheroUsuarios= "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);
			ficheroUsuarios = prop.getProperty("ficherousuario");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fichero = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fichero = new File(ficheroUsuarios);
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(";");
				Usuario u = new Usuario();
				u.setIDusuario(campos[0]);
				u.setEmail(campos[1]);
				u.setNombre(campos[2]);
				u.setApellidos(campos[3]);
				u.setFechaNacimiento(convertirFechas(campos[4]));
				u.setFechaInscripcion(convertirFechas(campos[5]));
				this.usuarios.add(u);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e) {
			System.out.println("Error de lectura");
		}
		finally {
			try {
				if (fr != null) {
					fr.close();
				}
			}
			catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		return usuarios;
	}
	
	/* 
	 * @Resumen Guarda en un fichero los usuarios
	 * @param listaUsu = vector con los usuarios
	 */
	public void almacenarFicheroUsuario (ArrayList <Usuario> listaUsu){
		Properties prop = new Properties();
		String filename = "ficheros.properties";
		String ficheroUsuarios = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);
			ficheroUsuarios = prop.getProperty("ficherousuario");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fichero = new File(ficheroUsuarios);
		FileWriter fw = null;
		BufferedWriter bw = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			fw = new FileWriter(fichero,false);
			bw = new BufferedWriter(fw);
			for (Usuario u : listaUsu) {
				bw.write(u.getIDusuario() + ";" + u.getEmail() + ";" + u.getNombre() + ";" + u.getApellidos() + ";" + (u.getFechaNacimiento().format(formatter)) + ";" + u.getFechaInscripcion());
				bw.newLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e) {
			System.out.println("Error de lectura");
		}
		finally {
			try {
				if (bw != null) {
					bw.close();
				}
			}
			catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
	}

	/* 
	 * @Resumen Lee de un fichero las reservas.
	 */
	public void leerFicheroReserva() {
		Properties prop = new Properties();
		String filename = "ficheros.properties";
		String ficheroReservas = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);
			ficheroReservas = prop.getProperty("ficherousuario");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fichero = new File(ficheroReservas);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(";");
				if (campos[0].equals("infantil")) {
					ReservaInfantil ri = new ReservaInfantil();
					ri.setIdReserva(campos[1]);
					ri.setIdUsuario(campos[2]);
					ri.setFechaYhora(convertirFechas(campos[3]));
					ri.setMinutosReserva(Integer.parseInt(campos[4]));
					ri.setIdPista(Integer.parseInt(campos[5]));
					ri.setPrecioPista(Float.parseFloat(campos[6]));
					ri.setDescuento(Integer.parseInt(campos[7]));
					ri.setModalidad(campos[8]);
					ri.setNumeroNinos(Integer.parseInt(campos[9]));
					this.reservasInfantiles.add(ri);
				}
				else if (campos[0].equals("adultos")) {
					ReservaAdultos ra = new ReservaAdultos();
					ra.setIdReserva(campos[1]);
					ra.setIdUsuario(campos[2]);
					ra.setFechaYhora(convertirFechas(campos[3]));
					ra.setMinutosReserva(Integer.parseInt(campos[4]));
					ra.setIdPista(Integer.parseInt(campos[5]));
					ra.setPrecioPista(Float.parseFloat(campos[6]));
					ra.setDescuento(Integer.parseInt(campos[7]));
					ra.setModalidad(campos[8]);
					ra.setNumeroAdultos(Integer.parseInt(campos[10]));
					this.reservasAdultos.add(ra);
				}
				else if (campos[0].equals("familiar")) {
					ReservaFamiliar rf = new ReservaFamiliar();
					rf.setIdReserva(campos[1]);
					rf.setIdUsuario(campos[2]);
					rf.setFechaYhora(convertirFechas(campos[3]));
					rf.setMinutosReserva(Integer.parseInt(campos[4]));
					rf.setIdPista(Integer.parseInt(campos[5]));
					rf.setPrecioPista(Float.parseFloat(campos[6]));
					rf.setDescuento(Integer.parseInt(campos[7]));
					rf.setModalidad(campos[8]);
					rf.setNumeroAdultos(Integer.parseInt(campos[10]));
					this.reservasFamiliares.add(rf);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e) {
			System.out.println("Error de lectura");
		}
		finally {
			try {
				if (fr != null && br != null) {
					fr.close();
					br.close();
				}
			}
			catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
	}

	/* 
	 * @Resumen Guarda en un fichero las reservas
	 * @param listaResInf = vector con las reservas infantiles
	 * @param listaResAd = vector con las reservas de adultos
	 * @param listaResFam = vector con las reservas familiares
	 */
	public void almacenarFicheroReserva(ArrayList<ReservaInfantil> listaResInf, ArrayList<ReservaAdultos> listaResAd, ArrayList<ReservaFamiliar> listaResFam) {
		File fichero = new File("a");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			for (ReservaInfantil ri : listaResInf) {
				bw.write("infantil;" + ri.getIdReserva() + ";" + ri.getIdUsuario() + ";" + ri.getFechaYhora() + ";" + ri.getMinutosReserva() + ";" + ri.getIdPista() + ";" + ri.getPrecioPista() + ";" + ri.getDescuento() + ";" + ri.getModalidad() + ";" + ri.getNumeroNinos() );
				bw.newLine();
			}
			for (ReservaAdultos ra : listaResAd) {
				bw.write("adultos;" + ra.getIdReserva() + ";" + ra.getIdUsuario() + ";" + ra.getFechaYhora() + ";" + ra.getMinutosReserva() + ";" + ra.getIdPista() + ";" + ra.getPrecioPista() + ";" + ra.getDescuento() + ";" + ra.getModalidad() + ";" + ra.getNumeroAdultos() );
				bw.newLine();
			}
			for (ReservaFamiliar rf : listaResFam) {
				bw.write("adultos;" + rf.getIdReserva() + ";" + rf.getIdUsuario() + ";" + rf.getFechaYhora() + ";" + rf.getMinutosReserva() + ";" + rf.getIdPista() + ";" + rf.getPrecioPista() + ";" + rf.getDescuento() + ";" + rf.getModalidad() + ";" + rf.getNumeroNinos()+ ";" + rf.getNumeroAdultos());
				bw.newLine();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e) {
			System.out.println("Error de lectura");
		}
		finally {
			try {
				if (fw != null	&& bw != null) {
					fw.close();
					bw.close();
				}
			}
			catch (IOException e) {
				System.out.println("Error al cerrar el fichero");

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

}