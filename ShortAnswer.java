package ch12java6thedition;

/**
 * This is the Short Answer portion of the Chapter 12
 * review questions and exercises.
 * 
 * @author craig
 */
public class ShortAnswer {
	
	/*
	1. If you do not change the default close operation, what happens when 
	the user clicks on the close button on a JFrame object?

	answer: The JFrame object is hidden but is still running.

	2. Why is it sometimes necessary to place a component inside a panel
	and then place the panel inside a container governed by a BorderLayout
	manager?

	answer: To prevent the BorderLayout manager from resizing the component
	to fill up the region it is placed in if the window gets re-sized. Adding the 
	components to panels first also allows you to add more than one component
	to each region in a BorderLayout manager. 

	3. In what type of situation would you present a group of items to the user
	with radio buttons? With check boxes?

	answer: Radio buttons should be presented when the user should choose 
	only one item from a list of choices. Then the ButtonGroup the radio buttons
	are members of can ensure that if the user changes their mind, their previous
	choice is automatically de-selected.
	Check boxes should be used when the user is allowed to choose more than one
	item from a list of choices.

	4. How can you create a specialized panel component that can be used to hold
	other components and their related code?

	answer: By creating a separate class for the component. 
	*/
}
