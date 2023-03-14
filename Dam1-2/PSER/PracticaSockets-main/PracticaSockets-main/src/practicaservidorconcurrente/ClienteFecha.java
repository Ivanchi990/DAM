package practicaservidorconcurrente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class ClienteFecha {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = 8900;
		
		
		try {
			//Me conecto al servidor
			Socket cliente = new Socket(servidor, puerto);
			//Creamos un flujo de entrada para leer la fecha que nos pasa el servidor
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			//Muestra por pantalla la fecha enviada por el servidor
			System.out.println(ois.readObject());
			//Cierro la conexion
			cliente.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
}
