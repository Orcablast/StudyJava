package kh.java.run;

import kh.java.server.Server;

public class Start {

	public static void main(String[] args) {
		
		try {
			new Server().main();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
