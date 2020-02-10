package kr.or.iei.point;

public class Silver {
	
	private String name;
	private String grade;
	private int point;
	
	public Silver() {} // �⺻ ������
	
	public Silver(String name, String grade, int point) { // �Ű����� ������
		this.name=name;
		this.grade=grade;
		this.point=point;
	}
	
	
	// getter
	public String getName() {
		return name;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public int getPoint() {
		return point;
	}
	
	public double getBonus() {
		return point*0.02;
	}
	
	// setter	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
}
