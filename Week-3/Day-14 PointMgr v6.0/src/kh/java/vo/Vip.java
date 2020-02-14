package kh.java.vo;

public class Vip extends Grade{

	public Vip() {}
	
	public Vip(String grade, String name, int point) {
		super(grade,name,point);
		
		
	}
	
	
	@Override
	public int getBonus() {
		return (int)(getPoint()*0.07);				
	}
	
}
