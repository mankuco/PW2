package pw.app;

import java.time.LocalDate;
import java.util.Scanner;

import pw.usuario.GestorUsuario;
import pw.usuario.Usuario;
import pw.reservas.GestorReservas;

public class ProgramaReservas{
	
	public static void mainReservas() {
		
		GestorReservas factoryGestor = new GestorReservas();
		GestorUsuario Gestor = new GestorUsuario();
		Scanner scan = new Scanner(System.in);
		int num = 0;
		while(num!=6) {
			
			System.out.println("BIENVENIDO AL PROGRAMA DE RESERVAS");
			System.out.println("1. Crear Reserva");
			System.out.println("2. Editar Reserva");
			System.out.println("3. Eliminar Reserva");
			System.out.println("4. Mostrar reservas futuras");
			System.out.println("5. Buscar reservas por fecha y pista");
			System.out.println("6. Salir");
			String aux = scan.nextLine();
			try{
				num = Integer.parseInt(aux);
			}
			catch (NumberFormatException e) {
				System.out.print("Formato no valido");
			}
			switch(num) {
				
				//Crear Reserva
				case 1:{
					System.out.println("Email del usuario que desea reservar: ");
					String emailU = scan.nextLine();
					Usuario u = Gestor.buscarUsuario(emailU);
					if(u==null) {
						System.out.println("Email no encontrado en los usuarios");
						break;
					}
					String idU = u.getIDusuario();
					System.out.println("Minutos que desea reservar: ");
					String aux2 = scan.nextLine();
					int minR = Integer.parseInt(aux2);
					System.out.println("Seleccione el tipo de reserva que desea crear");
					System.out.println("1. Familiar");
					System.out.println("2. Adultos");
					System.out.println("3. Infantil");
					String aux1 = scan.nextLine();
					int opc = Integer.parseInt(aux1);
					switch(opc) {
						
						//FAMILIAR
						case 1:{
					        System.out.println("Numero de ninos de la reserva: ");
							String aux4 = scan.nextLine();
							int numeroN = Integer.parseInt(aux4);
							System.out.println("Numero de adultos de la reserva: ");
							String aux5 = scan.nextLine();
							int numeroA = Integer.parseInt(aux5);
							System.out.println("Seleccione la modalidad de la reserva: ");
							System.out.println("1. Reserva Individual");
							System.out.println("2. Reserva bono");
							String aux3 = scan.nextLine();
							int opc2 = Integer.parseInt(aux3);
							switch(opc2) {
								//Individual
								case 1:{								
									LocalDate fechaI = u.getFechaInscripcion();
									Float precioP = factoryGestor.calcularPrecioReservaInd(minR, fechaI);
									factoryGestor.crearReservaFamiliar(idU,minR,precioP,0,"Individual",numeroN,numeroA);
									}
									break;
									
								//Bono
								case 2:{
									Float precioP = factoryGestor.calcularPrecioReservaBono(minR);
									factoryGestor.crearReservaFamiliar(idU,minR,precioP,0,"Bono",numeroN,numeroA);
									}
									break;
								default:{
									System.out.println("Opcion no valida");
									}
								}
							}
							break;
							
						//ADULTOS
						case 2:{
							System.out.println("Numero de adultos de la reserva: ");
							String aux5 = scan.nextLine();
							int numeroA = Integer.parseInt(aux5);
							System.out.println("Seleccione la modalidad de la reserva: ");
							System.out.println("1. Reserva Individual");
							System.out.println("2. Reserva bono");
							String aux3 = scan.nextLine();
							int opc2 = Integer.parseInt(aux3);
							switch(opc2) {
							
								//Individual
								case 1:{
									LocalDate fechaI = u.getFechaInscripcion();
									Float precioP = factoryGestor.calcularPrecioReservaInd(minR, fechaI);
									factoryGestor.crearReservaAdulto(idU,minR,precioP,0,"Individual",numeroA);
									}
									break;
									
								//Bono
								case 2:{
									Float precioP = factoryGestor.calcularPrecioReservaBono(minR);
									factoryGestor.crearReservaAdulto(idU,minR,precioP,0,"Bono",numeroA);
									}
									break;
								default:{
									System.out.println("Opcion no valida");
									}
							}
							}
							break;
							
						//INFANTIL
						case 3:{
							System.out.println("Numero de ninos de la reserva: ");
							String aux5 = scan.nextLine();
							int numeroN = Integer.parseInt(aux5);
							System.out.println("Seleccione la modalidad de la reserva: ");
							System.out.println("1. Reserva Individual");
							System.out.println("2. Reserva bono");
							String aux3 = scan.nextLine();
							int opc2 = Integer.parseInt(aux3);
							switch(opc2) {
							
								//Individual
								case 1:{
									LocalDate fechaI = u.getFechaInscripcion();
									Float precioP = factoryGestor.calcularPrecioReservaInd(minR, fechaI);
									factoryGestor.crearReservaInfantil(idU,minR,precioP,0,"Individual",numeroN);
									}
									break;
								
								//Bono
								case 2:{
									Float precioP = factoryGestor.calcularPrecioReservaBono(minR);
									factoryGestor.crearReservaInfantil(idU,minR,precioP,0,"Bono",numeroN);
									}
									break;
								default:{
									System.out.println("Opcion no valida");
									}
							}
							}
							break;
					}
					}
					break;
			
				//Editar reserva
				case 2:{
					System.out.println("Seleccione el tipo de reserva que desea editar:");
					System.out.println("1. Familiar");
					System.out.println("2. Adultos");
					System.out.println("3. Infantil");
					String aux2= scan.nextLine();
					int opc = Integer.parseInt(aux2);
					
					//Familiar
					if(opc == 1) {
						System.out.println("Introduzca el ID de la reserva que se va a editar (no se cambia el ID): ");
						String ID = (scan.nextLine());
						if(factoryGestor.buscarReservaF(ID) == null) {
							System.out.println("No existe ninguna reserva con ese ID");
							break;
						}
						System.out.println("Introduzca el email del propietario de la reserva ");
						String emaile = scan.nextLine();
						Usuario u = Gestor.buscarUsuario(emaile);
						if(u==null) {
							System.out.println("Email no encontrado en los usuarios");
							break;
						}	
						String idU = u.getIDusuario();
						System.out.println("Minutos que desea reservar: ");
						String aux5 = scan.nextLine();
						int minR = Integer.parseInt(aux5);
				        System.out.println("Numero de ninos de la reserva: ");
						String aux4 = scan.nextLine();
						int numeroN = Integer.parseInt(aux4);
						System.out.println("Numero de adultos de la reserva: ");
						String aux6 = scan.nextLine();
						int numeroA = Integer.parseInt(aux6);
						System.out.println("Seleccione la modalidad de la reserva: ");
						System.out.println("1. Reserva Individual");
						System.out.println("2. Reserva bono");
						String aux3 = scan.nextLine();
						int opc2 = Integer.parseInt(aux3);
						switch(opc2) {
						
							//Individual
							case 1:{
								LocalDate fechaI = u.getFechaInscripcion();
								Float precioP = factoryGestor.calcularPrecioReservaInd(minR, fechaI);
								factoryGestor.modificarReservaFamiliar(ID,idU,minR,precioP,0,"Individual",numeroN,numeroA);
								}
								break;
							case 2:{
								Float precioP = factoryGestor.calcularPrecioReservaBono(minR);
								factoryGestor.modificarReservaFamiliar(ID,idU,minR,precioP,0,"Bono",numeroN,numeroA);
								}
								break;
							default:{
								System.out.println("Opcion no valida");
								}
						}
					}
					
					//Adultos
					else if(opc == 2) {
						System.out.println("Introduzca el ID de la reserva que se va a editar (no se cambia el ID): ");
						String ID = (scan.nextLine());
						if(factoryGestor.buscarReservaF(ID) == null) {
							System.out.println("No existe ninguna reserva con ese ID");
							break;
						}
						System.out.println("Introduzca el email del propietario de la reserva ");
						String emaile = scan.nextLine();
						Usuario u = Gestor.buscarUsuario(emaile);
						if(u==null) {
							System.out.println("Email no encontrado en los usuarios");
							break;
						}	
						String idU = u.getIDusuario();
						System.out.println("Minutos que desea reservar: ");
						String aux5 = scan.nextLine();
						int minR = Integer.parseInt(aux5);
						System.out.println("Numero de adultos de la reserva: ");
						String aux6 = scan.nextLine();
						int numeroA = Integer.parseInt(aux6);
				        System.out.println("Seleccione la modalidad de la reserva: ");
						System.out.println("1. Reserva Individual");
						System.out.println("2. Reserva bono");
						String aux3 = scan.nextLine();
						int opc2 = Integer.parseInt(aux3);
						switch(opc2) {
						
							//Individual
							case 1:{
								LocalDate fechaI = u.getFechaInscripcion();
								Float precioP = factoryGestor.calcularPrecioReservaInd(minR, fechaI);
								factoryGestor.modificarReservaAdulto(ID,idU,minR,precioP,0,"Individual",numeroA);
								}
								break;
							
							//Bono
							case 2:{
								Float precioP = factoryGestor.calcularPrecioReservaBono(minR);
								factoryGestor.modificarReservaAdulto(ID,idU,minR,precioP,0,"Bono",numeroA);
								}
								break;
							default:{
								System.out.println("Opcion no valida");
								}
						}
					}
						
					//Infantil
					else if(opc == 3) {
						System.out.println("Introduzca el ID de la reserva que se va a editar (no se cambia el ID): ");
						String ID = (scan.nextLine());
						if(factoryGestor.buscarReservaF(ID) == null) {
							System.out.println("No existe ninguna reserva con ese ID");
							break;
						}
						System.out.println("Introduzca el email del propietario de la reserva ");
						String emaile = scan.nextLine();
						Usuario u = Gestor.buscarUsuario(emaile);
						if(u==null) {
							System.out.println("Email no encontrado en los usuarios");
							break;
						}	
						String idU = u.getIDusuario();
						System.out.println("Minutos que desea reservar: ");
						String aux5 = scan.nextLine();
						int minR = Integer.parseInt(aux5);
						System.out.println("Numero de Ninos de la reserva: ");
						String aux6 = scan.nextLine();
						int numeroN = Integer.parseInt(aux6);
						System.out.println("Seleccione la modalidad de la reserva: ");
						System.out.println("1. Reserva Individual");
						System.out.println("2. Reserva bono");
						String aux3 = scan.nextLine();
						int opc2 = Integer.parseInt(aux3);
						switch(opc2) {
						
							//Individual
							case 1:{
								LocalDate fechaI = u.getFechaInscripcion();
								Float precioP = factoryGestor.calcularPrecioReservaInd(minR, fechaI);
								factoryGestor.modificarReservaInfantil(ID,idU,minR,precioP,0,"Individual",numeroN);
								}
								break;
							case 2:{
								Float precioP = factoryGestor.calcularPrecioReservaBono(minR);
								factoryGestor.modificarReservaInfantil(ID,idU,minR,precioP,0,"Bono",numeroN);
								}
								break;
							default:{
								System.out.println("Opcion no valida");
								}
						}
					}
					}
					break;
					
				//Eliminar reserva
				case 3:{
					System.out.println("Seleccione el tipo de reserva que desea eliminar");
					System.out.println("1. Familiar");
					System.out.println("2. Adultos");
					System.out.println("3. Infantil");
					String aux1 = scan.nextLine();
					int opc = Integer.parseInt(aux1);
					switch(opc) {
						
						//Familiar
						case 1:{
							System.out.println("Introduzca el ID de la reserva que va a eliminar: ");
							String ID = (scan.nextLine());
							if(factoryGestor.buscarReservaF(ID) == null) {
								System.out.println("No existe ninguna reserva con ese ID");
							}
							else {
								factoryGestor.eliminaReservaF(ID);
							}
							}
							break;
							
						//Adultos
						case 2:{
							System.out.println("Introduzca el ID de la reserva que va a eliminar: ");
							String ID = (scan.nextLine());
							if(factoryGestor.buscarReservaA(ID) == null) {
								System.out.println("No existe ninguna reserva con ese ID");
							}
							else {
								factoryGestor.eliminaReservaA(ID);
							}
							}
							break;
							
						//Infantil
						case 3:{
							System.out.println("Introduzca el ID de la reserva que va a eliminar: ");
							String ID = (scan.nextLine());
							if(factoryGestor.buscarReservaI(ID) == null) {
								System.out.println("No existe ninguna reserva con ese ID");
							}
							else {
								factoryGestor.eliminaReservaI(ID);
							}
							}
							break;
						default:{
							System.out.println("Opcion no valida");
							}
				
					}
					}
					break;
			
				//Mostrar reservas
				case 4:{
					factoryGestor.mostrarReservasFuturas();
					}
					break;
			
				//Muestra las reservas para cierto dia
				case 5:{
					System.out.println("Introduzca la fecha de las reservas que desea ver: ");
					String fecha = (scan.nextLine());
					LocalDate fechaLD=LocalDate.parse(fecha);
					factoryGestor.buscarReservaFechas(fechaLD);
					}
					break;
				case 6:
					break;
				default:{
					System.out.println("Opcion no valida");
				}
			}
		}
	}
}