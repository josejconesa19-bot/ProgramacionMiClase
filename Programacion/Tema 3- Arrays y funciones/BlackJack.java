package primerProyecto;
import java.util.Scanner;
 
public class Blackjack {
	static Scanner sc = new Scanner(System.in);
 
	public static void main(String[] args) {
		int jugador = turnoJugador();
		int ordenador = turnoOrdenador();
		mostrarGanador(jugador, ordenador);
	}
 
	public static int lanzarDado() {
		return (int) (Math.random() * 6) + 1;
	}
 
	public static int turnoJugador() {
		int suma = 0, turno = 0;
		String historial = "";
		String respuesta = "";
 
		do {
			int tirada = lanzarDado();
			turno++;
			suma = suma + tirada;
			historial = historial + tirada + " ";
 
			System.out.println("\nJUGADOR - Tirada " + turno + ": " + tirada);
			System.out.println("Tiradas: " + historial);
			System.out.println("Total: " + suma);
 
			if (suma <= 21) {
				System.out.println("¿Quieres volver a lanzar? Y/N");
				respuesta = sc.nextLine();
			}
		} while (suma <= 21 && respuesta.equalsIgnoreCase("Y"));
 
		if (suma > 21) {
			System.out.println("Te has pasado de 21.");
		}
		return suma;
	}
 
	public static int turnoOrdenador() {
		int suma = 0, turno = 0;
		String historial = "";
 
		while (suma < 17) {
			System.out.println("\nPulsa Enter para ver la tirada del ordenador...");
			sc.nextLine();
 
			int tirada = lanzarDado();
			turno++;
			suma = suma + tirada;
			historial = historial + tirada + " ";
 
			System.out.println("ORDENADOR - Tirada " + turno + ": " + tirada);
			System.out.println("Tiradas: " + historial);
			System.out.println("Total: " + suma);
		}
 
		if (suma > 21) {
			System.out.println("El ordenador se ha pasado de 21.");
		} else {
			System.out.println("El ordenador se planta.");
		}
		return suma;
	}
 
	public static void mostrarGanador(int jugador, int ordenador) {
		System.out.println("\nJugador: " + jugador + " | Ordenador: " + ordenador);
 
		if (jugador > 21 && ordenador > 21) {
			System.out.println("Os habéis pasado los dos. No gana nadie.");
		} else if (jugador > 21) {
			System.out.println("Pierdes. Gana la máquina.");
		} else if (ordenador > 21) {
			System.out.println("Has ganado a la máquina.");
		} else if (jugador > ordenador) {
			System.out.println("Has ganado a la máquina.");
		} else if (jugador == ordenador) {
			System.out.println("Empate. Gana la máquina.");
		} else {
			System.out.println("Pierdes. Gana la máquina.");
		}
	}
}
