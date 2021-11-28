package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 2. Monthly Sales Tax
 * A retail company must file a monthly sales tax report listing 
 * the total sales for the month, and the amount of state and
 * county sales tax collected. The state sales tax rate is 4 
 * percent and the county sales tax rate is 2 percent. Create 
 * a GUI application that allows the user to enter the total sales
 * for the month into a text field. From this figure, the 
 * application should calculate and display the following:
 * 
 * - The amount of county sales tax
 * - The amount of state sales tax
 * - The total sales tax (county plus state)
 * 
 * In the application's code, represent the county tax rate (0.02) 
 * and the state tax rate (0.04) as named constants.
 * 
 * @author craig
 */
public class MonthlySalesTax extends JFrame {
	
	private final double COUNTY_SALES_TAX = 0.02;	// Constant county tax
	private final double STATE_SALES_TAX = 0.04; 	// Constant state tax
	private final int WINDOW_WIDTH = 350;		// Window width
	private final int WINDOW_HEIGHT = 100;		// Window height
	double sales;				// To hold double from String
	double stateTax;				// To hold calculated state tax
	double countyTax; 				// To hold calculated county tax
	double totalTax;				// To hold calculated total tax
	private JPanel panel;				// To reference panel object
	private JLabel label; 				// To reference label object
	private JTextField textField;			// To reference text field object
	private JButton calculateButton; 			// To reference button object

	/**
	 * Constructor
	 */
	public MonthlySalesTax() {

		// Set the title of the window
		setTitle("Monthly Sales Tax");

		// Set the dimensions of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify the action when user clicks close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel
		buildPanel();

		// Add the panel to the content pane
		add(panel);

		// Display the window
		setVisible(true);

	}

	/**
	 * The buildPanel method adds the proper components to the panel.
	 */
	private void buildPanel() {

		// Create the panel object
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// Create the label
		label = new JLabel("Enter the total monthly sales:");

		// Create the text field
		textField = new JTextField(10);

		// Create the button
		calculateButton = new JButton("Calculate Taxes");

		// Register the button with an action listener
		calculateButton.addActionListener(new ButtonListener());

		// Add the components to the panel
		panel.add(label);
		panel.add(textField);
		panel.add(calculateButton);

	}

	/**
	 * Private inner class to respond to button events.
	 */
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {

			String monthlySales; 		// To hold text entered by user

			// Convert String sales to double
			monthlySales = textField.getText();
			sales = Double.parseDouble(monthlySales);

			// Calculate state tax amount 
			stateTax = sales * STATE_SALES_TAX; 

			// Calculate county tax amount
			countyTax = sales * COUNTY_SALES_TAX;
			
			// Calculate total taxes 
			totalTax = stateTax + countyTax;

			// Display the results
			JOptionPane.showMessageDialog
			(null, (String.format("State Sales Tax: $%,.2f\n"
				+ "County Sales Tax: $%,.2f\n"
				+ "Total Sales Tax: $%,.2f", 
				stateTax, countyTax, totalTax)));
		}

	}
	
	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new MonthlySalesTax();

	}
}
