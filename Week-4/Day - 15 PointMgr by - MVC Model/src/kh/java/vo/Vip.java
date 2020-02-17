package kh.java.vo;

public class Vip extends Grade {

	public Vip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vip(String name, String grade, int point) {
		super(name, grade, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBonus() {
		// TODO Auto-generated method stub
		return (int)(getPoint()*0.07);
	}
	
	
}
