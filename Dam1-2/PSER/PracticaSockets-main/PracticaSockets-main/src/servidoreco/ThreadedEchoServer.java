package servidoreco;

/**
@version 1.10 1997-06-27
@author Cay Horstmann
*/

import java.io.*;
import java.net.*;

/**
 * This program implements a multithreaded server that listens to port 8189 and
 * echoes back all client input.
 */
public class ThreadedEchoServer {
	public static void main(String[] args) {
		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8189);
			System.out.println("Petición del Cliente " + i);
			while (true) {
				Socket incoming = s.accept();
				
				Thread t = new ThreadedEchoHandler(incoming, i);
				t.start();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * This class handles the client input for one server socket connection.
 */
class ThreadedEchoHandler extends Thread {
	private Socket incoming;
	private int counter;
	/**
	 * Constructs a handler.
	 * 
	 * @param i the incoming socket
	 * @param c the counter for the handlers (used in prompts)
	 */
	public ThreadedEchoHandler(Socket i, int c) {
		incoming = i;
		counter = c;
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
			PrintWriter out = new PrintWriter(incoming.getOutputStream(), true /* autoFlush */);

			out.println("Hello! Enter BYE to exit.");

			boolean done = false;
			while (!done) {
				String str = in.readLine();
				if (str == null)
					done = true;
				else {
					out.println("Echo (" + counter + "): " + str);

					if (str.trim().equals("BYE"))
						done = true;
				}
			}
			incoming.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
