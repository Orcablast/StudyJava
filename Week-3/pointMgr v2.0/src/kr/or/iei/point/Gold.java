package kr.or.iei.point;

public class Gold extends Silver{
	// grade 변수, name 변수, point 변수
	// getter, setter 상속 완료
	
	public Gold() {
		super();
	}
	
	public Gold(String name, String grade, int point) {		
		super(name, grade, point); // 부모 생성자에 매개변수를 삽입, 반드시 생성자 첫줄에 위치		
		
	}
	
	@Override
	public double getBonusP() {
		return 0.05*getPoint(); // point로 직접 접근이 불가하여 getter 사용
	}
}
