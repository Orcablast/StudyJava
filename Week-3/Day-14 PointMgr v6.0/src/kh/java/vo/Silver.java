package kh.java.vo;

public class Silver extends Grade {

	public Silver() {}
	
	public Silver(String grade, String name, int point) {
		super(grade, name, point);
	}
	
	
	@Override
	public int getBonus() {
		return (int)(getPoint()*0.03);
	}
	
}
