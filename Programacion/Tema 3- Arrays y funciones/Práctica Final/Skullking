package practicaSkullKing;

import java.util.Random;
import java.util.Scanner;

public class skullKing {

    public static final Scanner sc = new Scanner(System.in);
    public static final Random azar = new Random();

    public static final int TOTAL_CARTAS = 70;
    public static final int TOTAL_RONDAS = 10;

    // Usamos -1 para representar una posición sin carta.
    public static final int VACIO = -1;

    public static void main(String[] args) {

        // Con 70 cartas y una última ronda de 10 cartas,
        // pueden participar como máximo 7 jugadores.
        int maximoJugadores = TOTAL_CARTAS / TOTAL_RONDAS;

        int numeroJugadores = pedirEntero(
                "Introduce el número de jugadores:",
                2,
                maximoJugadores
        );

        // Para probar el reparto, elegimos una ronda.
        // En el juego completo, las rondas avanzarán del 1 al 10.
        int numeroRonda = pedirEntero(
                "Introduce la ronda que quieres probar:",
                1,
                TOTAL_RONDAS
        );

        int[] mazo = crearMazo();

        int[][] manos = repartirCartas(
                mazo,
                numeroJugadores,
                numeroRonda
        );

        int[] apuestas = recogerApuestas(manos, numeroRonda);

        mostrarApuestas(apuestas);

        System.out.println(
                "\nCartas disponibles en el mazo: "
                + contarCartasDisponibles(mazo)
        );
    }

    public static int pedirEntero(
            String mensaje,
            int minimo,
            int maximo) {

        while (true) {

            System.out.println(mensaje);
            System.out.println(
                    "Introduce un número entre "
                    + minimo + " y " + maximo
            );

            // Leemos una línea completa para evitar problemas
            // al combinar nextInt() con nextLine().
            String entrada = sc.nextLine();

            try {

                int numero = Integer.parseInt(entrada.trim());

                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }

                System.out.println("El número está fuera del rango.");

            } catch (NumberFormatException e) {

                System.out.println("Debes escribir un número entero.");
            }
        }
    }

    public static int[] crearMazo() {

        int[] mazo = new int[TOTAL_CARTAS];

        // Recorrido secuencial.
        // Visitamos todas las posiciones, desde 0 hasta 69.
        for (int posicion = 0; posicion < mazo.length; posicion++) {

            // Cada carta recibe un identificador distinto.
            mazo[posicion] = posicion;
        }

        return mazo;
    }

    public static int contarCartasDisponibles(int[] mazo) {

        int disponibles = 0;

        // Recorrido secuencial con contador.
        for (int posicion = 0; posicion < mazo.length; posicion++) {

            if (mazo[posicion] != VACIO) {
                disponibles++;
            }
        }

        return disponibles;
    }

    public static int sacarCartaAleatoria(int[] mazo) {

        int disponibles = contarCartasDisponibles(mazo);

        if (disponibles == 0) {
            throw new IllegalStateException("El mazo está vacío.");
        }

        // Elegimos una de las cartas que todavía quedan.
        //
        // Si quedan 5 cartas, nextInt(5) devuelve
        // un número entre 0 y 4.
        int numeroElegido = azar.nextInt(disponibles);

        int contadorDisponibles = 0;

        // Búsqueda lineal.
        // Buscamos la carta disponible que ocupa
        // el puesto aleatorio que hemos elegido.
        for (int posicion = 0; posicion < mazo.length; posicion++) {

            if (mazo[posicion] != VACIO) {

                if (contadorDisponibles == numeroElegido) {

                    int carta = mazo[posicion];

                    // Marcamos la carta como retirada.
                    // Así no podrá repartirse otra vez.
                    mazo[posicion] = VACIO;

                    return carta;
                }

                contadorDisponibles++;
            }
        }

        throw new IllegalStateException(
                "No se ha encontrado la carta seleccionada."
        );
    }

    public static int[][] repartirCartas(
            int[] mazo,
            int numeroJugadores,
            int cartasPorJugador) {

        int necesarias = numeroJugadores * cartasPorJugador;

        if (necesarias > contarCartasDisponibles(mazo)) {
            throw new IllegalArgumentException(
                    "No quedan suficientes cartas para repartir."
            );
        }

        int[][] manos = new int[numeroJugadores][cartasPorJugador];

        // Bucles anidados.
        //
        // Primero repartimos la primera carta a todos.
        // Después, la segunda carta a todos.
        // Continuamos hasta completar las manos.
        for (int posicion = 0; posicion < cartasPorJugador; posicion++) {

            for (int jugador = 0; jugador < numeroJugadores; jugador++) {

                manos[jugador][posicion] = sacarCartaAleatoria(mazo);
            }
        }

        return manos;
    }

    public static String nombreCarta(int carta) {

        if (carta == VACIO) {
            return "Posición vacía";
        }

        if (carta >= 0 && carta <= 55) {

            int color = carta / 14;
            int numero = carta % 14 + 1;

            String nombreColor;

            switch (color) {

                case 0:
                    nombreColor = "Verde";
                    break;

                case 1:
                    nombreColor = "Amarilla";
                    break;

                case 2:
                    nombreColor = "Morada";
                    break;

                default:
                    nombreColor = "Negra";
            }

            return nombreColor + " " + numero;
        }

        if (carta >= 56 && carta <= 60) {
            return "Pirata";
        }

        switch (carta) {

            case 61:
                return "Skull King";

            case 62:
            case 63:
                return "Sirena";

            case 64:
                return "Ballena";

            case 65:
                return "Kraken";

            case 66:
            case 67:
            case 68:
            case 69:
                return "Alianza";

            default:
                throw new IllegalArgumentException(
                        "Identificador de carta incorrecto."
                );
        }
    }

    public static void mostrarMano(int[] mano) {

        for (int posicion = 0; posicion < mano.length; posicion++) {

            if (mano[posicion] != VACIO) {

                System.out.println(
                        (posicion + 1) + ". "
                        + nombreCarta(mano[posicion])
                );
            }
        }
    }

    public static int[] recogerApuestas(
            int[][] manos,
            int numeroRonda) {

        int[] apuestas = new int[manos.length];

        for (int jugador = 0; jugador < manos.length; jugador++) {

            System.out.println(
                    "\nMANO DEL JUGADOR " + (jugador + 1)
            );

            // manos[jugador] es un array de una dimensión.
            // Contiene todas las cartas de ese jugador.
            mostrarMano(manos[jugador]);

            apuestas[jugador] = pedirEntero(
                    "¿Cuántas bazas crees que ganarás?",
                    0,
                    numeroRonda
            );
        }

        return apuestas;
    }

    public static void mostrarApuestas(int[] apuestas) {

        System.out.println("\nAPUESTAS DE LA RONDA");

        for (int jugador = 0; jugador < apuestas.length; jugador++) {

            System.out.println(
                    "Jugador " + (jugador + 1)
                    + " apuesta " + apuestas[jugador]
            );
        }
    }
