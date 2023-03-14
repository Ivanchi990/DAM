package chat;

import java.io.IOException;
import java.io.OutputStream;
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
	
	public static void difundir(String nombre, String mensaje) {
		
		Socket s = null;
		OutputStream out = null;
		PrintWriter pw = null;
		
		for (int i = 0; i < lista.size(); i++) {
			s = lista.get(i);
			try {
				out = s.getOutputStream();
				pw = new PrintWriter(out, true);
				pw.println(nombre + ":" +  mensaje);

				pw.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				//pw.close();
			}
		}
		
	}
	
	public static void eliminar(Socket s) {
		PrintWriter pw;
		
		for (int i = 0; i < lista.size(); i++) {
			s = lista.get(i);
			try {
				lista.remove(s);
				pw = new PrintWriter(s.getOutputStream());
				contClientes--;
				if(contClientes == 0) {
					pw.print("No hay usuarios. ADIOS");
					pw.close();
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}
	
}

