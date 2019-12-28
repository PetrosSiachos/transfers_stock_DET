package STOCKOVERFLOWPackage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
    	int l = 0;
    	do {
    	String  y = JOptionPane.showInputDialog(null, "Press: " + " 1 : to make an order " + " or "
    			+ " 2 : to control the apotheke");
    	if ( y.equals("1")) {
    		l = 1;
    		Object[] options = { "OK", "CANCEL" };
   		 JOptionPane.showOptionDialog(null, "Hello to our ERP ", " MESSAGE",
   		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
   		null, options, options[0]);
   		
   		Object [] possibleValues = { "PEN BLUE", "PEN RED", "PEN BLACK", "PEN GREEN", "PEN PINK", 
				"HIGHLIGHTER YELLOW", "HIGHLIGHTER PINK", "HIGHLIGHTER GREEN", "SHARPENER", 
				"RUBBER FOR PENCILS",  "RUBBER FOR PENS", 
				"RULER BLACK",  "RULER WHITE", "PENCIL", "MECHANICAL PENCIL"};
   		Object [] a1 = new Object[5];
   		Object [] a2 = new Object[5];
		/*ADD AND THE OTHERS PRODUCTS*/
   		JOptionPane.showMessageDialog(null, "Choose please from 1 until 5 products");
   		String X;
   		int i = 0;
		do {
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Choose one", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		a1[i] = selectedValue;
		i++;
		String inputValue = JOptionPane.showInputDialog("Please input a value");
		a1[i-1] = inputValue;
		do {
		 X = JOptionPane.showInputDialog(null,"Do you want an other product? Answer YES or NO");
		 
		 if ( (X.equals("YES") || X.equals("NO")) == false) {
			  JOptionPane.showMessageDialog(null,"Wrong answer");
		 }
		} while ((X.equals("YES") || X.equals("NO")) == false);
		
			 
		} while ( X.equals("YES"));
		
		String inputValue = JOptionPane.showInputDialog("Please input a value");
		
		Connection con = null;
		DB db = new DB();
		

		try {
			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt1 = con.prepareStatement("INSERT INTO CUSTOMERS (IDCUSTOMER " + 
					"NAMECUSTOMER" + 
					"PHONE " + 
					"ADDRESS " + 
					"YEARS_OF_COOPERATION" + 
					"PERCENT_OF_STOCK DECIMAL" + 
					"CREADITWORTHINESS ");
			
			PreparedStatement stmt2 = con.prepareStatement("INSERT INTO ORDERS (IDCUSTOMER " + 
					"NAMECUSTOMER" + 
					"PHONE " + 
					"ADDRESS " + 
					"YEARS_OF_COOPERATION" + 
					"PERCENT_OF_STOCK DECIMAL" + 
					"CREADITWORTHINESS ");

			// execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
			stmt1.executeUpdate();
			stmt2.executeUpdate();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			JOptionPane.showMessageDialog(null, "Insert Completed");
		}
	
    
    	} else if ( y.equals("2")) {
    		l = 1;
    		int k = 0;
    		
    		do {
    			String  x = JOptionPane.showInputDialog(null, "You have to log in. Write the password");
    		if ( x.equals("1234")) {
    			 k = 1;
    		} else {
    			Object[] options = { "OK", "CANCEL" };
   	   		 JOptionPane.showOptionDialog(null, "Alert ", "Wrong password ",
   	   		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
   	   		null, options, options[0]);
    		}
    		
    		} while (k == 0);
    		
    		/* connect to url*/
    		Desktop d = Desktop.getDesktop();
    		d.browse(new URI("http://ism.dmst.aueb.gr/ismgroup28/JAVA%20II/index.html"));	
    	} else {
    		l = 0;
    		JOptionPane.showMessageDialog(null, " You can only press 1 or 2. Please try again");
    		
    	}
    	
    } while  ( l == 0);
  }
}
    		
			
				
				
	    
    		
    	
    		  
