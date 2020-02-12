package kh.java.run;

import kh.java.test.Test1;

public class Start {
	public static void main(String[] args) {

		Test1 t1 = new Test1();
		// Test1 클래스의 clone() 메소드의 리턴타입은 Object
		// 다형성은 부모타입 레퍼런스 자식타입 객체를 저장
		Test1 t2 = (Test1) t1.clone();

		// String값 비교시 사용했던 equals
		// heap 영역의 참조값을 비교할때 사용
		String str1 = new String("Hello");
		String str2 = new String("Hello");

		if (str1.equals(str2)) {
			
			System.out.println("같습니다.");
			
		} else {
			
			System.out.println("다릅니다.");
		}
	}
}
