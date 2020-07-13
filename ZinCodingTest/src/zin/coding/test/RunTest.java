package zin.coding.test;

import java.io.IOException;

public class RunTest {
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		try {
			controller.setUp();			
			controller.putFileToCd();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
