package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 1. Retail Price Calculator
 * Create a GUI application where the user enters the wholesale cost 
 * of an item and its markup percentage into text fields. (For example,
 * if an item's wholesale cost is $5 and its markup percentage is 100%,
 * then its retail price is $10.) The application should have a button that
 * displays the item's retail price when clicked.
 * 
 * @author craig
 * 8/11/21
 * 1:54pm
 * at home
 */
public class RetailPriceCalculator extends JFrame {

	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 150;
	private JPanel panel;
	private JLabel costLabel;
	private JLabel markupLabel;
	private JTextField costField;
	private JTextField markupField;
	private JButton calculateButton;
	
	/**
	 * Constructor
	 */
	public RetailPriceCalculator() {

		// Set the title of the window
		setTitle("Retail Price Calculator");

		// Set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Set the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel
		buildPanel();

		// Add the panel to the content pane
		add(panel);

		// Display the panel
		setVisible(true);
		
	}

	/**
	 * The buildPanel method builds the panel to be added to
	 * the content pane.
	 */
	private void buildPanel() {

		
		// Create a cost label and markup label 
		costLabel = new JLabel("Wholesale cost:");
		markupLabel = new JLabel("Markup percentage:");

		// Create the text fields
		costField = new JTextField(10);
		markupField = new JTextField(10);

		// Create the button to calculate the retail price
		calculateButton = new JButton("Calculate Retail Price");

		// Register the button with an action listener
		calculateButton.addActionListener(new buttonListener());

		// Create a JPanel object and let the 'panel' field reference it
		panel = new JPanel();

		// Left-justify the components 
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		// Add the components to the panel
		panel.add(costLabel);
		panel.add(costField);
		panel.add(markupLabel);
		panel.add(markupField);
		panel.add(calculateButton);

	}

	/**
	 * Private class for event listeners
	 */
	private class buttonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Variables for text fields and calculations
			String costFieldText;
			String markupFieldText;
			double cost;
			double markup;

			// Get the input from text fields
			costFieldText = costField.getText();
			markupFieldText = markupField.getText();

			// Convert text to double 
			cost = Double.parseDouble(costFieldText);
			markup = cost * (Double.parseDouble(markupFieldText) * .01);

			cost += markup;

			JOptionPane.showMessageDialog(null, "The retail price "
				+ "of the item is $" + cost);
			
		} 

	} 


	/**
	 * Main method
	 */
	public static void main(String[]args) {

		new RetailPriceCalculator();

	}

}
