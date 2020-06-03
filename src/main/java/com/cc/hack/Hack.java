package main.java.com.cc.hack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Hack {
	public static void main(String[] args) throws IOException {
			ServerSocket serverSocket = new ServerSocket(6379);
			Socket socket = serverSocket.accept();
			byte[] bytes = new byte[1024];
			
			socket.getInputStream().read(bytes);
			System.err.println(new String(bytes));
		
	}
}
