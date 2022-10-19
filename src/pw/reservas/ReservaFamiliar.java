package pw.reservas;

import java.time.LocalDate;
import java.util.Date;

public class ReservaFamiliar extends ReservaDAO {
	
	protected int NumeroNinos;
	protected int NumeroAdultos;
	

	public ReservaFamiliar(String idUsuario, int minutosReserva, float precioPista, int descuento,
			String modalidad, int numeroNinos, int numeroAdultos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		NumeroNinos = numeroNinos;
		NumeroAdultos = numeroAdultos;
		this.tipo=TipoReserva.FAMILIAR;
		this.idPista=01;
	}
	
	
	public ReservaFamiliar(String idR, String idUsuario, int minutosReserva, float precioPista, int descuento,
			String modalidad, int numeroNinos, int numeroAdultos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		this.idReserva = idR;
		NumeroNinos = numeroNinos;
		NumeroAdultos = numeroAdultos;
		this.tipo=TipoReserva.FAMILIAR;
		this.idPista=01;
	}



	public ReservaFamiliar() {

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
