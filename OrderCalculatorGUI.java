package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates the GUI window for 
 * the bagel/coffee classes and calculates the
 * price of the items selected.
 * (Brandi's Bagel House application)
 *
 * @author craig
 */
public class OrderCalculatorGUI extends JFrame {
	
	private BagelPanel bagels;		// Bagel panel
	private ToppingPanel toppings;		// Toppings panel
	private CoffeePanel coffee;		// Coffee panel
	private GreetingPanel banner;		// Greeting panel
	private JPanel buttonPanel;		// To hold the buttons
	private JButton calcButton;		// To calculate the cost
	private JButton exitButton;		// To exit the application
	private final double TAX_RATE = .06;	// Sales tax rate	

	/**
	 * Constructor
	 */		
	public OrderCalculatorGUI() {

		// Display a title
		setTitle("Order Calculator");

		// Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a border layout manager
		setLayout(new BorderLayout());

		// Create the custom panels
		banner = new GreetingPanel();
		coffee = new CoffeePanel();
		bagels = new BagelPanel();
		toppings = new ToppingPanel();

		// Create the button panel
		buildButtonPanel();

		// Add the components to the content pane
		add(banner, BorderLayout.NORTH);
		add(bagels, BorderLayout.WEST);
		add(toppings, BorderLayout.CENTER);
		add(coffee, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// Pack the contents of the window and display it
		pack();
		setVisible(true);
	
	}

	/**
	 * The buildButtonPanel method builds the button panel
	 */
	public void buildButtonPanel() {

		// Create a panel for the buttons
		buttonPanel = new JPanel();

		// Create the buttons
		calcButton= new JButton("Calculate");
		exitButton = new JButton("Exit");

		// Register the action listeners
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());

		// Add the buttons to the panel
		buttonPanel.add(calcButton);
		buttonPanel.add(exitButton);

	}

	/**
	 * Private inner class that handles the event when 
	 * the user clicks the calculate button.
	 */
	private class CalcButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Variables to hold the subtotal, tax, and total
			double subtotal, tax, total;

			// Calculate the subtotal
			subtotal = bagels.getBagelCost() +
				coffee.getCoffeeCost() + 
				toppings.getToppingCost();

			// Calculate the sales tax
			tax = subtotal * TAX_RATE;

			// Calculate the total
			total = subtotal + tax;

			// Display the charges
			JOptionPane.showMessageDialog(null, 
				String.format("Subtotal: $%,.2f\n"
					     + "Tax: $%,.2f\n"
					     + "Total: $%,.2f",
					      subtotal, tax, total));

		}

	}

	/**
	 * Private inner class that handles the event when 
	 * the user clicks the exit button.
	 */
	private class ExitButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.exit(0);

		}

	}

	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new OrderCalculatorGUI();

	}
}
