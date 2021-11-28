package ch12java6thedition;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 10. Celsius to Fahrenheit
 * Write a GUI application that allows that converts Celsius 
 * temperatures to Fahrenheit temperatures. The user should
 * be able to enter a Celsius temperature, click a button, and
 * then see the equivalent Fahrenheit temperature. Use the 
 * following formula to make the conversion:
 * 
 * 	F = 9/5C + 32;
 *	
 * F is the Fahrenheit temperature and C is the Celsius 
 * temperature. 
 * 
 * @author craig
 */
public class CelsiusToFahrenheit extends JFrame {
	
	private final int WINDOW_WIDTH = 375;
	private final int WINDOW_HEIGHT = 100;

	private String celsiusText;
	private double fahrenheit;
	private double celsius;
	
	private JPanel panel;
	private JLabel celsiusLabel;

	private JTextField celsiusTextField;
	private JButton calculateButton;

	/**
	 * Constructor.
	 */
	public CelsiusToFahrenheit() {

		setTitle("Celsius to Fahrenheit");

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocation(500, 250);

		celsiusLabel = new JLabel("Celsius");
		celsiusTextField = new JTextField(10);
		calculateButton = new JButton("Conversion to Fahrenheit");
		calculateButton.addActionListener(new ButtonListener());

		panel = new JPanel();
		panel.add(celsiusLabel);
		panel.add(celsiusTextField);
		panel.add(calculateButton);

		add(panel);
		
		setVisible(true);
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
				
			celsiusText = celsiusTextField.getText();
			celsius = Double.parseDouble(celsiusText);

			// Don't forget to eliminate integer division**
			fahrenheit = (9 / 5.0) * celsius + 32;
			
			JOptionPane.showMessageDialog(null, 
				String.format(celsius + " degrees "
					+ "celsius is %.1f "
					+ " degrees fahrenheit.", fahrenheit));
		}

	}
	public static void main(String[]args) {
		new CelsiusToFahrenheit();
	} 
}
