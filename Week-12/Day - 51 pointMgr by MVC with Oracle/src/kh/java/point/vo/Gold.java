package kh.java.point.vo;

public class Gold extends Grade{

	@Override
	public int getBonus() {
		return (int)(getPoint()*0.05);
	}

	
}
