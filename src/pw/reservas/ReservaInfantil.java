package pw.reservas;

import java.time.LocalDate;
import java.util.Date;

public class ReservaInfantil extends ReservaDAO  {
	
	protected int NumeroNinos;
	
	

	public ReservaInfantil(
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

	public ReservaInfantil(String idReserva,
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

	public ReservaInfantil() {

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
