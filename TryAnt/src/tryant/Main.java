package tryant;

public class Main {
	
	//klasi pou periexei tin dimiourgia ton proionton
	
	//iparxoun dinatotita dimiourgias mono 3 proionton, prepei na prostethoun kai alla
		
		public static void main (String [] args) {
			Stock a1 = new Stock(3 , 1400 , 10);
			Stock a2 = new Stock(4 , 60000, 10);
			Stock a3 = new Stock(6 , 8000 , 9);
			Stock a4 = new Stock(5 , 12000 , 10);
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			System.out.println(a4);
			Stock.printAllStocks();
			Stock.printHighestQuantity();
			Stock.printLowestQuantity();
			System.out.println();
			System.out.println("Hello, we have an order!");
			new Order(1);
			System.out.println("Hello, we have an order!");
			new Order(2);
			System.out.println("Hello, we have an order!");
			new Order(3);
			System.out.println();
			Order.printGoodOrders();
			System.out.println();
			Order.printBlackList();
			System.out.println();
			Order.printAllOrders();
			System.out.println();
			Order.printAverageNumberOfProducts();
			System.out.println();
		}
	}
