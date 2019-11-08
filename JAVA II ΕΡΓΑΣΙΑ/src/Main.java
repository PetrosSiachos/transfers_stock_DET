
public class Main {

	public static void main (String [] args) {
		
		Stock a = new Stock(3.5 , 14 , 10);
		System.out.println(a);//Stock [id=1, price=3.5, quantity=14, minQuantity=10]
		System.out.println(new Stock(3.1 , 3 , 9)); // Stock [id=2, price=3.1, quantity=9, minQuantity=9] because q<minQ
		Stock.printAllStocks();
		Stock.printHighestQuantity();
		Stock.printLowestQuantity();
		new Stock(3.1 , 23 , 9);
		Stock.printHighestQuantity();
		System.out.println();
		
		Order nik = new Order(3);
		System.out.println(nik);//order=[Stock [id=2, price=0.0, quantity=1648, minQuantity=0], Stock [id=2, price=3.1, quantity=7879, minQuantity=9]]
		Order.printAllOrders();
		Order.printAverageNumberProductsPerOrder();
	}
}
