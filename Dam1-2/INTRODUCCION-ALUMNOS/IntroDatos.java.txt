package estructurasdecontrol;

import java.io.IOException;
import java.util.Scanner;

/* ejemplos para aprender como
 * introducir por teclado diferentes 
 * tipos de datos
 */
public class IntroDatos {

	public static void main(String[] args) throws IOException
	{
		//tipo char 
		System.out.println("introduce un caracter:");
		char caracter = (char)System.in.read();
		System.out.println("caracter es "+ caracter);
		//limpia el buffer eliminando \n\r
		System.in.skip(2);
		
		//salta dos líneas
		System.out.println("\n\n");
		
		// creamos un objeto Scanner
		Scanner entrada = new Scanner(System.in);
		
		//tipo cadena
		System.out.println("introduce una cadena:");
		String cadena = entrada.nextLine();
		System.out.println("cadena = " + cadena);
						
		
		//tipo entero
		System.out.println("introduce un número entero:");
		int numEntero = entrada.nextInt();
		System.out.println("número entero = " + numEntero);
		
		System.out.println("\n\n");
		
		System.out.println("introduce un número real:");
		double numReal = entrada.nextDouble();
		System.out.println("número real = " + numReal);
		
		System.out.println("\n\n");
		
		

	}

}
