package kh.java.vo;

public class Silver extends Grade {

	public Silver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Silver(String name, String grade, int point) {
		super(name, grade, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBonus() {
		// TODO Auto-generated method stub
		return (int)(getPoint()*0.03);
	}
	
	
	
	

}
