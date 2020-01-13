/*
 * VolumeSet
 * 
 * Copyright 2019
 */

package STOCKOVERFLOWPackage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Calculates the volume of each order and places the orders on the appropriate
 * route according to their volume in descending order through the method
 * bestFit of class OptimalPlacement.
 * 
 * @version
 * @authors Petros Siachos, Melpomeni Konstantinou
 */

public class VolumeSet {

	private int sumVolume;
	private int idcust;
	static int sumCust = Order.getOrders().size();
	static int numRoutes;
	static final int CAPACITY_OF_ROUTE = 820;
	static int[][] sortArrayOfOrders;
	static ArrayList<Integer> volumes = new ArrayList<Integer>(); // Αrraylist of data type int with customers' id
																	// and volume
	int sumVol = 0;

	public VolumeSet(int idcust, int sumVolume, int sumcust, int numRoutes, int[][] sortArray,
			ArrayList<Integer> volumes) {
		super();
		this.idcust = idcust;
		this.sumVolume = VolumeSet.sumCust = sumcust;
		VolumeSet.numRoutes = numRoutes;
		VolumeSet.sortArrayOfOrders = sortArray;
		VolumeSet.volumes = volumes;
	}

	public ArrayList<Integer> fillVolumes() {
		int idcust;
		int sumVolume;
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
		int volumeSize;
		int best_i;
		int metritis;

		for (int i = 0; i < Order.getOrders().size(); i++) {
			idcust = Order.getOrders().get(i).idcustomer;

			quantity1 = Order.getOrders().get(i).quantity1;
			prodid1 = Order.getOrders().get(i).idproduct1;
			int volume1;
			quantity2 = Order.getOrders().get(i).quantity2;
			prodid2 = Order.getOrders().get(i).idproduct2;
			int volume2;
			quantity3 = Order.getOrders().get(i).quantity3;
			prodid3 = Order.getOrders().get(i).idproduct3;
			int volume3;
			quantity4 = Order.getOrders().get(i).quantity4;
			prodid4 = Order.getOrders().get(i).idproduct4;
			int volume4;
			quantity5 = Order.getOrders().get(i).quantity5;
			prodid5 = Order.getOrders().get(i).idproduct5;
			int volume5;

			for (int y = 0; y < Stock.getStocks().size(); y++) {
				if (prodid1 == Stock.getStocks().get(y).id) {
					volume1 = Stock.getStocks().get(y).volume;
				} else if (prodid2 == Stock.getStocks().get(y).id) {
					volume2 = Stock.getStocks().get(y).volume;
				} else if (prodid3 == Stock.getStocks().get(y).id) {
					volume3 = Stock.getStocks().get(y).volume;
				} else if (prodid4 == Stock.getStocks().get(y).id) {
					volume4 = Stock.getStocks().get(y).volume;
				} else if (prodid5 == Stock.getStocks().get(y).id) {
					volume5 = Stock.getStocks().get(y).volume;
				}
			}
			sumVolume = (volume1 * quantity1 + volume2 * quantity2 + volume3 * quantity3 + volume4 * quantity4
					+ volume5 * quantity5);

			// Arraylist with the volume of each customer's order and the corresponding id
			volumes.add(sumVolume, idcust);
		}
		volumeSize = volumes.size();
		sortArrayOfOrders = new int[volumeSize][2];
		metritis = 0;

		while (volumes.size() != 0) {
			int currentMax = 0;
			for (int i = 0; i < volumes.size() - 1; i++) { // isws -1
				if (currentMax < volumes.get(i).sumVolume) {
					currentMax = volumes.get(i).sumVolume;
					best_i = i;
				}
				sumVol = sumVol + volumes.get(i).sumVolume;
			}
			sortArrayOfOrders[metritis][0] = currentMax;
			sortArrayOfOrders[metritis][1] = volumes.get(best_i).idcust;
			metritis++;
			volumes.remove(best_i);
		}
		numRoutes = sumVol / CAPACITY_OF_ROUTE;
		return volumes;
	}

	// int[][] bppArray = new int[numRoutes][sumcust+3];
	static int finalRoutes[][] = OptimalPlacement.bestFit(sortArrayOfOrders, numRoutes, CAPACITY_OF_ROUTE, sumCust + 3);

	public static String[] printRoutes() {
		String[] results = new String[numRoutes];
		for (int i = 1; i <= numRoutes; i++) {
			results[i - 1] = "Route" + finalRoutes[i][0] + ":";
			for (int j = 1; j < finalRoutes[i].length; j++) {
				if (finalRoutes[i][j] != 0) {
					results[i] = results[i] + finalRoutes[i][j] + " ";
				}
			}
		}
		return results;
	}

}
