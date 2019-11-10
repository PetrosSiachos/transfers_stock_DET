//this is the class where we control the programm
//LETS HAVE FUN
public class Main {
public static void main (String [] args) {
		Stock a1 = new Stock(3.5 , 1400 , 10);
		Stock a2 = new Stock(4.5 , 60000, 10);
		Stock a3 = new Stock (3.4 , 8000 , 9);
		Stock a4 = new Stock (4.5 , 12000 , 10);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		Stock.printAllStocks();
		Stock.printHighestQuantity();
		Stock.printLowestQuantity();
		Stock.printHighestQuantity();
		System.out.println();
		System.out.println("Hello,we have an order");
		Order O1 = new Order(1);
		System.out.println("Hello,we have an order");
		Order O2 = new Order(2);
		System.out.println("Hello,we have an order");
		Order O3 = new Order(3);
		System.out.println();
		Order.printGoodOrders();
		System.out.println();
		Order.printBlackList();
		System.out.println();
		Order.printAllOrders();
		System.out.println();
		Order.printAverageNumberOfProducts();
		System.out.println();
		System.out.println();
		}
}
