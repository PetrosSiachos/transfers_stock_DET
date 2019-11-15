
import java.util.ArrayList;
import java.util.List;

public class Commissions {

	int idcom; /* είναι η θέση της λίστας sum όπου βρίσκεται ήδη ένας κωδικός προϊόντος */
	int q2; /* η ποσότητα που πρέπει να προμηθευτούμε */
	static boolean found;
	static double price;
	static int minQuantity;

	public Commissions(int idcom, int q2, double price, int minQuantity) {
		super();
		this.idcom = idcom;
		this.q2 = q2;
		this.price = price;
		this.minQuantity = minQuantity;
	}

	static ArrayList<Commissions> sum = new ArrayList<Commissions>(); /*
																		 * υπολογίζει το άθροισμα όλων των ποσοτήτων
																		 * κάθε προϊόντος της blacklist
																		 */
	/* static ArrayList<Integer> ids = new ArrayList<Integer>(); */

	public static ArrayList<Commissions> sum(ArrayList<Order> blackList) {

		for (int i = 0; i < Order.BlackList.size(); i++) {
			System.out.println(Order.BlackList.get(i));
			int id1 = Order.BlackList.get(i).idcust;
			int q1 = Order.BlackList.get(i).numberofproducts;
			found = false;
			for (int y = 0; y < Stock.stocks.size(); y++) {
				System.out.println(id1);
				System.out.println(q1);

				if (id1 == Stock.stocks.get(y).id) {
					System.out.println("same");
					found = true;
					if (q1 > Stock.stocks.get(y).quantity) {
						System.out.println("we need more of this quantiy");
						int q2 = q1 - Stock.stocks.get(y).quantity;

						if (sum.contains(id1)) {
							int number = sum.indexOf(id1);

							q2 = q2 + sum.get(number).q2;
							double price = Stock.stocks.get(y).price;
							int minQuantity = Stock.stocks.get(y).minQuantity;
							Commissions sum1 = new Commissions(id1, q2, price, minQuantity);
							sum.add(number, sum1);
							System.out.println(sum.get(number));

						} else {
							Commissions sum1 = new Commissions(id1, q2, price, minQuantity);
							sum.add(sum1);
							int number=sum.size();
							System.out.println(sum.get(number));
						}

					}
					break;
				}
			}
		}
		for (int x=0;x<sum.size();x++) {
			System.out.println(sum.get(x));
		}
		System.out.println(sum.size());
		return sum;
		
	}

	public static void messages(ArrayList<Commissions> sum) {
		System.out.println(sum.size());
		for (int i = 0; i < sum.size(); i++) {
			System.out.println("We need " + sum.get(i).q2 + "of product with id " + sum.get(i).idcom);

		}
	}

	public static ArrayList<Stock> newstocks(ArrayList<Stock> stocks, ArrayList<Commissions> sum) {
		for (int i = 0; i < Stock.stocks.size(); i++) {
			if (sum.contains(Stock.stocks.get(i).id)) {
				int number = sum
						.indexOf(Stock.stocks.get(i).id); /* η θέση που βρίσκεται το συγκεκριμένο id τη λίστα sum */
				Stock sum1 = new Stock(sum.get(number).idcom, sum.get(number).price, sum.get(number).q2,
						sum.get(number).minQuantity);
				Stock.stocks.add(i, sum1);
			}
		}
		return Stock.stocks;

	}

}
