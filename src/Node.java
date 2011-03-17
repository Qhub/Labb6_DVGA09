/**
 * Class for a node in a binary search tree with integers
 * @author Kerstin Andersson
 *
 */

public class Node {
	//First the properties
    private int _element;
    private Node _left;
    private Node _right;

    //Then the methods, starting with the constructor
    public Node(int element){
    	_element = element;
    }

    //An accessor method
    public int getElement(){
        return _element;
    }

    //A mutator method
    public void setElement(int element){
    	_element = element;
    }
    
    //An accessor method
    public Node getLeft(){
        return _left;
    }
    
    //A mutator method
    public void setLeft(Node aNode){
    	_left = aNode;
    }
    
    //An accessor method
    public Node getRight(){
        return _right;
    }
    
    //A mutator method
    public void setRight(Node aNode){
    	_right = aNode;
    }

}
