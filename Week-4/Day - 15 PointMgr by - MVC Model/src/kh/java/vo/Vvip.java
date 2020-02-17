package kh.java.vo;

public class Vvip extends Grade {

	public Vvip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vvip(String name, String grade, int point) {
		super(name, grade, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBonus() {
		// TODO Auto-generated method stub
		return (int)(getPoint()*0.1);
	}
	
	
}
