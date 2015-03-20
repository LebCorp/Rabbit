package fr.leben.rabbitapi;

import fr.leben.rabbit.RabbitServer;
import fr.leben.rabbitapi.event.PlayerJoinEvent;

public class Rabbit {

	public static Server SERVER = new RabbitServer();
	
	public static Rabbit INSTANCE = new Rabbit();
	
	public static void main(String[] args) {
	}
	
	public void onCaca(PlayerJoinEvent e) {
		System.out.println("loule");
	}
} 
