package kh.java.test;

public class Calc implements CalcFunc { // interface를 상속하는 명령어 implements
	
	@Override
	public int sum(int num1, int num2) {
		return num1+num2;	
	}
}
