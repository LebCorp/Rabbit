package fr.leben.rabbitapi;

import java.util.logging.Logger;

import fr.leben.rabbit.RabbitServer;

public class Rabbit {

	public static Server SERVER = new RabbitServer();
	
	public static Rabbit INSTANCE = new Rabbit();
	
	
	public static Server getServer() {
		return SERVER;
	}
	
	public static World createWorld(WorldCreator creator) {
		return getServer().createWorld(creator);
	}
	
	public static Logger getLogger() {
		return getServer().getLogger();
	}
	
	public static void start() {
		getServer().start();
	}
	
	public static void shutdown() {
		getServer().shutdown();
	}
	
	public static void main(String[] args) {
		Rabbit.start();
	}
} 
