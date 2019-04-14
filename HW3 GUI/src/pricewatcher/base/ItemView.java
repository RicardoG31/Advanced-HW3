/*Ricardo Godoy and Stephanie Callejas.*/
package pricewatcher.base;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import pricewatcher.Item;
import pricewatcher.ConsoleUI;
import pricewatcher.base.Main;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel {
	
	Item item;
    
	/** Interface to notify a click on the view page icon. */
	public interface ClickListener {
		
		/** Callback to be invoked when the view page icon is clicked. */
		void clicked();
	}
	
	/** Directory for image files: src/image in Eclipse. */
	private final static String IMAGE_DIR = "/image/";
        
	/** View-page clicking listener. */
    private ClickListener listener;
    
    /** Create a new instance. */
    public ItemView(Item item) {
    	this.item = item;
    	setPreferredSize(new Dimension(100, 160));
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
            		listener.clicked();
            	}
            }
        });
    }
        
    /** Set the view-page click listener. */
    public void setClickListener(ClickListener listener) {
    	this.listener = listener;
    }
    
    /** Overridden here to display the details of the item. */
    @Override
	public void paintComponent(Graphics g) {
    	//Item item = new Item();
        super.paintComponent(g); 
        //Dimension dim = getSize();
        
        
        //--
        //-- WRITE YOUR CODE HERE!
        //--
        int x = 20, y = 30;

        g.drawImage(getImage("google_chrome.png"), 20, 15, this);
        y += 20;
        g.drawString("Name: ", x, y);
        y += 20;
        g.drawString("URL: ", x, y);
        y += 20;
        g.drawString("Price: ", x, y);
        y += 20;
        g.drawString("Change: ", x, y);
        y += 20;
        g.drawString("Added: ", x, y);
        y -= 60;
        x += 60;
        g.drawString(item.getURL(), x, y);
        y += 20;
        g.setColor(Color.BLUE);
        String price = String.format("%.2f", item.currentPrice);
        g.drawString("$" + price, x, y);
        y += 20;
        g.setColor(Color.BLACK);
        
        /*This condition sets the color of the font depending on the change in price.*/
        if (item.currentPrice > item.initialPrice) {
        	g.setColor(Color.RED);
	        String priceChange = String.format("%.2f" , item.changePrice);
            g.drawString("%" + priceChange , x, y);
        }
        else if(item.currentPrice < item.initialPrice && item.changePrice != 0) {
        	g.setColor(Color.GREEN);
            String priceChange = String.format("%.2f" , item.changePrice);
            g.drawString("%" + priceChange , x, y);
        }
        
        String priceChange = String.format("%.2f" , item.changePrice);
        g.drawString("%" + priceChange , x, y);
        y += 20;
        g.setColor(Color.BLACK);
        g.drawString(item.getdateAdded(), x, y);
        x += 80;
        String initialPrice = String.format("%.2f", item.initialPrice);
        g.drawString("Initial Price: $" + initialPrice, x, y);
        y -= 80;
        Font font = new Font("Arial", Font.BOLD, 13);
        g.setFont(font);
        x -= 80;
        g.drawString(item.getName(), x, y);

    }
    
    /** Return true if the given screen coordinate is inside the viewPage icon. */
    private boolean isViewPageClicked(int x, int y) {
    	//--
    	//-- WRITE YOUR CODE HERE
    	//--
    	
    	
    	return new Rectangle(20, 20, 30, 20).contains(x,  y);
    }
        
    /** Return the image stored in the given file. */
    public Image getImage(String file) {
        try {
        	URL url = new URL(getClass().getResource(IMAGE_DIR), file);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
