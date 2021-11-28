package ch12java6thedition;
import javax.swing.*;

/**
 * This is the GreetingPanel class that creates 
 * a panel with a greeting in it.
 * 
 * @author craig
 */
public class GreetingPanel extends JPanel {
		
	private JLabel greeting;	// To display a greeting 

	/**
	 * Constructor
	 */
	public GreetingPanel() {

		// Create the lable
		greeting = new JLabel("Welcome to Brandi's Bagel House");

		// Add the lable to this panel 
		add(greeting);

	}

}
