package STOCKOVERFLOWPackage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    	
    		int x;
			int y;
			do {
				
				Object[] options = { "OK", "CANCEL" };
	    		 y = JOptionPane.showOptionDialog(null, "Click ok ", "Hello to ERP ",
	    		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	    		null, options, options[0]);
	    		 if ( y == 1) {
	    			 break;
	    		 }
    		 x = JOptionPane.showConfirmDialog(null,
    		"Do you want to make an order", "new order", JOptionPane.YES_NO_OPTION);
    		} while ( x == 1 || y == 1 );

    		
    		/*/*Show a dialog asking the user to select a String:*/
    		/*Object[] possibleValues = { "First", "Second", "Third" };
    		String inputValue = JOptionPane.showInputDialog("Please input a value");
    		Object selectedValue = JOptionPane.showInputDialog(null,
    		"Choose one", "Input",
    		JOptionPane.INFORMATION_MESSAGE, null,
    		possibleValues, possibleValues[0]);*/
        
        
    }

}