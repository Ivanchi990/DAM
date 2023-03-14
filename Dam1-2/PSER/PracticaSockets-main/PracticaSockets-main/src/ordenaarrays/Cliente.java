package ordenaarrays;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = 11100;		
		
		try {
			//Me conecto al servidor
			Socket cliente = new Socket(servidor, puerto);
			
			//Declaramos e instanciamos un array de enteros sin ordenar.
			int [] array = {4, 7, 13, 2, 25, 6, 28, 45};
			
			int [] array1 = {41, 3, 5, 17, 6, 24};
			
			System.out.println("Array sin ordenar");
			visualizarArray(array);
			System.out.println("Array 1 sin ordenar");
			visualizarArray(array1);
			//Enviar datos al servidor
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			
			//Creamos un flujo de entrada para leer la fecha que nos pasa el servidor
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			//Enviar arrays sin ordenar al servidor
			oos.writeObject(array);
			oos.writeObject(array1);
			
			//Leemos los arrays del servidor ya ordenados y fusionados
			array = (int []) ois.readObject();
			array1 = (int []) ois.readObject();
			int [] arrayFusionado = (int []) ois.readObject();
			
			//Muestra por pantalla los arrays enviados por el servidor
			System.out.println("Array ordenado: ");
			visualizarArray(array);
			System.out.println("Array 1 ordenado: ");
			visualizarArray(array1);
			System.out.println("Array fusionado: ");
			visualizarArray(arrayFusionado);
			
			//Cierro la conexion
			cliente.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void visualizarArray(int[] array) {
		for (int i=0;i<array.length;i++) {
			System.out.println(array[i] + " ");
		}
		
	}
	
}
