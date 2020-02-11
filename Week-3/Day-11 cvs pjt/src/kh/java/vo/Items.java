package kh.java.vo;

public class Items {
	// 가격, 재고, 상품이름, 성인 인증 필요 유무

	private String name;
	private int stock;
	private int price;
	private boolean adult;
	
	// 기본 생성자
	public Items() {}
		
	// 매개변수 생성자
	public Items(String name, int stock, int price, boolean adult) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.adult = adult;
	}
	
	// getter
	public String getName() {
		return name;
	}
	
	public int getStock() {
		return stock;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean getAdult() {
		return adult;
	}
		
	// setter
	public void setName(String name) {
		this.name=name;
	}
	
	public void setStock(int stock) {
		this.stock=stock;
		
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public void setAdult(boolean adult) {
		this.adult=adult;
	}	


}
