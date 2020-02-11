package kh.java.vo;

public class Eatable extends Items {
	int kcal;
	
	public Eatable() {}
	
	public Eatable(String name, int stock, int price, boolean adult, int kcal) {
		super(name,stock,price,adult);
		this.kcal=kcal;
	}
	
	public int getKcal() {
		return kcal;
		
	}
	
	public void getKcal(int kcal) {
		this.kcal=kcal;
	}
	

}
