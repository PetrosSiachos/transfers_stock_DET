import java.util.ArrayList;

public class Stock {
	int id;
	String name;
	String description;
	int volume;
	int minQuantity;
	int stock;
	double price;
	int idorder;
	int idproduct1;
	String nameproduct1;
	int quantity1;
	double price1;
	int idproduct2;
	String nameproduct2;
	int quantity2;
	double price2;
	int idproduct3;
	String nameproduct3;
	int quantity3;
	double price3;
	int idproduct4;
	String nameproduct4;
	int quantity4;
	double price4;
	int idproduct5;
	String nameproduct5;
	int quantity5;
	double price5;
	
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
	
//constructor that constructs a stock for Order
		public Stock(int idorder, int idproduct1, String nameproduct1, int quantity1, double price1, 
				int idproduct2, String nameproduct2, int quantity2, double price2, int idproduct3, 
				String nameproduct3, int quantity3, double price3, int idproduct4, String nameproduct4,
				int quantity4, double price4, int idproduct5, String nameproduct5, int quantity5, double price5) {
			super();
			idorder = this.idorder;
			idproduct1 = this.idproduct1;
			nameproduct1 = this.nameproduct1;
			quantity1 = this.quantity1;
			price1 = this.price1;
			idproduct2 = this.idproduct2;
			nameproduct2 = this.nameproduct2;
			quantity2 = this.quantity2;
			price2 = this.price2;
			idproduct3 = this.idproduct3;
			nameproduct3 = this.nameproduct3;
			quantity3 = this.quantity3;
			price3 = this.price3;
			idproduct4 = this.idproduct4;
			nameproduct4 = this.nameproduct4;
			quantity4 = this.quantity4;
			price4 = this.price4;
			idproduct5 = this.idproduct5;
			nameproduct5 = this.nameproduct5;
			quantity5 = this.quantity5;
			price5 = this.price5;
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
				+ ", minQuantity=" + minQuantity + ", stock=" + stock + ", price=" + price + ", idorder=" + idorder
				+ ", idproduct1=" + idproduct1 + ", nameproduct1=" + nameproduct1 + ", quantity1=" + quantity1
				+ ", price1=" + price1 + ", idproduct2=" + idproduct2 + ", nameproduct2=" + nameproduct2
				+ ", quantity2=" + quantity2 + ", price2=" + price2 + ", idproduct3=" + idproduct3 + ", nameproduct3="
				+ nameproduct3 + ", quantity3=" + quantity3 + ", price3=" + price3 + ", idproduct4=" + idproduct4
				+ ", nameproduct4=" + nameproduct4 + ", quantity4=" + quantity4 + ", price4=" + price4 + ", idproduct5="
				+ idproduct5 + ", nameproduct5=" + nameproduct5 + ", quantity5=" + quantity5 + ", price5=" + price5
				+ "]";
	}
}
	
