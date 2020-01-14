/** Statistics
 *
 * 2nd year
 * Sargenti Panagiota, Elena Tzerefou, Eugenia Fourla
 */
package STOCKOVERFLOWPackage;

/**
 * Statistical results for business data
 *
 * Statistics for Customers Statistics for Orders Statistic for Stocks
 */

public class Statistics {

	/** successful Orders: orders that can be placed divided by total */
	public static double rateofgoodorders() throws Exception {
		double rate;
		System.out.println(Order.getGoodOrders().size());
		System.out.println(Order.getOrders().size());
		rate = ((double) Order.getGoodOrders().size()) / ((double) Order.getOrders().size());
		return rate;
	}

	/** -------------------Statistics of Class Order------------------------- */

	/** CustomerSumOrders: Sum of orders for each customer */
	public static int[] CustomerSumOrders() throws Exception {
		int[] array = new int[Customer.getCustomers().size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		for (Order o : Order.getOrders()) {
			int idCust = o.getIdcustomer();
			array[idCust - 2]++;
		}
		return array;
	}

	/** Customer with max Orders: The highest number of orders per customer */
	public static String[] CustomerMaxOrders() throws Exception {
		int max = 0;
		int k = 0;
		int[] arr = CustomerSumOrders();
		String[] array = new String[Customer.getCustomers().size()];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		for (Customer cust : Customer.getCustomers()) {
			int idCust = cust.getIdcustomer();
			if (arr[idCust - 2] == max) {
				array[k] = cust.getNamecustomer();
				k++;
			}
		}
		return array;
	}

	/** Customer with min Orders: The lowest number of orders per customer */
	public static String[] CustomerMinOrders() throws Exception {
		int min = 0;
		int k = 0;
		int[] arr = CustomerSumOrders();
		String[] array = new String[Customer.getCustomers().size()];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		for (Customer cust : Customer.getCustomers()) {
			int idCust = cust.getIdcustomer();
			if (arr[idCust - 2] == min) {
				array[k] = cust.getNamecustomer();
				k++;
			}
		}
		return array;
	}

	/** -------------------Statistics of Class Customer------------------------- */

	/**
	 * AverageCreditworthiness of Customers: The average amount that all customers
	 * can spend on their purchases
	 */
	public static double AverageCreditworthiness() throws Exception {
		int sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = sum + cust.getCreditworthiness();
		}
		return (double) sum / Customer.getCustomers().size();
	}

	/**
	 * Customer with max creditworthiness: The customer who can spend the largest
	 * amount on his purchases relative to others
	 */
	public static String[] CustomerMaxCreaditworthiness() throws Exception {
		int cred = 0;
		int i = 0;
		String[] array = new String[Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() > cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}

	/**
	 * Customer with min creditworthiness: The customer who can spend the smallest
	 * amount on his purchases relative to others
	 */
	public static String[] CustomerMinCreaditworthiness() throws Exception {
		int cred = 0;
		int i = 0;
		String[] array = new String[Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() < cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}

	/**
	 * Satisfactory average creditworthiness or not: If the average amount Customers
	 * can afford for their purchases is satisfactory
	 */
	public static boolean SatisfactoryAverageCreditworthiness() throws Exception {
		boolean sat = false;
		if (Statistics.AverageCreditworthiness() > 70) {
			sat = true;
		}
		return sat;
	}

	/**
	 * AverageYears_of_cooperation of Customers: The average time of business
	 * cooperation with customers
	 */
	public static double AverageYears_of_cooperation() throws Exception {
		int sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = sum + cust.getYears_of_cooperation();
		}
		return (double) sum / Customer.getCustomers().size();
	}

	/**
	 * Customer with max Years_of_cooperation: Customer with maximum cooperation
	 * time value
	 */
	public static String[] CustomerMaxYears_of_cooperation() throws Exception {
		int years = 0;
		int i = 0;
		String[] array = new String[Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() > years) {
				years = cust.getYears_of_cooperation();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() == years) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}

	/**
	 * Customer with min Years_of_cooperation: Customer with minimum cooperation
	 * time value
	 */
	public static String[] CustomerMinYears_of_cooperation() throws Exception {
		int years = 100;
		int i = 0;
		String[] array = new String[Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() < years) {
				years = cust.getYears_of_cooperation();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() == years) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}

	/**
	 * AveragePercent_of_stock of Customers: The average percentage of shares that
	 * customers have in business
	 */
	public static double AveragePercent_of_stock() throws Exception {
		double sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = (double) (sum + cust.getPercent_of_stock());
		}
		return (double) sum / Customer.getCustomers().size();
	}

