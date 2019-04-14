/*Ricardo Godoy and Stephanie Callejas.*/
package pricewatcher;

import java.util.Random;

public class Item {
	public static String name = ("Sony SRS-XB41 Wireless Bluetooth Speaker");
	public String url = ("https://www.amazon.com/Sony-SRS-XB41-Portable-Bluetooth-SRSXB41/dp/B079V81NSG/ref=sr_1_acs_osp_osp18-1d0bb696_cov_4_2?s=electronics&ie=UTF8&qid=1549252925&sr=1-4-acs&keywords=bluetooth+speaker&tag=thewire06oa-20&ascsubtag=1d0bb696-435c-4008-a72b-1f50c7c75bc2&linkCode=oas&cv_ct_id=amzn1.osp.1d0bb696-435c-4008-a72b-1f50c7c75bc2&cv_ct_pg=search&cv_ct_wn=osp-search&creativeASIN=B079V81NSG");
	public double currentPrice;
	public double initialPrice = 198.00;
	public String dateAdded = ("11/10/2018");
	public double changePrice;
	
	
	/*Return the name of the item*/
	
	public String getName() {
		return name;
	}
	
	/*Sets the name of the item.
	 * 
	 * @param newName is a string with the name of the item
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/*Sets the current price of the item
	 * 
	 * @param currentPrice double value with the current price of the item computed randomly in the PriceFinder class
	 */
	public void setPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	/*Returns the current price of the item*/
	 
	public double getPrice() {
		return currentPrice;
	}
	
	/*Sets the initial price of the item
	 * 
	 * @param newInitialPrice is the initial price of the item
	 */
	public void setinitialPrice(double newinitialPrice) {
		this.initialPrice = newinitialPrice;
	}
	
	/*Returns the initial price of the item*/
	 
	public double getinitialPrice() {
		return initialPrice;
	}

	/*Sets the URL of the item*/
	
	public void setURL(String newURL) {
		this.url = newURL;
	}

	/*Returns the URL of the item*/
	 
	public String getURL() {
		return url;
	}
	
	/*Sets the date added of the item.
	 * 
	 * @param newDateAdded is a string with the date added of the item
	 */
	public void setdateAdded(String newDateAdded) {
		this.dateAdded = newDateAdded;
	}

	/*Returns the date added of the item*/
	public String getdateAdded() {
		return dateAdded;
	}
	
	/*Returns the change in price of the item*/
	public double getChangePrice() {
		return changePrice;
	}
	
	/*Sets the change in price of the item
	 * 
	 * @param changePriceNew a double value with the change in price of the item
	 */
	public void setChangePrice(double changePriceNew) {
		this.changePrice = changePriceNew;
	}

	/*Returns the change in price of the item*/
	public double changeInPrice() {
		changePrice = currentPrice - initialPrice;
		changePrice = (changePrice / initialPrice) * 100;
		//String increaseAsString = Double.toString(increase);
		return changePrice;

	}
}