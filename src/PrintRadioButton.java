/**
 * Class for modeling a radio button for selecting a print order for a BST
 * @author Kerstin Andersson
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class PrintRadioButton extends JRadioButton {
	//First the properties
	private String _title;
    private HolderPrintOrder _holder;

    //Then the methods, starting with the constructor
    public PrintRadioButton(String title, HolderPrintOrder aHolder, boolean isSelected){
    	super(title, isSelected);
    	_title = title;
    	_holder = aHolder;
    	if (isSelected)
    		_holder.setPrintOrder(title);
    	this.addActionListener(new RadioListener());
    }
    
    private class RadioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			_holder.setPrintOrder(_title);
		}
    }

}
