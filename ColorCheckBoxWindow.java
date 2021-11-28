package ch12java6thedition;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * This is Code Listing 12-15 which demonstrates
 * how check boxes can be used.
 * 
 * @author craig
 */
public class ColorCheckBoxWindow extends JFrame {
	
	private JLabel messageLabel; 		// A message to the user
	private JCheckBox yellowCheckBox;	// To select a yellow background
	private JCheckBox redCheckBox;	// To select a red foreground
	private final int WINDOW_WIDTH = 300;	// The window's width
	private final int WINDOW_HEIGHT = 100;	// The window's height

	/**
	 * Constructor
	 */
	public ColorCheckBoxWindow() {
		
		// Set the title for the window
		setTitle("Color Check Boxes");

		// Set the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a lable
		messageLabel = new JLabel("Select the check boxes to "
			+ "change colors.");

		// Create the check boxes
		yellowCheckBox = new JCheckBox("Yellow background");
		redCheckBox = new JCheckBox("Red foreground");

		// Add an item listener to the check boxes
		yellowCheckBox.addItemListener(new CheckBoxListener());
		redCheckBox.addItemListener(new CheckBoxListener());

		// Add a FlowLayout manager to the content pane
		setLayout(new FlowLayout());

		// Add the label and checkBoxes to the content pane
		add(messageLabel);
		add(yellowCheckBox);
		add(redCheckBox);

		// Display the window
		setVisible(true);
	}

	/**
	 * Private inner class that handles the event when the 
	 * user clicks one of the check boxes
	 */
	private class CheckBoxListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			// Determine which check box was clicked
			if (e.getSource() == yellowCheckBox) {

				// Is the yellow check box selected? If so,
				// we want to set the background color to
				// yellow.
				if (yellowCheckBox.isSelected()) {

					// The yellow check box was selected. Set the 
					// background color for the contente pane and 
					// the two check boxes to yellow
					getContentPane().setBackground(Color.YELLOW);
					yellowCheckBox.setBackground(Color.YELLOW);
					redCheckBox.setBackground(Color.YELLOW);
				}
				else {

					// The yellow check box was de-selected. Set the
					// background color for the content pane and the
					// two check boxes to light gray.
					getContentPane().setBackground(Color.LIGHT_GRAY);
					yellowCheckBox.setBackground(Color.LIGHT_GRAY);
					redCheckBox.setBackground(Color.LIGHT_GRAY);
				}

			
			}
			else if (e.getSource() == redCheckBox) {

				if (redCheckBox.isSelected()) {

					// The red check box was selected. Set the 
					// background color for the content pane and
					// both check boxes to red.
					getContentPane().setBackground(Color.RED);
					yellowCheckBox.setBackground(Color.RED);
					redCheckBox.setBackground(Color.RED);
				}
				else {

					// The red check box was de-selected. Set the
					// background color for the content pane and 
					// the two check boxes to light gray.
					getContentPane().setBackground(Color.BLACK);
					yellowCheckBox.setForeground(Color.BLUE);
					yellowCheckBox.setBackground(Color.BLACK);
					redCheckBox.setBackground(Color.BLACK);
					redCheckBox.setForeground(Color.BLUE);
				}
			}

		}	

	}

	/**
	 * The main method creates an instance of the 
	 * ColorCheckBoxWindow class, displaying 
	 * its window.
	 */
	public static void main(String[]args) {

		new ColorCheckBoxWindow();
	}
}
