public class batallaPokemon {
	/*
	 * Enunciado: Crea un programa que calcule el daño de un ataque durante una
	 * batalla Pokémon. - La fórmula será la siguiente: daño = 50 * (ataque /
	 * defensa) * efectividad - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5
	 * (no es muy efectivo) - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y
	 * Eléctrico (buscar su efectividad) - El programa recibe los siguientes
	 * parámetros: - Tipo del Pokémon atacante. - Tipo del Pokémon defensor. -
	 * Ataque: Entre 1 y 100. - Defensa: Entre 1 y 100.
	 * 
	 */
	// Me declaro una variable scanner global para utilizarla tanto en mi main como
	// metodos
	static Scanner teclado = new Scanner(System.in);
	public static String tipo_pokemon;
	public static int nivel_evolucion;

	
	public static void main(String[] args) {
		int nivel_evolucion;
		int nivel_evolucion2;
		String tipo_pokemon1;
		String tipo_pokemon2;
		do {
			System.out.println("Que nivel de evolucion tiene el pokemon 1");
			nivel_evolucion = teclado.nextInt();
			teclado.nextLine();

		} while (nivel_evolucion != 1 && nivel_evolucion != 2 && nivel_evolucion != 3);
		do {
			System.out.println("Que nivel de evolucion tiene el pokemon 2");
			nivel_evolucion2 = teclado.nextInt();
			teclado.nextLine();

		} while (nivel_evolucion2 != 1 && nivel_evolucion2 != 2 && nivel_evolucion2 != 3);

		tipo_pokemon1 = menuTipos();
		tipo_pokemon2= menuTipos();
		
		batallaPokemon(tipo_pokemon1, tipo_pokemon2, ataquePokemon(nivel_evolucion), ataquePokemon(nivel_evolucion2),
				defensaPokemon(nivel_evolucion), defensaPokemon(nivel_evolucion2), vidaPokemon(nivel_evolucion),
				vidaPokemon(nivel_evolucion2));

	}

	public static double ataquePokemon(int evolucion) {
		double ataque_pokemon = 550;

		switch (evolucion) {

		case 1:
			ataque_pokemon *= 1;

			break;
		case 2:
			ataque_pokemon *= 1.25;

			break;
		case 3:
			ataque_pokemon *= 1.50;
			break;
		default:
			System.out.println("Me has introducido una evolucion incorrecta" + "las evoluciones son 1,2,3\n");

			break;
		}

		return ataque_pokemon;
	}

	public static double defensaPokemon(int evolucion) {
		double defensa_pokemon = 5;

		switch (evolucion) {

		case 1:
			defensa_pokemon *= 1;

			break;
		case 2:
			defensa_pokemon *= 1.25;

			break;
		case 3:
			defensa_pokemon *= 1.50;
			break;
		default:
			System.out.println("Me has introducido una evolucion incorrecta" + "las evoluciones son 1,2,3\n");

			break;
		}

		return defensa_pokemon;
	}

	public static void tiposPokemon() {
		menuTipos();

	}

	public static String menuTipos() {
		do {
			System.out.println("-------MENU TIPOS-------" + "\nTipo: Agua \n" + "Tipo: Fuego \n" + "Tipo: Planta \n"
					+ "Tipo: Electrico \n" + "Introduce el tipo escribiendo lo que está a la derecha de tipo: .");
			tipo_pokemon = teclado.nextLine();
			tipo_pokemon = tipo_pokemon.toLowerCase();
			if (!tipo_pokemon.equals("agua") && !tipo_pokemon.equals("fuego") && !tipo_pokemon.equals("planta")
					&& !tipo_pokemon.equals("electrico")) {
				System.out.println("Tienes que escribirme un tipo de los que hay en el menu");
			}
		} while (!tipo_pokemon.equals("agua") && !tipo_pokemon.equals("fuego") && !tipo_pokemon.equals("planta")
				&& !tipo_pokemon.equals("electrico"));
		return tipo_pokemon;

	}

	public static int vidaPokemon(int evolucion) {
		int vida_pokemon = 1000;
		switch (evolucion) {

		case 1:
			vida_pokemon *= 1;

			break;
		case 2:
			vida_pokemon *= 1.05;

			break;
		case 3:
			vida_pokemon *= 1.10;
			break;
		default:
			System.out.println("Me has introducido una evolucion incorrecta" + "las evoluciones son 1,2,3\n");

			break;
		}

		return vida_pokemon;
	}

