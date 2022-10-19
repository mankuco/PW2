package pw.reservas;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public abstract class ReservaDAO {

	protected String idReserva;
	protected String idUsuario;
	protected LocalDate fechaYhora;
	protected int minutosReserva;
	protected int idPista;
	protected float precioPista;
	protected int descuento;
	protected TipoReserva tipo;
	protected String modalidad;
	
	
	public ReservaDAO(String idUsuario, int minutosReserva, float precioPista, int descuento,
			 String modalidad) {
				
		this.idReserva = generarIdUnico();
		this.idUsuario = idUsuario;
		this.fechaYhora = LocalDate.now();;
		this.minutosReserva = minutosReserva;
		this.precioPista = precioPista;
		this.descuento = descuento;
		this.modalidad = modalidad;
	}


	
	
	public ReservaDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String generarIdUnico(){
	    UUID uuid = UUID.randomUUID();
	    return uuid.toString();
	}

	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public LocalDate getFechaYhora() {
		return fechaYhora;
	}


	public void setFechaYhora(LocalDate fechaYhora) {
		this.fechaYhora = fechaYhora;
	}


	public int getMinutosReserva() {
		return minutosReserva;
	}


	public void setMinutosReserva(int minutosReserva) {
		this.minutosReserva = minutosReserva;
	}


	public int getIdPista() {
		return idPista;
	}


	public void setIdPista(int idPista) {
		this.idPista = idPista;
	}


	public float getPrecioPista() {
		return precioPista;
	}


	public void setPrecioPista(float precioPista) {
		this.precioPista = precioPista;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	public TipoReserva getTipo() {
		return tipo;
	}


	public void setTipo(TipoReserva tipo) {
		this.tipo = tipo;
	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	
	public String getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}


	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idUsuario=" + idUsuario + ", fechaYhora=" + fechaYhora
				+ ", minutosReserva=" + minutosReserva + ", idPista=" + idPista + ", precioPista=" + precioPista
				+ ", descuento=" + descuento + ", tipo=" + tipo + ", modalidad=" + modalidad + "]";
	}


	
	
	
}

