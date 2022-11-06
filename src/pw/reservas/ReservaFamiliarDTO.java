package pw.reservas;

import java.time.LocalDate;
import java.util.Date;

public class ReservaFamiliarDTO extends Reserva {
	
	protected int NumeroNinos;
	protected int NumeroAdultos;
	

	public ReservaFamiliarDTO(String idUsuario, int minutosReserva, float precioPista, int descuento,
			String modalidad, int numeroNinos, int numeroAdultos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		NumeroNinos = numeroNinos;
		NumeroAdultos = numeroAdultos;
		this.tipo=TipoReserva.FAMILIAR;
		this.idPista=01;
	}
	
	
	public ReservaFamiliarDTO(String idR, String idUsuario, int minutosReserva, float precioPista, int descuento,
			String modalidad, int numeroNinos, int numeroAdultos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		this.idReserva = idR;
		NumeroNinos = numeroNinos;
		NumeroAdultos = numeroAdultos;
		this.tipo=TipoReserva.FAMILIAR;
		this.idPista=01;
	}



	public ReservaFamiliarDTO() {

	}


	public int getNumeroNinos() {
		return NumeroNinos;
	}


	public void setNumeroNinos(int numeroNinos) {
		NumeroNinos = numeroNinos;
	}


	public int getNumeroAdultos() {
		return NumeroAdultos;
	}


	public void setNumeroAdultos(int numeroAdultos) {
		NumeroAdultos = numeroAdultos;
	}

	
	
}
