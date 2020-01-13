
/*
 * Purchase
 * 
 * Copyright 2019-2020 Athens University of Economics and Business
 */
import java.util.ArrayList;

/**
 * With this class we operate the commissions, that are required from the
 * supplier. With this class, we find the quantities of every product, that are
 * required from the supplier. We check the minimum quantity of every product.
 * Finally we refresh the lists of Stocks and Orders, and we calculate some
 * statistics.
 * 
 * @author Eugenia Fourla
 */

public class Purchase {
	/* An ArrayList of Stocks, that contains the Stocks of the BlackList */
	static ArrayList<Stock> PurchaseStocks = new ArrayList<Stock>();
	/*
	 * An ArrayList of Stocks, that contains the final needs of Stocks for every
	 * product
	 */
	static ArrayList<Stock> sumPurchaseStocks = new ArrayList<Stock>();
	/*
	 * An ArrayList of Integers, that contains the needs of Stocks of every product
	 */
	static ArrayList<Integer> quantities = new ArrayList<Integer>();
	/* An ArrayList of Strings, that contains the messages to the supplier */
	static ArrayList<String> messages = new ArrayList<String>();
	/*
	 * An ArrayList of Doubles, that contains for every product the percentage of
	 * the total sum of commissions
	 */
	static ArrayList<Double> averages = new ArrayList<Double>();

	/*
	 * With this method we create a list, where the orders have been divided in
	 * stocks
	 */

	public static void createPurchaseStocks() throws Exception {
		for (int i = 0; i < Order.getBlackList().size(); i++) {
			for (int k = 0; k < Order.getBlackList().get(i).getA().size(); k++) {
				PurchaseStocks.add(Order.getBlackList().get(i).getA().get(k));
			}
		}
	}

	/*
	 * With this method we create a list, that includes the quantities of every
	 * product id, which are required from the supplier
	 */
	public static ArrayList<Stock> sumPurchaseStocks() throws Exception {
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			quantities.add(0);
		}

		for (int i = 0; i < PurchaseStocks.size(); i++) {
			quantities.add((PurchaseStocks.get(i).id) - 1,
					quantities.get(PurchaseStocks.get(i).id - 1) + PurchaseStocks.get(i).stock);

		}
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			sumPurchaseStocks.add(i,
					new Stock(PurchaseStocks.get(i).id + 1, PurchaseStocks.get(i).name,
							PurchaseStocks.get(i).description, PurchaseStocks.get(i).volume,
							PurchaseStocks.get(i).minQuantity, quantities.get(i), PurchaseStocks.get(i).price));

		}
		return sumPurchaseStocks;

	}

	/*
	 * With this method, we check the minimum stock's Quantity for every product and
	 * we find the final quantity, that is required from the supplier
	 */

	public static ArrayList<Stock> finalQuantities() throws Exception {
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			if (sumPurchaseStocks.get(i).stock > Stock.getStocks().get(i).stock) {
				int fquantity; // calculates the final quantity
				fquantity = sumPurchaseStocks.get(i).stock - Stock.getStocks().get(i).stock
						+ Stock.getStocks().get(i).minQuantity;
				sumPurchaseStocks.add(i,
						new Stock(PurchaseStocks.get(i).id + 1, PurchaseStocks.get(i).name,
								PurchaseStocks.get(i).description, PurchaseStocks.get(i).volume,
								PurchaseStocks.get(i).minQuantity, fquantity, PurchaseStocks.get(i).price));
			} else {
				if (Stock.getStocks().get(i).stock
						- sumPurchaseStocks.get(i).stock < Stock.getStocks().get(i).minQuantity) {
					int fquantity = Stock.getStocks().get(i).minQuantity;
					sumPurchaseStocks.add(i,
							new Stock(PurchaseStocks.get(i).id + 1, PurchaseStocks.get(i).name,
									PurchaseStocks.get(i).description, PurchaseStocks.get(i).volume,
									PurchaseStocks.get(i).minQuantity, fquantity, PurchaseStocks.get(i).price));
				}
			}
		}
		return sumPurchaseStocks;
	}

	/*
	 * With this method we send messages to the supplier , which include the final
	 * required quantities and we refresh the stocks
	 */

	public static ArrayList<String> messages() throws Exception {

		for (int i = 0; i < sumPurchaseStocks.size(); i++) {
			messages.add(
					"We need " + sumPurchaseStocks.get(i).stock + " of product with id " + sumPurchaseStocks.get(i).id);
			Stock.getStocks().add(i, sumPurchaseStocks.get(i));

		}
		return messages;
	}

	/* With this method we refresh the following lists */

	public static void refreshLists() throws Exception {
		for (int i = 0; i < Order.getBlackList().size(); i++) {
			Order.getGoodOrders().add(Order.getBlackList().get(i));
			Order.getBlackList().remove(i);

		}

	}

	/*
	 * With this method we find the maximum quantity that is required from the
	 * supplier
	 */
	public static Stock maximum(ArrayList<Stock> sumPurchaseStocks) {
		int max;// finds the maximum quantity of the list
		max = sumPurchaseStocks.get(0).stock;
		for (int i = 0; i < sumPurchaseStocks.size(); i++) {
			if (sumPurchaseStocks.get(i).stock > max) {
				max = sumPurchaseStocks.get(i).stock;
			}
		}
		return sumPurchaseStocks.get(sumPurchaseStocks.indexOf(max));
	}

	/*
	 * With this method we find the minimum quantity that is required from the
	 * supplier
	 */
	public static Stock minimum(ArrayList<Stock> sumPurchaseStocks) {
		int min;// finds the minimum quantity of the list
		min = sumPurchaseStocks.get(0).stock;
		for (int i = 0; i < sumPurchaseStocks.size(); i++) {
			if (sumPurchaseStocks.get(i).stock < min) {
				min = sumPurchaseStocks.get(i).stock;
			}
		}
		return sumPurchaseStocks.get(sumPurchaseStocks.indexOf(min));
	}

	/*
	 * With this method we find the sum of quantities that are required from the
	 * supplier. In addition we create a list, where for every product we calculate
	 * the percentage of this sum
	 */
	public static ArrayList<Double> sum(ArrayList<Stock> sumPurchaseStocks) {
		double avg = 0;// the percentage of every product
		int sum = 0;// the sum of all quantities
		for (int i = 0; i < sumPurchaseStocks.size(); i++) {
			sum = sum + sumPurchaseStocks.get(i).stock;
		}
		if (sum > 0) {
			for (int i = 0; i < sumPurchaseStocks.size(); i++) {
				avg = (sumPurchaseStocks.get(i).stock / sum) * 100;
				averages.add(i + 1, avg);
			}
		}
		return averages;

	}
}