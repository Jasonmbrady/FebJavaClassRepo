package main;

import java.util.ArrayList;

public class CafeJavaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coffee myCoffee = new Coffee();
		myCoffee.setName("Breakfast Blend");
		myCoffee.setNumberOfOunces(16);
		myCoffee.setPrice(2.99);
		myCoffee.setRoast("light");
		myCoffee.setHasCream(false);
		myCoffee.setHasSugar(false);
		myCoffee.purchase();
		Cookie snickerdoodle = new Cookie();
		snickerdoodle.setName("Snickerdoodle");
		snickerdoodle.setPrice(2.00);
		snickerdoodle.setIsFrosted(false);
		
		ArrayList<Purchasable> cart = new ArrayList<Purchasable>();
		
		cart.add(myCoffee);
		cart.add(snickerdoodle);
		for (Purchasable p : cart) {
			System.out.println(p.getName());
		}
		
		System.out.println(myCoffee.getName() + " is a " + myCoffee.getNumberOfOunces() + "oz " + myCoffee.getRoast() + " roast coffee " + (myCoffee.getHasCream() ? "with" : "without") + " cream and " + (myCoffee.getHasSugar() ? "with" : "without") + " sugar. It costs $" + myCoffee.getPrice());
	}

}
