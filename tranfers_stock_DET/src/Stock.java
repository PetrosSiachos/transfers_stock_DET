import java.util.ArrayList;

public class Stock {

	int id; //id αυτοαυξανόμενο
	static int counter = 1;
	String name;
	double price;
	int quantity;
	static ArrayList<Stock> stocks = new ArrayList<Stock>(); // an arrayList of all stocks
	int minQuantity; // minimun quantity of each product or stock
	
	//constructor that constructs a stock for Stock
	public Stock(String name, double price, int quantity, int minQuantity) {
		super();
		this.id = counter++;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.minQuantity = minQuantity;
		if (this.quantity < minQuantity) {
			this.quantity = minQuantity;
		}// if quantity given is smaller than minQuantity then quantity=minQuantity!
		// In order to create a stock we are going to set quantity to a specific amount = minQuantity
		//LATER, IF IT GETS LOWER THAN MIN WE MAKE A PUCHASE AND USE METHOD "checkMinQuantity"!!!!! 
		stocks.add(this);
	}
	
	
	//constructor that constructs a stock for Order
	public Stock(int id, String name, double price, int quantity, int minQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.minQuantity = minQuantity;
	}


	//prints all elements of ArrayList stocks
	public static void printAllStocks() {
		for (int i=0; i<stocks.size(); i++) {
			System.out.println(stocks.get(i));
		}
	}
	
	//prints the highest quantity of the stock and the id to which the quantity belongs to
	public static void printHighestQuantity() {
		int max = 0;
		int id = 0;
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).quantity > max) {
				max = stocks.get(i).quantity;
				id = stocks.get(i).id;
			}
		}
		System.out.println("The highest quantity of all stocks is " + max + " and belongs to the product with id " + id);
	}
	
	//prints the lowest quantity of the stock and the id to which the quantity belongs to
	public static void printLowestQuantity() {
		int min = 1000000000;
		int id = 0;
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).quantity < min) {
				min= stocks.get(i).quantity;
				id = stocks.get(i).id;
			}
		}
		System.out.println("The lowest quantity of all stocks is " + min + " and belongs to the product with id " + id);
	}
	
	/*
	 * // checks if quantity given is smaller than minQuantity then sets
	 * quantity=minQuantity! public void checkMinQuantity() { if (this.quantity <
	 * minQuantity) { this.quantity = minQuantity; //SOS!!! CREATE A PURCHASE WITH
	 * QUANTITY = minQuantity - this.quantity; } }
	 */
	
	public boolean checkMinQuantity() {
		if (this.quantity < minQuantity) {
			return false;
		} else {
			return true;
		}
	}
	
	public void descreaseQuantity(int idstock) {
		for(Stock num : stocks) {
			if (idstock == this.id) {
				this.quantity--;
			}
		}
	}
	
	public void increaseQuantity(int idstock) {
		for (Stock num : stocks) {
			if (idstock == this.id) {
				this.quantity++;
			}
		}
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name " + name + ", price=" + price + ", quantity=" + quantity + ", minQuantity=" + minQuantity + "]";
	}
	
	
		
}
