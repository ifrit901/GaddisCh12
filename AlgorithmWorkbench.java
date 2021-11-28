package ch12java6thedition;
import javax.swing.*;
import java.awt.*;

/**
 * This is the Algorithm Workbench section of the Ch. 12
 * review questions and exercises.
 * 
 * @author craig
 */
public class AlgorithmWorkbench extends JFrame {
	public static void main(String[]args) {

		/*
		1. The variable myWindow references a JFrame object. Write a statement 
		that sets the size of the object to 500 pixels wide and 250 pixels high.
		*/
		JFrame myWindow = new JFrame();
		myWindow.setSize(500, 250);

		/*
		2. The variable myWindow references a JFrame object. Write a statement
		that causes the application to end when the user clicks on the JFrame object's
		close button.
		*/
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		3. The variable myWindow references a JFrame object. Write a statement
		that displays the object's window on the screen.
		*/
		//myWindow.setVisible(true);

		/*
		4. The variable myButton references a JButton object. Write the code to set 
		the object's background color to white and foreground color to red. 
		*/
		JButton myButton = new JButton("My Button");
		myButton.setBackground(Color.WHITE);
		myButton.setForeground(Color.RED);
		// Add the components to the window

		/*
		5. Assume that a class inherits from the JFrame class. Write code that 
		can appear in the class constructor, which gives the content pane a 
		FlowLayout manager. Components added to the content pane should 
		be aligned with the left edge of each row.
		*/
		//myWindow.setLayout(new FlowLayout(FlowLayout.LEFT));


		// For display purposes, we will give the code in these questions
		// a BorderLayout manager so that we can add all the components
		// and see them in action
		myWindow.setLayout(new BorderLayout());

		myWindow.add(panelBorder(), BorderLayout.EAST);
		myWindow.add(buttonGroup(), BorderLayout.CENTER);
		// Add the component to the content pane, but you can't do that.
		// You can't add a window to a container
		myWindow.add(myButton, BorderLayout.SOUTH);

		myWindow.setVisible(true);
	}
		/*
		6. Assume that a class inherits from the JFrame class. Write code that 
		can appear in the class constructor, which gives the content pane a 
		GridLayout manager with five rows and ten columns. 
		*/
	private class newClass extends JFrame {
		public newClass() {
			setLayout(new GridLayout(5, 10));
		}
	}

	private static class newClass2 extends JFrame {

		/*
		7. Assume that the variable 'panel' references a JPanel object that uses
		a BorderLayout manager. In addition, the variable 'button' references 
		a JButton object. Write code that adds the button object to the 'panel' 
		object's west region.
		*/
		/*
		public newClass2() {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			JButton button = new JButton();
			panel.add(button, BorderLayout.WEST);

		}
		*/
	}	
		/*
		8. Write code that creates three radio buttons with the text "Option 1",
		"Option 2", "Option 3". The radio button that displays the text "Option 1"
		should be initially selected. Make sure these buttons are grouped so that
		a mutually exclusive relationship exists between them.
		*/
		public static JPanel buttonGroup() {
			JRadioButton option1 = new JRadioButton("Option 1", true);
			JRadioButton option2 = new JRadioButton("Option 2");
			JRadioButton option3 = new JRadioButton("Option 3");

			ButtonGroup bg = new ButtonGroup();
			bg.add(option1);
			bg.add(option2);
			bg.add(option3);
			JPanel panel = new JPanel();
			panel.add(option1);
			panel.add(option2);
			panel.add(option3);

			return panel;

		}

		/*
		9. Assume that panel references a JPanel object. Write code that creates a
		two pixel thick blue line border around it.
		*/
		public static JPanel panelBorder() {
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
			panel.setVisible(true);
			return panel;
		}


}
