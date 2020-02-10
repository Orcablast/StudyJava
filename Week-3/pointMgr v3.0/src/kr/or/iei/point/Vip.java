package kr.or.iei.point;

public class Vip extends Gold{
	
	public Vip() {
		super();
	}
	
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double getBonus() {
		return getPoint()*0.07;
	}

}
