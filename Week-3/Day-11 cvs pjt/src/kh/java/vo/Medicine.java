package kh.java.vo;

public class Medicine extends Items {
	
	String expired;
	
	public Medicine() {}
	
	public Medicine(String name, int stock, int price, boolean adult, String expired) {
		super(name, stock, price, adult);
		this.expired=expired;
	}
	
	public String getExpired() {
		return expired;
	}
	
	public void setExpired(String expired) {
		this.expired=expired;
	}
}
