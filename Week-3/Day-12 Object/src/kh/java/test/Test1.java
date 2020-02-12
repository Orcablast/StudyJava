package kh.java.test;

public class Test1 implements Cloneable{
	private int data;
	
	public Test1() {
		
	}
	
	public Test1(int data) {
		this.data=data;		
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data=data;
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}		
		return null;
	}
	

}
