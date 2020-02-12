package kr.or.iei.vo;

public class Student {
	private String name; // 멤버변수 문자열 변수 name
	private int age; // 멤버변수 정수형 변수 age
	private String addr; // 멤버변수 문자열 변수 addr
	
	public Student() {	// 기본생성자
	}
	
	public Student(String name, int age, String addr) { // 매개변수 생성자
		this.name = name; // 멤버변수 name로 매개변수 name의 값을 선언
		this.age = age; // 멤버변수 age로 매개변수 age의 값을 선언
		this.addr = addr; // 멤버변수 addr로 매개변수 addr의 값을 선언
	}
	
	
	//getter
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getAddr() {
		return addr;
	}
	
	
	//setter
	public void setName(String name) {
		this.name = name;		
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		String str = name+"\t"+age+"\t"+addr;
		return str;
	}
	

}
