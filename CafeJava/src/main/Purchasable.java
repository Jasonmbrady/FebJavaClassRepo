package main;

public interface Purchasable {
	
	public void purchase();
	public String getName();
	public Double getPrice();
	public default void sayHi() {
		System.out.println("Hi");
	}
}