	/**
	 * Customer with max Percent_of_stock: Customer with most shares in the business
	 */
	public static String[] CustomerMaxPercent_of_stock() throws Exception {
		double stock = 0;
		int i = 0;
		String[] array = new String[Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if ((double) cust.getPercent_of_stock() > stock) {
				stock = (double) cust.getPercent_of_stock();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if ((double) cust.getPercent_of_stock() == stock) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}

	/**
	 * Customer with min Percent_of_stock: Customer with the fewest shares in the
	 * business
	 */
	public static String[] CustomerMinPercent_of_stock() throws Exception {
		double stock = 1000.0;
		int i = 0;
		String[] array = new String[Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if ((double) cust.getPercent_of_stock() < stock) {
				stock = (double) cust.getPercent_of_stock();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if ((double) cust.getPercent_of_stock() == stock) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}

	/** Array of Value of customers */
	public static double[] ValueOfCustomers() throws Exception {
		int i = 0;
		double[] array = new double[Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			int y = cust.getYears_of_cooperation();
			int c = cust.getCreditworthiness();
			double p = cust.getPercent_of_stock();
			array[i] = ((double) y / 30.0) * 0.4 + ((double) c / 100.0) * 0.5 + p * 0.1;
			i++;
		}
		return array;
	}

	/** Customer with max value */
	public static String[] CustomerMostValuable() throws Exception {
		double MaxValue = 0;
		int i = 0;
		double[] array = Statistics.ValueOfCustomers();
		String[] array2 = new String[Customer.getCustomers().size()];
		for (int k = 0; k < array.length; k++) {
			if (array[k] > MaxValue) {
				MaxValue = array[k];
			}
		}

		for (Customer cust : Customer.getCustomers()) {
			int id = cust.getIdcustomer();
			if (array[id - 2] == MaxValue) {
				array2[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array2;
	}

	/** Customer with min value */
	public static String[] CustomerLessValuable() throws Exception {
		double MinValue = 0;
		int i = 0;
		double[] array = Statistics.ValueOfCustomers();
		String[] array2 = new String[Customer.getCustomers().size()];
		for (int k = 0; k < array.length; k++) {
			if (array[k] < MinValue) {
				MinValue = array[k];
			}
		}

		for (Customer cust : Customer.getCustomers()) {
			int id = cust.getIdcustomer();
			if (array[id - 2] == MinValue) {
				array2[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array2;
	}

	/**
	 * HealthyDoingBusiness: if 60% of customers have creditworthiness above 0.6
	 * then we are ok/else not
	 */
	public static boolean HealthyDoingBusiness() throws Exception {
		int count = 0;
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() > 60) {
				count++;
			}
		}
		double per = count / Customer.getCustomers().size();
		if (per > 0.6) {
			return true;
		}
		return false;
	}

	/**
	 * -----------------------------------------O r d e r
	 * s--------------------------------------------
	 */

	/**
	 * Rate of failed orders: Orders that can not be placed divided by total
	 */
	public static double rateofblackorders() throws Exception {
		double rate;
		rate = ((double) Order.getBlackList().size()) / ((double) Order.getOrders().size());
		return rate;
	}

	/** Popular product: The product id that has the most deals on orders */
	public static int popularpr() throws Exception {
		int k[] = new int[Stock.getStocks().size()];
		int id = 0;
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct2 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct3 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct4 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct5 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
			}
		}
		int max = -1;
		for (int s = 0; s < k.length; s++) {
			if (k[s] > max) {
				max = k[s];
				id = s;
			}
		}

		return id;
	}

	/**
	 * Not popular product: The product id that has the least amount of orders
	 */
	public static int notpoppr() throws Exception {
		int id = 0;
		int min = 100000;
		int k[] = new int[Stock.getStocks().size()];
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct2 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct3 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct4 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
				if (Order.getOrders().get(i).idproduct5 == Stock.getStocks().get(j).id) {
					k[j] = k[j] + 1;
				}
			}

		}
		for (int i = 0; i < k.length; i++) {
			if (k[i] < min) {
				min = k[i];
				id = i;
			}
		}
		return id;
	}

	/** maxinpr: Product with the highest income */
	public static int maxincpr() throws Exception {
		double a[] = new double[Stock.getStocks().size()];
		int id = 0;
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct2 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct3 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct4 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct5 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
			}
		}
		double max = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				id = i;
			}
		}
		return id;
	}

	/** mininpr: Product with the lowest income */
	public static int minincpr() throws Exception {
		int id = 0;
		double a[] = new double[Stock.getStocks().size()];
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Stock.getStocks().size(); j++) {
				if (Order.getOrders().get(i).idproduct1 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct2 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct3 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct4 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
				if (Order.getOrders().get(i).idproduct5 == Stock.getStocks().get(j).id) {
					a[j] = a[j] + Stock.getStocks().get(j).price;
				}
			}
		}
		double min = 10000000;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
				id = i;
			}
		}
		return id;
	}

	/**
	 * -----------------------------------------C u s t o m e r
	 * s--------------------------------------------
	 */
	/** Popular Customer: The Customer who has the most orders */
	public static int popcustomer() throws Exception {
		int idcust = 0;
		int a[] = new int[Customer.getCustomers().size()];
		for (int i = 0; i < Order.getOrders().size(); i++) {
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

	/**
	 * -----------------------------------------S t o c k
	 * s--------------------------------------------
	 */
	/** Highest stock */
	public static int Higheststock() throws Exception {
		int highq = 0;
		int id = 0;
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).stock > highq) {
				highq = Stock.getStocks().get(i).stock;
			}
		}
		return highq;
	}

	/** Lowest stock */
	public static int Loweststock() throws Exception {
		int lowq = 1000000000;
		int id = 0;
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).stock < lowq) {
				lowq = Stock.getStocks().get(i).stock;
			}
		}
		return lowq;

	}

	/** Lowest price on stocks */
	public static double minprice() throws Exception {
		double minp = 10000000;
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).price < minp) {
				minp = Stock.getStocks().get(i).price;
			}
		}
		return minp;
	}

	/** Highest price on stocks */
	public static double maxprice() throws Exception {
		double maxp = -1;
		for (int i = 0; i < Stock.getStocks().size(); i++) {
			if (Stock.getStocks().get(i).price > maxp) {
				maxp = Stock.getStocks().get(i).price;
			}
		}
		return maxp;
	}

}
