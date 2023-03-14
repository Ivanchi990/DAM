package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTelnet {
	
	static String servidor = "localhost";
	static int puerto = 9556;

	public static void main(String[] args) {
		
		ServidorChat servidorChat = new ServidorChat();
		ManejadorPeticionChat cliente = new ManejadorPeticionChat(null);
		
		conectarseA(servidor, puerto);
		
	}

	private static void conectarseA(String servidor, int puerto) {
		
		try {
			//Creamos el socket TCP
			Socket socketCliente = new Socket(servidor, puerto);
			Hilo hiloLectura = new Hilo(socketCliente.getInputStream(), System.out);
			Hilo hiloEscritura = new Hilo(System.in, socketCliente.getOutputStream());

			hiloLectura.start();
			hiloEscritura.start();
			
		}catch (IOException e) {
			
		}
		
	}
	
	
}