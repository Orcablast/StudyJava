package kr.or.iei.point;

public class Silver extends Grade {
	
	public Silver() {
		super();
	} // 기본 생성자
	
	public Silver(String name, String grade, int point) { // 매개변수 생성자
		super(name,grade,point);
	}
	
	@Override
	public double getBonus() { // int 타입 멤버변수 point를 연산하여 double 타입 자료형을 반환하는 메소드
		return getPoint()*0.02;
	}
	
}
