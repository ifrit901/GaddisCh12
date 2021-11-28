package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 7. Long Distance Calls
 * A long distance provider charges the following rates for 
 * telephone calls:
 *  
 *  Rate Category			Rate per minute
 * ---------------------------------------------------------------------------
 * Daytime (6 A.M through 5:59 P.M.)               $0.07
 * Evening (6 P.M. through 11:59 P.M.)	      $0.12
 * Off-Peak (12 A.M. through 5:59 A.M.)	      $0.05
 * 
 * Create a GUI application that allows the user to select a 
 * rate category (from a set of radio buttons), and enter 
 * the number of minutes of the call into a text field.
 * A dialog box should display the charge for the call. 
 * 
 * @author craig
 */
public class LongDistanceCalls extends JFrame {
	
	// Rate category constants
	private final double DAYTIME_RATE = 0.07;
	private final double EVENING_RATE = 0.12;
	private final double OFF_PEAK_RATE = 0.05; 

	// Variable for user entry of call minutes
	private int numberOfMinutes;

	// Window size constants
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 300;

	// Radio buttons
	private JRadioButton daytimeRate;
	private JRadioButton eveningRate;
	private JRadioButton offPeakRate;
	private ButtonGroup bg;

	// Label for textField
	private JLabel numberOfMinutesLabel;

	// Text field
	private JTextField numberOfMinutesTextField;

	// Calculate button
	private JButton calculateButton;

	private double totalCharges = 0.0;

	// Panel 
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	/**
	 * Constructor.
	 */
	public LongDistanceCalls() {

		// Set the window title
		setTitle("Long Distance Calls");

		// Set the window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify the close button action
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set window location
		setLocation(500, 250);


		setLayout(new BorderLayout());


		// Build the panel
		buildPanel();

		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
		
		pack();
		// Display the window
		setVisible(true);

	}

	/**
	 * The buildPanel method creates the JFrame components
	 * and adds them to the panel.
	 */
	public void buildPanel() {

		// Create the panel 
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		

		// Create the radio buttons
		daytimeRate = new JRadioButton("Daytime Rate");
		eveningRate = new JRadioButton("Evening Rate");
		offPeakRate = new JRadioButton("Off-peak Rate");

		// Create a button group for the radio buttons
		// and add them to the group
		bg = new ButtonGroup();
		bg.add(daytimeRate);
		bg.add(eveningRate);
		bg.add(offPeakRate);

		// Create the label and text field for 
		// number of minutes entered.
		numberOfMinutesLabel = new JLabel("Minutes on call:");
		numberOfMinutesTextField = new JTextField(10);

		// Create the calculate button
		calculateButton = new JButton("Calculate Charges");

		// Register the button with a Action Listener 
		calculateButton.addActionListener(new ButtonListener());

		// Add the components to the pane
		panel1.add(daytimeRate);
		panel1.add(eveningRate);
		panel1.add(offPeakRate);

		panel2.add(numberOfMinutesLabel);
		panel2.add(numberOfMinutesTextField);

		panel3.add(calculateButton);
		

	}

	/**
	 * Private class to handle button events.
	 */
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String minutes;
			int minuteConversion;

			minutes = numberOfMinutesTextField.getText();
			minuteConversion = Integer.parseInt(minutes);

			if (daytimeRate.isSelected()) {
				totalCharges = minuteConversion * DAYTIME_RATE;
			} else if (eveningRate.isSelected()) {
				totalCharges = minuteConversion * EVENING_RATE;
			} else if (offPeakRate.isSelected()) {
				totalCharges = minuteConversion * OFF_PEAK_RATE;
			}

			JOptionPane.showMessageDialog(null, "The total "
				+ "charges are: $" + 
				String.format("%,.2f", totalCharges));
			
		}		

	}

	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new LongDistanceCalls();

	}
}
