package kh.java.vo;

public class Silver extends Grade  {

	public Silver() {
		super();
	}

	public Silver(String name, String grade, int point) {
		super(name, grade, point);
	}

	@Override
	public int getBonus() {
		return (int)(getPoint() * 0.03);
	}

}
