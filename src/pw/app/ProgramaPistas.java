package pw.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import pw.pistakart.GestorPistas;
import pw.pistakart.Pista;
import pw.reservas.ReservaAdultos;
import pw.pistakart.Dificultades;
import pw.usuario.GestorUsuario;

public class ProgramaPistas {

	public static void mainPistas() {
		
		/*Al gestor de pistas hay que pasarle un array de pistas y otro de karts*/
		GestorPistas factoryGestor = new GestorPistas();
		GestorUsuario Gestor = new GestorUsuario();
		Scanner scan = new Scanner(System.in);
		
		int num = 0;
		while(true) {
			
			System.out.println("BIENVENIDO AL PROGRAMA DE PISTAS");
			System.out.println("1. Crear Pista");
			System.out.println("2. Crear Kart");
			System.out.println("3. Asociar kart a pista disponible");
			System.out.println("4. Mostrar pistas libres para un numero de karts");
			System.out.println("5. Salir");
			String aux = scan.nextLine();
			try{
				num = Integer.parseInt(aux);
				switch(num) {
					case 1:
						factoryGestor.crearPista();
						break;
					case 2:
						factoryGestor.crearKart();
						break;
					case 3:
						factoryGestor.asociarKarts();
						break;
					case 4:
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
									if((dific==1) || (dific==2) || (dific==3)) {
										ArrayList<Pista> disponibles = factoryGestor.pistasDisponibles(numkarts, dificultad);
										for (Pista b : disponibles) {
											System.out.println(b.toString());
										}
									}
								}
								catch (NumberFormatException e) {
									System.out.print("Formato no valido");
								}
							}
						}
						catch (NumberFormatException e) {
							System.out.print("Formato no valido");
						}
						break;
					case 5:
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