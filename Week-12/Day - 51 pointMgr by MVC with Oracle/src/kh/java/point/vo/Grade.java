package kh.java.point.vo;

public abstract class Grade {
	private int memberNo;
	private String memberName;
	private String grade;
	private String phone;
	private int point;
	
	public Grade() {
		super();
	}

	public Grade(int memberNo, String memberName, String grade, String phone, int point) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.grade = grade;
		this.phone = phone;
		this.point = point;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public abstract int getBonus();
	
	@Override
	public String toString() {
		return memberNo+"\t"+memberName+"\t"+phone+"\t"+point+"\t"+getBonus()+"\t"+grade; 
	}
	
	
}
