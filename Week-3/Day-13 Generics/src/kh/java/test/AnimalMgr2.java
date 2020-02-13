package kh.java.test;

public class AnimalMgr2 <T extends Animal> {
	private T data;
	
	public AnimalMgr2() {}
	
	public AnimalMgr2(T data) {
		this.setData(data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
