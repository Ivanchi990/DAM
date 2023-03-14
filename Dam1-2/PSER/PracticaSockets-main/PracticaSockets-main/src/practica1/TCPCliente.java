package practica1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class TCPCliente {

	private Socket SocketCliente = null;
	private String ip;
	private int puerto;
	
	public TCPCliente(String ip, int puerto)
	{
		this.ip = ip;
		this.puerto = puerto;
	}
	
	public Socket socketCliente()
	{
		try 
		{
			SocketCliente = new Socket(ip, puerto);        
		} 
		catch (UnknownHostException e) 
		{
			System.out.println("Referencia a host no resuelta");
		}
		catch (IOException e) 
		{
			System.out.println("Error en las comunicaciones");
		}
		catch (SecurityException e) 
		{
			System.out.println("Comunicacion no permitida por razones de seguridad");
		}
		return SocketCliente;
	}
  
	public abstract void startCliente();

	
	
}
