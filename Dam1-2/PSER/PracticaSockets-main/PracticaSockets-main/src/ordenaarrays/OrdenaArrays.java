package ordenaarrays;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;

public class OrdenaArrays {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(11100);
			System.out.println("Servidor encendido");
			while(true) {
				Socket cliente = serverSocket.accept();
				Thread tarea = new OrdenaArray(cliente);
				tarea.start();
				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

class OrdenaArray extends Thread {
	
	Socket cliente;
	
	public OrdenaArray(Socket s) {
		cliente = s;
	}
	
	
	public static void ordenaBurbuja(int array[]) {
		/*Recorremos el array, comparamos elementos adyacentes
		 * y si no están bien ordenados los intercambiamos
		 */
		boolean hayIntercambio;
		do {
			hayIntercambio = false;
			//array.length - 1 para que no se pase leyendo
			for(int i = 0; i < array.length - 1; i++) {
				
				if(array[i] > (array[i + 1])) {
					//los intercambiamos
					int aux = array[i];
					array[i] = array[i + 1];
					array[i+1] = aux;
					hayIntercambio = true;
				}
			}
		}while(hayIntercambio);
		
	}

	public static int[] fusion(int[] arrayCliente, int[] arrayCliente1){
		int [] arrayFusion = new int[arrayCliente.length + arrayCliente1.length];
		//nos situamos en la primera posicion de cada array
		int i = 0; //array
		int j = 0; //array1
		int k = 0; //array2
		
		while(i < arrayCliente.length && j < arrayCliente1.length) {
			if(arrayCliente[i] < arrayCliente1[j]) {
				arrayFusion[k] = arrayCliente[i];
				i++;
				k++;
			}else {
				arrayFusion[k] = arrayCliente1[j];
				j++;
				k++;
			}
		}
		while(i < arrayCliente.length) {
			arrayFusion[k] = arrayCliente[i];
			i++;
			k++;
		}
		
		while(j < arrayCliente1.length) {
			arrayFusion[k] = arrayCliente1[j];
			k++;
			j++;
		}
		return arrayFusion;
	}
	
	public void run() {
		
		try {
			//Creamos los flujos de entrada y salida
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			
			//Recibimos los arrays sin ordenar del cliente
			int [] arrayCliente = (int[]) ois.readObject();
			
			int [] arrayCliente1 = (int []) ois.readObject();
			
			//ordenamos los arrays y los fusionamos
			ordenaBurbuja(arrayCliente);
			ordenaBurbuja(arrayCliente1);
			int [] arrayFusionado = fusion(arrayCliente, arrayCliente1);
			
			//pasamos los arrays al cliente
			oos.writeObject(arrayCliente);
			oos.writeObject(arrayCliente1);
			oos.writeObject(arrayFusionado);
			
			//cerramos flujos
			oos.close();
			ois.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}
	
	
}
	

