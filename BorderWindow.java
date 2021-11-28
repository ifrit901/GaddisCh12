package ch12java6thedition;
import java.awt.*;		// Needed for the BorderLayout class
import javax.swing.*;	// Needed for the Swing classes

/**
 * This is Code Listing 12-10 which demonstrates 
 * a BorderLayout manager handling the arrangement
 * of components in a content pane.
 * 
 * @author craig
 */
public class BorderWindow extends JFrame {
	
	private final int WINDOW_WIDTH = 400;		// Window width
	private final int WINDOW_HEIGHT =300;		// Window height

	/**
	 * Constructor
	 */
	public BorderWindow() {

		// Set the window's title
		setTitle("Border Layout");

		// Set the window's dimensions
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add a BorderLayout manager to the content pane.
		// Add gaps horizontally and vertically so that the 
		// buttons don't touch each other.
		setLayout(new BorderLayout(5, 10));

		// Create five buttons 
		JButton button1 = new JButton("North Button");
		JButton button2 = new JButton("South Button");
		JButton button3 = new JButton("East Button");
		JButton button4 = new JButton("West Button");
		JButton button5 = new JButton("Center Button");

		// Add the five buttons to the content pane
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(button3, BorderLayout.EAST);
		add(button4, BorderLayout.WEST);
		add(button5, BorderLayout.CENTER);

		// Display the window
		setVisible(true);
	}

	/**
	 * Main method. This creates an instance of the 
	 * BorderWindow class causing it to display its window.
	 */
	public static void main(String[]args) {
		new BorderWindow();
	}
}
