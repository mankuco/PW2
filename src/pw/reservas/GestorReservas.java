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
	private ArrayList<ReservaFamiliar> reservasFamiliares = new ArrayList<ReservaFamiliar>();
	private ArrayList<ReservaAdultos> reservasAdultos = new ArrayList<ReservaAdultos>();
	private ArrayList<ReservaInfantil> reservasInfantiles = new ArrayList<ReservaInfantil>();
	
	
	public GestorReservas() {
		
		this.cargarReservas();
		
	}
	
	
	private void cargarReservas() {
		this.reservasFamiliares = new ArrayList<ReservaFamiliar>();
		this.reservasAdultos = new ArrayList<ReservaAdultos>();
		this.reservasInfantiles = new ArrayList<ReservaInfantil>();
	}


	public void crearReservaFamiliar(String idU, int minR, Float precioP, int Descuento , String modalidad,  int numeroNinos, int numeroAdultos  ) {
		ReservaFamiliar reserva = new ReservaFamiliar(idU, minR, precioP, Descuento, modalidad, numeroNinos, numeroAdultos);
		reservasFamiliares.add(reserva);
	}
	
	public void crearReservaAdulto(String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroAdultos ) {
		ReservaAdultos reserva = new ReservaAdultos(idU, minR, precioP, Descuento, modalidad, numeroAdultos);
		reservasAdultos.add(reserva);
	}

	public void crearReservaInfantil(String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroNinos ) {
		ReservaInfantil reserva = new ReservaInfantil(idU, minR, precioP, Descuento, modalidad, numeroNinos);
		reservasInfantiles.add(reserva);
	}
	
	
public void modificarReservaFamiliar(String idR, String idU, int minR, Float precioP, int Descuento , String modalidad,  int numeroNinos, int numeroAdultos  ) {
		
		ReservaFamiliar reserva = new ReservaFamiliar(idR, idU, minR, precioP, Descuento, modalidad, numeroNinos, numeroAdultos);
		reservasFamiliares.add(reserva);
	}
	
	public void modificarReservaAdulto(String idR,String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroAdultos ) {
		ReservaAdultos reserva = new ReservaAdultos(idR,idU, minR, precioP, Descuento, modalidad, numeroAdultos);
		reservasAdultos.add(reserva);
		
	}

	public void modificarReservaInfantil(String idR,String idU, int minR, Float precioP, int Descuento , String modalidad, int numeroNinos ) {
		ReservaInfantil reserva = new ReservaInfantil(idR,idU, minR, precioP, Descuento, modalidad, numeroNinos);
		reservasInfantiles.add(reserva);
		
	}
	
	
	public ReservaFamiliar buscarReservaF(String id) {
		
		if (reservasFamiliares.size() == 0) {
			return null;
		}
		for (ReservaFamiliar f : reservasFamiliares) {
			if (f.getIdReserva() == id) {
				return f;
			}
		}
		return null;
	}
	
	
	public ReservaAdultos buscarReservaA(String id) {
		
		if (reservasAdultos.size() == 0) {
			return null;
		}
		for (ReservaAdultos a : reservasAdultos) {
			if (a.getIdReserva() == id) {
				return a;
			}
		}
		return null;
	}

	public ReservaInfantil buscarReservaI(String id) {
	
	if (reservasInfantiles.size() == 0) {
		return null;
	}
	for (ReservaInfantil i : reservasInfantiles) {
		if (i.getIdReserva() == id) {
			return i;
		}
	}
	return null;
}

	
	public ArrayList<ReservaFamiliar> eliminaReservaF( String ID){
		ArrayList<ReservaFamiliar> reservas;
		reservas=this.reservasFamiliares;
		for(Iterator<ReservaFamiliar> iterator = reservas.iterator(); iterator.hasNext();) {
			ReservaDAO aux = iterator.next();
			if (aux.getIdReserva() == ID) {
				iterator.remove();
			}
		}
		return reservas;
	}
	
	public ArrayList<ReservaAdultos> eliminaReservaA( String ID){
		ArrayList<ReservaAdultos> reservas;
		reservas=this.reservasAdultos;
		for(Iterator<ReservaAdultos> iterator = reservas.iterator(); iterator.hasNext();) {
			ReservaDAO aux = iterator.next();
			if (aux.getIdReserva() == ID) {
				iterator.remove();
			}
		}
		return reservas;
	}
	
	public ArrayList<ReservaInfantil> eliminaReservaI( String ID){
		ArrayList<ReservaInfantil> reservas;
		reservas=this.reservasInfantiles;
		for(Iterator<ReservaInfantil> iterator = reservas.iterator(); iterator.hasNext();) {
			ReservaDAO aux = iterator.next();
			if (aux.getIdReserva() == ID) {
				iterator.remove();
			}
		}
		return reservas;
	}
	
	public float calcularPrecioReservaInd(int MinReserva , LocalDate fechaInscripcion) {
		
		
		LocalDate fecha =fechaInscripcion;

		LocalDate hoy = LocalDate.now();

		long antiguedad = ChronoUnit.YEARS.between(fecha, hoy);
		float precio = 0;	

		if(antiguedad>=2) {
			
			if(MinReserva==60){ precio=18 ; }
			if(MinReserva==90){ precio=27; }
			if(MinReserva==120){ precio= 36 ; }
			
		}else {
		
		if(MinReserva==60){ precio=20 ; }
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
	if( reservasAdultos.size() != 0) {
		for (ReservaAdultos a : reservasAdultos) {
			if (a.getFechaYhora().compareTo(LocalDate.now()) < 0) {
				System.out.println(a.toString());
			}}
	}
	if( reservasInfantiles.size() != 0) {
		for (ReservaInfantil i : reservasInfantiles) {
			if (i.getFechaYhora().compareTo(LocalDate.now()) < 0) {
				System.out.println(i.toString());
			}}
	}
	if( reservasFamiliares.size() != 0) {
		for (ReservaFamiliar f : reservasFamiliares) {
			if (f.getFechaYhora().compareTo(LocalDate.now()) < 0) {
				System.out.println(f.toString());
			}}
	}
	
}


public void buscarReservaFechas(LocalDate Fecha) {
	
	if( reservasAdultos.size() != 0) {
		for (ReservaAdultos a : reservasAdultos) {
			if (a.getFechaYhora().compareTo(Fecha) == 0) {
				System.out.println(a.toString());
			}}
	}
	if( reservasInfantiles.size() != 0) {
		for (ReservaInfantil i : reservasInfantiles) {
			if (i.getFechaYhora().compareTo(Fecha) == 0) {
				System.out.println(i.toString());
			}}
	}
	if( reservasFamiliares.size() != 0) {
		for (ReservaFamiliar f : reservasFamiliares) {
			if (f.getFechaYhora().compareTo(Fecha) == 0) {
				System.out.println(f.toString());
			}}
	}
}
	

	
}
