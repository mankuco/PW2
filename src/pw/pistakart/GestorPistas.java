package pw.pistakart;

import java.util.ArrayList;
import pw.fichero.*;
import java.util.Scanner;

import pw.usuario.Usuario;

public class GestorPistas {
	
	private ArrayList<Pista> pistas = new ArrayList<Pista>();
	private ArrayList<Kart> karts = new ArrayList<Kart>();
	
	public GestorPistas(){
		pistas.clear();
		this.pistas = this.cargarPistas();
		karts.clear();
		this.karts = this.cargarKarts();
	}

	/* 
	 * @Resumen Crea una pista, si no existe ya, y la guarda en la lista pistas
	 */
	public void crearPista() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la pista");
		String nombrePista = sc.nextLine();
		boolean existe = false;
		for (Pista pista : pistas) {
			if (pista.getNombrePista().equals(nombrePista)) {
				existe = true;
			}
		}
		if (existe) {
			System.out.println("La pista ya existe");
		}
		else {
			System.out.println("Introduce el tipo de pista");
			boolean tipoEstado = sc.nextBoolean();
			System.out.println("Introduce la dificultad");
			Dificultades dificultad = Dificultades.valueOf(sc.next());
			System.out.println("Introduce el numero maximo de karts");
			int maxKarts = sc.nextInt();
			ArrayList<Kart> listaKarts = new ArrayList<Kart>();
			Pista pista = new Pista(nombrePista, tipoEstado, dificultad, maxKarts, listaKarts);
			pistas.add(pista);
			System.out.println("Pista creada");
		}
	}

	/* 
	 * @Resumen Crea un kart, si no existe ya, y la guarda en la lista karts
	 */
	public void crearKart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id del kart");
		int idKart = sc.nextInt();
		boolean existe = false;
		for (Kart kart : karts) {
			if (kart.getIdKart() == idKart) {
				existe = true;
			}
		}
		if (existe) {
			System.out.println("El kart ya existe");
		}
		else {
			System.out.println("Introduce el estado del kart");
			Estados estado = Estados.valueOf(sc.next());
			System.out.println("Introduce el tipo de kart");
			boolean tipoKart = sc.nextBoolean();
			Kart kart = new Kart(idKart,tipoKart, estado);
			karts.add(kart);
			System.out.println("Kart creado");
		}
	}

	/* 
	 * @Resumen Pide una pista, si existe, pide la identificacion del kart, si este existe y
	 * hay espacio en la pista, llama a la funcion asociarKartPista() para esta pista
	 */
	public void asociarKarts(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la pista");
		String nombrePista = sc.nextLine();
		boolean existe = false;
		for (Pista pista : pistas) {
			if (pista.getNombrePista().equals(nombrePista)) {
				existe = true;
				System.out.println("Introduce el id del kart");
				int idKart = sc.nextInt();
				boolean existeKart = false;
				for (Kart kart : karts) {
					if (kart.getIdKart() == idKart) {
						existeKart = true;
						if (pista.getListaKarts().size() < pista.getMaxKarts()) {
							pista.asociarKartPista(kart, pista);
						}
						else {
							System.out.println("La pista esta llena");
						}
					}
				}
				if (!existeKart) {
					System.out.println("El kart no existe");
				}
			}
		}
		if (!existe) {
			System.out.println("La pista no existe");
		}
	}

	/* 
	 * @Resumen Lista todas las pistas que no estén en mantenimiento
	 */
	public void listarPistas() {
		for (Pista pista : pistas) {
			if(!pista.isTipoEstado()) {
				System.out.println(pista.getNombrePista() + " " + pista.getDificultad() + " " + pista.getMaxKarts());
			}
		}
	}
	
	/* 
	 * @Resumen Busca las pistas que estan disponibles para cierto numero de karts
	 * @param numKart, es el numero de karts para los que buscamos una pista disponible
	 * @param dificultad, el la dificultas (infantil, adultos, familiar) para la que buscamos la pista
	 * @return disponibles, devuelve un vector con todas las pistas que cumplen los requisitos
	 */
	public ArrayList<Pista> pistasDisponibles (int numKart, Dificultades dificultad){
		ArrayList<Pista> disponibles = new ArrayList<Pista>();
		for(Pista pista : pistas) {
			if(pista.isTipoEstado() && pista.getDificultad() == dificultad && pista.getMaxKarts() >= numKart) {
				disponibles.add(pista);
			}
		}
		for(Pista pista : disponibles) {
			System.out.println(pista.getNombrePista());
		}
		return disponibles;
	}
}
	
