package practica1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class TCPServidor {

protected Socket socketServidor = null;
	
	private int puerto;
	
	public TCPServidor(int puerto)
	{
		this.puerto = puerto;
		
		try 
		{
			System.out.println("servidor esperando que le lleguen peticiones...");
			ServerSocket SocketServidor = new ServerSocket(puerto);
			socketServidor = SocketServidor.accept();

			System.out.println("Comunicacion establecida");
		}
		catch (IOException e) 
		{
			System.out.println("Error en las comunicaciones");
			System.exit(0);
		} 
		catch (SecurityException e) 
		{
			System.out.println("Comunicacion no permitida por razones de seguridad");
			System.exit(0);
		}
	
	}
	
	public abstract void startServidor();

}
