package pw.reservas;

import java.time.LocalDate;
import java.util.Date;

public class ReservaInfantilDTO extends Reserva  {
	
	protected int NumeroNinos;
	
	

	public ReservaInfantilDTO(
			String idUsuario,
			int minutosReserva, 
			float precioPista,
			int descuento,
			String modalidad, 
			int numeroNinos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		this.NumeroNinos = numeroNinos;
		this.tipo=TipoReserva.INFANTIL;
		this.idPista=03;
	}

	public ReservaInfantilDTO(String idReserva,
			String idUsuario,
			int minutosReserva, 
			float precioPista,
			int descuento,
			String modalidad, 
			int numeroNinos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		this.idReserva = idReserva;
		this.NumeroNinos = numeroNinos;
		this.tipo=TipoReserva.INFANTIL;
		this.idPista=03;
	}

	public ReservaInfantilDTO() {

	}


	public int getNumeroNinos() {
		return NumeroNinos;
	}

	public void setNumeroNinos(int numeroNinos) {
		NumeroNinos = numeroNinos;
	}

	@Override
	public String toString() {
		return "ReservaInfantil [NumeroNinos=" + NumeroNinos + ", idReserva=" + idReserva + ", idUsuario=" + idUsuario
				+ ", fechaYhora=" + fechaYhora + ", minutosReserva=" + minutosReserva + ", idPista=" + idPista
				+ ", precioPista=" + precioPista + ", descuento=" + descuento + ", tipo=" + tipo + ", modalidad="
				+ modalidad + "]";
	}

	
	
	

}
