package main.java.com.cc;

import main.java.com.cc.client.Client;
import redis.clients.jedis.Jedis;

public class Test {
	
	public static void main(String[] args) {
		Client jedis = new Client("127.0.0.1",6379);
		System.out.println(jedis.set("czh", "666"));
		System.out.println(jedis.get("czh"));
	}
}
