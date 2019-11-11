import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;
public class Order {
	int idcust; 
	static int counter = 1;
	int location;
	static int counter2 = 1;
	int customer; 
	java.util.Date date;
	Scanner in = new Scanner(System.in);
	static int numberofproducts;
	static int sumproducts = 0;
	static int numberoforders =0 ;
	static int numberofgoodorders = 0;
	static int numberofBlackList = 0;
	static String FIND = "FALSE";
	
	
	ArrayList<Stock> order = new ArrayList<Stock>(); // an arrayList of all stocks of an order
	static ArrayList<Order> orders = new ArrayList<Order>(); // an arrayList of all orders
	static ArrayList<Order> goodOrders = new ArrayList<Order>(); // an arrayList of all orders that CAN we fulfilled 
	static ArrayList<Order> BlackList = new ArrayList<Order>(); // an arrayList of all orders that CANT be fulfilled
	static ArrayList<Integer> numberOfProducts = new ArrayList<Integer>();// an arrayList of number of products per order px. orderId=1 number=2,orderId=2 number=3
	// SOSSSS numberOfProducts = 2 = banana + orange = NOT 2 bananas
	static ArrayList<Integer> idproducts =new ArrayList<Integer>();
	
	public Order(int customer) {
		super();
		this.idcust = counter++;
		this.location = counter2++;
		this.customer = customer;
		this.date = setDate();
		numberoforders++;//metraw paraggelies
		do {
			String fn = JOptionPane.showInputDialog("Please tell me how many products do you want to buy:");
			int numberofproducts = Integer.parseInt(fn);
			
			//mou dinei o xrhsths posa thelei na agorasei
			if (numberofproducts > Stock.stocks.size()) {
				System.out.println(" Please buy until: " + (Stock.stocks.size()) + " products ");//tou vazo periorismo mexri osa exw sta stocks
			}
		} while (numberofproducts > Stock.stocks.size());
		
			this.order = setOrder();
			FIND = "FALSE";
		for (int y = 0 ; y < order.size() ; y++) {
		for(int i = 0; i < Stock.stocks.size() ; i++) {
			if (order.get(y).id == Stock.stocks.get(i).id) {
				if (order.get(y).quantity > Stock.stocks.get(i).quantity) {
					FIND = "TRUE";
					System.out.println("We need more of this product me id: " +  order.get(y).id );
				//Estw oti o xrhsths thelei na agorasei 3 proionta.Vlepo an kapoio apo ayta yparxei eleima.tote Olh h paraggelia tha bei blacklist
				} 
			}
			}
		}
	
		if (FIND.equals("FALSE")){
			goodOrders.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA GOOD
		for (int y = 0 ; y < order.size() ; y++) {
			for(int i = 0; i < Stock.stocks.size() ; i++){
			if (order.get(y).id == Stock.stocks.get(i).id) {
				System.out.println("FOR " +  order.get(y));
				System.out.println("Before");
		System.out.println(Stock.stocks.get(i).quantity);
		Stock.stocks.get(i).quantity = Stock.stocks.get(i).quantity - order.get(y).quantity ;
		System.out.println("After");
		System.out.println(Stock.stocks.get(i).quantity);
		System.out.println();//ENHMERONO TA STOCKS EFOSON DO OTI H PARGGELIA EINAI GOOD
			}
		}
	}
		numberofgoodorders++;

		} else {
		BlackList.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA BLACKLIST
		numberofBlackList++;
		}
		
		orders.add(this);
		sumproducts = sumproducts + numberofproducts;
		
		
		}
	

	// method that fills arrayList order with stocks
	public ArrayList<Stock> setOrder() {
		int idpr=0;
		double price = 0;
		int quantity;
		int minQuantity = 0;
		int l =-1;
		
		for (int i = 0 ; i < numberofproducts  ; i ++) {
			l++;
			
					idpr = getRandomIntBetweenRange(1 , Stock.stocks.size() );
					idproducts.add(i,idpr);
					//de thelw na dvsei idio id proiontos o idios pelaths opote apaitw na einai diaforetika, to l xrhsimopoieitai opws kai meta
				quantity = getRandomIntBetweenRange (1 , 10000);// quantity is between 1 and 10000(big number)
			
			for (int k = 0 ; k < Stock.stocks.size() ; k++) {// goes through arrayList stocks of Stock and finds the object of the arrayList 
				if (Stock.stocks.get(k).id == idpr) { //where object.id=id given and sets price= price of object with id
					
					price = Stock.stocks.get(k).price;
					minQuantity = Stock.stocks.get(k).minQuantity;
					//TO l TO EXW ETSI OSTE SE KATHE PARAGGELIA NA XEKINAEI O PINAKAS ORDER APO TH THESH 0 GIA EYKOLIA MOU;
					 }
			}
			order.add(l,new Stock (idpr , price , quantity , minQuantity ));
			System.out.println(order);
			
				
			
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
	public static void printAverageNumberOfProducts() {
		System.out.println(sumproducts/numberoforders);
	}
	
	public static void printGoodOrders() {
		for (int i=0; i<goodOrders.size(); i++) {
			System.out.println(goodOrders.get(i));
		}
		System.out.println(numberofgoodorders);
	}
	
	public static void printBlackList() {
		for (int i=0; i<BlackList.size(); i++) {
			System.out.println(BlackList.get(i));
		}
		System.out.println(numberofBlackList);
	}
		
	
	@Override
	public String toString() {
		return "Order [idcust=" + idcust + ", location=" + location + ", customer=" + customer + ", date=" + date + ", order="
				+ order + "]";
	}
}