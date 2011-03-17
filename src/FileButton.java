/**
 * Class for modeling buttons for a BST requiring a file-name input
 * @author Kerstin Andersson
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class FileButton extends JButton {
	//First the properties
	private String _title;
    private BST _bst;
    private JTextField _fileName;
    private JLabel _message;

    //Then the methods, starting with the constructor
    public FileButton(String title, BST aBST, JTextField aFileName, JLabel aMessage){
    	super(title);
    	_title = title;
    	_bst = aBST;
    	_fileName = aFileName;
    	_message = aMessage;
    	this.addActionListener(new FileListener());
    }
    
    private class FileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String fileName = _fileName.getText();
			if (!this.okInput(fileName)) 
				_message.setText("Wrong input data!");
			else {
				if (_title.equals("Save"))
					this.save(fileName);
				else if (_title.equals("Open"))
					this.open(fileName);
			}
			_fileName.setText("");
		}
		
		//Method for checking the correctness of input data
		public boolean okInput(String aString) {
			boolean ret = true;

			if (aString.equals(""))
				ret = false;	
			
			return ret;
		}
		
		//Method for saving a BST
		public void save(String fileName) {
			_message.setText("Not implemented!");
		}
		
		//Method for loading a BST
		public void open(String fileName) {
			_message.setText("Not implemented!");
		}
		
	}
}
