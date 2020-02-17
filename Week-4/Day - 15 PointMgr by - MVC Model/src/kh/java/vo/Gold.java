package kh.java.vo;

public class Gold extends Grade {

	public Gold() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gold(String name, String grade, int point) {
		super(name, grade, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBonus() {
		// TODO Auto-generated method stub
		return (int)(getPoint()*0.05);
	}
	
}
