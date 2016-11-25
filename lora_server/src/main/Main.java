package main;

import net.Socket_Server;

public class Main {

	public static void main(String[] args) {
		new Thread(new Socket_Server(1780)).start();
	}

}
