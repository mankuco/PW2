package pw.pistakart;

import java.util.ArrayList;
import pw.fichero.*;
import java.util.Scanner;

import es.uco.pw.p2.data.dao.UserDAO;
import pw.usuario.Usuario;

public class GestorPistas {
	
	public GestorPistas(){ }

	/* 
	 * @Resumen Devuelve la pista, si esta registrada en la base de datos., si no lo esta devuelve NULL
	 */
	public Pista existePista(String nombrePista) {
		//////////////////////////////////////////////////////////////////////
		Pista pista = new Pista(nombrePista, true, Dificultades.ADULTOS, 30);
		return pista;
	}
	public void crearPista(String nombre, boolean tipoEstado, Dificultades dificultad, int maxKarts) {
		Pista pista = new Pista(nombre, tipoEstado, dificultad, maxKarts);
		PistaDAO crear = new PistaDAO();
		crear.guardarPista(nombre, tipoEstado, dificultad, maxKarts);
	}
	/* 
	 * @Resumen Devuelve el kart, si esta registrado en la base de datos., si no lo esta devuelve NULL
	 */
	public Kart existeKart(int idKart) {
		//////////////////////////////////////////////////////////////////////
		Kart kart = new Kart(idKart, true, Estados.DISPONIBLE);
		return kart;
	}
	/* 
	 * @Resumen Crea un kart, si no existe ya, y la guarda en la lista karts
	 */
	public void crearKart(int idKart, boolean tipoKart, Estados estado) {
		Kart kart = new Kart(idKart,tipoKart, estado);
		KartDAO crear = new KartDAO();
		crear.guardarKart(idKart,tipoKart, estado);
	}
	

	/* 
	 * @Resumen Lista todas las pistas que no estén en mantenimiento
	 */
	public ArrayList<Pista> listarPistasmantenimiento() {
		PistaDAO listar= new PistaDAO();
		ArrayList<Pista> pistas = listar.listarmantenimiento();
		return pistas;
	}
	
	/* 
	 * @Resumen Busca las pistas que estan disponibles para cierto numero de karts
	 * @param numKart, es el numero de karts para los que buscamos una pista disponible
	 * @param dificultad, el la dificultas (infantil, adultos, familiar) para la que buscamos la pista
	 * @return disponibles, devuelve un vector con todas las pistas que cumplen los requisitos
	 */
	public ArrayList<Pista> pistasDisponibles (int numKart, Dificultades dificultad){
		PistaDAO listar= new PistaDAO();
		ArrayList<Pista> pistas = listar.listardisponibles(numKart, dificultad);
		return pistas;
	}
}
	
