package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorPeticionChat extends Thread {
	
	Socket cliente;
	BufferedReader entrada;
	PrintWriter salida;
	String linea;
	String salir = "adios";
	
	public ManejadorPeticionChat(Socket cliente) {
		this.cliente = cliente;
		
	}

	public void run() {
		
		try {
			
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			salida = new PrintWriter(cliente.getOutputStream(), true);
			
			salida.println("Introduce tu nombre: ");
			String nombre = entrada.readLine();
			ServidorChat.difundir(nombre, "Conectado al chat");
			salida.println("Bienvenido\nPara salir teclea: adios");
			linea = entrada.readLine();

			while(!linea.equals(salir)) {
				ServidorChat.difundir(nombre, linea);	
				linea = entrada.readLine();
			}
			if(linea.equals(salir)) {
				ServidorChat.difundir(nombre, "se ha desconectado");
				ServidorChat.eliminar(cliente);
			}
			
			try {
                sleep(100);
            } catch (InterruptedException e) {
            	System.err.println("Error espera:" + e.getMessage());
            }	
			
		}catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
			
		
		
	}
} 