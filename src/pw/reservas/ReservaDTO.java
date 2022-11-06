package pw.reservas;

import java.io.Serializable;


public class ReservaDTO extends Reserva implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ReservaDTO(String idUsuario, int minutosReserva, float precioPista, int descuento,
			 String modalidad) {
		super(idUsuario,minutosReserva,precioPista,descuento,modalidad);
}

	public ReservaDTO(String idReserva, String idUsuario, int minutosReserva, float precioPista, int descuento,
			String modalidad, int numeroNinos, int numeroAdultos) {
		// TODO Auto-generated constructor stub
	}
}
