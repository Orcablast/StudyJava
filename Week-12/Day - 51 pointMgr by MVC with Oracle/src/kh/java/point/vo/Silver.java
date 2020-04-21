package kh.java.point.vo;

public class Silver extends Grade {
		
	
	@Override
	public int getBonus() {
		return (int)(getPoint() * 0.03);
	}
	
	
}
