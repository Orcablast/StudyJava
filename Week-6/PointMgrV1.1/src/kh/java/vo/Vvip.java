package kh.java.vo;

public class Vvip extends Grade {
	
	public Vvip() {
		super();
	}

	public Vvip(String name, String grade, int point) {
		super(name, grade, point);
	}

	@Override
	public int getBonus() {
		return (int)(getPoint()*0.1);
	}
}
