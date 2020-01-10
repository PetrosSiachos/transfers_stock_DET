package transfers_stock_DET;
import java.util.ArrayList;

public class Purchase3 {

	static ArrayList<Stock> PurchaseStocks = new ArrayList<Stock>();
	static ArrayList<Stock> sumPurchaseStocks = new ArrayList<Stock>();
	static ArrayList<Integer> quantities = new ArrayList<Integer>();

	/*With this methdod we create a list, where the orders have been divided in stocks*/
	
	public static void createPurchaseStocks() {
		for (int i = 0; i < Order.BlackList.size(); i++) {
			for (int k = 0; k < Order.BlackList.get(i).order.size(); k++) {
				PurchaseStocks.add(Order.BlackList.get(i).order.get(k));
			}
		}
	}

	/*With this methdod we create a list, that includes the quantities of every product id, which are required from the supplier*/
	
	public static ArrayList<Stock> sumPurchaseStocks() {
		for (int i = 0; i < Stock.stocks.size(); i++) {
			quantities.add(0);
		}

		for (int i = 0; i < PurchaseStocks.size(); i++) {
			quantities.add((PurchaseStocks.get(i).id) - 1,
					quantities.get(PurchaseStocks.get(i).id - 1) + PurchaseStocks.get(i).quantity);

		}
		for (int i = 0; i < Stock.stocks.size(); i++) {
			sumPurchaseStocks.add(i, new Stock(i + 1, PurchaseStocks.get(i).price, quantities.get(i),
					PurchaseStocks.get(i).minQuantity));

		}
		return sumPurchaseStocks;

	}

	/*With this method, we check the minimum stock's Quantity for every product  and we find the final quantity, that is required from the supplier*/
	
	public static ArrayList<Stock> finalQuantities() {
		for (int i = 0; i < Stock.stocks.size(); i++) {
			if (sumPurchaseStocks.get(i).quantity > Stock.stocks.get(i).quantity) {
				int fquantity = sumPurchaseStocks.get(i).quantity - Stock.stocks.get(i).quantity
						+ Stock.stocks.get(i).minQuantity;
				sumPurchaseStocks.add(i,
						new Stock(i + 1, PurchaseStocks.get(i).price, fquantity, PurchaseStocks.get(i).minQuantity));
			} else {
				if (Stock.stocks.get(i).quantity
						- sumPurchaseStocks.get(i).quantity < Stock.stocks.get(i).minQuantity) {
					int fquantity = Stock.stocks.get(i).minQuantity;
					sumPurchaseStocks.add(i, new Stock(i + 1, PurchaseStocks.get(i).price, fquantity,
							PurchaseStocks.get(i).minQuantity));
				}
			}
		}
		return sumPurchaseStocks;
	}
	/*With this method we send messages to the supplier , which include the final required quantities and we refresh the stocks*/

	public static void messages() {

		for (int i = 0; i < sumPurchaseStocks.size(); i++) {
			System.out.println("We need " + sumPurchaseStocks.get(i).quantity + " of product with id "
					+ sumPurchaseStocks.get(i).id);
			Stock.stocks.add(i,sumPurchaseStocks.get(i));

		}

	}
	/*With this method we refresh the following lists*/

	public static void refreshLists() {
		for (int i = 0; i < Order.BlackList.size(); i++) {
			Order.goodOrders.add(Order.BlackList.get(i));
			Order.BlackList.remove(i);
		}

	}

}