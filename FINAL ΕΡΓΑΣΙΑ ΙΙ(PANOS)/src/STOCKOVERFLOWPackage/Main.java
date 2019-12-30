package STOCKOVERFLOWPackage;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	/*System.out.println(Order.getOrders().size());
    	System.out.println(Order.getGoodOrders().size());
    	System.out.println(Order.getBlackList().size());
    	System.out.println(Stock.getStocks().size());
    	System.out.println(Customer.getCustomers());*/
    	
    	
    	
    	
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
   		JOptionPane.showMessageDialog(null, "Choose please from 1 until 5 products");
   		int id = Customer.getCustomers().size()+2;
   		String name = JOptionPane.showInputDialog("Please input your name");
   		String phone = JOptionPane.showInputDialog("Please input your phone");
   		String address = JOptionPane.showInputDialog("Please input your address");
   		int years = Integer.parseInt(JOptionPane.showInputDialog("Please input the years of cooperation with us"));
   		Float perc =Float.parseFloat(JOptionPane.showInputDialog("Please input if you have percent of stock in our firm"));
   		int creadit;
   		if (years > 1) {
   			 creadit = 1;
   		}	else {
   			 creadit = 0;
   		}
   		/*add the others products*/
   		Object [] possibleValues = { "PEN BLUE", "PEN RED", "PEN BLACK", "PEN GREEN", "PEN PINK", 
				"HIGHLIGHTER YELLOW", "HIGHLIGHTER PINK", "HIGHLIGHTER GREEN", "SHARPENER", 
				"RUBBER FOR PENCILS",  "RUBBER FOR PENS", 
				"RULER BLACK",  "RULER WHITE", "PENCIL", "MECHANICAL PENCIL"};
   		
		
		Connection con = null;
		DB db = new DB();
		

		try {
			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt1 = con.prepareStatement("INSERT INTO CUSTOMERS VALUES ('" + id + "', '"+ name +"', '"+ phone +"', '"+ address +"', '"+ years +"', '"+ perc + "', '"+ creadit +"')") ; 
		
			stmt1.executeUpdate();
			System.out.println("success");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {
			JOptionPane.showMessageDialog(null, "Insert Completed");
		}
		String [] nameprod = {"", "", "","", "", ""};
		Integer [] x = {0, 0, 0, 0, 0};
		Float [] o = {(float)9.4, (float)0.3, (float)0.46, (float) 0.92, (float)0.98};
		Integer [] n = {0, 0, 0, 0, 0};
		int i = 0;
		String X;
		do {
			nameprod[i] = (String) JOptionPane.showInputDialog(null,
					"Choose one", "Input",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			for (int a = 0; a < Stock.getStocks().size(); a++) {
				if (Stock.getStocks().get(a).name.equals(nameprod)) {
					 x[i] = Stock.getStocks().get(a).id;
					 o[i] = Stock.getStocks().get(a).price;
			}
			}
				 n[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Input the quantity"));

				 
				 do {
		X = JOptionPane.showInputDialog(null,"Do you want an other product? Answer YES or NO");
		 
		 if ( (X.equals("YES") || X.equals("NO")) == false) {
			  JOptionPane.showMessageDialog(null,"Wrong answer");
		 }
		 
		} while ((X.equals("YES") || X.equals("NO")) == false);
		
			 i++;
		} while ( X.equals("YES"));
		
		Integer idorder = Order.getOrders().size() +1 ;
		String Date = JOptionPane.showInputDialog(null, "PLease insert the date");
		try {
			// open connection and get Connection object
			con = db.getConnection();
		PreparedStatement stmt2 = con.prepareStatement("INSERT INTO ORDERS VALUES ('"+ idorder + "', '"+ id +"','" + name +"', '"+ Date +"','"+  x[0] + "','"+ nameprod[0] +"','" + n[0] +"', '"+ o[0] +"','"+ x[1] + "', '"+ nameprod[1] +"','" + n[1] +"', '"+ o[1] +"','"+ x[2] + "', '"+ nameprod[2] +"','" + n[2] +"', '"+ o[2] +"','"+ x[3] + "', '"+ nameprod[3] +"','" + n[3] +"', '"+ o[3] +"', '" + x[4] + "', '"+ nameprod[4] +"','" + n[4] +"', '"+ o[4] + "')"); 
						stmt2.executeUpdate();
				stmt2.executeUpdate();
				System.out.println("success");
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

