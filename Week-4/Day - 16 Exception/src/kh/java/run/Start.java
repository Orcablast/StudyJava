package kh.java.run;

import kh.java.test.TestClass;
import kh.java.test.ExceptionTest1;

public class Start {

	public static void main(String[] args) {
//		TestClass t01 = new TestClass();
//		t01.exam01();
		
		
		new TestClass().div(10, 0);
		
//		new ExceptionTest1();
	}

}
