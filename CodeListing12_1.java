package ch12java6thedition;
import javax.swing.*;

/**
 * This is Code Listing 12-1. It demonstrates a 
 * simple window with a title bar that closes when 
 * the user clicks the close button.
 * 
 * @author craig
 */
public class CodeListing12_1 {
	public static void main(String[]args) {

		final int WINDOW_WIDTH = 350; 	// The window's width
		final int WINDOW_HEIGHT = 250; 	// The window's height

		// Create a window
		JFrame window = new JFrame();

		// Set the window's title
		window.setTitle("A simple window");

		// Set the size of the window
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the window
		window.setVisible(true);
	}	
}
