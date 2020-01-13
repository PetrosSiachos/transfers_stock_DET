/*
 * VolumeSet
 * 
 * Copyright 2020
 */

package STOCKOVERFLOWPackage;

import java.util.ArrayList;




/**
 * Calculates the volume of each order and places the orders on the appropriate
 * route according to their volume in descending order through the method
 * bestFit of class OptimalPlacement.
 * 
 * @authors Petros Siachos, Menia Konstantinou
 */

public class VolumeSet {

	/** The total amount of routes */
	static int numRoutes;
	/** The maximum capacity of each route */
	static final int CAPACITY_OF_ROUTE = 1830;
	/** The array that will contain the orders sorted in descending order */
	static int[][] sortArrayOfOrders;
	/**
	 * ArrayList that will be filled with the volume of each order and the id of the
	 * corresponding customer
	 */
	static ArrayList<VolumeSet> volumes = new ArrayList<VolumeSet>();
	/** Initialize the total volume of all orders */
	static int sumVol = 0;
	/** The volume of each order */
	private int sumVolume;
	/** The id of each customer */
	private int idcust;

	public VolumeSet(int sumVolume, int idcust) {
		this.sumVolume = sumVolume;
		this.idcust = idcust;
		volumes.add(this);
	}

	public VolumeSet() {
		super();
	}

	/**
	 * Returns a two-dimensional array of data type int with the orders sorted in
	 * descending order and the id of the corresponding customer. This method uses a
	 * loop for each order and accesses the ArrayList "orders" through the method
	 * "getOrders()" of class Order and the ArrayList "stocks" through the method
	 * "getStocks()" of class Stock to store the customer's id, the id, the quantity
	 * and the volume of each product ordered by the customer. Then, it calculates
	 * the total volume of each order and add it in the ArrayList "volumes" with the
	 * id of the corresponding customer. After that, if finds the largest volume
	 * order from the ArrayList "volumes" each time and saves it in the array
	 * "sortArrayOfOrders" that the method returns. It also calculates the sum of
	 * the volume of all orders and by using this sum and the capacity of routes it
	 * computes the total number of itineraries.
	 * 
	 * @return the two-dimensional array "sortArrayOfOrders" of data type int filled
	 *         with the orders sorted in descending order
	 * @throws Exception
	 */
	public int[][] sortOrders() throws Exception {
		int quantity1;
		int prodid1;
		int quantity2;
		int prodid2;
		int quantity3;
		int prodid3;
		int quantity4;
		int prodid4;
		int quantity5;
		int prodid5;
		int best_i = 0;
		int bi = 0;
		int counter;

		for (int i = 0; i < Order.getOrders().size(); i++) {
			idcust = Order.getOrders().get(i).idcustomer;

			prodid1 = Order.getOrders().get(i).idproduct1;
			quantity1 = Order.getOrders().get(i).quantity1;
			int volume1 = 0;
			boolean flag1 = false;
			prodid2 = Order.getOrders().get(i).idproduct2;
			quantity2 = Order.getOrders().get(i).quantity2;
			int volume2 = 0;
			boolean flag2 = false;
			prodid3 = Order.getOrders().get(i).idproduct3;
			quantity3 = Order.getOrders().get(i).quantity3;
			int volume3 = 0;
			boolean flag3 = false;
			prodid4 = Order.getOrders().get(i).idproduct4;
			quantity4 = Order.getOrders().get(i).quantity4;
			int volume4 = 0;
			boolean flag4 = false;
			prodid5 = Order.getOrders().get(i).idproduct5;
			quantity5 = Order.getOrders().get(i).quantity5;
			int volume5 = 0;
			boolean flag5 = false;

			for (int y = 0; y < Stock.getStocks().size(); y++) {
				if (prodid1 == Stock.getStocks().get(y).id) {
					volume1 = Stock.getStocks().get(y).volume;
					flag1 = true;
				} else if (prodid2 == Stock.getStocks().get(y).id) {
					volume2 = Stock.getStocks().get(y).volume;
					flag2 = true;
				} else if (prodid3 == Stock.getStocks().get(y).id) {
					volume3 = Stock.getStocks().get(y).volume;
					flag3 = true;
				} else if (prodid4 == Stock.getStocks().get(y).id) {
					volume4 = Stock.getStocks().get(y).volume;
					flag4 = true;
				} else if (prodid5 == Stock.getStocks().get(y).id) {
					volume5 = Stock.getStocks().get(y).volume;
					flag5 = true;
				}
				if (flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {
					break;
				}
			}
			sumVolume = (volume1 * quantity1 + volume2 * quantity2 + volume3 * quantity3 + volume4 * quantity4
					+ volume5 * quantity5); // Compute the volume of the specific order

			VolumeSet c = new VolumeSet(sumVolume, idcust);
			volumes.add(c); // Add the specific order (object c) in the ArrayList volumes
		}
		System.out.println(volumes.size());
		sortArrayOfOrders = new int[volumes.size() / 2][2];
		counter = 0;
		while (counter < sortArrayOfOrders.length) {
			int currentMax = 0;
			volumes.remove(bi);
			for (int i = 0; i < volumes.size(); i++) {
				if (i % 2 == 0) {
					if (currentMax < volumes.get(i).sumVolume) {
						currentMax = volumes.get(i).sumVolume;
						best_i = volumes.get(i).idcust;
						bi = i;
					}
				}
			}
			sumVol = sumVol + currentMax; // Calculate the sum of the volume of all orders
			sortArrayOfOrders[counter][0] = currentMax;
			sortArrayOfOrders[counter][1] = best_i;
			counter++;
			volumes.remove(bi);
		}
		numRoutes = sumVol / CAPACITY_OF_ROUTE + 1; // Calculate the total amount of routes
		return sortArrayOfOrders;
	}

	/**
	 * Returns a two-dimensional array of data type int with the orders
	 * (corresponding customers' id) that will be delivered by each route This
	 * method creates the array "finalRoutes" using the the method "bestFit" of
	 * class OptimalPlacement.
	 * 
	 * @return the two-dimensional array "finalRoutes" of data type int filled with
	 *         the orders (customers' id) that will be in a specific route
	 * @throws Exception
	 */
	public static int[][] returnFinal() throws Exception {
		int [][] finalRoutes = new int[numRoutes][Order.getOrders().size() + 3];
			try {
			finalRoutes = OptimalPlacement.bestFit(sortArrayOfOrders, numRoutes, CAPACITY_OF_ROUTE,
					Order.getOrders().size() + 3);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return finalRoutes;
	}

	/**
	 * Returns an array of data type String with the results of array "finalRoutes".
	 * This method creates creates this array that will have the contents of array
	 * "finalRoutes" in String form.
	 * 
	 * @return the array "results" of data type String with the contents of the
	 *         array "finalRoutes" in String form.
	 * @throws Exception
	 */
	public static String[] printRoutes() throws Exception {
		int finalArray[][] = returnFinal();

		String[] results = new String[numRoutes];
		for (int i = 0; i < numRoutes; i++) {
			results[i] = "Route" + finalArray[i][0] + ":";
			for (int j = 1; j < finalArray[i].length; j++) {
				if (finalArray[i][j] != 0) {
					results[i] = results[i] + finalArray[i][j] + " ";
				}
			}
		}
		return results;
	}

}
