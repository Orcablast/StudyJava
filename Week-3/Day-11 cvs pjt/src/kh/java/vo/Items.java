package kh.java.vo;

public class Items {
	// ����, ���, ��ǰ�̸�, ���� ���� �ʿ� ����

	private String name;
	private int stock;
	private int price;
	private boolean adult;
	
	// �⺻ ������
	public Items() {}
		
	// �Ű����� ������
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
