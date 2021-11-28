package ch12java6thedition;
import javax.swing.*;
import java.awt.*;

/**
 * This is the ToppingPanel class which allows 
 * the user to select toppings for the bagel.
 * 
 * @author craig
 */
public class ToppingPanel extends JPanel {
	
	// The following constants are used to indicate
	// the cost of toppings.
	public final double CREAM_CHEESE = .50;
	public final double BUTTER = .25;
	public final double PEACH_JELLY = .75;
	public final double BLUEBERRY_JAM = .75;

	private JCheckBox creamCheese;	// To select cream cheese
	private JCheckBox butter;		// To select butter
	private JCheckBox peachJelly;		// To select peach jelly
	private JCheckBox blueberryJam;	// To select blueberry jam

	/**
	 * Constructor
	 */	
	public ToppingPanel() {

		// Create a GridLayout manager with four
		// rows and one column.
		setLayout(new GridLayout(4, 1));

		// Create the check boxes
		creamCheese = new JCheckBox("Cream Cheese");
		butter = new JCheckBox("Butter");
		peachJelly = new JCheckBox("Peach Jelly");
		blueberryJam = new JCheckBox("Blueberry Jam");

		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Toppings"));

		// Add the check boxes to the panel
		add(creamCheese);
		add(butter);
		add(peachJelly);
		add(blueberryJam);

	}

	/**
	 * getToppingCost method returns the price 
	 * of the topping.
	 * @return The cost of the selected toppings.
	 */
	public double getToppingCost() {

		double toppingCost = 0.0;

		if (creamCheese.isSelected()) {
			toppingCost += CREAM_CHEESE;
		}
		if (butter.isSelected()) {
			toppingCost += BUTTER;
		}
		if (peachJelly.isSelected()) {
			toppingCost += PEACH_JELLY;
		}
		if(blueberryJam.isSelected()) {
			toppingCost += BLUEBERRY_JAM;
		}

		return toppingCost;
	}
}
