package kh.java.point.vo;

public class Vip extends Grade {

	@Override
	public int getBonus() {
		return (int)(getPoint()*0.1);
	}

}
