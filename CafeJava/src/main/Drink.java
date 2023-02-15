package main;

public abstract class Drink {
	private String name;
	private Integer numberOfOunces;
	private Double price;
	
	public Drink() {}

	public void purchase() {
		System.out.println("You have purchased a " + numberOfOunces + "oz " + name + ", which costs $" + price + ".");
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfOunces() {
		return numberOfOunces;
	}

	public void setNumberOfOunces(Integer numberOfOunces) {
		this.numberOfOunces = numberOfOunces;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	};
	
}
