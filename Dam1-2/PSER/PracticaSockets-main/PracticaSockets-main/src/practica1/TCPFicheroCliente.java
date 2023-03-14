package practica1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TCPFicheroCliente extends TCPCliente{

	private int tamax;
	private FileInputStream fis;
	private DataOutputStream dos;
	File fichero = null;
	String nombreFich;
	
	
	public TCPFicheroCliente(String ip, int port) throws IOException {
		super(ip, port);
		tamax = 256;
		
			System.out.println("introduce la ruta del fichero: ");
			Scanner sc = new Scanner(System.in);
			nombreFich = sc.nextLine();
			fichero = new File(nombreFich);
			
			fis = new FileInputStream(fichero);
			dos = new DataOutputStream(socketCliente().getOutputStream());
		
			startCliente();
	}

	@Override
	public void startCliente() {
		
		byte buffer[] = new byte[tamax];
		int br = 0;
		do {
			try {
				//leer fichero
				br = fis.read(buffer);
			} catch(IOException e) {
				System.err.println("error de al leer");
				System.err.println(e.getMessage());
			}
			try {
				dos.write(buffer, 0, br);
			} catch(IOException e) {
				System.err.println("error al escribir");
				System.err.println(e.getMessage());
			}
		} while(br == tamax);
		
		try {
			fis.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		try {
			dos.close();
			System.out.println();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	

}
