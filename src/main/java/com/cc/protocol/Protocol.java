package main.java.com.cc.protocol;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
	public static final String DOLLAR_BYTE = "$";
	public static final String ASTERISK_BYTE = "*";
	public static final String BLACK_STRING = "\r\n";	
	/**
	 * 组装数据
	 */
	public static void sendCommand(OutputStream outputStream,Command command,byte[] ... args) {
		StringBuffer sb = new StringBuffer();	
		sb.append(ASTERISK_BYTE).append(args.length + 1).append(BLACK_STRING);
		sb.append(DOLLAR_BYTE).append(command.name().length()).append(BLACK_STRING);
		sb.append(command.name()).append(BLACK_STRING);
		
		for (final byte[] arg : args) {
			sb.append(DOLLAR_BYTE).append(arg.length).append(BLACK_STRING);
			sb.append(new String(arg)).append(BLACK_STRING);
		}
		try {
			outputStream.write(sb.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static enum Command {
		GET,SET,KEYS
	}
}
