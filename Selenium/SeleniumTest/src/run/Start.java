package run;

import java.io.IOException;

import himart.test.func.testFunc;

public class Start {

	public static void main(String[] args) {
		
		testFunc test = new testFunc();
		
//		test.getUserInfo();
		
		test.setUpLogin();
		
		test.main();
	}

}
