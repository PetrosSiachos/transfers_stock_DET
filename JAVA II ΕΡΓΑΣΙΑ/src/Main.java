import java.sql.SQLException;

import javax.swing.JOptionPane ;
public class Main {
	public static void main (String [] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
		ConnectMySQL.now();
		for (int i = 0 ; i < Stock.stocks.size() ; i++) {
			JOptionPane.showMessageDialog(null,"new product: " + Stock.stocks.get(i));
		}
		JOptionPane.showMessageDialog(null,"the lowest quantity is: " +Stock.printLowestQuantity());
		JOptionPane.showMessageDialog(null,"the highest quantity is: "+Stock.printHighestQuantity());
		JOptionPane.showMessageDialog(null, "all orders" + Order.printAllOrders());
		JOptionPane.showMessageDialog(null,"good orders:" +Order.printGoodOrders());
		JOptionPane.showMessageDialog(null,"bad orders:" +Order.printBlackList());
		JOptionPane.showMessageDialog(null,"the average number of products is:"+ Order.printAverageNumberOfProducts());
	}		
}	

