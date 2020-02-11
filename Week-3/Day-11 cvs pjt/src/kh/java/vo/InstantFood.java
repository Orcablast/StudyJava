package kh.java.vo;

public class InstantFood extends Eatable {
	
	private String expired;
	
	public InstantFood(){}
	
	public InstantFood(String name, int stock, int price, boolean adult, String expired, int kcal) {
		super(name,stock,price,adult,kcal);
		this.expired=expired;
	}
	
	public String getExpired() {
		return expired;
	}	
	
	public void setExpired(String expired) {
		this.expired=expired;
		
	}
	
}
