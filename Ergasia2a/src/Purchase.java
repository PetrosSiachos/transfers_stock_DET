import java.util.ArrayList;
import java.util.List;
public class Purchase  {
	int idpur;
	static int counter=1;
	int idproduct;
	int quantity=0;
	static ArrayList<Purchase> purchases = new ArrayList<Purchase>();
	public Purchase() {
		super();
		this.idpur = counter++;
		//bazo ta apothemata poy einai kato apo to min kai tis fail paraggelies se mia lista
		for (int i=0; i<= Order.BlackList.size(); i++) {
			this.idproduct = Order.BlackList.get(i).order.get(i).id;
			this.quantity = Order.BlackList.get(i).order.get(i).quantity;
			for (int y=0 ; y<= Stock.stocks.size(); y++) {
				if (Stock.stocks.get(y).id ==  Order.BlackList.get(i).order.get(i).id) {
					if (Stock.checkMinQuantity()== false) {
						int c = Stock.stocks.get(i).minQuantity - Stock.stocks.get(i).quantity;
						this.quantity = Order.BlackList.get(i).order.get(i).quantity + c;
					}
				}
			}
		}
		purchases.add(this);
	}
	public static void printAllPurchases() {
		for (int i=0; i<= purchases.size(); i++) {
			System.out.println("We need" + purchases.get(i).quantity + purchases.get(i).idproduct );
		}
		
 	}
}
	

