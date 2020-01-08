import java.util.ArrayList;

public class Purchase {

	static ArrayList<Stock> PurchaseStocks = new ArrayList<Stock>();
	static ArrayList<Stock> sumPurchaseStocks = new ArrayList<Stock>();
	static ArrayList<Integer> quantities = new ArrayList<Integer>();

	/*
	 * Ξ�Ξ―Ξ± Ξ»Ξ―ΟƒΟ„Ξ± Ο�Ο€ΞΏΟ… ΞΏΞΉ orders Ξ­Ο‡ΞΏΟ…Ξ½ Ο‡Ο‰Ο�ΞΉΟƒΟ„ΞµΞ― ΟƒΞµ
	 * stocks, Ξ±Ο€Ο� Ο„Ξ± ΞΏΟ€ΞΏΞ―Ξ± ΞΊΞ±ΞΉ Ξ±Ο€ΞΏΟ„ΞµΞ»ΞΏΟ�Ξ½Ο„Ξ±Ξ½
	 */
	public static void createPurchaseStocks() {
		for (int i = 0; i < Order.BlackList.size(); i++) {
			for (int k = 0; k < Order.BlackList.get(i).order.size(); k++) {
				PurchaseStocks.add(Order.BlackList.get(i).order.get(k));
			}
		}
	}

	/*
	 * Ξ”Ξ·ΞΌΞΉΞΏΟ…Ο�Ξ³ΞµΞ―Ο„Ξ±ΞΉ ΞΌΞ―Ξ± Ξ½ΞµΞ± Ξ»Ξ―ΟƒΟ„Ξ± Ο�Ο€ΞΏΟ… Ξ³ΞΉΞ± ΞΊΞ¬ΞΈΞµ
	 * id Ξ­Ο‡ΞµΞΉ Ο„ΞΉΟ‚ Ο€ΞΏΟƒΟ�Ο„Ξ·Ο„ΞµΟ‚ Ο€ΞΏΟ… Ξ±Ο€Ξ±ΞΉΟ„ΞΏΟ�Ξ½Ο„Ξ±ΞΉ Ξ±Ο€Ο�
	 * Ο„ΞΏΞ½ Ο€Ο�ΞΏΞΌΞ·ΞΈΞµΟ…Ο„Ξ®
	 */
	public static ArrayList<Stock> sumPurchaseStocks() {
		for (int i = 0; i < Stock.stocks.size(); i++) {
			quantities.add(0);
		}

		for (int i = 0; i < PurchaseStocks.size(); i++) {
			quantities.add((PurchaseStocks.get(i).id) - 1,
					quantities.get(PurchaseStocks.get(i).id - 1) + PurchaseStocks.get(i).quantity);

		}
		for (int i = 0; i < Stock.stocks.size(); i++) {
			sumPurchaseStocks.add(i, new Stock(i + 1, PurchaseStocks.get(i).price, quantities.get(i),
					PurchaseStocks.get(i).minQuantity));

		}
		return sumPurchaseStocks;

	}

	/*
	 * Ξ“ΞΉΞ± ΞΊΞ¬ΞΈΞµ Ο€Ο�ΞΏΟ�Ο�Ξ½ Ο„ΟƒΞµΞΊΞ¬Ο�Ο‰ Ο„ΞΏ minQuantity ΞΊΞ±ΞΉ
	 * Ξ²Ο�Ξ―ΟƒΞΊΟ‰ Ο„Ξ·Ξ½ Ο„ΞµΞ»ΞΉΞΊΞ® Ο€ΞΏΟƒΟ�Ο„Ξ·Ο„Ξ± Ο€ΞΏΟ… Ξ¶Ξ·Ο„Ο� Ξ±Ο€Ο�
	 * Ο„ΞΏΞ½ Ο€Ο�ΞΏΞΌΞ·ΞΈΞµΟ…Ο„Ξ®
	 */
	public static ArrayList<Stock> finalQuantities() {
		for (int i = 0; i < Stock.stocks.size(); i++) {
			if (sumPurchaseStocks.get(i).quantity > Stock.stocks.get(i).quantity) {
				int fquantity = sumPurchaseStocks.get(i).quantity - Stock.stocks.get(i).quantity
						+ Stock.stocks.get(i).minQuantity;
				sumPurchaseStocks.add(i,
						new Stock(i + 1, PurchaseStocks.get(i).price, fquantity, PurchaseStocks.get(i).minQuantity));
			} else {
				if (Stock.stocks.get(i).quantity
						- sumPurchaseStocks.get(i).quantity < Stock.stocks.get(i).minQuantity) {
					int fquantity = Stock.stocks.get(i).minQuantity;
					sumPurchaseStocks.add(i, new Stock(i + 1, PurchaseStocks.get(i).price, fquantity,
							PurchaseStocks.get(i).minQuantity));
				}
			}
		}
		return sumPurchaseStocks;
	}

	/*
	 * Ξ£Ο„ΞµΞ»Ξ½ΞµΞΉ Ο„Ξ± ΞΌΞ·Ξ½Ο�ΞΌΞ±Ο„Ξ± ΟƒΟ„ΞΏΞ½ Ο€Ο�ΞΏΞΌΞ·ΞΈΞµΟ…Ο„Ξ® ΞΌΞµ
	 * Ο„ΞΉΟ‚ Ο„ΞµΞ»ΞΉΞΊΞ­Ο‚ Ξ¶Ξ·Ο„ΞΏΟ�ΞΌΞµΞ½ΞµΟ‚ Ο€ΞΏΟƒΟ�Ο„Ξ·Ο„ΞµΟ‚ ΞΊΞ±ΞΉ
	 * Ξ±Ξ½Ξ±Ξ½ΞµΟ�Ξ½ΞµΟ„Ξ±ΞΉ Ξ· Stocks
	 */
	public static void messages() {

		for (int i = 0; i < sumPurchaseStocks.size(); i++) {
			System.out.println("We need " + sumPurchaseStocks.get(i).quantity + " of product with id "
					+ sumPurchaseStocks.get(i).id);
			Stock.stocks.add(i, sumPurchaseStocks.get(i));

		}

	}

	/*
	 * Ξ‘Ξ½Ξ±Ξ½ΞµΟ�Ξ½ΞΏΞ½Ο„Ξ±ΞΉ ΞΏΞΉ Ο€Ξ±Ο�Ξ±ΞΊΞ¬Ο„Ο‰ Ξ»Ξ―ΟƒΟ„ΞµΟ‚ Ξ±Ο†ΞΏΟ�
	 * Ξ­Ο‡ΞΏΟ…Ξ½ Ξ³Ξ―Ξ½ΞµΞΉ ΞΏΞΉ Ο€Ο�ΞΏΞΌΞ®ΞΈΞµΞΉΞµΟ‚
	 */
	public static void refreshLists() {
		for (int i = 0; i < Order.BlackList.size(); i++) {
			Order.goodOrders.add(Order.BlackList.get(i));
			Order.BlackList.remove(i);
		}

	}

}