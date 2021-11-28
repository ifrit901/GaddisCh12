package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 9. MPG Calculator
 * Write a GUI application that calculates a car's gas
 * mileage. The application should let the user enter
 * the number of gallons of gas the car holds, and 
 * the number of miles it can be driven on a full tank.
 * When a 'Calculate MPG' button is clicked, the 
 * application should display the number of miles that
 * the car may be driven per gallon of gas. Use the 
 * following formula to calculate MPG:
 * 
 * 	MPG = Miles / Gallons
 * 
 * @author craig
 */
public class MPGCalculator extends JFrame {
	
	private double miles;
	private double gallons;
	private double mpg;

	private JPanel panel;
	private JLabel gallonsHeldLabel;
	private JTextField gallonsHeldTextField;
	private JLabel milesOnFullTankLabel;
	private JTextField milesOnFullTankTextField;
	private JButton calculateMPGButton;

	private final int WINDOW_WIDTH = 450;
	private final int WINDOW_HEIGHT = 125;


	/**
	 * Constructor.
	 */
	public MPGCalculator() {

		// Set the window title
		setTitle("MPG Calculator");

		// Set the window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Set window location
		setLocation(500, 250);

		// Specify the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel
		buildPanel();

		// Add the panel to the content pane
		add(panel);
		
		// Display the window
		setVisible(true);

	}

	/**
	 * The buildPanel method creates the JFrame objects
	 * and adds them to the panel.
	 */
	public void buildPanel() {

		// Create the components
		gallonsHeldLabel = new JLabel("Enter the number of gallons:");
		gallonsHeldTextField = new JTextField(10);
		milesOnFullTankLabel = new JLabel("Miles that can be driven on a full tank:");
		milesOnFullTankTextField = new JTextField(10);

		calculateMPGButton = new JButton("Calculate MPG");

		// Register the button with an action listener
		calculateMPGButton.addActionListener(new ButtonListener());

		// Create the panel
		panel = new JPanel();
		
		panel.add(gallonsHeldLabel);
		panel.add(gallonsHeldTextField);
		panel.add(milesOnFullTankLabel);
		panel.add(milesOnFullTankTextField);
		panel.add(calculateMPGButton);
	}

	/**
	 * Private inner class to handle button events.
	 */
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String gallonsText = gallonsHeldTextField.getText();
			gallons = Double.parseDouble(gallonsText);

			String milesText = milesOnFullTankTextField.getText();
			miles = Double.parseDouble(milesText);

			mpg = miles / gallons;

			JOptionPane.showMessageDialog(null, "The MPG of this car is "
				+ String.format("%,.2f", mpg));

		}	
	}

	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new MPGCalculator();

	}
}
