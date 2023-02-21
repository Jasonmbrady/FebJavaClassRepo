package main;

public class Coffee extends Drink implements Purchasable {
	private static Integer numSold;
	private String roast;
	private Boolean hasCream = false;
	private Boolean hasSugar = false;
	
	public Coffee() {}
	
	public Coffee(String roast) {
		this.roast = roast;
	}

	@Override
	public void purchase() {
		System.out.println("That will be " + this.getPrice());
		
	}
	
	public String getRoast() {
		return roast;
	}
	
	public String getRoast(String roastName) {
		return roastName + " is a " + roast + "roast blend";
	}

	public void setRoast(String roast) {
		this.roast = roast;
	}

	public Boolean getHasCream() {
		return hasCream;
	}

	public void setHasCream(Boolean hasCream) {
		this.hasCream = hasCream;
	}

	public Boolean getHasSugar() {
		return hasSugar;
	}

	public void setHasSugar(Boolean hasSugar) {
		this.hasSugar = hasSugar;
	}

	public static Integer getNumSold() {
		return numSold;
	}

	public static void setNumSold(Integer numSold) {
		Coffee.numSold = numSold;
	};
	
}
