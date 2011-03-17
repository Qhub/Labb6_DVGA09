/**
 * Class for modeling the layout for a binary search tree application
 * @author Kerstin Andersson
 *
 */

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
	//First the properties
	private final int NUM_PANEL = 3;
    private BST _bst;
    private HolderPrintOrder _holder;
    private ElementButton _add, _search, _remove;
    private OtherButton _removeAll, _isEmpty;
    private FileButton _save, _open;
    private PrintButton _print;
    private PrintRadioButton _pre, _in, _post;
    private JLabel _result;
    private JLabel _element;
    private JLabel _fileName;
    private JTextField _elementText;
    private JTextField _fileNameText;
    private JPanel _resultP, _controlP, _otherP;
    private JPanel [] _elementP, _printP, _fileP;

    //Then the methods, starting with the constructor
    public ControlPanel(){
    	//This panel consists of two equally large panels, one with
        //results and messages and the other with control buttons
    	super(new GridLayout(2,1));
    	_bst = new BST();                 //create the binary search tree  
    	_holder = new HolderPrintOrder(); //create a holder for the print order
    	//Create the result panel
    	this.makeResultPanel();
    	this.add(_resultP);
    	//Create the control panel with 2 x 2 panels
    	_controlP = new JPanel(new GridLayout(2,2));
    	this.makeElementPanel();
    	this.makePrintPanel();
    	this.makeOtherPanel();
    	this.makeFilePanel();
    	this.add(_controlP);
    }

    //Method for creating the result panel
    public void makeResultPanel(){
    	//Make label
    	_result = new JLabel("Welcome!");
    	_result.setFont(new Font("Default", Font.BOLD, 20));
    	//Make panel
    	FlowLayout f = new FlowLayout();
    	f.setVgap(40);
    	_resultP = new JPanel(f);
    	_resultP.setBackground(Color.CYAN);
    	_resultP.add(_result);
    }

    //Method for creating the panel with buttons for adding, searching for, 
    //and removing elements
    public void makeElementPanel(){
    	//Initialize panels
    	_elementP = new JPanel[NUM_PANEL];
    	for (int i = 0; i < NUM_PANEL; i++) {
    		_elementP[i] = new JPanel();
        	_elementP[i].setBackground(Color.GREEN);
    	}
    	//Make label and text field and add to a panel
    	_element = new JLabel("Element:");
    	_element.setFont(new Font("Default", Font.BOLD, 12));
    	_elementText = new JTextField("", 15);
    	_elementP[0].add(_element);
    	_elementP[0].add(_elementText);
    	//Make three buttons and add to a panel
    	_add = new ElementButton("Add", _bst, _elementText, _result);
    	_search = new ElementButton("Search", _bst, _elementText, _result);
    	_remove = new ElementButton("Remove", _bst, _elementText, _result);
    	_elementP[1].add(_add);
    	_elementP[1].add(_search);
    	_elementP[1].add(_remove);
    	//Add the two panels above to the third panel
    	_elementP[2].add(_elementP[0]);
    	_elementP[2].add(_elementP[1]);
    	//Add the third panel to the control panel
    	_controlP.add(_elementP[2]);
    }

    //Method for creating a panel with button for printing
    public void makePrintPanel(){
    	//Initialize panels
    	_printP = new JPanel[NUM_PANEL];
    	for (int i = 0; i < NUM_PANEL; i++) {
    		_printP[i] = new JPanel();
        	_printP[i].setBackground(Color.BLUE);
    	}
    	//Make three radio buttons and add to a panel
    	_pre  = new PrintRadioButton("PreOrder", _holder, false);
    	_in   = new PrintRadioButton("InOrder", _holder, true);
    	_post = new PrintRadioButton("PostOrder", _holder, false);
    	ButtonGroup group = new ButtonGroup(); //group them together
    	group.add(_pre);                       //to make them mutually
    	group.add(_in);                        //exclusive
    	group.add(_post);
    	_printP[0].add(_pre);
    	_printP[0].add(_in);
    	_printP[0].add(_post);
    	//Make a button an add to a panel
    	_print = new PrintButton("Print", _bst, _holder, _result);
    	_printP[1].add(_print);
    	//Add the two panels above to the third panel
    	_printP[2].add(_printP[0]);
    	_printP[2].add(_printP[1]);
    	//Add the third panel to the control panel
    	_controlP.add(_printP[2]);
    }

    //Method for creating a panel for buttons for removing all elements
    //and checking whether the tree is empty or not
    public void makeOtherPanel(){
    	//Initialize panel
    	FlowLayout f = new FlowLayout();
    	f.setVgap(30);
    	_otherP = new JPanel(f);
    	_otherP.setBackground(Color.RED);
    	//Make two buttons and add to panel
    	_removeAll = new OtherButton("Remove All", _bst, _result);
    	_isEmpty = new OtherButton("Is Empty", _bst, _result);
    	_otherP.add(_removeAll);
    	_otherP.add(_isEmpty);
    	//Add panel to the control panel
    	_controlP.add(_otherP);
    }
    
    //Method for creating a panel with buttons for saving and reading 
    //a tree to/from a file
    public void makeFilePanel(){
    	//Initialize panels
    	_fileP = new JPanel[NUM_PANEL];
    	for (int i = 0; i < NUM_PANEL; i++) {
    		_fileP[i] = new JPanel();
        	_fileP[i].setBackground(Color.YELLOW);
    	}
    	//Make label and text field and add to a panel
    	_fileName = new JLabel("File Name:");
    	_fileName.setFont(new Font("Default", Font.BOLD, 12));
    	_fileNameText = new JTextField("", 15);
    	_fileP[0].add(_fileName);
    	_fileP[0].add(_fileNameText);
    	//Make three buttons and add to a panel
    	_save = new FileButton("Save", _bst, _fileNameText, _result);
    	_open = new FileButton("Open", _bst, _fileNameText, _result);
    	_fileP[1].add(_save);
    	_fileP[1].add(_open);
    	//Add the two panels above to the third panel
    	_fileP[2].add(_fileP[0]);
    	_fileP[2].add(_fileP[1]);
    	//Add the third panel to the control panel
    	_controlP.add(_fileP[2]);
    }

}
