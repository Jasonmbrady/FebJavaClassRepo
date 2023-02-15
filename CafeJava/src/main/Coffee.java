package main;

public class Coffee extends Drink implements Purchasable {
	private String roast;
	private Boolean hasCream;
	private Boolean hasSugar;
	
	public Coffee() {}

	public String getRoast() {
		return roast;
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
	};
	
}
