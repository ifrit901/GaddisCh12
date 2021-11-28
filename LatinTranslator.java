package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 8. Latin Translator
 * Look at the following list of Latin words and their meanings:
 * 
 * 	Latin			English
 * --------------------------------------------------------------------
 * 	sinister			left
 * 	dexter			right
 * 	medium			center
 * 
 * Write a GUI application that translates the Latin words to
 * English. The window should have three buttons, one for
 * each Latin word. When the user clicks a button, the 
 * program displays the English translation in a label.
 * 
 * @author craig
 */
public class LatinTranslator extends JFrame {
	
	// JFrame objects
	private JButton sinisterButton;
	private JButton dexterButton;
	private JButton mediumButton;

	private JLabel sinisterLabel;
	private JLabel dexterLabel;
	private JLabel mediumLabel;

	// Panels to hold components
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;

	// Size constants
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 175;


	/**
	 * Constructor.
	 */
	public LatinTranslator() {

		// Set location
		setLocation(500, 250);

		// Set Layout
		setLayout(new GridLayout(3, 2));

		// Set the title of the content pane
		setTitle("Latin Translator");

		// Specify the defaut close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Call the build panel
		buildPanel();


		// Dispaly the window
		setVisible(true);

	}

	public void buildPanel() {

		// Create the buttons and labels
		sinisterButton = new JButton("Sinister");
		dexterButton = new JButton("Dexter");
		mediumButton = new JButton("Medium");

		// Register the buttons with an action listener
		sinisterButton.addActionListener(new ButtonListener());
		dexterButton.addActionListener(new ButtonListener());
		mediumButton.addActionListener(new ButtonListener());

		sinisterLabel = new JLabel("Left");
		sinisterLabel.setBorder(BorderFactory.createEtchedBorder
			   	(Color.YELLOW, Color.LIGHT_GRAY));
		dexterLabel = new JLabel("Right");
		mediumLabel = new JLabel("Center");

		// Hide the labels
		sinisterLabel.setVisible(false);
		dexterLabel.setVisible(false);
		mediumLabel.setVisible(false);

		// Create the panels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();

		panel1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		// Add the components to the panel
		panel1.add(sinisterButton);
		panel2.add(sinisterLabel);
		panel3.add(dexterButton);
		panel4.add(dexterLabel);
		panel5.add(mediumButton);
		panel6.add(mediumLabel);

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);

	}

	/**
	 * Private inner class to handle button events.
	 */
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == sinisterButton) {
				sinisterLabel.setVisible(true);
				dexterLabel.setVisible(false);
				mediumLabel.setVisible(false);
			} else if (e.getSource() == dexterButton) {
				sinisterLabel.setVisible(false);
				dexterLabel.setVisible(true);
				mediumLabel.setVisible(false);
			} else if (e.getSource() == mediumButton) {
				sinisterLabel.setVisible(false);
				dexterLabel.setVisible(false);
				mediumLabel.setVisible(true);
			}


		}		

	}
	/**
	 * Main method.
	 */
	public static void main(String[]args) {

		new LatinTranslator();

	}
}
