/*Ricardo Godoy and Stephanie Callejas.*/
package pricewatcher;

import java.util.Scanner;

public class ConsoleUI {
	private Item item;
	Scanner sc = new Scanner(System.in);

	public ConsoleUI(Item item) {
		this.item = item;
	}

	public void showWelcome() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to PW!");
	}

	public void showItem() {
		// TODO Auto-generated method stub
		System.out.println("Here're item details...");
		System.out.println("Name: \t" + item.getName());
		System.out.println("URL: \t" + item.getURL());
		System.out.println("Price: \t" +  "$" + item.getPrice());
		System.out.printf("Change: %.2f ", item.changeInPrice());
		System.out.println("%");
		System.out.println("Added: \t" + item.getdateAdded() + " Price: " + "$" +   item.getPrice());
	}

	public int promptUser() {
		
		System.out.println("Enter 1 (to check price), 2 (to view page), 3 to view the item details again, or -1 to quit? ");
		int request = sc.nextInt();
		return request;
	}
	
	public void endProgram() {
		System.out.println("Thank you for using Price Watcher. Goodbye.");
		System.exit(0);
	}
	

}