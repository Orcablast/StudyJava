package kh.java.run;

import kh.java.test.Animal;
import kh.java.test.Tiger;

public class Start {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.crying(); // Animal의 특성
		Tiger t = new Tiger();
		t.hunting(); // Tiger만의 특성
		
		
		//upCasting 개념
		Animal at = new Tiger(); // 하위 클래스를 상위 클래스로 선언
		at.crying();
		// at.hunting(); Tiger 객체는 맞지만 Animal 타입으로 선언했기에 Animal의 기능만 사용가능
				
		//downCasting 개념
		((Tiger)at).hunting(); //at(Animal타입)을 Tiger 타입으로 형변환 후 hunting기능 실행
		
		
	}

}
