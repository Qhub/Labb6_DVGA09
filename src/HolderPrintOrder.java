/**
 * Class for holding a string with print-order information
 * @author Kerstin Andersson
 *
 */

public class HolderPrintOrder {
	//First the properties
    private String _printOrder;
    
    //Then the methods, starting with the constructor
    public HolderPrintOrder(){
    	_printOrder = "";
    }

    //A mutator method 
    public void setPrintOrder(String aString){
    	_printOrder = aString;
    }

    //An accessor method
    public String getPrintOrder(){
        return _printOrder;
    }

}