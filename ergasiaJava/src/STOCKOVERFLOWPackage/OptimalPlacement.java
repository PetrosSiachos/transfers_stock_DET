/*
 * OptimalPlacement
 * 
 * Copyright 2019 
 */

/**
 * Places with the right and best way the orders on the routes through the
 * method bestFit that returns the array bppArray in the class VolumeSet.
 * 
 * @version
 * @authors Petros Siachos, Melpomeni Konstantinou
 */

package STOCKOVERFLOWPackage;

public class OptimalPlacement {

	public OptimalPlacement() {
		super();
	}

	/**
	 * Returns a two-dimensional array of data type int with the customers (nodes) that will be satisfied (visited)
	 * by each route.
	 * This method uses a loop for each order (index i) and an interior loop for each route (index j), 
	 * checks in turn the routes and stores one specific order in the first one that can satisfy it.
	 * Every time that one order is stored, the remaining space of the specific route decreases.
	 * 
	 * @param sortedOrders
	 * @param numberOfRoutes
	 * @param c
	 * @param k
	 * @return the two-dimensional array "bppArray" of data type int with the customers(nodes) that correspond 
	 * to each route  
	 */
	public static int[][] bestFit(int sortedOrders[][], int numberOfRoutes, int c, int k) {

		int[][] bppArray = new int[numberOfRoutes][k]; // The array with the customers that will be satisfied by each
													   // route
		int rem[] = new int[numberOfRoutes]; // Create an array to store the remaining space of routes
		bppArray[1][2] = sortedOrders[0][1]; // The first order will be placed in the first route
		rem[1] = c - sortedOrders[0][0]; 
		int min = c + 1; // Initialize minimum space left
		int bj = 0; // Initialize index of best route
		int counter1 = 3;
		int counter2 = 2;
		for (int i = 1; i < sortedOrders.length; i++) {
			for (int j = 1; j <= numberOfRoutes; j++) {
				if (j == 1) {
					if (rem[1] >= sortedOrders[i][0] && rem[1] - sortedOrders[i][0] < min) {
						bj = 1;
						min = rem[1] - sortedOrders[i][0];
						rem[1] = rem[1] - sortedOrders[i][0];
						bppArray[1][counter1] = sortedOrders[i][1];
						counter1++;
						bppArray[1][0] = 1;
						bppArray[1][1] = 1;
						bppArray[1][k - 1] = 1;
					}
				} else {
					rem[j] = c;
					if (rem[j] >= sortedOrders[i][0] && rem[j] - sortedOrders[i][0] < min) {
						bj = j;
						min = rem[j] - sortedOrders[i][0];
						rem[j] = rem[j] - sortedOrders[i][0];
						bppArray[j][counter2] = sortedOrders[i][1];
						counter2++;
						bppArray[j][0] = j;
						bppArray[j][1] = 1;
						bppArray[j][k - 1] = 1;
					}
				}
				break;
			}
		}
		return bppArray;
	}
}
