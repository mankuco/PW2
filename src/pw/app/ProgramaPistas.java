package pw.app;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Scanner;

import pw.pistakart.GestorPistas;
import pw.pistakart.Kart;
import pw.pistakart.Pista;
import pw.reservas.ReservaAdultos;
import pw.pistakart.Dificultades;
import pw.pistakart.Estados;
import pw.usuario.GestorUsuario;

public class ProgramaPistas {

	public static void mainPistas() {
		
		/*Al gestor de pistas hay que pasarle un array de pistas y otro de karts*/
		GestorPistas factoryGestor = new GestorPistas();
		GestorUsuario Gestor = new GestorUsuario();
		Scanner scan = new Scanner(System.in);
		
		int num = 0;
		while(num != 6) {
			
			System.out.println("BIENVENIDO AL PROGRAMA DE PISTAS");
			System.out.println("1. Crear Pista");
			System.out.println("2. Crear Kart");
			System.out.println("3. Asociar kart a pista disponible");
			System.out.println("4. Mostrar pistas que estan en manteniento");
			System.out.println("5. Mostrar pistas libres para un numero de karts");
			System.out.println("6. Salir");
			String aux = scan.nextLine();
			try{
				num = Integer.parseInt(aux);
				switch(num) {
					//Crear pista
					case 1:
						System.out.println("Introduce el nombre de la pista");
						String nombre = scan.nextLine();
						if (factoryGestor.existePista(nombre) != null) {
							System.out.println("La pista ya existe");
						}
						else {
							System.out.println("Introduce el tipo de pista");
							boolean tipoEstado = scan.nextBoolean();
							System.out.println("Introduce la dificultad");
							Dificultades dificultad = Dificultades.valueOf(scan.next());
							System.out.println("Introduce el numero maximo de karts");
							int maxKarts = scan.nextInt();
							factoryGestor.crearPista(nombre, tipoEstado, dificultad, maxKarts);
							System.out.println("Pista creada");
						}
						break;
					//Crear Kart
					case 2:
						System.out.println("Introduce el id del kart");
						int idKart = scan.nextInt();
						if (factoryGestor.existeKart(idKart) != null) {
							System.out.println("El kart ya existe");
						}
						else {
							int i=0;
							Estados estado;
							while(i==0) {
								i=1;
								System.out.println("Introduce el estado del kart");
								System.out.println("1. Disponible");
								System.out.println("2. Reservado");
								System.out.println("3. Mantenimiento");
								String a = scan.nextLine();
								try{
									int est = Integer.parseInt(a);
									switch(est) {
										case 1:
											estado=Estados.DISPONIBLE;
											break;
										case 2:
											estado=Estados.RESERVADO;
											break;
										case 3:
											estado=Estados.MANTENIMIENTO;
											break;
										default:
											System.out.print("Formato no valido");
											i=0;
											break;	
									}
								}
								catch (NumberFormatException e) {
									System.out.print("Formato no valido");
								}
							}
							boolean tipoKart;
							while(i==1) {
								i=0;
								System.out.println("Introduce el tipo de kart");
								System.out.println("1. Adulto");
								System.out.println("2. Infantil");
								String a = scan.nextLine();
								try{
									int v = Integer.parseInt(a);
									switch(v) {
										case 1:
											tipoKart=true;
											break;
										case 2:
											tipoKart=false;
											break;
										default:
											System.out.print("Formato no valido");
											i=1;
											break;	
									}
								}
								catch (NumberFormatException e) {
									System.out.print("Formato no valido");
								}
							}
							factoryGestor.crearKart(idKart,tipoKart, estado);
							System.out.println("Kart creado");
						}
						break;
					//Asociar kart a pista
					case 3:
						System.out.println("Introduce el nombre de la pista");
						String nombrePista = scan.nextLine();
						Pista pista;
						if ((pista = factoryGestor.existePista(nombrePista)) != null) {
							System.out.println("Introduce el id del kart");
							int id = scan.nextInt();
							Kart kart;
							if ((kart = factoryGestor.existeKart(id)) != null) {
								if (pista.getListaKarts().size() < pista.getMaxKarts()) {
									if(pista.getDificultad()== Dificultades.ADULTOS && kart.getTipoKart() == true){
										pista.asociarKartPista(kart, pista);
									}
									else if(pista.getDificultad()== Dificultades.INFANTIL && kart.getTipoKart() == false){
										pista.asociarKartPista(kart, pista);
									}
									else if(pista.getDificultad()== Dificultades.FAMILIAR){
										pista.asociarKartPista(kart, pista);
									}
									else {
										System.out.println("Kart no valido para esta pista");
									}
								}
								else {
									System.out.println("La pista esta llena");
								}
							}
							else {
								System.out.println("El kart no existe");
							}
						}
						else {
							System.out.println("La pista no existe");
						}
						break;
					//Mostrar pistas que estan en mantenimiento
					case 4:
						ArrayList<Pista> pistas = factoryGestor.listarPistasmantenimiento();
						for (Pista a : pistas) {
							System.out.println(a.toString());
						}
						break;
					//Mostrar pistas libres para un numero de karts
					case 5:
						System.out.println("Introduce el numero de karts");
						String a = scan.nextLine();
						int numkarts,dific;
						try{
							numkarts = Integer.parseInt(a);
							Dificultades dificultad;
							int i=0;
							while(i==0){
								i=1;
								System.out.println("Quiere que la pista sea:");
								System.out.println("1. Familiar");
								System.out.println("2. Adulto");
								System.out.println("3. Infantil");
								a = scan.nextLine();
								try{
									dific = Integer.parseInt(a);
									switch(dific) {
										case 1:
											dificultad=Dificultades.FAMILIAR;
											break;
										case 2:
											dificultad=Dificultades.ADULTOS;
											break;
										case 3:
											dificultad=Dificultades.INFANTIL;
											break;
										default:
											System.out.print("Formato no valido");
											i=0;
											break;	
									}
								}
								catch (NumberFormatException e) {
									System.out.print("Formato no valido");
								}
							}
							ArrayList<Pista> disponibles = factoryGestor.pistasDisponibles(numkarts, dificultad);
							for (Pista b : disponibles) {
								System.out.println(b.toString());
							}
						}
						catch (NumberFormatException e) {
							System.out.print("Formato no valido");
						}
						break;
					case 6:
						break;
					default:
						System.out.println("Opcion no valida");
				}	
			}
			catch (NumberFormatException e) {
				System.out.print("Formato no valido");
			}
		}
	}
}