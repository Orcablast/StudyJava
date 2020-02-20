package kh.java.run;

import kh.java.client.Client;

public class Start {

	public static void main(String[] args) {
		
		try {
			new Client().main();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
