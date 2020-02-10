package kr.or.iei.point;

public class Silver {
	private String name; // 멤버변수 문자열 name
	private String grade; // 멤버변수 문자열 grade
	private int point; // 멤버변수 정수 point
	
	public Silver() {} // 기본 생성자
	
	public Silver(String name, String grade, int point) { // 매개변수 생성자
		this.name=name;
		this.grade=grade;
		this.point=point;	
	}
	
	//getter 멤버변수
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
		return point*0.02;
	}
	
	
	//setter 멤버변수
	public void setName(String name) {
		this.name=name;		
	}
	
	public void setGrade(String grade) {
		this.grade=grade;
	}
	
	public void setPoint(int point) {
		this.point=point;
	}
	
}
