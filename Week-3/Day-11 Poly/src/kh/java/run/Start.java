package kh.java.run;

import kh.java.test.Animal;
import kh.java.test.Tiger;

public class Start {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.crying(); // Animal�� Ư��
		Tiger t = new Tiger();
		t.hunting(); // Tiger���� Ư��
		
		
		//upCasting ����
		Animal at = new Tiger(); // ���� Ŭ������ ���� Ŭ������ ����
		at.crying();
		// at.hunting(); Tiger ��ü�� ������ Animal Ÿ������ �����߱⿡ Animal�� ��ɸ� ��밡��
				
		//downCasting ����
		((Tiger)at).hunting(); //at(AnimalŸ��)�� Tiger Ÿ������ ����ȯ �� hunting��� ����
		
		
	}

}
