package pw.reservas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;


public class GestorReservas {
	
	
	public static GestorReservas instance = null;
	
	
	
	

	public void crearReservaFamiliar(String idU, int minR, Float precioP, int Descuento , String modalidad,  int numeroNinos, int numeroAdultos  ) {
		ReservaFamiliarDTO reserva = new ReservaFamiliarDTO(idU, minR, precioP, Descuento, modalidad, numeroNinos, numeroAdultos);
		new ReservaFamiliarDAO().insertaReservaFamiliar(reserva);
	}
	
	public void crearReservaAdulto(String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroAdultos ) {
		ReservaAdultosDTO reserva = new ReservaAdultosDTO(idU, minR, precioP, Descuento, modalidad, numeroAdultos);
		new ReservaAdultosDAO().insertaReservaAdultos(reserva);
	}

	public void crearReservaInfantil(String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroNinos ) {
		ReservaInfantilDTO reserva = new ReservaInfantilDTO(idU, minR, precioP, Descuento, modalidad, numeroNinos);
		new ReservaInfatilDAO().insertaReservaInfantil(reserva);
	}
	
	
public void modificarReservaFamiliar(String idR, String idU, int minR, Float precioP, int Descuento , String modalidad,  int numeroNinos, int numeroAdultos  ) {
		
		ReservaFamiliarDTO reserva = new ReservaFamiliarDTO(idR, idU, minR, precioP, Descuento, modalidad, numeroNinos, numeroAdultos);
		new ReservaFamiliarDAO().modificaReservaFamiliar(reserva);
	}
	
	public void modificarReservaAdulto(String idR,String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroAdultos ) {
		ReservaAdultosDTO reserva = new ReservaAdultosDTO(idR,idU, minR, precioP, Descuento, modalidad, numeroAdultos);
		new ReservaAdultosDAO().modificaReservaAdultos(reserva);
		
	}

	public void modificarReservaInfantil(String idR,String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroNinos ) {
		ReservaInfantilDTO reserva = new ReservaInfantilDTO(idR,idU, minR, precioP, Descuento, modalidad, numeroNinos);
		new ReservaInfatilDAO().modificaReservaInfantil(reserva);
		
	}
	
	
	public ReservaFamiliarDTO buscarReservaF(String id) {
		
		return (new ReservaFamiliarDAO()).buscarReservaF(id);
	}
	
	

	public ReservaAdultosDTO buscarReservaA(String id) {
		
		return (new ReservaAdultosDAO()).buscarReservaA(id);
	}


	public ReservaInfantilDTO buscarReservaI(String id) {
		
		return (new ReservaInfatilDAO().buscarReservaI(id));
	}

	
	public  void eliminaReserva( String ID){
		new ReservaDAO().borraReserva(ID);
	}
	

	
	
	public float calcularPrecioReservaInd(int MinReserva , LocalDate fechaInscripcion) {
		
		
		LocalDate fecha =fechaInscripcion;

		LocalDate hoy = LocalDate.now();

		long antiguedad = ChronoUnit.YEARS.between(fecha, hoy);
		float precio = 0;	

		if(antiguedad>=2) {
			
			if(MinReserva<=60){ precio=18 ; }
			if(MinReserva==90){ precio=27; }
			if(MinReserva==120){ precio= 36 ; }
			
		}else {
		
		if(MinReserva<=60){ precio=20 ; }
		if(MinReserva==90){ precio=30; }
		if(MinReserva==120){ precio= 40 ; }
		}
		
		return precio;
	}
	
public float calcularPrecioReservaBono(int MinReserva) {
		
		float precio = 0;
		
		if(MinReserva==60){ precio=19 ; }
		if(MinReserva==90){ precio=(float) 28.5; }
		if(MinReserva==120){ precio= 38 ; }
		
		
		return precio;
	}

public void mostrarReservasFuturas() {
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	reservas=new ReservaDAO().verReservas();
	for(Reserva r : reservas) {
		System.out.println(r.toString());
	}
}


public void buscarReservaFechas(LocalDate Fecha) {
	
	
}
	

	
}
