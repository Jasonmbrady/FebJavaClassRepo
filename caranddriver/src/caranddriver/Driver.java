package caranddriver;

public class Driver extends Car{
	
	public Driver() {};
	private Integer milesTraveled = 0;
	
	public Boolean isGameOver() {
		if (this.checkGas() <= 0) {
			return true;
		}
		return false;
	}
	public String drive() {
		this.setGas(1);
		this.milesTraveled += 10;
		if (this.isGameOver()) {
			return "You are out of gas. Game Over";
		}
		return "You drive the car.\nGas remaining: " + this.checkGas() + "/10" ;
	}
	
	public String useBoosters() {
		if (this.isGameOver()) {
			return "You are out of gas. Game Over";
		}
		if (this.checkGas() >= 3) {
			this.setGas(3);
			this.milesTraveled += 25;
			return "You use the boosters. \nGas remaining: " + this.checkGas() + "/10";
		}
		return "Not enough gas to boost!";
	}
	
	public String refuel() {
		if (this.isGameOver()) {
			return "You are out of gas. Game Over";
		}
		if (this.checkGas() <= 8) {
			this.setGas(-2);
			return "You refuel your car. \nGas remaining: " + this.checkGas() + "/10";			
		}
		return "Not enough room for more fuel!";
	}
	public Integer getMilesTraveled() {
		return milesTraveled;
	}
	public void setMilesTraveled(Integer milesTraveled) {
		this.milesTraveled = milesTraveled;
	}
	
}
