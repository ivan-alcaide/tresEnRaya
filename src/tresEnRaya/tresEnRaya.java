package tresEnRaya;
import java.util.Arrays;
import java.util.Scanner;
public class tresEnRaya {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		char turno = 'X';
		char[][] tablero=new char[3][3];
		tablero=inicializarTablero(tablero);
		do {
			
			mostrarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1 : turno=jugar(sc, tablero, turno);
						break;
			case 2 : mostrarInstrucciones();
						break;
			case 3 : mostrarTablero(tablero);
						break;
			case 4 : break;
			default: System.out.println("La opción seleccionada no existe");
			}
			
		}while(opcion!=4);
		
	}
	
	public static void mostrarMenu() {
		System.out.println("Bienvenido a tres en raya :), a continuación podrá ver las opciones posibles");
		System.out.println("1)Jugar\n2)Instrucciones\n3)Mostrar tablero\n4)salir");
		
	}
	public static void mostrarInstrucciones() {
		
		System.out.println("  0   1   2  ");
		System.out.println("0 - | - | - |");
		System.out.println("1 - | - | - |");
		System.out.println("2 - | - | - |");
		
	}
	public static char jugar(Scanner sc,char[][] t, char turno) {
		boolean completo = tableroCompleto(t);
		if(completo==false) {
		int fila,columna;
		boolean ocupado;
		System.out.println("Turno de "+ turno);
		System.out.println("Elija la fila");
		fila=sc.nextInt();
		System.out.println("Elija la columna");
		columna=sc.nextInt();
		ocupado=tableroLleno(t, fila, columna);
		if(ocupado) {
			System.out.println("Esa posición está ocupada");
			return turno;
		}else {
			t[fila][columna]=turno;
			if(hayGanador(t, turno)) {
			    System.out.println("Partida terminada.");
			    System.exit(0);
			}
			turno=cambiarTurno(turno);
			return turno;
			
		}
		}else {
			System.out.println("Tablero completo es empate");
			return turno;
		}
		
	}
	public static char[][] inicializarTablero(char[][] t) {
		for(int i=0;i<t.length;i++) {
			for(int j=0;j<t[i].length;j++) {
				t[i][j]='-';
			}
		}
		return t;
		
	}
	public static void mostrarTablero(char[][] t) {
		for(int i=0;i<t.length;i++) {
			for(int j=0;j<t[i].length;j++) {
				System.out.print(t[i][j] + " | ");
			}
			System.out.print("\n");
		}
		
	}
	public static boolean hayGanador(char[][] t, char turno) {

	    // Revisar filas
	    for(int i = 0; i < 3; i++) {
	        if(t[i][0] == turno && t[i][1] == turno && t[i][2] == turno) {
	            System.out.println("El jugador " + turno + " ha ganado");
	            return true;
	        }
	    }

	    // Revisar columnas
	    for(int i = 0; i < 3; i++) {
	        if(t[0][i] == turno && t[1][i] == turno && t[2][i] == turno) {
	            System.out.println("El jugador " + turno + " ha ganado");
	            return true;
	        }
	    }

	    if(t[0][0] == turno && t[1][1] == turno && t[2][2] == turno) {
	        System.out.println("El jugador " + turno + " ha ganado");
	        return true;
	    }

	    // Revisar diagonal inversa
	    if(t[0][2] == turno && t[1][1] == turno && t[2][0] == turno) {
	        System.out.println("El jugador " + turno + " ha ganado");
	        return true;
	    }

	    return false;
	}
	public static boolean tableroLleno(char[][] t, int fila, int columna) {
		if(t[fila][columna]=='-') {
			return  false;
		}else {
			return true;
		}
		
	}
	public static boolean tableroCompleto(char[][] t) {
		int contador=0;
		for(int i=0;i<t.length;i++) {
			for(int j=0;j<t[i].length;j++) {
				if(t[i][j]!='-') {
					contador++;
				}
			}
		}
		if(contador==9) {
			return true;
		}else {
			return false;
		}
	}
	public static char cambiarTurno(char turno) {
		if(turno=='X') {
			turno='O';
			return turno;
		}else {
			turno='X';
			return turno;
		}
	}
}
