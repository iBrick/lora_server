package main;

import socket.Socket_Server;

public class LoRaMain {

	public static void main(String[] args) {
		new Thread(new Socket_Server(1780)).start();
	}

}
