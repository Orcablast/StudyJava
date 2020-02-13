package kh.java.test;

public class Exam01<T> {
	
	private T data;

	public Exam01() {}
	
	public Exam01(T data) {
		this.data = data;
	}
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
