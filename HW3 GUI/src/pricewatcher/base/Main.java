/*Ricardo Godoy and Stephanie Callejas.
 * Homework 2: 2-D Graphics.
 * Second iteration of the Price Watcher application using a simple GUI using Java 2D graphics.
 * Date: 3/6/19
 */

package pricewatcher.base;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pricewatcher.Browser;
import java.awt.Graphics;
import pricewatcher.Item;
import pricewatcher.PriceFinder;

/**
* A dialog for tracking the price of an item.
*
* @author Yoonsik Cheon
*/
@SuppressWarnings("serial")
public class Main extends JFrame {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_SIZE = new Dimension(400, 300);
      
    /** Special panel to display the watched item. */
    private ItemView itemView;
      
    /** Message bar to display various messages. */
    private JLabel msgBar = new JLabel(" ");
    
    private Item item;

    /** Create a new dialog. */
    public Main() {
    	this(DEFAULT_SIZE);
    }
    
    /** Create a new dialog of the given screen dimension. */
    public Main(Dimension dim) {
        super("Price Watcher");
        setSize(dim);
        item = new Item();
        
        configureUI();
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        //setResizable(false);
        showMessage("Welcome!");
    }
  
    /** Callback to be invoked when the refresh button is clicked. 
     * Find the current price of the watched item and display it 
     * along with a percentage price change. */
    private void refreshButtonClicked(ActionEvent event) {

		//--
    	//-- WRITE YOUR CODE HERE!
    	//--
    	
    	item.setPrice(PriceFinder.priceGenerator());
    	item.changePrice = item.changeInPrice();
    	/*This conditions plays the sound according to the change in price of the item when the Refresh button is pressed.*/
    	
    	if (item.currentPrice > item.initialPrice) {
    		play(getClass().getResource("/sound/"), "maybe-next-time-huh.wav");
    	}
    	else if(item.currentPrice < item.initialPrice) {
    		play(getClass().getResource("/sound/"), "woohoo.wav");
    	}
    	
    	double price = (item.currentPrice);
    	String priceAsString = String.format("%.2f", price);
    	showMessage("Current Price: $" + priceAsString);
    	itemView.repaint();
 	
    }
    /** 
     * Play the audio clip (wav) specified by a URL. This method has no effect 
     * if the audio clip cannot be found.
     */
    public void play(URL url) {
    	try {
            AudioInputStream in = AudioSystem.getAudioInputStream(url);
            //sun.audio.AudioPlayer.player.start(in);
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    /** 
     * Play the audio clip (wav) given the URL and a specifier relative to the URL.
     * This method has no effect if the audio clip cannot be found.
     */
    public void play(URL url, String name) {
    	try {
            play(new URL(url, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** Callback to be invoked when the view-page icon is clicked.
     * Launch a (default) web browser by supplying the URL of
     * the item. */
    private void viewPageClicked() {    	
    	//--
    	//-- WRITE YOUR CODE HERE!
    	//--
    	
    	
    	try {
			Browser.getURL();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	showMessage("View clicked!");
    }
        
    /** Configure UI. */
    private void configureUI() {
        setLayout(new BorderLayout());
        JPanel control = makeControlPanel();
        control.setBorder(BorderFactory.createEmptyBorder(10,16,0,16)); 
        add(control, BorderLayout.NORTH);
        JPanel board = new JPanel();
        board.setBorder(BorderFactory.createCompoundBorder(
        		BorderFactory.createEmptyBorder(10,16,0,16),
        		BorderFactory.createLineBorder(Color.GRAY)));
        board.setLayout(new GridLayout(1,1));
        itemView = new ItemView(item);
        itemView.setClickListener(this::viewPageClicked);
        board.add(itemView);
        add(board, BorderLayout.CENTER);
        msgBar.setBorder(BorderFactory.createEmptyBorder(10,16,10,0));
        add(msgBar, BorderLayout.SOUTH);
    }
      
    /** Create a control panel consisting of a refresh button. */
    private JPanel makeControlPanel() {
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    	JButton refreshButton = new JButton("Refresh");
    	refreshButton.setFocusPainted(false);
        refreshButton.addActionListener(this::refreshButtonClicked);
        panel.add(refreshButton);
        return panel;
    }

    /** Show briefly the given string in the message bar. */
    private void showMessage(String msg) {
        msgBar.setText(msg);
        new Thread(() -> {
        	try {
				Thread.sleep(3 * 1000); // 3 seconds
			} catch (InterruptedException e) {
			}
        	if (msg.equals(msgBar.getText())) {
        		SwingUtilities.invokeLater(() -> msgBar.setText(" "));
        	}
        }).start();
    }
    
    public static void main(String[] args) {
        new Main();
    }

}
