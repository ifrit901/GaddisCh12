package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 4. Travel Expenses
 * Create a GUI application that calculates and displays the total
 * travel expenses of a business person on a trip. Here is the 
 * information that the user must provide.
 * 
 * - Number of days on the trip
 * - Amount of airfare
 * - Amount of car rental fees, if any
 * - Number of miles driven, if a private vehicle was used
 * - Amount of parking fees, if any
 * - Amount of taxi fees, if any
 * - Conference or seminar registration fees, if any 
 * - Lodging charges, per night
 * 
 * The company reimburses travel expenses according to the following policy:
 * 
 * - $37 per day for meals
 * - Parking fees, up to $10 per day
 * - Taxi charges, up to $20 per day
 * - Lodging charges up to $95 per day 
 * - If a private vehicle is used, $0.27 per mile driven
 * 
 * The application should calculate and display the following:
 * 
 * - Total expenses incurred by the business person
 * - The total allowable expenses for the trip
 * - The excess that must be paid by the business person, if any
 * - The amount saved by the business person if the expenses are under the total allowed
 * 
 * @author craig
 * 8/12/21
 * 12:16pm
 * at home
 */
public class TravelExpenses extends JFrame {
	
	// User entered variables
	private int daysOnTrip;
	private int milesDriven;
	private double airfareFees;
	private double carRentalFees;
	private double parkingFees;
	private double taxiFees;
	private double conferenceFees;
	private double lodgingFees;

	// Labels for user entered text fields
	private JLabel daysOnTripLabel;
	private JLabel milesDrivenLabel;
	private JLabel airfareFeesLabel;
	private JLabel carRentalFeesLabel;
	private JLabel parkingFeesLabel;
	private JLabel taxiFeesLabel;
	private JLabel conferenceFeesLabel;
	private JLabel lodgingFeesLabel;
		
	// Text fields for user entry
	private JTextField daysOnTripTextField;
	private JTextField milesDrivenTextField;
	private JTextField airfareFeesTextField;
	private JTextField carRentalFeesTextField;
	private JTextField parkingFeesTextField;
	private JTextField taxiFeesTextField;
	private JTextField conferenceFeesTextField;
	private JTextField lodgingFeesTextField;

	// Calculation button
	private JButton calculateButton;

	// Panel for displaying GUI
	private JPanel panel;

	// Company reimbursement constants
	private final double MEALS = 37.00; 		// per day
	private final double PARKING = 10.00;		// per day
	private final double TAXIS = 20.00;		// per day
	private final double LODGING = 95.00;		// per day
	private final double PRIVATE_MILES = .27; 		// per mile

	// Window size constants
	private final int WINDOW_WIDTH = 275;
	private final int WINDOW_HEIGHT = 290;

	// Calculations for display
	private double totalExpenses;		// Total trip expenses
	private double totalAllowableExpenses;	// Total company will pay for
	private double excessToBePaid; 	// Amount business person must pay
	private double amountSaved;		// Amount business person saved


	/**
	 * Constructor.
	 */
	public TravelExpenses() {

		/*
		I will make the window tall and skinny so the fields 
		should make one long column using a FlowLayout.
		*/

		// Set title of window
		setTitle("Travel Expenses");

		// Set dimensions of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Set location
		setLocation(500, 250);
		
		// Specify action for close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel
		buildPanel();

		// Add the panel to the content pane
		add(panel);

		// Display the window
		setVisible(true);

	}

