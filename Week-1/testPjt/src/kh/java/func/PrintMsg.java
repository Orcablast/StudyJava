package kh.java.func;

public class PrintMsg {
	public void printHello() {
		System.out.println("HELLO");
	}
	public void test() {
		System.out.println(1+1); // 정수 + 정수 = 정수 2
		System.out.println(1.1+1.1); //실수 + 실수 = 실수 2.2
		System.out.println('1'+'1'); // 문자 + 문자 = 정수 98 (ASCII code)
		System.out.println("1"+" 1"); // 문자열 + 문자열 = 문자열
	}
	public void test2() {
		System.out.println(1+1.1); // 정수 + 실수 = 실수 2.1
		System.out.println(1+'1'); // 정수 + 정수 = 정수
		System.out.println(1.1+'1'); // 실수 + 문자 = 실수
		System.out.println("HI"+1); // 문자열 + 정수 = 문자열 HI1
	}
}
