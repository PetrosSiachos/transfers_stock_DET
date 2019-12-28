package STOCKOVERFLOWPackage;

public class Statistics {

	/* Ελάχιστη τιμή παραγγελίας*/
	public static double Minprice() throws Exception {
		int id;
		double min = 1000000000;
		for (int i = 0; i < Order.getGoodOrders().size(); i++) {
			if (Order.getGoodOrders().get(i).price1 < min) {
				min= Order.getGoodOrders().get(i).price1;
			}
		}
		return min;
	}
	
	/* Μέγιστη τιμή παραγγελίας */
	public static double Maxprice() throws Exception {
		int id;
		double max = -1;
		for (int i = 0; i < Order.getGoodOrders().size(); i++) {
			if (Order.getGoodOrders().get(i).price1 > max) {
				max= Order.getGoodOrders().get(i).price1;
			}
		}
		return max;
	}
	
	/* Ποσοστό επιτυχημένων παραγγελιών */
	public static double rateofgoodorders() throws Exception {
		double rate;
		rate = Order.getGoodOrders().size()/Order.getOrders().size();
		return rate;
	}
	
	/* Ποσοστό αποτυχημένων παραγγελιών */
	public static double rateofblackorders() throws Exception {
		double rate;
		rate = Order.getBlackList().size()/Order.getOrders().size();
		return rate;
	}
	
	/* Δημοφιλές προϊόν (αυτό που υπάρχει στις περισσότερες παραγγελίες */
	
	public static int popularpr() throws Exception {
		int k[] = new int [Stock.getStocks().size()];
		int id = 0;
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++ ) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
			}
		}
		int max = -1;
		for (int s = 0; s < k.length; s++) {
			if (k[s] > max) {
				max = k[s];
				id = Stock.getStocks().get(s).id;
			}
		}
		return id;
	}
	
	/* Λιγότερο δημοφιλές προϊόν */
	public static int notpoppr() throws Exception {
		int id = 0;
		int min = 100000;
		int k[] = new int [Stock.getStocks().size()];
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++ ) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
			}
		}
		for (int i = 0; i < k.length; i++) {
			if(k[i] < min) {
				min = k[i];
				id = Stock.getStocks().get(i).id;
			}
		}
		return id;
	}
	
	/* Προϊόν με τα μεγαλύτερα έσοδα */
	
	public static int maxpripr() throws Exception {
		double a[] = new double[Stock.getStocks().size()];
		int id = 0;
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++ ) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
			}
		}
		double max = -1;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
				id = Stock.getStocks().get(i).id;
			}
		}
		return id;
	}
	
	/* Προϊόν με τα μικρότερα έσοδα */
	public static int minpripr() throws Exception {
		int id = 0;
		double a[] = new double[Stock.getStocks().size()];
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++ ) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
			}
		}
		double min = 10000000;
		for (int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
				id = Stock.getStocks().get(i).id;
			}
		}
		return id;
	}
	/* ποσοστά προϊόντων στις παραγγελίες */
	public static double[] average_pr_orders() throws Exception {
		int k[] = new int [Stock.getStocks().size()];
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++ ) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
			}
		}
		double i[] = new double [Stock.getStocks().size()];
		for (int s = 0; s < Stock.getStocks().size(); s++) {
			i[s] = k[s]/Order.getOrders().size();
		}
		return i;
	}
	
	public static int popcustomer() throws Exception {
		int idcust = 0;
		int a[] = new int[Customer.getCustomers().size()];
		for (int i=0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Customer.getCustomers().size(); j++) {
				if (Order.getOrders().get(i).namecustomer == Customer.getCustomers().get(j).namecustomer) {
					a[j] = a[j] + 1;
				}
			}
		}
		int max = -1;
		for (int s = 0; s < a.length; s++) {
			if (a[s] > max) {
				max = a[s];
				idcust = Customer.getCustomers().get(s).idcustomer;
			}
		}
		return idcust;
	}
	
	/* Μέγιστη ποσότητα προϊόντων */
	public static int Highestquantity() throws Exception {
		int highq = 0;
		int id = 0;
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).stock > highq) {
				highq = Stock.getStocks().get(i).stock;
			}
		}
		return highq;
	}
	
	/* Ελάχιστη ποσότητα προϊόντων */
	public static int Lowestquantity() throws Exception {
		int lowq = 1000000000;
		int id = 0;
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).stock < lowq) {
				lowq= Stock.getStocks().get(i).stock;
			}
		}
		return lowq;
		
	}
	
	public static double minprice() throws Exception {
		double minp = 10000000;
		for (int i=0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).price < minp) {
				minp = Stock.getStocks().get(i).price;
			}
		}
		return minp;
	}
	
	public static double maxprice() throws Exception {
		double maxp = 0;
		for (int i=0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).price > maxp) {
				maxp = Stock.getStocks().get(i).price;
			}
		}
		return maxp;
	}
	
}