	public static double modificadorAtaque(String tipo1, String tipo2) {
		double modificador = 0;
		switch (tipo1 + tipo2) {
		// efectivos *2
		case "fuegoplanta", "aguafuego", "plantaagua", "electricoagua":
			modificador = 2;
			return modificador;

		// no efectivo *0.5
		case "aguaplanta", "aguaelectrico", "fuegoagua", "plantafuego":
			modificador = 0.5;
			return modificador;

		default:
			modificador = 1;
			return modificador;
		}
	}



public static void batallaPokemon(String tipoPokemon_1, String tipoPokemon_2,
        double ataquePokemon_1, double ataquePokemon_2,
        double defensaPokemon_1, double defensaPokemon_2,
        double vidaPokemon_1, double vidaPokemon_2) {

    // COLORES ANSI
    final String RESET = "\u001B[0m";
    final String ROJO = "\u001B[31m";
    final String VERDE = "\u001B[32m";
    final String AMARILLO = "\u001B[33m";
    final String AZUL = "\u001B[34m";
    final String CYAN = "\u001B[36m";

    int contador = 1;

    System.out.println(CYAN + "\n========================================");
    System.out.println("           COMBATE POKEMON");
    System.out.println("========================================" + RESET);

    System.out.println(AZUL + "\n----------- POKEMON 1 -----------" + RESET);
    System.out.println("Tipo: " + tipoPokemon_1);
    System.out.println("Ataque: " + ataquePokemon_1);
    System.out.println("Defensa: " + defensaPokemon_1);
    System.out.printf(VERDE + "Vida: %.2f%n" + RESET, vidaPokemon_1);

    System.out.println(AMARILLO + "\n                 VS" + RESET);

    System.out.println(ROJO + "\n----------- POKEMON 2 -----------" + RESET);
    System.out.println("Tipo: " + tipoPokemon_2);
    System.out.println("Ataque: " + ataquePokemon_2);
    System.out.println("Defensa: " + defensaPokemon_2);
    System.out.printf(VERDE + "Vida: %.2f%n" + RESET, vidaPokemon_2);

    System.out.println(CYAN + "\n========================================");
    System.out.println("          INICIA EL COMBATE");
    System.out.println("========================================" + RESET);

    // Evitamos dividir entre cero
    if (defensaPokemon_1 <= 0 || defensaPokemon_2 <= 0) {
        System.out.println(ROJO + "ERROR: Defensa no valida." + RESET);
        return;
    }

    while (vidaPokemon_1 > 0 && vidaPokemon_2 > 0) {

        System.out.println(AMARILLO + "\n========================================");
        System.out.println("                TURNO " + contador);
        System.out.println("========================================" + RESET);

        // POKEMON 1 ATACA
        System.out.println(AZUL + "\n>>> POKEMON 1 ATACA <<<" + RESET);
        double modificadorAtaque = modificadorAtaque(tipoPokemon_1,tipoPokemon_2);
        
        double danio1 = (ataquePokemon_1 / defensaPokemon_2)
                * modificadorAtaque;

        System.out.printf("Ataque: %.2f%n", ataquePokemon_1);
        if(modificadorAtaque == 2) {
            System.out.printf(ROJO + "Golpe critico: Dano causado: %.2f%n" + RESET, danio1);

        }else if(modificadorAtaque == 0.5) {
            System.out.printf(ROJO + "No es muy efectivo: Dano causado: %.2f%n" + RESET, danio1);

        }else {
            System.out.printf(ROJO + "Dano causado: %.2f%n" + RESET, danio1);

        }

        vidaPokemon_2 -= danio1;

        if (vidaPokemon_2 <= 0) {
            vidaPokemon_2 = 0;

            System.out.println(AMARILLO + "\n¡¡GOLPE FINAL!!" + RESET);
            System.out.println(ROJO + "POKEMON 2 DERROTADO" + RESET);
            System.out.println(VERDE + "¡¡POKEMON 1 ES EL GANADOR!!" + RESET);
            break;
        }

        System.out.printf(VERDE + "Vida restante Pokemon 2: %.2f%n" + RESET, vidaPokemon_2);

        System.out.println(CYAN + "\n----------------------------------------" + RESET);

        // POKEMON 2 ATACA
        System.out.println(ROJO + "\n>>> POKEMON 2 CONTRAATACA <<<" + RESET);

        modificadorAtaque = modificadorAtaque(tipoPokemon_2,tipoPokemon_1);
        
        double danio2 = (ataquePokemon_2 / defensaPokemon_1)
                * modificadorAtaque;

        System.out.printf("Ataque: %.2f%n", ataquePokemon_2);
        if(modificadorAtaque == 2) {
            System.out.printf(ROJO + "Golpe critico: Dano causado: %.2f%n" + RESET, danio2);

        }else if(modificadorAtaque == 0.5) {
            System.out.printf(ROJO + "No es muy efectivo: Dano causado: %.2f%n" + RESET, danio2);

        }else {
            System.out.printf(ROJO + "Dano causado: %.2f%n" + RESET, danio2);

        }
        vidaPokemon_1 -= danio2;

        if (vidaPokemon_1 <= 0) {
            vidaPokemon_1 = 0;

            System.out.println(AMARILLO + "\n¡¡GOLPE FINAL!!" + RESET);
            System.out.println(ROJO + "POKEMON 1 DERROTADO" + RESET);
            System.out.println(VERDE + "¡¡POKEMON 2 ES EL GANADOR!!" + RESET);
            break;
        }

        System.out.printf(VERDE + "Vida restante Pokemon 1: %.2f%n" + RESET, vidaPokemon_1);

        // RESUMEN DEL TURNO
        System.out.println(CYAN + "\n------------ ESTADO ACTUAL ------------" + RESET);

        System.out.printf(AZUL + "Pokemon 1 [%s] " + RESET + "- Vida: %.2f%n",
                tipoPokemon_1, vidaPokemon_1);

        System.out.printf(ROJO + "Pokemon 2 [%s] " + RESET + "- Vida: %.2f%n",
                tipoPokemon_2, vidaPokemon_2);

        System.out.println(CYAN + "---------------------------------------" + RESET);

        contador++;
    }

    System.out.println(AMARILLO + "\n========================================");
    System.out.println("             FIN DEL COMBATE");
    System.out.println("========================================" + RESET);
}


}
