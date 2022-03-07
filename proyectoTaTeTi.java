import java.util.Scanner;


public class proyectoTaTeTi {

	private static final int TOTAL_FICHAS = 9;
	private static int FILA = 3; // creacion de la referencia en matriz
	private static int COLUMNA = 3; // creacion de la referencia en matriz

	public static void main(String[] args) {
		System.out.println("\n                                                  ");
		System.out.println("    :)  BIENVENIDOS AL  TA                          ");
		System.out.println("                             TE                   \n  ");
		System.out.println("                                  TI  :)             \n  ");
		Scanner scn = new Scanner(System.in);

		int c1, c2; // declaración.
		char vacio = '_';
		char jugador1 = 'X';
		char jugador2 = 'O';
		boolean turno = true;
		boolean ganador = false; // hay ganador?

		char matriz[][] = new char[FILA][COLUMNA]; // Creación matriz de referencia //Solo defino en la variable

		for (int f = 0; f < FILA; f++) { // recorrido llenando tablero de guiones
			for (int c = 0; c < COLUMNA; c++) {
				matriz[f][c] = '-'; // matriz
			}
		}

		int cantidadFichas = 0;

		while (cantidadFichas < TOTAL_FICHAS) {

			while (turno) {

				System.out.println("\n       Turno JUGADOR I ");
				c1 = validarCoordenada(0, 2);
				c2 = validarCoordenada(0, 2);

				if (matriz[c1][c2] == '-') {

					matriz[c1][c2] = jugador1;
					turno = false;

				} else {

					System.out.println("\n                       !      ");
					System.out.println("                     DANGER   ");
					System.out.println("\n CELDA OCUPADA -- INGRESE COORENADAS DEL 0 AL 2:");

				}

				mostrarTablero(matriz);

				if (validarJugada(jugador1, matriz)) { // validarJugada para jugador1
					cantidadFichas = TOTAL_FICHAS;
					System.out.println(jugador1 + "\n    HA GANADO EL JUGADOR X!!");
					ganador = true;
				}
				cantidadFichas++;
			} // TURNO

			if (cantidadFichas < TOTAL_FICHAS) {
				turno = true;
			}
			while (turno) {
				System.out.println("\n      Turno JUGADOR II");

				c1 = validarCoordenada(0, 2);
				c2 = validarCoordenada(0, 2);
				if (matriz[c1][c2] == '-') {
					matriz[c1][c2] = jugador2;
					turno = false;
				} else {
					System.out.println("\n                       !      ");
					System.out.println("                     DANGER   ");
					System.out.println("\n CELDA OCUPADA -- INGRESE COORENADAS DEL 0 AL 2:");

				} // cierre else

				mostrarTablero(matriz);

				if (validarJugada(jugador2, matriz)) { // validarJugada para jugador2
					cantidadFichas = TOTAL_FICHAS;
					System.out.println(jugador2 + "\n   HA GANADO EL JUGADOR O!!");
					ganador = true;
				}
				cantidadFichas++;
			} // cierre while jugador 2.TURNO

			turno = true;

		} // FICHAS3 cierra evaluacion cantidadFichas < TOTAL_FICHAS

		if (ganador == false) {
			System.out.println("\n   GANA LA CASA!!");
		} // cerrando if empate

	}// cerrando main

	private static void mostrarTablero(char matriz[][]) {
		for (int f = 0; f < FILA; f++) {
			for (int c = 0; c < COLUMNA; c++) {
				System.out.print(matriz[f][c] + " ");
		}
			System.out.println();
		}
		}


		// ---------------------------------------------------------------------------------------------------------------------------------

		private static int validarCoordenada(int minimo, int maximo) {
			int numero = 99;
			Scanner sc = new Scanner(System.in);

			while (numero < minimo || numero > maximo) {
				System.out.println("\nIngrese su coordena de " + minimo + " a " + maximo + "  : ");
				numero = sc.nextInt();
			} // while

			return numero;
		}

		private static boolean validarJugada(char jugador, char matriz[][]) {
			boolean ganador = false;
			if (matriz[0][0] == jugador && matriz[0][1] == jugador && matriz[0][2] == jugador) {
				ganador = true;
			}

			if (matriz[1][0] == jugador && matriz[1][1] == jugador && matriz[1][2] == jugador) {
				ganador = true;
			}
			if (matriz[2][0] == jugador && matriz[2][1] == jugador && matriz[2][2] == jugador) {
				ganador = true;
			}
			if (matriz[0][0] == jugador && matriz[1][1] == jugador && matriz[2][2] == jugador) {
				ganador = true;
			}
			if (matriz[0][2] == jugador && matriz[1][1] == jugador && matriz[2][0] == jugador) {
				ganador = true;
			}
			if (matriz[0][0] == jugador && matriz[0][1] == jugador && matriz[0][2] == jugador) {
				ganador = true;
			}
			if (matriz[1][0] == jugador && matriz[1][1] == jugador && matriz[1][2] == jugador) {
				ganador = true;
			}
			if (matriz[2][0] == jugador && matriz[2][1] == jugador && matriz[2][2] == jugador) {
				ganador = true;
		}
			return ganador;
		} // metodo validaJugada

	}// cerrando class Tateti_Sara



