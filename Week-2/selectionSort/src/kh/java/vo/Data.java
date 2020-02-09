package kh.java.vo;

public class Data {
	
	private int data; // 멤버변수 data
	
	
	public Data() {} // 기본 생성자
	
	public Data(int data) { // 매개변수 생성자
		this.data = data;
	}
	
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data=data;
	}
	
	
	
}
