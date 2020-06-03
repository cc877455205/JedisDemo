package main.java.com.cc.client;


import main.java.com.cc.connection.Connection;
import main.java.com.cc.protocol.Protocol;

/**
 * api²Ù×÷²ã
 * 
 * @author Administrator
 *
 */
public class Client {
	Connection connection;

	public Client(String host, int port) {
		this.connection = new Connection(host, port);
	}

	public String set(String key, String value) {
		// todo

		connection.sendCommand(Protocol.Command.SET, key.getBytes(), value.getBytes());

		return connection.getStatusReply();
	}

	public String get(String key) {
		connection.sendCommand(Protocol.Command.GET, key.getBytes());
		return connection.getStatusReply();
	}

}
