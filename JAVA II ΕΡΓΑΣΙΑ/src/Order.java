import java.util.ArrayList; 
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;
public class Order {
	int idorder; 
	int idcustomer;
	String namecustomer; 
	String date_of_order;
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
	static int numberofproducts;
	static int sumproducts = 0;
	static int numberoforders = 0 ;
	static int numberofgoodorders = 0;
	static int numberofBlackList = 0;
	static String FIND = "FALSE";
	
	static ArrayList<Order> orders = new ArrayList<Order>(); // an arrayList of all orders
	static ArrayList<Order> goodOrders = new ArrayList<Order>(); // an arrayList of all orders that CAN we fulfilled 
	static ArrayList<Order> BlackList = new ArrayList<Order>(); // an arrayList of all orders that CANT be fulfilled
	static ArrayList<Integer> numberOfProducts = new ArrayList<Integer>();// an arrayList of number of products per order px. orderId=1 number=2,orderId=2 number=3
	// SOSSSS numberOfProducts = 2 = banana + orange = NOT 2 bananas
	static ArrayList<Integer> idproducts =new ArrayList<Integer>();
	
	public Order(int idorder, int idcustomer, String namecustomer, String date_of_order, int idproduct1, String nameproduct1, int quantity1, double price1, 
			int idproduct2, String nameproduct2, int quantity2, double price2, int idproduct3, 
			String nameproduct3, int quantity3, double price3, int idproduct4, String nameproduct4,
			int quantity4, double price4, int idproduct5, String nameproduct5, int quantity5, double price5) { 
		super();
		this.idorder = idorder;
		this.idcustomer = idcustomer;
		this.namecustomer = namecustomer;
		this.date_of_order = date_of_order;
		numberoforders++;//metraw paraggelies
		this.idproduct1 = idproduct1;
		this.nameproduct1 = nameproduct1;
		this.quantity1 = quantity1;
		this.price1 = price1;
		this.idproduct2 = idproduct2;
		this.nameproduct2 = nameproduct2;
		this.quantity2 = quantity2;
		this.price2 = price2;
		this.idproduct3 = idproduct3;
		this.nameproduct3 = nameproduct3;
		this.quantity3 = quantity3;
		this.price3 = price3;
		this.idproduct4 = idproduct4;
		this.nameproduct4 = nameproduct4;
		this.quantity4 = quantity4;
		this.price4 = price4;
		this.idproduct5 = idproduct5;
		this.nameproduct5 = nameproduct5;
		this.quantity5 = quantity5;
		this.price5 = price5;
		orders.add(this);
		JOptionPane.showMessageDialog(null,"Lets see the orders for today:");
		JOptionPane.showMessageDialog(null,this);
			FIND = "FALSE";
		for (int y = 0 ; y < orders.size() ; y++) {
		for(int i = 0; i < Stock.stocks.size() ; i++) {
			if (orders.get(y).idproduct1 == Stock.stocks.get(i).id) {
				if (orders.get(y).quantity1 > Stock.stocks.get(i).stock) {
					BlackList.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA BLACKLIST
					numberofBlackList++;
					JOptionPane.showMessageDialog(null,"We need more of this product me id: " +  orders.get(y).idproduct1);
					break;
				//Estw oti o xrhsths thelei na agorasei 3 proionta.Vlepo an kapoio apo ayta yparxei eleima.tote Olh h paraggelia tha bei blacklist
				} 
			}
			if (orders.get(y).idproduct2 == Stock.stocks.get(i).id) {
				if (orders.get(y).quantity2 > Stock.stocks.get(i).stock) {
					FIND = "TRUE";
					BlackList.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA BLACKLIST
					numberofBlackList++;
					JOptionPane.showMessageDialog(null,"We need more of this product me id: " +  orders.get(y).idproduct1);
				//Estw oti o xrhsths thelei na agorasei 3 proionta.Vlepo an kapoio apo ayta yparxei eleima.tote Olh h paraggelia tha bei blacklist
				} 
			}
			if (orders.get(y).idproduct3 == Stock.stocks.get(i).id) {
				if (orders.get(y).quantity3 > Stock.stocks.get(i).stock) {
					BlackList.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA BLACKLIST
					numberofBlackList++;
					JOptionPane.showMessageDialog(null,"We need more of this product me id: " +  orders.get(y).idproduct1);
				//Estw oti o xrhsths thelei na agorasei 3 proionta.Vlepo an kapoio apo ayta yparxei eleima.tote Olh h paraggelia tha bei blacklist
				} 
			}
			if (orders.get(y).idproduct4 == Stock.stocks.get(i).id) {
				if (orders.get(y).quantity4 > Stock.stocks.get(i).stock) {
					FIND = "TRUE";
					BlackList.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA BLACKLIST
					numberofBlackList++;
					JOptionPane.showMessageDialog(null,"We need more of this product me id: " +  orders.get(y).idproduct1);
				//Estw oti o xrhsths thelei na agorasei 3 proionta.Vlepo an kapoio apo ayta yparxei eleima.tote Olh h paraggelia tha bei blacklist
				} 
			}
			if (orders.get(y).idproduct5 == Stock.stocks.get(i).id) {
				if (orders.get(y).quantity5 > Stock.stocks.get(i).stock) {
					FIND = "TRUE";
					BlackList.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA BLACKLIST
					numberofBlackList++;
					JOptionPane.showMessageDialog(null,"We need more of this product me id: " +  orders.get(y).idproduct1);
				//Estw oti o xrhsths thelei na agorasei 3 proionta.Vlepo an kapoio apo ayta yparxei eleima.tote Olh h paraggelia tha bei blacklist
				} 
			}
			}
		}
	
		if (FIND.equals("FALSE")){
			goodOrders.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA GOOD
		for (int y = 0 ; y < orders.size() ; y++) {
			for(int i = 0; i < Stock.stocks.size() ; i++){
			if (orders.get(y).idproduct1 == Stock.stocks.get(i).id) {
				JOptionPane.showMessageDialog(null,"FOR " +  orders.get(y).nameproduct1);
				JOptionPane.showMessageDialog(null,"Before");
				JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		Stock.stocks.get(i).stock = Stock.stocks.get(i).stock- orders.get(y).quantity1 ;
		JOptionPane.showMessageDialog(null,"After");
		JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		//ENHMERONO TA STOCKS EFOSON DO OTI H PARGGELIA EINAI GOOD
			}
			if (orders.get(y).idproduct2 == Stock.stocks.get(i).id) {
				JOptionPane.showMessageDialog(null,"FOR " +  orders.get(y).nameproduct2);
				JOptionPane.showMessageDialog(null,"Before");
				JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		Stock.stocks.get(i).stock = Stock.stocks.get(i).stock- orders.get(y).quantity2 ;
		JOptionPane.showMessageDialog(null,"After");
		JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		//ENHMERONO TA STOCKS EFOSON DO OTI H PARGGELIA EINAI GOOD
			}
			if (orders.get(y).idproduct3 == Stock.stocks.get(i).id) {
				JOptionPane.showMessageDialog(null,"FOR " +  orders.get(y).nameproduct3);
				JOptionPane.showMessageDialog(null,"Before");
				JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		Stock.stocks.get(i).stock = Stock.stocks.get(i).stock- orders.get(y).quantity3 ;
		JOptionPane.showMessageDialog(null,"After");
		JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		//ENHMERONO TA STOCKS EFOSON DO OTI H PARGGELIA EINAI GOOD
			}
			if (orders.get(y).idproduct4 == Stock.stocks.get(i).id) {
				JOptionPane.showMessageDialog(null,"FOR " +  orders.get(y).nameproduct4);
				JOptionPane.showMessageDialog(null,"Before");
				JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		Stock.stocks.get(i).stock = Stock.stocks.get(i).stock- orders.get(y).quantity4 ;
		JOptionPane.showMessageDialog(null,"After");
		JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		//ENHMERONO TA STOCKS EFOSON DO OTI H PARGGELIA EINAI GOOD
			}
			if (orders.get(y).idproduct5 == Stock.stocks.get(i).id) {
				JOptionPane.showMessageDialog(null,"FOR " +  orders.get(y).nameproduct5);
				JOptionPane.showMessageDialog(null,"Before");
				JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		Stock.stocks.get(i).stock = Stock.stocks.get(i).stock- orders.get(y).quantity5 ;
		JOptionPane.showMessageDialog(null,"After");
		JOptionPane.showMessageDialog(null,Stock.stocks.get(i).stock);
		//ENHMERONO TA STOCKS EFOSON DO OTI H PARGGELIA EINAI GOOD
			}
		}
	}
		numberofgoodorders++;

		} else {
			BlackList.add(this);//VAZO OLH THN PARAGGELIA ME OLA TA STOIXEIA STHN KATHGORIA BLACKLIST
			numberofBlackList++;
		}
		sumproducts = sumproducts + numberofproducts;
	}
	// method that creates random numbers from min-max
	public static int getRandomIntBetweenRange(int min, int max){
	    int x = (int) ((Math.random()*((max-min)+1))+min);
	    return x;
	}
	
	//prints all elements of ArrayList orders
	public static int printAllOrders() {
		for (int i=0; i<orders.size(); i++) {
			System.out.println(orders.get(i));
		}
		return numberoforders;
	}
	
	//prints average number of products per order
	public static double printAverageNumberOfProducts() {
		return sumproducts/numberoforders;
	}
	
	public static int printGoodOrders() {
		for (int i=0; i<goodOrders.size(); i++) {
			System.out.println(goodOrders.get(i));
		}
		return numberofgoodorders;
	}
	
	public static int printBlackList() {
		for (int i=0; i<BlackList.size(); i++) {
			System.out.println(BlackList.get(i));
		}
		return numberofBlackList;
	}


	@Override
	public String toString() {
		return "Order [idorder=" + idorder + ", idcustomer=" + idcustomer + ", namecustomer=" + namecustomer
				+ ", date_of_order=" + date_of_order + "]";
	}
}
