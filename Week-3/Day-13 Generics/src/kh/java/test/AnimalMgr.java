package kh.java.test;

public class AnimalMgr {
	private Object data;

	public AnimalMgr() {
	}

	public AnimalMgr(Object data) {
		this.setData(data);
	}
	

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
