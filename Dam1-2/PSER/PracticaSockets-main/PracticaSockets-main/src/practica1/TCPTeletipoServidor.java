package practica1;

import java.io.DataInputStream;
import java.io.IOException;

public class TCPTeletipoServidor extends TCPServidor {

	public TCPTeletipoServidor(int puerto) {

		super(puerto);
		startServidor();
	
	}

	@Override
	void startServidor() {
		String entrada = "";
		try {
			DataInputStream dis = new DataInputStream(conexion.getInputStream());
			entrada = dis.readUTF();
			while(entrada != null) {
				System.out.println(entrada);
				entrada = dis.readUTF();
				
			}
			conexion.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
