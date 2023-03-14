package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServidorChat {

	static LinkedList<Socket> lista = new LinkedList<Socket>();
	static int contClientes = 0;
	PrintStream salida = null;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(9556);
			System.out.println("Servidor en marcha");
			while(true) {
				Socket cliente = serverSocket.accept();
				lista.add(contClientes, cliente);
				System.out.println("Nuevo cliente se une al chat");
				Thread hilo = new ManejadorPeticionChat(cliente);
				hilo.start();
				
				contClientes++;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized static void difundir(String nombre, String mensaje) {
		
		Socket s;
		PrintWriter pw;
		
		for (int i = 0; i < lista.size(); i++) {
			s = lista.get(i);
			try {
				pw = new PrintWriter(s.getOutputStream());
				pw.println(nombre + " se ha conectado");
				pw.println(mensaje);
				pw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public synchronized static void eliminar(Socket s) {
		PrintWriter pw;
		
		for (int i = 0; i < lista.size(); i++) {
			s = lista.get(i);
			try {
				lista.remove(s);
				pw = new PrintWriter(s.getOutputStream());
				contClientes--;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}
	
}


