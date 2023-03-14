package practica1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TCPTeletipoCliente extends TCPCliente {

	public TCPTeletipoCliente(String host, int puerto) {
		
		super(host, puerto);
		startCliente();
	}

	@Override
	public void startCliente() {
		Scanner sc = new Scanner(System.in);
		String entrada = "";
		DataOutputStream dos = null;
		try {
			System.out.println("Escucha mensajes, teclea fin para salir...");
			dos = new DataOutputStream(socketCliente.getOutputStream());
			
			while (!entrada.equals("fin")) {
				entrada = sc.nextLine();
				dos.writeUTF(entrada);
				
				
			}
			socketCliente.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
