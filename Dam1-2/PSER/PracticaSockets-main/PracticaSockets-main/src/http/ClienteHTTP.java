package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class ClienteHTTP {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = 80;
		
		try {
			Socket socket = new Socket(servidor, puerto);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			
			salida.println("GET /index.html HTTP/1.1\r\n\r");
			
			String linea = null;
			while ((linea = entrada.readLine()) != null) {
				System.out.println(linea);
				
			}
			socket.close();
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Debes estar conectado para que esto funcione bien.");
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
