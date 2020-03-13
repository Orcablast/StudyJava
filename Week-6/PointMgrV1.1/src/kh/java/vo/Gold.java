package kh.java.vo;

public class Gold extends Grade{
	
	public Gold() {
		super();
	}

	public Gold(String name, String grade, int point) {
		super(name, grade, point);
	}

	@Override
	public int getBonus() {
		return (int)(getPoint() * 0.05);
	}
}
