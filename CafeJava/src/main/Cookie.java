package main;

public class Cookie implements Purchasable{
	
	private String name;
    private Boolean isFrosted;
    private Double price;

    public Cookie(){};
    public Cookie(String name, Boolean isFrosted, Double price){
        this.name = name;
        this.isFrosted = isFrosted;
        this.price = price;
    }
    
    public void purchase() {
    	System.out.println("You purchased a " + name + " cookie for $" + price);
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsFrosted() {
		return isFrosted;
	}
	public void setIsFrosted(Boolean isFrosted) {
		this.isFrosted = isFrosted;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
    
}
