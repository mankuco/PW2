package pw.pistakart;

import java.util.ArrayList;

import pw.dao.*;

public class GestorPistas {
	
	public GestorPistas(){ }

	/* 
	 * @Resumen Devuelve la pista, si esta registrada en la base de datos, si no lo esta devuelve null
	 * @param nombrePista = String, es el nombre de la pista que buscamos
	 * @return pista = Pista, es la pista que ha encontrado (si no la ha encontrado entonces devolvera null)
	 */
	public Pista existePista(String nombrePista) {
		PistaDAO consultar = new PistaDAO();
		Pista pista = consultar.existepista(nombrePista);
		return pista;
	}
	/* 
	 * @Resumen Devuelve el kart, si esta registrado en la base de datos., si no lo esta devuelve null
	 * @param idKart = Kart, es el identificador del kart que buscamos
	 * @return kart = Kart, es el kart que ha encontrado (si no lo ha encontrado entonces devolvera null)
	 */
	public Kart existeKart(int idKart) {
		KartDAO consultar = new KartDAO();
		Kart kart= consultar.existekart(idKart);
		return kart;
	}
	
	/* 
	 * @Resumen Llama a la funcion void guardarpista(Pista pista)
	 * @param Entran como parametros todos los datos necesarios para crear una pista
	 */
	public void crearPista(String nombre, boolean tipoEstado, Dificultades dificultad, int maxKarts) {
		Pista pista = new Pista(nombre, tipoEstado, dificultad, maxKarts);
		PistaDAO crear = new PistaDAO();
		crear.guardarPista(pista);
	}
	/* 
	 * @Resumen Llama a la funcion void guardarKart(Kart kart)
	 * @param Entran como parametros todos los datos necesarios para crear un kart
	 */
	public void crearKart(int idKart, boolean tipoKart, Estados estado) {
		Kart kart = new Kart(idKart,tipoKart, estado);
		KartDAO crear = new KartDAO();
		crear.guardarKart(kart);
	}

	/* 
	 * @Resumen Devuelve true si el kart esta asignado a una pista
	 * @param kart = Kart
	 */
	public boolean tienepista(Kart kart) {
		return (kart.getnombrePista() != null);
	}
	
	/* 
	 * @Resumen Elimina de la lista de karts asignados a una pista el kart que se va a asignar a otra pista distinta y se actualiza el numero de karts asignados
	 * @param kart = Kart, el kart que hay que eliminar
	 * @param pista = Pista
	 */
	public void eliminarkart(Kart kart, Pista pista) {
		ArrayList<Kart> array = new ArrayList<Kart>();
		for(int i = 0; i < pista.getListaKarts().size(); i++) {
			if(pista.getListaKarts().get(i).getIdKart() != kart.getIdKart()) {
				array.add(pista.getListaKarts().get(i));
			}
		}
		pista.setListaKarts(array);
		pista.setnkartsasociados(pista.getnkartsasociados() - 1);
		PistaDAO cambiar = new PistaDAO();
		cambiar.cambiarnkartsasociados(pista);
	}
	
	/* 
	 * @Resumen Lista todas las pistas que no est�n en mantenimiento
	 */
	public ArrayList<Pista> listarPistasmantenimiento() {
		PistaDAO listar= new PistaDAO();
		ArrayList<Pista> pistas = listar.listarmantenimiento();
		return pistas;
	}
	
	/* 
	 * @Resumen LLama a la funcion ArrayList<Pista> listardisponibles(int numKart, Dificultades dificultad)
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
	
