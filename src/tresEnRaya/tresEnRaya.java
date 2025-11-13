package tresEnRaya;
import java.util.Scanner;
public class tresEnRaya {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		char[][] tablero=new char[3][3];
		do {
			
			mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1 : jugar(sc);
			case 2 : mostrarInstrucciones();
			case 3 : break;
			default: System.out.println("La opción seleccionada no existe");
			}
			
		}while(opcion!=3);
		
	}
	
	public static void mostrarMenu() {
		System.out.println("Bienvenido a tres en raya :), a continuación podrá ver las opciones posibles");
		System.out.println("1)Jugar\n2)Instrucciones\n3)salir");
		
	}
	public static void mostrarInstrucciones() {
		
		
	}
	public static void jugar(Scanner sc) {
		
	}
	public static void inicializarTablero(char[][] t) {
		for(int i=0;i<t.length;i++) {
			for(int j=0;j<t[i].length;j++) {
				t[i][j]='-';
			}
		}
		
		
	}
	public static void mostrarTablero(char[][] t) {
		
	}
	public static void hayGanador() {
		
	}
	public static void tableroLleno() {
		
	}
}
