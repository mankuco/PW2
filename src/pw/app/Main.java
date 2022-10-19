package pw.app;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
       Scanner esc = new Scanner(System.in);
       /*ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
       ArrayList<Pista> listaPistas = new ArrayList<Pista>();
       ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
       GestorUsuario gestorUsuarios = new GestorUsuario();*/
        
       int num=0;
  
       while(num<5) {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1. Ir al menu de usuarios");
			System.out.println("2. Ir al menu de pistas");
			System.out.println("3. Ir al menu de reservas");
			System.out.println("4. Salir");
	        String opcion = esc.nextLine();
	        
	        try{
				num = Integer.parseInt(opcion);
			}
			catch (NumberFormatException e) {
				System.out.print("Formato no valido");
			}
        	
            switch (num) {
                case 1:
                    ProgramaUsuarios.mainUsuarios();
                    break;
                case 2:
                    ProgramaPistas.mainPistas();
                    break;
                case 3:
                    ProgramaReservas.mainReservas();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
 }
