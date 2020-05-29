package test.vo;

public class Student {
	private int grade;

	private String name;

	private int age;

	private String address;

	public Student() {

	super();

	}

	public Student(int grade, String name, int age, String address) {

	super();

	this.grade = grade;

	this.name = name;

	this.age = age;

	this.address = address;

	}

	public int getGrade() {

	return grade;

	}

	public void setGrade(int grade) {

	this.grade = grade;

	}

	public String getName() {

	return name;

	}

	public void setName(String name) {

	this.name = name;

	}

	public int getAge() {

	return age;

	}

	public void setAge(int age) {

	this.age = age;

	}

	public String getAddress() {

	return address;

	}

	public void setAddress(String address) {

	this.address = address;

	}
}
