mport java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Order {

	// έστω πως id, location είναι μοναδικά (αυτοαυξανόμενα) και πως ο customer μπαίνει από το πληκτρολόγιο
	int id; //id αυτοαυξανόμενο
	static int counter = 1;
	int location;//location αυτοαυξανόμενο
	static int counter2 = 1;
	int customer; //
	java.util.Date date;
	
	
	ArrayList<Stock> order = new ArrayList<Stock>(); // an arrayList of all stocks of an order
	static ArrayList<Order> orders = new ArrayList<Order>(); // an arrayList of all orders
	static ArrayList<Order> goodOrders = new ArrayList<Order>(); // an arrayList of all orders that CAN we fulfilled 
	static ArrayList<Order> BlackList = new ArrayList<Order>(); // an arrayList of all orders that CANT be fulfilled
	static ArrayList<Integer> numberOfProducts = new ArrayList<Integer>();// an arrayList of number of products per order px. orderId=1 number=2,orderId=2 number=3
	// SOSSSS numberOfProducts = 2 = banana + orange = NOT 2 bananas
	
	
	public Order(int customer) {
		super();
		this.id = counter++;
		this.location = counter2++;
		this.customer = customer;
		this.date = setDate();
		this.order = setOrder();
		orders.add(this);
	}

	// method that fills arrayList order with stocks
	public ArrayList<Stock> setOrder() {
		
		int id;
		double price = 0;
		int quantity;
		int minQuantity = 0;
		for (int i = 0 ; i < 2 ; i ++) {//default! customer can order max 2 products per order
			id = getRandomIntBetweenRange(1 , Stock.stocks.size());// id between 1-stocks.size(). max = as many as the stocks are
			quantity = getRandomIntBetweenRange (1 , 10000);// quantity is between 1 and 10000(big number)
			for (int k = 0 ; k < Stock.stocks.size() ; k++) {// goes through arrayList stocks of Stock and finds the object of the arrayList 
				if (Stock.stocks.get(k).id == id) {			//where object.id=id given and sets price= price of object with id
					price = Stock.stocks.get(k).price;
					minQuantity = Stock.stocks.get(k).minQuantity;
				}
			}
			order.add(new Stock (id , price , quantity , minQuantity ));
		}
		return order;
	}
	
	// method that sets a random date form january to march of 2019
	public java.util.Date setDate(){
		return new GregorianCalendar(2019, getRandomIntBetweenRange(0, 2), getRandomIntBetweenRange(0, 28)).getTime();
	}
	
	// method that creates random numbers from min-max
	public static int getRandomIntBetweenRange(int min, int max){
	    int x = (int) ((Math.random()*((max-min)+1))+min);
	    return x;
	}
	
	//prints all elements of ArrayList orders
	public static void printAllOrders() {
		for (int i=0; i<orders.size(); i++) {
			System.out.println(orders.get(i));
		}
	}
	
	//prints average number of products per order
	public static void printAverageNumberProductsPerOrder() {
		int sum = 0;
		for (int i=0; i<orders.size(); i++) {// goes through all elements of arrayList Orders and sums the number of the products of each order
			sum = sum + orders.get(i).order.size();
		}
		System.out.println(sum / orders.size());
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", location=" + location + ", customer=" + customer + ", date=" + date + ", order="
				+ order + "]";
	}
	
	
	
	
	
}
