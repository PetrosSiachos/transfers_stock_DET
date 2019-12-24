import java.util.ArrayList;
public class Statistics {
	
	/* Ελάχιστη τιμή παραγγελίας*/
	public static double Minprice() {
		int id;
		double min = 1000000000;
		for (int i = 0; i < Order.goodOrders.size(); i++) {
			if (Order.goodOrders.get(i).order.get(i).price < min) {
				min= Order.goodOrders.get(i).order.get(i).price;
				id = Order.goodOrders.get(i).order.get(i).id;
			}
		}
		return min;
	}
	
	/* Μέγιστη τιμή παραγγελίας */
	public static double Maxprice() {
		int id;
		double max = -1;
		for (int i = 0; i < Order.goodOrders.size(); i++) {
			if (Order.goodOrders.get(i).order.get(i).price > max) {
				max= Order.goodOrders.get(i).order.get(i).price;
				id = Order.goodOrders.get(i).order.get(i).id;
			}
		}
		return max;
	}
	
	/* Ποσοστό επιτυχημένων παραγγελιών */
	public static double rateofgoodorders() {
		double rate;
		rate = Order.numberofgoodorders/Order.numberoforders;
		return rate;
	}
	
	/* Ποσοστό αποτυχημένων παραγγελιών */
	public static double rateofblackorders() {
		double rate;
		rate = Order.numberofBlackList/Order.numberoforders;
		return rate;
	}
	
	/* Δημοφιλές προϊόν (αυτό που υπάρχει στις περισσότερες παραγγελίες */
	static int k[] = new int [Order.numberofproducts];
	public static int popularpr() {
		int id = 0;
		int cust;
		for (int i = 0; i < Order.orders.size(); i++) {
			for (int j = 0; j < Order.numberofproducts; j++ ) {
				if (Order.orders.get(i).order.get(i).id == Order.orders.get(j).idproducts.get(j)) {
					k[j] = k[j] + 1;
				}
			}
		}
		int max = -1;
		for (int s = 0; s < Order.numberofproducts; s++) {
			if (k[s] > max) {
				max = k[s];
				id = k[s];
				cust = Order.orders.get(id).customer;
			}
		}
		return id;
	}
	
	/* ποσοστά προϊόντων στις παραγγελίες */
	public static double[] average_pr_orders() {
		double i[] = new double [Order.numberofproducts];
		for (int s = 0; s < Order.numberofproducts; s++) {
			i[s] = k[s]/Order.numberofproducts;
		}
		return i;
	}
	
	public static int popcustomer() {
		int idcust;
		int a[] = new int[Customer.customers.size()];
		for (int i=0; i < Order.orders.size(); i++) {
			for (int j = 0; j < Customer.customers.size(); j++) {
				if (Order.orders.get(i).idcust == Customer.customers.get(j).custid) {
					a[j] = a[j] + 1;
				}
			}
		}
		int max = -1;
		for (int s = 0; s < a.length; s++) {
			if (a[s] > max) {
				max = a[s];
				idcust = Customer.customers.get(s).custid;
			}
		}
		return idcust;
	}
	
	
	/* Μέγιστη ποσότητα προϊόντων */
	public static int Highestquantity() {
		int highq = 0;
		int id = 0;
		for (int i = 0; i < Stock.stocks.size(); i++) {
			if (Stock.stocks.get(i).quantity > highq) {
				highq = Stock.stocks.get(i).quantity;
				id = Stock.stocks.get(i).id;
			}
		}
		return highq;
	}
	
	/* Ελάχιστη ποσότητα προϊόντων */
	public static int Lowestquantity() {
		int lowq = 1000000000;
		int id = 0;
		for (int i = 0; i < Stock.stocks.size(); i++) {
			if (Stock.stocks.get(i).quantity < lowq) {
				lowq= Stock.stocks.get(i).quantity;
				id = Stock.stocks.get(i).id;
			}
		}
		return lowq;
		
	}
	
	public static double minprice() {
		double minp = 10000000;
		for (int i=0; i < Stock.stocks.size(); i++) {
			if (Stock.stocks.get(i).price < minp) {
				minp = Stock.stocks.get(i).price;
			}
		}
		return minp;
	}
	
	public static double maxprice() {
		double maxp = 0;
		for (int i=0; i < Stock.stocks.size(); i++) {
			if (Stock.stocks.get(i).price > maxp) {
				maxp = Stock.stocks.get(i).price;
			}
		}
		return maxp;
	}
	
}
