package kh.java.vo;

public class Drink extends Eatable {
	private int amount;
	
	public Drink() {}
	
	public Drink(String name, int stock, int price, boolean adult, int amount, int kcal) {
		super(name, stock, price, adult, kcal);
		this.amount=amount;
	}
	
	public int getAmount () {
		return amount;
	}
		
	public void setAmount(int amount) {
		this.amount=amount;
	}
	
	
}
