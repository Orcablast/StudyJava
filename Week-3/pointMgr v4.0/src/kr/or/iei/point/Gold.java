package kr.or.iei.point;

public class Gold extends Grade { // Silver를 상위클래스로 가지는 하위 클래스 Gold

	public Gold() { // 하위 클래스 Gold의 기본 생성자
		super();
	}
	
	public Gold(String name, String grade, int point) { // 하위 클래스 Gold의 매개변수 생성자
		super(name, grade, point); // Gold 클래스의 매개변수로 상위 클래스 매개변수 생성자 이용
	}
	
	@Override // 컴파일 주석 오버라이드
	public double getBonus() { // 상위 클래스의 getBonus 메소드를 오버라이드
		return getPoint()*0.05; // return값의 연산을 0.05로 오버라이드
	}
}
