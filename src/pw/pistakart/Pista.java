package pw.pistakart;

import java.util.ArrayList;

public class Pista {
	
	private String nombrePista;
	private boolean tipoEstado; //true si esta disponible a reserva
	private Dificultades dificultad;
	private int maxKarts;
	private int nkartsasociados;
	private ArrayList<Kart> listaKarts;
	
	//CONSTRUCTOR PARAMETRIZADO
	public Pista(String nombrePista, boolean tipoEstado, Dificultades dificultad, int maxKarts) {
		super();
		this.nombrePista = nombrePista;
		this.tipoEstado = tipoEstado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
		this.nkartsasociados=0;
	}
	//CONSTRUCTOR
	public Pista() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	/* 
	 * @Resumen Devuelve el nombre de la pista
	 * @return nombrePista = String
	 */
	public String getNombrePista() {
		return nombrePista;
	}
	/* 
	 * @Resumen Cambia el nombre de la pista
	 * @param nombrePista = String
	 */
	public void setNombrePista(String nombrePista) {
		this.nombrePista = nombrePista;
	}
	/* 
	 * @Resumen Devuelve el estado de la pista
	 * @return tipoEstado = bool // true=disponible false=no disponible
	 */
	public boolean isTipoEstado() {
		return tipoEstado;
	}
	/* 
	 * @Resumen Cambia el estado de la pista
	 * @param tipoEstado = bool // true=disponible false=no disponible
	 */
	public void setTipoEstado(boolean tipoEstado) {
		this.tipoEstado = tipoEstado;
	}
	/* 
	 * @Resumen Devuelve la dificultad de la pista
	 * @return dificultad = Dificultades // INFANTIL, FAMILIAR, ADULTOS 
	 */
	public Dificultades getDificultad() {
		return dificultad;
	}
	/* 
	 * @Resumen Cambia la dificultad de la pista
	 * @param dificultad = Dificultades // INFANTIL, FAMILIAR, ADULTOS 
	 */
	public void setDificultad(Dificultades dificultad) {
		this.dificultad = dificultad;
	}
	/* 
	 * @Resumen Devuelve el numero maximo de karts que puede tener asignados una pista
	 * @return maxKarts = int 
	 */
	public int getMaxKarts() {
		return maxKarts;
	}
	/* 
	 * @Resumen Cambia el numero maximo de karts que puede tener asignados una pista
	 * @param maxKarts = int 
	 */
	public void setMaxKarts(int maxKarts) {
		this.maxKarts = maxKarts;
	}
	/* 
	 * @Resumen Devuelve el numero de karts asignados una pista
	 * @return nkartsasociados = int 
	 */
	public int getnkartsasociados() {
		return nkartsasociados;
	}
	/* 
	 * @Resumen Cambia el numero de karts asignados una pista
	 * @param nkartsasociados = int 
	 */
	public void setnkartsasociados(int nkartsasociados) {
		this.nkartsasociados = nkartsasociados;
	}
	/* 
	 * @Resumen Devuelve un vector con todas las pistas
	 * @return listaKarts = ArrayList<Kart> 
	 */
	public ArrayList<Kart> getListaKarts() {
		return listaKarts;
	}
	/* 
	 * @Resumen Cambia un vector con todas las pistas
	 * @param listaKarts = ArrayList<Kart> 
	 */
	public void setListaKarts(ArrayList<Kart> listaKarts) {
		this.listaKarts = listaKarts;
	}

	
	/* 
	 * @Resumen Devuelve un vector con todas las pistas disponibles
	 * @return listaKartsDisponibles = ArrayList<Kart> 
	 */
	public ArrayList<Kart> consultarKartsDisponibles() {
		
		ArrayList<Kart> listaKartsDisponibles = new ArrayList<Kart>();
		ArrayList<Kart> listaAUX = getListaKarts();
		
		for(int i=0; i < listaAUX.size(); i++ ) {
		   if(listaAUX.get(i).getEstado() == Estados.DISPONIBLE) {
			   listaKartsDisponibles.add(listaAUX.get(i));
		   }
		}
		
		return listaKartsDisponibles;
	}
	
	/* 
	 * @Resumen Asocia un kart a una pista
	 * @param kart = Kart
	 * @param pista = Pista 
	 */
	public void asociarKartPista(Kart kart, Pista pista) {
		pista.getListaKarts().add(kart);
		kart.setnombrePista(pista.getnombrePista());
		nkartsasociados++;
	}
	
	/* 
	 * @Resumen Devuelve una cadena con la informacion del pista
	 * @return string
	 */
	@Override
	public String toString() {
		return "Pista [nombrePista=" + nombrePista + ", tipoEstado=" + tipoEstado + ", dificultad=" + dificultad
				+ ", maxKarts=" + maxKarts + ", listaKarts=" + listaKarts + "]";

	}
}
