/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author 2dam
 */
public class Utilidades {
    public static LocalDate introducirFecha(String mensaje) {

		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		boolean va;

		do {
			try {
				System.out.println("Introduce la fecha en formato dd-MM-yyyy");
				va = true;
				fecha = LocalDate.parse(introducirCadena(mensaje), formateador);
			} catch (DateTimeParseException e) {
				System.out.println("ERROR: Fecha introducida con formato incorrrecto");
				va = false;
			}
		} while (!va);

		return fecha;
	}

	public static String introducirCadena(String mensaje) {
		Scanner sc = new Scanner(System.in);

		String cadena = "";
		System.out.println(mensaje);

		try {
			cadena = sc.next();
		} catch (NoSuchElementException er) {
			System.out.println("Error al introducir datos");
			System.exit(0);
		}
		// sc.close();
		return cadena;
	}

	public static String leerString(int x, String mensaje) {
		String cadena = null;
		boolean ok;
		do {
			ok = true;
			cadena = introducirCadena(mensaje);
			if (cadena.length() > x) {
				System.out.println("Error al introducir datos. ");
				ok = false;
			}
		} while (!ok);

		return cadena;
	}

	public static double leerDouble(int x, int y, String mensaje) {
		double num = 0;
		boolean ok;
		do {
			try {
				ok = true;
				num = Double.parseDouble(introducirCadena(mensaje));

			} catch (NumberFormatException e) {
				System.out.println("Hay que introducir numeros");
				ok = false;
				num = x;

			}
			if (num < x || num > y) {
				System.out.println("Dato fuera de rango, introduce entre" + x + " y " + y);
				ok = false;
			}
		} while (!ok);
		return num;
	}

	public static double leerDouble(String mensaje) {
		double fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Double.parseDouble(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error al introducir el numero");
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

	public static boolean esBoolean(String mensaje) {
		String respu;
		do {
			respu = introducirCadena(mensaje).toLowerCase();
		} while (!respu.equals("0") && !respu.equals("1") && !respu.equals("si") && !respu.equals("no")
				&& !respu.equals("s") && !respu.equals("n") && !respu.equals("true") && !respu.equals("false"));
		if (respu.equals("1") || respu.equals("si") || respu.equals("s") || respu.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	public static char leerCharArray(char caracteres[], String mensaje) {
		int i;
		boolean error = false;
		String letra;
		char aux = 0;

		do {
			error = false;
			letra = introducirCadena(mensaje);
			if (letra.length() != 1) {
				System.out.println("Error, introduce un caracter: ");
				error = true;
			} else {
				aux = letra.toUpperCase().charAt(0);
				for (i = 0; i < caracteres.length; i++) {
					if (Character.toUpperCase(caracteres[i]) == Character.toUpperCase(aux)) {
						break;
					}
				}
				if (i == caracteres.length) {
					error = true;
					System.out.println("Error, el caracter introducido no es valido. ");
				}
			}
		} while (error);
		return aux;
	}

	public static char leerChar(String mensaje) {
		boolean error = false;
		String letra;

		do {
			error = false;
			letra = introducirCadena(mensaje);
			if (letra.length() != 1) {
				System.out.println("Error, introduce un caracter: ");
				error = true;
			}

		} while (error);
		return letra.toUpperCase().charAt(0);
	}

	public static float leerFloat(String mensaje) {
		float fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Float.parseFloat(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Error al introducir el numero");
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

	public static float leerFloat(float x, float y, String mensaje) {
		float fNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				fNumero = Float.parseFloat(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("Hay que introducir numeros. Vuelve a introducir: ");
				ok = false;
				fNumero = x;
			}
			if (fNumero < x || fNumero > y) {
				System.out.println("Dato fuera de rando. Introduce entre " + x + " y " + y);
				ok = false;
			}
		} while (!ok);
		return fNumero;
	}

	public static int leerInt(String mensaje) {
		int iNumero = 0;
		boolean ok;
		do {
			try {
				ok = true;
				iNumero = Integer.parseInt(introducirCadena(mensaje));
			} catch (NumberFormatException e) {
				System.out.println("hay que introducir numeros");
				ok = false;
			}
		} while (!ok);
		return iNumero;
	}

	public static int leerInt(int x, int y, String mensaje) {
		int num = 0;
		boolean ok;
		do {
			try {
				ok = true;
				num = Integer.parseInt(introducirCadena(mensaje));

			} catch (NumberFormatException e) {
				System.out.println("Hay que introducir numeros");
				ok = false;
				num = x;

			}
			if (num < x || num > y) {
				System.out.println("Dato fuera de rango, introduce entre " + x + " y " + y);
				ok = false;
			}
		} while (!ok);
		return num;
	}

	// Devuelve el n�mero de objetos de un fichero
	public static int calculoFichero(File fich) {
		int cont = 0;
		if (fich.exists()) {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(fich);
				ois = new ObjectInputStream(fis);

				Object aux = ois.readObject();

				while (aux != null) {
					cont++;
					aux = ois.readObject();
				}

			} catch (EOFException e1) {
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar los flujos");

			}
		}
		return cont;
	}
}
