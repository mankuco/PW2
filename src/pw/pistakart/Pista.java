package pw.pistakart;

import java.util.ArrayList;

public class Pista {
	
	
	 //ENUMERACION DE LOS ESTADOS

	
	private String nombrePista;
	private boolean tipoEstado;
	private Dificultades dificultad;
	private int maxKarts;
	private ArrayList<Kart> listaKarts;
	

	
	
		public Pista(String nombrePista, boolean tipoEstado, Dificultades dificultad, int maxKarts,
			ArrayList<Kart> listaKarts) {
		super();
		this.nombrePista = nombrePista;
		this.tipoEstado = tipoEstado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
		this.listaKarts = listaKarts;
	}

		public Pista() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
			
			
	public String getNombrePista() {
		return nombrePista;
	}


	public void setNombrePista(String nombrePista) {
		this.nombrePista = nombrePista;
	}


	public boolean isTipoEstado() {
		return tipoEstado;
	}


	public void setTipoEstado(boolean tipoEstado) {
		this.tipoEstado = tipoEstado;
	}


	public Dificultades getDificultad() {
		return dificultad;
	}


	public void setDificultad(Dificultades dificultad) {
		this.dificultad = dificultad;
	}


	public int getMaxKarts() {
		return maxKarts;
	}


	public void setMaxKarts(int maxKarts) {
		this.maxKarts = maxKarts;
	}


	public ArrayList<Kart> getListaKarts() {
		return listaKarts;
	}


	public void setListaKarts(ArrayList<Kart> listaKarts) {
		this.listaKarts = listaKarts;
	}

	public ArrayList<Kart> consultarKartsDisponibles() {
		ArrayList<Kart> listaKartsDisponibles = new ArrayList<Kart>();
		ArrayList<Kart> listaAUX = getListaKarts();
		
		for(int i=0; i < listaAUX.size(); i++ )
		{
		   if(listaAUX.get(i).getEstado() == Estados.DISPONIBLE) {
			 
			listaKartsDisponibles.add(listaAUX.get(i));
		   }
		}
		
		return listaKartsDisponibles;
	}
	
	
	public void asociarKartPista(Kart kart, Pista pista) {
		if(pista.getDificultad()== Dificultades.ADULTOS && kart.getTipoKart() == true){
			pista.getListaKarts().add(kart);
		}
		
		if(pista.getDificultad()== Dificultades.INFANTIL && kart.getTipoKart() == false){
			pista.getListaKarts().add(kart);
		}
		
		if(pista.getDificultad()== Dificultades.FAMILIAR){
			pista.getListaKarts().add(kart);
		}
		
		else {
			System.out.println("Kart no valido para esta pista");		}
		
	}
	
	
	@Override
	public String toString() {
		return "pista [nombrePista=" + nombrePista + ", tipoEstado=" + tipoEstado + ", dificultad=" + dificultad
				+ ", maxKarts=" + maxKarts + ", listaKarts=" + listaKarts + "]";

	}



}
