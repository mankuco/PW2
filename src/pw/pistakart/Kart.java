package pw.pistakart;

public class Kart {
	
	

	private int idKart;
	private boolean tipoKart;  //True= Adulto  False= Infantil
	private Estados estado;	
	
	


	 //CONSTRUCTOR
	
	
	public Kart(int idKart, boolean tipoKart, Estados estado) {
		super();
		this.idKart = idKart;
		this.tipoKart = tipoKart;
		this.estado = estado;
	}
	
	public Kart() {
		super();
	};
	

	public int getIdKart() {
		return idKart;
	}
	public void setIdKart(int idKart) {
		this.idKart = idKart;
	}
	public boolean getTipoKart() {
		return tipoKart;
	}
	public void setTipoKart(boolean tipoKart) {
		this.tipoKart = tipoKart;
	}
	
	
	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public String toString() {
		return "KART [IDKart=" + idKart + ", TipoKart=" + tipoKart + ", Estado=" + estado + "]";
	}	 

}