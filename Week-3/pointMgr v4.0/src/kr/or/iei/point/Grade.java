package kr.or.iei.point;

public abstract class Grade { // 다형성 , 추상클래스 (추상메소드가 존재하면 반드시 추상클래스여야한다)

	private String name; // 문자열 멤버변수 name
	private String grade; // 문자열 멤버변수 grade
	private int point; // 정수 멤버변수 point
	
	public Grade() {} // 기본 생성자
	
	public Grade(String name, String grade, int point) { // 매개변수 생성자
		this.name=name; // 멤버변수 name에 매개변수 name값을 대입
		this.grade=grade; // 멤버변수 grade에 매개변수 grade값을 대입
		this.point=point; // 멤버변수 point에 매개변수 point값을 대입
	}
	
	
	// getter
	public String getName() { // String 타입 멤버변수 name을 반환하는 메소드
		return name; 
	}
	
	public String getGrade() { // String 타입 멤버변수 grade를 반환하는 메소드
		return grade;
	}
	
	public int getPoint() { // int 타입 멤버변수 point를 반환하는 메소드
		return point;
	}

	public abstract double getBonus(); // int 타입 멤버변수 point를 연산하여 double 타입 자료형을 반환하는 메소드
		
	
	
	
	// setter	
	public void setName(String name) { // 멤버변수 name에 매개변수 name값을 대입
		this.name = name;
	}
	
	public void setGrade(String grade) { // 멤버변수 grade에 매개변수 grade값을 대입
		this.grade = grade;
	}
	
	public void setPoint(int point) { // 멤버변수 point에 매개변수 point값을 대입
		this.point = point;
	}
	
}
