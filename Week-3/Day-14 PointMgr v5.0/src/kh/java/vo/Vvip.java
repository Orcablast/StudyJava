package kh.java.vo;

public class Vvip extends Grade {
	
	public Vvip() {}
	
	public Vvip(String grade, String name, int point) {
		super(grade, name, point);
	}
	
	
	@Override
	public int getBonus() {
		return (int)(getPoint()*0.1);
	}
}
