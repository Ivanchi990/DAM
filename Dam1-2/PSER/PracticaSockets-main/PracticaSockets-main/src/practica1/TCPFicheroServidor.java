package practica1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TCPFicheroServidor extends TCPServidor {

	private DataInputStream dis;
	private FileOutputStream fos;
	
	public TCPFicheroServidor(int port) {
		super(port);
		
		try {
			dis = new DataInputStream(socketServidor.getInputStream());
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		
		startServidor();
	}

	@Override
	public void startServidor() {
		
		try {
			System.out.println("Introduce la ruta: ");
			Scanner sc = new Scanner(System.in);
			String ruta = sc.nextLine();
			
			File fichero = new File(ruta);
			
			fos = new FileOutputStream(fichero);
			
			int tamax = 256;
			int bytesLeidos = 0;
			byte buffer[] = new byte[tamax];
			
			do {
				bytesLeidos = dis.read(buffer);
				fos.write(buffer, 0, bytesLeidos);
			} while(bytesLeidos == tamax);
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
		try {
			dis.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
