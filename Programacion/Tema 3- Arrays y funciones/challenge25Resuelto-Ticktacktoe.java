public class PiedraPapelTijera {
	public static Scanner teclado = new Scanner(System.in); // Declaro un scanner global

	public static String partida(String tiradaJugador1, String tiradaJugador2) {
		// lA FUNCION PARTIDA devuelve segun la tirada quien gana
		if (tiradaJugador1.equalsIgnoreCase(tiradaJugador2)) {
			return "EMPATE";
		}
		switch (tiradaJugador1) {
		case "R":
			if (tiradaJugador2.equals("T")) {
				return "Jugador 1";
			} else if (tiradaJugador2.equals("P")) {
				return "Jugador 2";
			}
			break;
		case "T":
			if (tiradaJugador2.equals("R")) {
				return "Jugador 2";
			} else if (tiradaJugador2.equals("P")) {
				return "Jugador 1";
			}
			break;
		case "P":
			if (tiradaJugador2.equals("R")) {
				return "Jugador 1";
			} else if (tiradaJugador2.equals("T")) {
				return "Jugador 2";
			}
			break;
		}
		return "ERROR";
	}

	public static String calcularGanadorFinal(int victorias_jugador_1, int victorias_jugador_2) {
		// Se llamará en el main una vez conozcamos las victorias de cada jugador y mostrará quien gana
		if (victorias_jugador_1 > victorias_jugador_2) {
			return "Jugador 1";
		} else if (victorias_jugador_1 < victorias_jugador_2) {
			return "Jugador 2";

		} else {
			return "EMPATE";
		}
	}

	public static String ticktacktoe() { // Esta funcion preguntara al usaurio que tire siempre que sea R T o P y nos devolverá su tirada
		String sacado;

		do {
			System.out.println(
					"Introduce tu tirada\n" + "Escribe:\n" + "R -> Piedra\n" + "T -> Tijeras\n" + "P -> Papel\n");
			sacado = teclado.nextLine().toUpperCase();

		} while (!sacado.equals("R") && !sacado.equals("T") && !sacado.equals("P"));
		return sacado;
	}

	public static int preguntarPartidas() {
		int numero_partidas;
		do {

			System.out.println("Cuantas partidas quereis jugar \n");
			numero_partidas = teclado.nextInt();
			if (numero_partidas < 0) {
				System.out.println("No se pueden jugar " + numero_partidas + " partidas");

			}
		} while (numero_partidas < 0);
		teclado.nextLine();
		return numero_partidas;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero_partidas = preguntarPartidas();
		int contador_jugador_1 = 0;
		int contador_jugador_2 = 0;
		for (int i = 1; i <= numero_partidas; i++) {
			System.out.println("Partida : " + i + "\n");
			System.out.println("Tirada del jugador 1: \n");
			String tirada_jugador_1 = ticktacktoe();
			System.out.println("Tirada del jugador 2: \n");
			String tirada_jugador_2 = ticktacktoe();

			String ganador_ronda = partida(tirada_jugador_1, tirada_jugador_2);

			if (ganador_ronda.equalsIgnoreCase("jugador 1")) {
				contador_jugador_1++;
			} else if (ganador_ronda.equalsIgnoreCase("jugador 2")) {
				contador_jugador_2++;
			}

		}
		System.out.println("Resultado : " + calcularGanadorFinal(contador_jugador_1, contador_jugador_2));
		teclado.close();
	}

}
