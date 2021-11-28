package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;		// For action listener
/**
 * 5. Theater Revenue
 * A movie theater only keeps a percentage of the revenue
 * earned from ticket sales. The remainder goes to the movie
 * company. Create a GUI application that allows the user
 * to enter the following data into text fields. 
 * 
 * - Price per adult ticket
 * - Number of adult tickets sold
 * - Price per child ticket
 * - Number of child tickets sold
 * 
 * The application should calculate and display the following data
 * for one night's box office business at a theater:
 * 
 * - Gross revenue for adult tickets sold. (This is the amount of money
 * taken in for all adult tickets sold.) 
 * - Net revenue for adult tickets sold. (This is the amount of money from
 * adult ticket sales left over after the payment to the movie company
 * has been deducted.)
 * - Gross revenue for child tickets sold. (This is the amount of money
 * taken in for all child tickets sold.)
 * - Net revenue for child tickets sold. (This is the amount of money from
 * child ticket sales left over after the payment to the movie company
 * has been deducted.)
 * - Total gross revenue. (This is the sum of gross revenue for adult and
 * child tickets sold.) 
 * - Total net revenue. (This is the sum of net revenue for adult and 
 * child tickets sold.) 
 * 
 * Assume the theater keeps 20% of its box office receipts. Use a constant
 * in your code to represent this percentage.
 * 
 * @author craig
 */
public class TheaterRevenue extends JFrame {
	
	// Variables for user input
	private int childTicketsSold;
	private int adultTicketsSold;
	private double childTicketPrice;
	private double adultTicketPrice; 
	private double totalGross;
	private double totalNet;

	// Labels
	private JLabel childTicketLabel;
	private JLabel adultTicketLabel;
	private JLabel childPriceLabel;
	private JLabel adultPriceLabel;

	// Text fields
	private JTextField childTicketTextField;
	private JTextField adultTicketTextField;
	private JTextField childPriceTextField;
	private JTextField adultPriceTextField;

	// Calculate button
	private JButton calculateButton;

	// Panel to hold components
	private JPanel panel;

	// Window dimensions
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 200;

	// Constant for percentage theater keeps
	private final double THEATER_KEEPS = .2;

	/**
	 * Constructor
	 */
	public TheaterRevenue() {

		// Set the window's title
		setTitle("Theater Revenue");

		// Set the window's dimensions
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify the activity of the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build a panel to hold components
		buildPanel();

		// Add the panel to the content pane
		add(panel);

		// Set the window's location on the screen
		setLocation(500, 250);

		// Display the window
		setVisible(true);

	}

	/**
	 * The buildPanel method creates the components and 
	 * adds them to the panel.
	 */
	public void buildPanel() {

		// Create the lables
		childTicketLabel = new JLabel("Child tickets sold:");
		adultTicketLabel = new JLabel("Adult tickets sold:");
		childPriceLabel = new JLabel("Child ticket price: ");
		adultPriceLabel = new JLabel("Adult ticket price:");

		// Create the text fields
		childTicketTextField = new JTextField(10);
		adultTicketTextField = new JTextField(10);
		childPriceTextField = new JTextField(10);
		adultPriceTextField = new JTextField(10);

		// Create the button 
		calculateButton = new JButton("Calculate Revenue");

		// Register the button with an action listener
		calculateButton.addActionListener(new ButtonListener());

		// Create the panel (import awt needed for FlowLayout)
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		// Add the components to the panel
		panel.add(childTicketLabel);
		panel.add(childTicketTextField);
		panel.add(adultTicketLabel);
		panel.add(adultTicketTextField);
		panel.add(childPriceLabel);
		panel.add(childPriceTextField);
		panel.add(adultPriceLabel);
		panel.add(adultPriceTextField);
		panel.add(calculateButton);

	}

	/**
	 * Private class to handle events from the button.
	 */
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Variables
			String       childTicketText,
				adultTicketText,
				childPriceText,
				adultPrictText;

			int 	childTicketsSold,
				adultTicketsSold;

			double 	childTicketPrice,
				adultTicketPrice;

			double 	adultTicketGross,
				childTicketGross,
				adultTicketNet,
				childTicketNet;

			// Get user input and parse
			childTicketText = childTicketTextField.getText();
			childTicketsSold = Integer.parseInt(childTicketText);

			adultTicketText = adultTicketTextField.getText();
			adultTicketsSold = Integer.parseInt(adultTicketText);

			childTicketText = childPriceTextField.getText();
			childTicketPrice = Double.parseDouble(childTicketText);

			adultTicketText = adultPriceTextField.getText();
			adultTicketPrice = Double.parseDouble(adultTicketText);

			// Perform calculations
			adultTicketGross = adultTicketsSold * adultTicketPrice;
			childTicketGross = childTicketsSold * childTicketPrice;
			adultTicketNet = adultTicketGross * THEATER_KEEPS;
			childTicketNet = childTicketGross * THEATER_KEEPS;
			totalGross = adultTicketGross + childTicketGross;
			totalNet = adultTicketNet + childTicketNet;

			JOptionPane.showMessageDialog(null, 
				(String.format("Adult Ticket Gross Revenue: $%,.2f\n"
					+ "Child Ticket Gross Revenue: $%,.2f\n"
					+ "Adult Ticket Net Revenue: $%,.2f\n"
					+ "Child Ticket Net Revenue: $%,.2f\n"
					+ "Total Gross Revenue: $%,.2f\n"
					+ "Total Net Revenue: $%,.2f", 
					adultTicketGross, childTicketGross,
					adultTicketNet, childTicketNet,
					totalGross, totalNet)));

		}	

	} 

	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new TheaterRevenue();

	}

}
