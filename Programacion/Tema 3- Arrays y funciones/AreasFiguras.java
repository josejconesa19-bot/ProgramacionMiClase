package funciones;

import java.util.Scanner;
public class AreasFiguras {	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Bienvenidos al calculador de areas
			double area = 0;
			int opcion = 0;
			String opcion2;
			do {
				opcion = menu();
				switch(opcion){
				case 1: // Rectangulo
					area = areaRectangulo();
					System.out.println("El area es: "+area);

					break;
				case 2: // Circulo
					area = areaCirculo();
					System.out.println("El area es: "+area);
					
					break;
				case 3:  // Triangulo
					area = areaTriangulo();
					System.out.println("El area es: "+area);
					break;
				case 0:
					System.out.println("Fin del programa");
					teclado.close();
					System.exit(0);
				}
				do {
					System.out.println("Deseas calcular otro area y/n");
					 opcion2 = teclado.next();
				} while(!opcion2.equalsIgnoreCase("y") && !opcion2.equalsIgnoreCase("n"));
		
			}while(opcion2.equalsIgnoreCase("y"));
			
			System.out.println("Has acabado el programa");
			teclado.close();
		
	}
	
	
	//Funciones areas
	public static double areaCirculo() {
		double radio = 0,pi = 0,area = 0;
		pi = Math.PI;
		System.out.println("Introduceme el radio del circulo");
		radio = teclado.nextDouble();
		teclado.nextLine();
		area = pi*(Math.pow(radio, 2));
		return area;
	}
	public static double areaTriangulo() {
		// El area de un triangulo es base*altura/2
		double altura = 0,base = 0,area = 0;
		System.out.println("Introduceme la altura del triangulo");
		altura = teclado.nextDouble();
		System.out.println("Introduce la base del triangulo");
		base = teclado.nextDouble();
		teclado.nextLine();
		area = (base*altura)/2;
		return area;
	}
	public static double areaRectangulo() {
		double altura, ancho;
		
		System.out.println("Introduce la altura del rectangulo");
		altura = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("Introduce el ancho del rectangulo");
		ancho = teclado.nextDouble();
		teclado.nextLine();
		
		return 0;
		
	}
	//Funcion Menu
	public static int menu() {
		int opcion = 0;
		do {
			//Pondré el menu
			System.out.println("Introduce el numero correspondiente"
					+ "a la opcion, es decir, si quieres calcular"
					+ "el area de un triangulo, selecciona 3 \n");
			System.out.println("----MENU----\n"
					+ "1-Rectangulo\n"
					+ "2-Círculo\n"
					+ "3-Triangulo\n"
					+ "0-Salir");
			opcion = teclado.nextInt(); // Opcion guarda el valor que reciba por teclado
			teclado.nextLine();
		}while(opcion < 0 || opcion > 3 );
		return opcion; // Es lo que la funcion devuelve al final.
	}
}
