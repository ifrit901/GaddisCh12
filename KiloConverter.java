package ch12java6thedition;
import java.awt.Color;
import javax.swing.*;	// Needed for Swing 
import java.awt.event.*;	// Needed for ActionListener Interface
/**
 * This is Code Listing 12-5 which demonstrates
 * adding objects to a JPanel which is placed in 
 * the content pane of a window.
 * 
 * @author craig
 */
public class KiloConverter extends JFrame {
	/*
	The KiloConverter class displays a JFrame that lets 
	the user enter a distance in kilometers. When the 
	Calculate button is clicked, a dialog box is displayed 
	with the distance converted to miles.
	*/	
	private JPanel panel;			// To reference a panel
	private JLabel messageLabel;		// To reference a label 
	private JTextField kiloTextField; 		// To reference a text field
	private JButton calcButton;		// To reference a button
	private final int WINDOW_WIDTH = 310;    // Window width
	private final int WINDOW_HEIGHT = 100;   // Window height

	/**
	 * Constructor
	 */
	public KiloConverter() {

		// Set the window title
		setTitle("Kilometer Converter");

		// Set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel and add it to the JFrame
		buildPanel();

		// Add the panel to the frame's content pane
		add(panel);

		// Display the window
		setVisible(true);
	}

	private void buildPanel() {

		// Create a label to display instructions
		messageLabel = new JLabel("Enter a distance in kilometers:");

		// Create a text field 10 characters wide
		kiloTextField = new JTextField(10);

		// Set the background color for the text field
		kiloTextField.setBackground(Color.GREEN);

		// Create a button with the text field "Calculate"
		calcButton = new JButton("Calculate");

		// Change color of the JButton
		calcButton.setBackground(Color.CYAN);

		// Change the color of the JButton text
		calcButton.setForeground(Color.PINK);

		// Add an action listener to the button
		calcButton.addActionListener(new CalcButtonListener());

		// Create a JPanel object and let the panel field
		// reference it
		panel = new JPanel();

		// Set the background color for the panel
		panel.setBackground(Color.ORANGE);

		// Add the label, text field, and button components 
		// to the panel
		panel.add(messageLabel);
		panel.add(kiloTextField);
		panel.add(calcButton);

	}

	/*
	CalcButtonListener is an action listener class for
	the Calculate button.
	*/
	private class CalcButtonListener implements ActionListener {
		
		/**
		 * The actionPerformed method executes when a 
		 * user clicks the Calculate button.
		 * @param e The event object.
		 */	
		public void actionPerformed(ActionEvent e) {

			final double CONVERSION = 0.6214;
			String input;	// To hold user input
			double miles;	// The number of miles

			// Get the text entered by the user
			// in the text field.
			input = kiloTextField.getText();

			// Convert the input to miles
			miles = Double.parseDouble(input) * CONVERSION;

			// Display the result
			JOptionPane.showMessageDialog(null, input + " kilometers = "
				+ miles + " miles.");
		}
	}

	/*
	Main method
	*/
	public static void main(String[]args) {
		new KiloConverter();
	}
}
