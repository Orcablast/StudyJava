package kr.or.iei.point;

public class Vip extends Grade{ // Gold 클래스를 상위클래스로 가지는 하위클래스 Vip
	
	public Vip() { // 하위클래스 Vip의 기본생성자
		super();
	}
	
	public Vip(String name, String grade, int point) { // Vip의 매개변수 생성자
		super(name, grade, point); // 상위클래스의 매개변수 생성자에 현재 매개변수를 대입
	}
	
	@Override // 컴파일 주석 오버라이드
	public double getBonus() { // 상위 클래스의 getBonus 메소드를 오버라이드
		return getPoint()*0.07; // getBonus의 연산값을 0.07로 조정
	}

}
