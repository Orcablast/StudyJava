package kr.or.iei.point;

public class Vip extends Silver {
	// 생성자
	public Vip() {}
	
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getBonusP() {
		return getPoint()*0.07; // point로 직접 접근이 불가하여 getter 사용
	}

}
