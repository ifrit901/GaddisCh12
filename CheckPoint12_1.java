package ch12java6thedition;

/**
 * This is Check Point 12.1 - 12.9.
 * 
 * @author craig
 */
public class CheckPoint12_1 {
	
	/**
	 * 1. What is a frame? How do you create a frame with Swing?
	 * 
	 * answer: A frame is a container that can be displayed as
	 * a window. In Swing, a frame object can be created from
	 * the JFrame class.
	 * 
	 * 2. How do you set a frame's size?
	 * 
	 * answer: You set a frame's size by passing width and height 
	 * arguments to the JFrame's setSize method.
	 * 
	 * 3. How do you display a frame on the screen?
	 * 
	 * answer: A frame can be displayed on the screen by setting 
	 * a JFrame's setVisible method to 'true'.
	 * 
	 * 4. What is a content pane?
	 * 
	 * answer: A Content Pane is a container that is part of every JFrame
	 * object. It is invisible and has no border, but any component that 
	 * is to be displayed in a JFrame must be added to its content pane.
	 * 
	 * 5. What is the difference between a frame and a panel?
	 * 
	 * answer: Frames and panels are both containers. A frame is a more
	 * basic container that holds all the other window's objects. A panel 
	 * is a more specific container that can hold components. A panel 
	 * is placed inside a frame, but not the other way around.
	 * 
	 * 6. What is an event listener?
	 * 
	 * answer: It is an object that responds to events.
	 * 
	 * 7. If you are writing an event listener class for a JButton component,
	 *     what interface must the class implement? What method must the
	 *     class have? When is this method executed?
	 * 
	 * answer: Event listener classes must implement the ActionListener interface.
	 * They must have an actionPerformed method. This method is executed
	 * when an event object is passed to it as an argument. 
	 * 
	 * 8. How do you register an event listener with a JButton component?
	 * 
	 * answer: By creating an object of the event listener class and passing
	 * it as an object to the addActionListener method which can be called
	 * by a JButton component.
	 * 
	 * 9. How do you change the background color of a component? How 
	 *     do you change the color of text displayed by a label or button?
	 * 
	 * answer: The background color of a component can be changed
	 * by calling the setBackground method on a component and 
	 * passing it a Color.(color) argument. The text color of a label or 
	 * button can be changed by calling the setForeground method on 
	 * the object.
	 */
}
