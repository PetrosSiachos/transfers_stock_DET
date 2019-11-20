import java.util.ArrayList;
public class Statistics {
	public static ArrayList<Statistics> statistics = new ArrayList<Statistics>();
	double countofvalues;
	double averageofvalues;
	double max;
	double min;
	
	public Statistics() {
		super();
		this.countofvalues = Order.priceofgoodorders;
		this.averageofvalues = Order.priceofgoodorders/(Order.numberofgoodorders);
		this.min = Minprice();
		this.max = Maxprice();
	}
			
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
	
}
