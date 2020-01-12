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
	
	static int counter ;
	private int sumVolume;
	private int idcust;
	static int numRoutes;
	
	static final int CAPACITY_OF_ROUTE = 820;
	static int[][] sortArrayOfOrders;
	static ArrayList<VolumeSet> volumes = new ArrayList<VolumeSet>(); // Árraylist of data type int with customers' id
																	// and volume
	static int sumVol = 0;
	

	public VolumeSet(int a, int b) {
		sumVolume = a;
		idcust = b;
		volumes.add(this);
	}
	
	public VolumeSet(int idcust, int numRoutes, int sumVolume, int[][] sortArray) {
		super();
		this.idcust = idcust;
		VolumeSet.sortArrayOfOrders = sortArray;
		VolumeSet.numRoutes = numRoutes;
	}

	public VolumeSet() {
		// TODO Auto-generated constructor stub
	}
	
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
		int counter;

		for (int i = 0; i < Order.getOrders().size() ; i++) {
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
					+ volume5 * quantity5);

			// Arraylist with the volume of each customer's order and the corresponding id
			new VolumeSet(sumVolume, idcust);
			
		}
		sortArrayOfOrders = new int[volumes.size()][2];
		counter = 0;

		while (volumes.size() != 0) {
			int currentMax = 0;
			for (int i = 0; i < volumes.size() - 1; i++) { // isws -1
			
				if (currentMax < volumes.get(i).sumVolume) {
					currentMax = volumes.get(i).sumVolume;
					best_i = i;
				}
				sumVol = sumVol + volumes.get(i).sumVolume;
			}
			sortArrayOfOrders[counter][0] = currentMax;
			
			sortArrayOfOrders[counter][1] = volumes.get(best_i).idcust;
			
			counter++;
			//volumes.remove(best_i);
		}
		numRoutes = sumVol / CAPACITY_OF_ROUTE;
		System.out.println("Succesful return");
		return sortArrayOfOrders;
	}
	
	// int[][] bppArray = new int[numRoutes][sumcust+3];
	public static int[][] returnFinal() throws Exception {
		int finalRoutes[][] = new int[numRoutes][2];
		try {
			finalRoutes = OptimalPlacement.bestFit(sortArrayOfOrders, numRoutes, CAPACITY_OF_ROUTE, Customer.getCustomers().size() + 3);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return finalRoutes;
	}
	
	public static String[] printRoutes() throws Exception {
		int finalArray [][] = returnFinal();
		
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
	/*public static void main(String [] args) throws Exception {
		VolumeSet  l = new VolumeSet();
		System.out.println(l.sortOrders());*/
	}

