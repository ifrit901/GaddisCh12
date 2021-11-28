package ch12java6thedition;
import javax.swing.*;
import java.awt.*;

/**
 * This is the CoffeePanel class allows the user 
 * to select coffee.
 * 
 * @author craig
 */
public class CoffeePanel extends JPanel {
	
	// The following constants are used to indicate 
	// the cost of coffee.
	public final double NO_COFFEE = 0.0;
	public final double REGULAR_COFFEE = 1.25;
	public final double DECAF_COFFEE = 1.25;
	public final double CAPPUCINO = 2.0;

	private JRadioButton noCoffee;		// To select no coffee
	private JRadioButton regularCoffee;	// To select regular coffee
	private JRadioButton decafCoffee;	// To select decaf coffee
	private JRadioButton cappucino;		// To select cappucino
	private ButtonGroup bg;		// Radio button group

	/**
	 * Constructor
	 */
	public CoffeePanel() {

		// Create a GridLayout manager with
		// four rows and one column.
		setLayout(new GridLayout(4, 1));

		// Create the radio buttons
		noCoffee = new JRadioButton("None");
		regularCoffee = new JRadioButton("Regular Coffee", true);
		decafCoffee = new JRadioButton("Decaf Coffee");
		cappucino = new JRadioButton("Cappucino");

		// Group the radio buttons
		bg = new ButtonGroup();
		bg.add(noCoffee);
		bg.add(regularCoffee);
		bg.add(decafCoffee);
		bg.add(cappucino);

		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Coffee"));

		// Add the radio buttons to the panel
		add(noCoffee);
		add(regularCoffee);
		add(decafCoffee);
		add(cappucino);

	}

	/**
	 * getCoffeeCost method returns the price 
	 * of the coffee selected.
	 * @return The price of the coffee.
	 */
	public double getCoffeeCost() {

		double coffeeCost = 0.0;

		if (noCoffee.isSelected()) 
			coffeeCost += NO_COFFEE;
		else if (regularCoffee.isSelected())
			coffeeCost += REGULAR_COFFEE;
		else if (decafCoffee.isSelected()) 
			coffeeCost += DECAF_COFFEE;
		else if (cappucino.isSelected())
			coffeeCost += CAPPUCINO;

		return coffeeCost;

	}

}
