package pricewatcher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

	public static void run() {
		Item item = new Item();
		ConsoleUI ui = new ConsoleUI(item);
		ui.showWelcome();
		ui.showItem();
		
		
		/*
		 * repeat until user ask for quit
		 *   print the item
		 *   prompt the user 
		 *   process the request
		 */
		int request = -1;
		do {
			request = ui.promptUser();
			switch (request) {
				case 1: 
					System.out.println("Price: $" + item.getPrice());
					System.out.println();
					break;
				case 2:
					try {
						Browser.getURL();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}// ...
					break;
				case -1:
					ui.endProgram();
					break;
				case 3: 
					ui.showItem();
					break;
				}
			
		} while (request != -1);			
	}
	

	public static void main(String[] args) {
		new Main().run();
	}

}
