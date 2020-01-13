import java.util.ArrayList;
public class Stock {
	int id;
	String name;
	String description;
	int volume;
	int minQuantity;
	int stock;
	double price;
	static ArrayList<Stock> stocks = new ArrayList<Stock>(); // an arrayList of all stocks
	//constructor that constructs a stock for Stock
	public Stock(int id, String name, String description, int volume, int minQuantity, int stock, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.volume = volume;
		this.minQuantity = minQuantity;
		this.stock = stock;
		this.price = price;
		checkMinQuantity();
		// if quantity given is smaller than minQuantity then quantity=minQuantity!
		// In order to create a stock we are going to set quantity to a specific amount = minQuantity
		//LATER, IF IT GETS LOWER THAN MIN WE MAKE A PUCHASE AND USE METHOD "checkMinQuantity"!!!!! 
		stocks.add(this);
	}
//we have a method that checks if quantity is smaller than minQuantity.Is this situation, quantity=minQuantity
		
//prints all elements of ArrayList stocks
	public static void printAllStocks() {
		for (int i=0; i<stocks.size(); i++) {
			System.out.println(stocks.get(i));
		}
	}
	
//prints the highest quantity of the stock and the id to which the quantity belongs to
	public static int printHighestQuantity() {
		int max = 0;
		int id = 0;
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).stock > max) {
				max = stocks.get(i).stock;
				id = stocks.get(i).id;
			}
		}
		return max;
	}
	
//prints the lowest quantity of the stock and the id to which the quantity belongs to
	public static int printLowestQuantity() {
		int min = 1000000000;
		int id = 0;
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).stock < min) {
				min= stocks.get(i).stock;
				id = stocks.get(i).id;
			}
		}
	return min;	
	}
	
// checks if quantity given is smaller than minQuantity then sets quantity=minQuantity!
	public void checkMinQuantity() {
		if (this.stock < minQuantity) {
			this.stock = minQuantity;
			//SOS!!! CREATE A PURCHASE WITH QUANTITY = minQuantity - this.quantity;
		}
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", description=" + description + ", volume=" + volume
				+ ", minQuantity=" + minQuantity + ", stock=" + stock + ", price=" + price + "]";
	}
}

	
