package pw.app;

import java.time.LocalDate;
import java.util.Scanner;

import pw.reservas.GestorReservas;
import pw.usuario.GestorUsuario;

public class ProgramaUsuarios {

	public static void mainUsuarios() {
		
		GestorUsuario factoryGestor = new GestorUsuario();
		Scanner scan = new Scanner(System.in);

		int num = 0;
		while(num!=4) {
			
			System.out.println("BIENVENIDO AL PROGRAMA DE USUARIOS");
			System.out.println("1. Añadir usuario");
			System.out.println("2. Modificar usuario");
			System.out.println("3. Listar usuarios");
			System.out.println("4. Salir");
			String opcion = scan.nextLine();
	        
	        try{
				num = Integer.parseInt(opcion);
			}
			catch (NumberFormatException e) {
				System.out.print("Formato no valido");
			}
	
		    switch (num) {
		        case 1:
		        	factoryGestor.altaUsuario();
		            break;
		        case 2:
		        	factoryGestor.modificarUsuario();
		            break;
		        case 3:
		        	factoryGestor.listarUsuarios();
		            break;
		        case 4:
		            break;
		        default:
		            System.out.println("Opcion no valida");
		            break;
		    }
		}
		factoryGestor.guardarUsuarios();
	}
}

