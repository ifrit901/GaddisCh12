package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * 6. Joe's Automotive
 * Joe's Automotive performs the following routine maintenance
 * services:
 * 
 * - Oil change ($26.00)
 * - Lube job ($18.00)
 * - Radiator flush ($30.00)
 * - Transmission flush ($80.00)
 * - Inspection ($15.00)
 * - Muffler replacement ($100.00)
 * - Tire rotation (20.00)
 * 
 * Joe also performs other non-routine services and charges for 
 * parts and labor ($20.00 per hour). Create a GUI application 
 * that displays the total for a customer's visit to Joe's.
 * @author craig
 */
public class JoesAutomotive extends JFrame {
	
	// Constants for different jobs
	private final double OIL_CHANGE = 26.00;
	private final double LUBE_JOB = 18.00;
	private final double RADIATOR_FLUSH = 30.00;
	private final double TRANSMISSION_FLUSH = 80.00;
	private final double INSPECTION = 15.00;
	private final double MUFFLER_REPLACEMENT = 100.00;
	private final double TIRE_ROTATION = 20.00;

	// Window dimensions
	private final int WINDOW_WIDTH = 245;
	private final int WINDOW_HEIGHT = 300;

	// Check boxes
	private JCheckBox oilChangeCheckBox;
	private JCheckBox lubeJobCheckBox;
	private JCheckBox radiatorFlushCheckBox;
	private JCheckBox transmissionFlushCheckBox;
	private JCheckBox inspectionCheckBox;
	private JCheckBox mufflerReplacementCheckBox;
	private JCheckBox tireRotationCheckBox;

	// Button
	private JButton calculateButton;

	// Panel
	private JPanel panel;

	// Total price
	private double totalPrice = 0.0;


	/**
	 * Constructor.
	 */
	public JoesAutomotive() {

		// Set the title for the window
		setTitle("Joe's Automotive");

		// Set the dimensions for the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Set screen location
		setLocation(500, 250);

		// Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel
		buildPanel();

		// Add the panel
		add(panel);

		// Display the window
		setVisible(true);
	}

	/**
	 * The buildPanel creates the components and 
	 * adds them to the panel.
	 */
	public void buildPanel() {

		// Create the check boxes
		oilChangeCheckBox = new JCheckBox("Oil Change - $26");
		lubeJobCheckBox = new JCheckBox("Lube Job - $18");
		radiatorFlushCheckBox = new JCheckBox("Radiator Flush - $30");
		transmissionFlushCheckBox = new JCheckBox("Transmission Flush - $80");
		inspectionCheckBox = new JCheckBox("Inspection - $15");
		mufflerReplacementCheckBox = new JCheckBox("Muffler Replacement - $100");
		tireRotationCheckBox = new JCheckBox("Tire Rotation - $20");

		// Add ItemListeners to the check boxes
		oilChangeCheckBox.addItemListener(new CheckBoxListener());
		lubeJobCheckBox.addItemListener(new CheckBoxListener());
		radiatorFlushCheckBox.addItemListener(new CheckBoxListener());
		transmissionFlushCheckBox.addItemListener(new CheckBoxListener());
		inspectionCheckBox.addItemListener(new CheckBoxListener());
		mufflerReplacementCheckBox.addItemListener(new CheckBoxListener());
		tireRotationCheckBox.addItemListener(new CheckBoxListener());

		// Create the panel
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// Create the button
		calculateButton = new JButton("Total Price");

		// Register the button with an ItemListener
		calculateButton.addActionListener(new ButtonListener());

		// Add the components to the panel
		panel.add(oilChangeCheckBox);
		panel.add(lubeJobCheckBox);
		panel.add(radiatorFlushCheckBox);
		panel.add(transmissionFlushCheckBox);
		panel.add(inspectionCheckBox);
		panel.add(mufflerReplacementCheckBox);
		panel.add(tireRotationCheckBox);
		panel.add(calculateButton);
	}

	/**
	 * Private inner class to handle the button events.
	 */
	private class CheckBoxListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			// Determine which check box was selected
			if (e.getSource() == oilChangeCheckBox) {
				if (oilChangeCheckBox.isSelected()) {
					totalPrice += OIL_CHANGE;
				} else {
					totalPrice -= OIL_CHANGE;
				}
			} else if (e.getSource() == lubeJobCheckBox) {
				if (lubeJobCheckBox.isSelected()) {
					totalPrice += LUBE_JOB;
				} else {
					totalPrice -= LUBE_JOB;
				}
			} else if (e.getSource() == radiatorFlushCheckBox) {
				if (radiatorFlushCheckBox.isSelected()) {
					totalPrice += RADIATOR_FLUSH;
				} else {
					totalPrice -= RADIATOR_FLUSH;
				}
			} else if (e.getSource() == transmissionFlushCheckBox) {
				if (transmissionFlushCheckBox.isSelected()) {
					totalPrice += TRANSMISSION_FLUSH;
				} else {
					totalPrice -= TRANSMISSION_FLUSH;
				}
			} else if (e.getSource() == inspectionCheckBox) {
				if (inspectionCheckBox.isSelected()) {
					totalPrice += INSPECTION;
				} else {
					totalPrice -= INSPECTION;
				}
			} else if (e.getSource() == mufflerReplacementCheckBox) {
				if (mufflerReplacementCheckBox.isSelected()) {
					totalPrice += MUFFLER_REPLACEMENT;
				} else {
					totalPrice -= MUFFLER_REPLACEMENT;
				}
			} else if (e.getSource() == tireRotationCheckBox) {
				if (tireRotationCheckBox.isSelected()) {
					totalPrice += TIRE_ROTATION;
				} else {
					totalPrice -= TIRE_ROTATION;
				}
			} 


		}

	}

	/**
	 * Private class to handle the button events.
	 */
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(null, 
				String.format("Total Price for Services: $%,.2f",
					totalPrice));

		}
		
	}
	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new JoesAutomotive();

	}

}
