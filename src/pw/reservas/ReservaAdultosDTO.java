package pw.reservas;

import java.time.LocalDate;
import java.util.Date;

public class ReservaAdultosDTO extends Reserva {
	
	protected int NumeroAdultos;

	
	
	public ReservaAdultosDTO(
			String idUsuario,
			int minutosReserva, 
			float precioPista,
			int descuento,
			String modalidad, 
			int numeroAdultos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		this.NumeroAdultos = numeroAdultos;
		this.tipo=TipoReserva.ADULTOS;
		this.idPista=02;
	}
	
	public ReservaAdultosDTO(String idReserva,
			String idUsuario,
			int minutosReserva, 
			float precioPista,
			int descuento,
			String modalidad, 
			int numeroAdultos) {
		super(idUsuario, minutosReserva, precioPista, descuento, modalidad);
		this.idReserva=idReserva;
		this.NumeroAdultos = numeroAdultos;
		this.tipo=TipoReserva.ADULTOS;
		this.idPista=02;
	}


    public ReservaAdultosDTO() {

    }

	public int getNumeroAdultos() {
		return NumeroAdultos;
	}



	public void setNumeroAdultos(int numeroAdultos) {
		NumeroAdultos = numeroAdultos;
	}

	@Override
	public String toString() {
		return "ReservaAdultos [NumeroAdultos=" + NumeroAdultos + ", idReserva=" + idReserva + ", idUsuario="
				+ idUsuario + ", fechaYhora=" + fechaYhora + ", minutosReserva=" + minutosReserva + ", idPista="
				+ idPista + ", precioPista=" + precioPista + ", descuento=" + descuento + ", tipo=" + tipo
				+ ", modalidad=" + modalidad + "]";
	}

	
	
	
	
}