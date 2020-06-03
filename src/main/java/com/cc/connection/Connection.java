package main.java.com.cc.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import main.java.com.cc.protocol.Protocol;
import main.java.com.cc.protocol.Protocol.Command;

/**
 * 传输层
 * 
 * @author Administrator
 *
 */
public class Connection {
	private Socket socket;
	private String host;
	private int port;
	private OutputStream outputStream;
	private InputStream inputStream;

	public Connection(String host, int port) {
		this.host = host;
		this.port = port;
	}

	// IO复用
	public Connection connection() {
		try {
			if (!isConnected()) {
				socket = new Socket(host, port);
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this;

	}

	/**
	 * 发送数据和命令
	 * 
	 * @param command
	 * @param args
	 * @return
	 */
	public Connection sendCommand(Protocol.Command command, byte[]... args) {
		// 连接
		connection();
		Protocol.sendCommand(outputStream, command, args);

		return this;
	}

	public String getStatusReply() {
		byte[] bytes = new byte[1024];
		try {
			socket.getInputStream().read(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new String(bytes);
	}

	public boolean isConnected() {
		return socket != null && socket.isBound() && !this.socket.isClosed() && this.socket.isConnected() && this.socket.isInputShutdown() && this.socket.isOutputShutdown();
	}
}
