package kh.java.vo;

public class Gold extends Grade {
	
	public Gold () {}
	
	public Gold(String grade, String name, int point) {
		super(grade,name,point);
	}
	
	@Override
	public int getBonus() {
		return (int)(getPoint()*0.05);
	}
	

}
