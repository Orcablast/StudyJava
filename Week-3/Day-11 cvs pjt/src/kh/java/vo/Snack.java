package kh.java.vo;

public class Snack extends Eatable {
	
	int weight;
	
	public Snack() {}
	
	public Snack(String name, int stock, int price, boolean adult, int kcal, int weight) {
		super(name,stock,price,adult,kcal);
		this.weight=weight;
	}
		
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight=weight;
	}

}
