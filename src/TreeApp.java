/**
 * Class for managing a binary search tree
 * @author Kerstin Andersson
 *
 */

import javax.swing.*;

public class TreeApp extends JFrame {
    private ControlPanel _controlPanel;

    public TreeApp(String title){
    	super(title);
    	this.setSize(600,350);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	_controlPanel = new ControlPanel();
    	this.add(_controlPanel);
    	this.setVisible(true);
    }

    public static void main(String[] args){
    	new TreeApp("Binary search tree");
    }

}