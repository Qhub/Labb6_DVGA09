/**
 * Class for modeling buttons for a BST requiring no input
 * @author Kerstin Andersson
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class OtherButton extends JButton {
	//First the properties
	private String _title;
    private BST _bst;
    private JLabel _message;

    //Then the methods, starting with the constructor
    public OtherButton(String title, BST aBST, JLabel aMessage){
    	super(title);
    	_title = title;
    	_bst = aBST;
    	_message = aMessage;
    	this.addActionListener(new OtherListener());
    }
    
    private class OtherListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		if (_title.equals("Remove All"))
    			_bst.clear();
    			//_message.setText("Not implemented!");
    		else if (_title.equals("Is Empty")) {
    			if (_bst.isEmpty())
    				_message.setText("BST is empty.");
    			else
    				_message.setText("BST is not empty.");
    		}
    	}
	}
}
