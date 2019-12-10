import java.sql.SQLException;

import javax.swing.JOptionPane ;

public class Main {
	public static void main (String [] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		ConnectMySQL.now();
		JOptionPane.showMessageDialog(null,"Hello Man");
		String fn = JOptionPane.showInputDialog("Could you control the orders");
		for(;;) { 
			if (fn.equals("no")) {
				JOptionPane.showMessageDialog(null,"Oh, come on start again");
				JOptionPane.showInputDialog("Could you control the orders");
			} 
			break;
		}
		
		for (int i = 0 ; i < Stock.stocks.size() ; i++) {
			JOptionPane.showMessageDialog(null,"new product: " + Stock.stocks.get(i));
		}
		JOptionPane.showMessageDialog(null,"the lowest quantity is: " +Stock.printLowestQuantity());
		JOptionPane.showMessageDialog(null,"the highest quantity is: "+Stock.printHighestQuantity());
		
		JOptionPane.showMessageDialog(null,"Hello we have an order");
		Order O1 = new Order(1);
		JOptionPane.showMessageDialog(null,"Hello we have an order");
		Order O2 = new Order(2);
		 JOptionPane.showMessageDialog(null,"Hello we have an order");
		Order O3 = new Order(3);
		
		JOptionPane.showMessageDialog(null, "all orders" + Order.printAllOrders());
		JOptionPane.showMessageDialog(null,"good orders:" +Order.printGoodOrders());
		JOptionPane.showMessageDialog(null,"bad orders:" +Order.printBlackList());
		JOptionPane.showMessageDialog(null,"the average number of products is:"+ Order.printAverageNumberOfProducts());
		}

	private static void ConnectMySQL() {
		// TODO Auto-generated method stub
		
	}	
}
