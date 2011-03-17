/**
 * Class for modeling buttons for a BST application 
 * (the buttons require a BST-element input)
 * @author Kerstin Andersson
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class ElementButton extends JButton {
	//First the properties
	private String _title;
    private BST _bst;
    private JTextField _element;
    private JLabel _message;

    //Then the methods, starting with the constructor
    public ElementButton(String title, BST aBST, JTextField aElement, JLabel aMessage){
    	super(title);
    	_title = title;
    	_bst = aBST;
    	_element = aElement;
    	_message = aMessage;
    	this.addActionListener(new ElementListener());
    }

	private class ElementListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String element = _element.getText();
			if (!this.okInput(element)) 
				_message.setText("Wrong input data!");
			else {
				if (_title.equals("Add"))
					this.add(Integer.parseInt(element));
				else if (_title.equals("Search"))
					this.search(Integer.parseInt(element));
				else if (_title.equals("Remove"))
					this.remove(Integer.parseInt(element));
			}
			_element.setText("");
		}
		
		//Method for checking the correctness of input data
		public boolean okInput(String aString) {
			boolean ret = true;
			try {
				Integer.parseInt(aString);
			} catch (NumberFormatException e) {
				ret = false;
			}
			return ret;
		}
		
		//Method for adding an element
		public void add(int element) {
			if (_bst.search(element))
				_message.setText("Already in BST!");
			else {
				_message.setText("");
				_bst.insert(element);
			}
		}
		
		//Method for searching for an element
		public void search(int element) {
			if (_bst.search(element))
				_message.setText("The element is in BST.");
			else 
				_message.setText("The element is not in BST.");
		}	
		
		//Method for removing an element
		public void remove(int element) {
			if (_bst.search(element))
				_message.setText("Not implemented!");
			else {
				_message.setText("Not in BST!");
			}
		}
		
	}
}
