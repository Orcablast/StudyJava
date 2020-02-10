package kr.or.iei.point;

public class Silver {
	private String name; // ������� ���ڿ� name
	private String grade; // ������� ���ڿ� grade
	private int point; // ������� ���� point
	private double bonusP;
	
	public Silver() {} // �⺻ ������
	
	public Silver(String name, String grade, int point) { // �Ű����� ������
		this.name=name;
		this.grade=grade;
		this.point=point;		
		this.bonusP=(point*0.02);
	}
	
	//getter �������
	public String getName() {
		return name;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public int getPoint() {
		return point;
	}
	
	public double getBonusP() {
		return bonusP;
	}
	
	
	//setter �������
	public void setName(String name) {
		this.name=name;		
	}
	
	public void setGrade(String grade) {
		this.grade=grade;
	}
	
	public void setPoint(int point) {
		this.point=point;
		this.bonusP=(point*0.02);
	}
	
}
