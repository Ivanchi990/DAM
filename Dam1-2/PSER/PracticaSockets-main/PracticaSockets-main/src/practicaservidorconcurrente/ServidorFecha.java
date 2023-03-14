package practicaservidorconcurrente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class ServidorFecha {

	public static void main(String[] args) {

		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8900);
			System.out.println("Servidor encendido");
			while (true) {
				Socket cliente = s.accept();
				i++;
				System.out.println("Atendiendo peticion del cliente" + i);
				System.out.println("\nPuerto: " + cliente.getPort());
				System.out.println("IP: " + cliente.getInetAddress());
				Thread tarea = new EnviarFecha(cliente);
				tarea.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


class EnviarFecha extends Thread {
	
	private Socket socket;
	
	public EnviarFecha(Socket i) {
		socket = i;

	}

	public void run() {
		
		Date fecha = new Date();
		try {

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			oos.writeObject(fecha);
			
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}