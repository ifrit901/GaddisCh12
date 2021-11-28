package ch12java6thedition;

/**
 * This is the Find The Error portion of the Ch 12
 * review questions and exercises.
 * 
 * @author craig
 */
public class Ch12FindTheError {
	
	public static void main(String[]args) {
		/*
		1. The following statement is in a class that uses Swing components:

		import java.swing.*;

		answer: The java should have an 'x' on the end

		2. The following is an inner class that will have an action listener for 
		    a JButton component:

		private class ButtonListener implements ActionListener {

			public void actionPerformed(){

				// Code appears here
			
			}
		}

		answer: The actionPerformed method is missing the argument
		which should be an object of the ActionEvent class.

		3. The intention of the following statement is to give the panel 
		    object a GridLayout manager with 10 columns and 5 rows:

		panel.setLayout(new GridLayout(10, 5));

		answer: This statement will reverse the number of columns and 
		rows desired. It should read (new GridLayout(5, 10)).

		4. The panel variable references a JPanel governed by a BorderLayout
		    manager. The following statement attempts to add the button component
		    to the North region of the panel:

		panel.add(button, NORTH);

		answer: The second argument in the statement should include BorderLayout:

		panel.add(button, BorderLayout.NORTH);

		5. The panel variable references a JPanel object. The intention of the following
		    statement is to create a titled border around panel:

		panel.setBorder(new BorderFactory("Choices"));

		answer: The BorderFactory class has static members and does not need 
		the 'new' keyword to create an object of that class. The statement should
		read:

		panel.setBorder(BorderFactory.createTitledBorder("Choices"));
			




		*/
	}
}