	/**
	 * The buildPanel method builds the panel and
	 * adds the components to it.
	 */
	public void buildPanel() {

		// Create the panel and right justify the components
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		// Create the labels
		daysOnTripLabel = new JLabel("Days on Trip:");
		milesDrivenLabel = new JLabel("Miles Driven:");
		airfareFeesLabel = new JLabel("Airfare Fees:");
		carRentalFeesLabel = new JLabel("Car Rental Fees:");
		parkingFeesLabel = new JLabel("Parking Fees:");
		taxiFeesLabel = new JLabel("Taxi Fees:");
		conferenceFeesLabel = new JLabel("Conference Fees:");
		lodgingFeesLabel = new JLabel("Lodging Fees:");

		// Create the text fields
		daysOnTripTextField = new JTextField(10);
		milesDrivenTextField = new JTextField(10);
		airfareFeesTextField = new JTextField(10);
		carRentalFeesTextField = new JTextField(10);
		parkingFeesTextField = new JTextField(10);
		taxiFeesTextField = new JTextField(10);
		conferenceFeesTextField = new JTextField(10);
		lodgingFeesTextField = new JTextField(10);

		// Create the calculate button
		calculateButton = new JButton("Calculate Expenses");

		// Register the calculate button with an action listener
		calculateButton.addActionListener(new ButtonListener());

		// Add the components to the panel
		panel.add(daysOnTripLabel);
		panel.add(daysOnTripTextField);
		panel.add(milesDrivenLabel);
		panel.add(milesDrivenTextField);
		panel.add(airfareFeesLabel);
		panel.add(airfareFeesTextField);
		panel.add(carRentalFeesLabel);
		panel.add(carRentalFeesTextField);
		panel.add(parkingFeesLabel);
		panel.add(parkingFeesTextField);
		panel.add(taxiFeesLabel);
		panel.add(taxiFeesTextField);
		panel.add(conferenceFeesLabel);
		panel.add(conferenceFeesTextField);
		panel.add(lodgingFeesLabel);
		panel.add(lodgingFeesTextField);
		panel.add(calculateButton);

	}

	/**
	 * Private inner class to handle events created by the calculateButton.
	 */
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Variables for text fields
			String       daysOnTripString,
				milesDrivenString,
				airfareString,
				carRentalString,
				parkingFeesString,
				taxiFeesString,
				conferenceFeesString,
				lodgingFeesString;

			double      milesPaid, 
				parkingPaid,
				taxisPaid,
				mealsPaid,
				lodgingPaid,
				totalPaid,
				totalExcess,
				amountSaved;

			// Get user entered data and parse
			daysOnTripString = daysOnTripTextField.getText();
			daysOnTrip = Integer.parseInt(daysOnTripString);

			milesDrivenString = milesDrivenTextField.getText();
			milesDriven = Integer.parseInt(milesDrivenString);

			airfareString = airfareFeesTextField.getText();
			airfareFees = Double.parseDouble(airfareString);

			carRentalString = carRentalFeesTextField.getText();
			carRentalFees = Double.parseDouble(carRentalString);

			parkingFeesString = parkingFeesTextField.getText();
			parkingFees = Double.parseDouble(parkingFeesString);

			taxiFeesString = taxiFeesTextField.getText();
			taxiFees = Double.parseDouble(taxiFeesString);

			conferenceFeesString = conferenceFeesTextField.getText();
			conferenceFees = Double.parseDouble(conferenceFeesString);

			lodgingFeesString = lodgingFeesTextField.getText();
			lodgingFees = Double.parseDouble(lodgingFeesString);

			// Variables to display results
			totalExpenses = airfareFees + carRentalFees + parkingFees +
				         taxiFees + conferenceFees + lodgingFees;

			milesPaid = milesDriven * PRIVATE_MILES;  
			parkingPaid = daysOnTrip * PARKING;
			taxisPaid = daysOnTrip * TAXIS;
			lodgingPaid = daysOnTrip * LODGING;
			mealsPaid = daysOnTrip * MEALS;
			totalPaid = milesPaid + parkingPaid + taxisPaid + 
				lodgingPaid + mealsPaid;

			totalExcess = totalExpenses - totalPaid;

			if (totalExcess < 0) {
				amountSaved = totalExcess * -1;
				totalExcess = 0.0;
			}
			else {
				amountSaved = 0.0;
			}

			JOptionPane.showMessageDialog(null, 
				(String.format("Total expenses: $%,.2f\n"
					+ "Total allowable expenses: $%,.2f\n"
					+ "Excess to be paid by business person: $%,.2f\n"
					+ "Extra gained by business person: $%,.2f",
					totalExpenses, totalPaid, 
					totalExcess, amountSaved)));
		}


	}

	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new TravelExpenses();

	}

}
