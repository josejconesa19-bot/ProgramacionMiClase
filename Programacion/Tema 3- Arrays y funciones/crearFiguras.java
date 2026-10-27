public class DibujarFiguras {

	public static void main(String[] args) {

		dibujarCuadrado(2);
		dibujarTriangulo(5);
		dibujarCirculo(10);
	}
	/*
	 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con
	 * asteriscos "*". - Indicaremos el tamaño del lado y si la figura a dibujar es
	 * una u otra. - EXTRA: ¿Eres capaz de dibujar más figuras?
	 */
	
	public static void dibujarCirculo(int radio) {

		    for (int fila = -radio; fila <= radio; fila++) {

		        for (int columna = -radio; columna <= radio; columna++) {

		            double distancia = Math.sqrt(
		                    (fila * fila) + (columna * columna)
		            );

		            if (distancia <= radio) {
		                System.out.print("* ");
		            } else {
		                System.out.print("  ");
		            }
		        }

		        System.out.println();
		    }
		}
	
	public static void dibujarTriangulo(int lado) {
		for(int fila = 1; fila <= lado; fila++) {
			for(int espacio = 1; espacio <= lado - fila ; espacio++) {
				System.out.print(" ");
			}
			for(int columna = 1 ; columna <= fila  ;columna++) {
			System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void dibujarCuadrado(int lado) {

		for (int fila = 0; fila < lado; fila++) {
			/*En mi fila 0 entraré en columna tantas veces como columna sea < lado
		Para lado = 2 ,    fila 0 columna 0, fila 0, columna 1
						   fila 1 columna 0, fila 1, columna 1
		Resultado visual	* *
							* *				
								 */
			//Es mi fila 1
			for (int columna = 0; columna < lado; columna++) {
				System.out.print(" * "); 
			}
			System.out.println();
		}
	}

}
