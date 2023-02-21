package caranddriver;

//import java.io.Console;
import java.util.Scanner;

public class RacingGameTest {
	public static void main(String[] args) {
		Driver speedRacer = new Driver();
		while(speedRacer.isGameOver() == false) {
			// add gameplay
			// Tell the player their options
			System.out.println("Please choose whether to drive, boost or refuel:");
//			Console c = new Console();
			Scanner in = new Scanner(System.in);
			String action = in.nextLine();
			// take in input from the user, selecting which action to perform.
//			if (action != "drive" && action != "boost" && action != "refuel") {
//				System.out.println("Action not recognized.");
//				continue;
//			}
			
			switch(action.toLowerCase()) {
				case "drive":
					System.out.println(speedRacer.drive());
					break;
				case "boost":
					System.out.println(speedRacer.useBoosters());
					break;
				case "refuel":
					System.out.println(speedRacer.refuel());
					break;
				default:
					System.out.println("Action not recognized.");
			}
			// validate the input
			
			// run appropriate method
			// give feedback to player, who will then choose again.
		}
		System.out.println("You made it " + speedRacer.getMilesTraveled() + " miles!");
//		System.out.println(speedRacer.drive());
//		System.out.println(speedRacer.drive());
//		System.out.println(speedRacer.drive());
//		System.out.println(speedRacer.drive());
//		System.out.println(speedRacer.useBoosters());
//		System.out.println(speedRacer.useBoosters());
//		System.out.println(speedRacer.drive());
//		System.out.println(speedRacer.refuel());
//		System.out.println(speedRacer.refuel());
//		System.out.println(speedRacer.refuel());
//		System.out.println(speedRacer.refuel());
//		System.out.println(speedRacer.useBoosters());
//		System.out.println(speedRacer.useBoosters());
//		System.out.println(speedRacer.useBoosters());
//		System.out.println(speedRacer.useBoosters());
//		System.out.println(speedRacer.refuel());
//		System.out.println(speedRacer.useBoosters());
//		System.out.println(speedRacer.drive());
	}
}
