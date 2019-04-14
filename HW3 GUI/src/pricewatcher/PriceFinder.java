/*Ricardo Godoy and Stephanie Callejas.*/
package pricewatcher;

import java.util.Random;

public class PriceFinder {

	public static double priceGenerator() {
		double rangeMin = 150.00;
		double rangeMax = 300.00;
		Random r = new Random();
		double price = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		return price;
	}
		

}
