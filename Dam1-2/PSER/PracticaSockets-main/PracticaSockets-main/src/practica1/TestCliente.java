package practica1;

import java.io.IOException;

public class TestCliente {

	public static void main(String[] args) {

		try {
			new TCPFicheroCliente("localhost", 8023);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
