/*
 * OptimumRoute
 * 
 * Copyright 2019
 */

package STOCKOVERFLOWPackage;

import java.util.Stack;
import java.util.Random;

/**
 * Finds for each itinerary the best (shortest) route between the locations the
 * vehicle needs to visit in order to deliver the orders.
 * 
 * @version
 * @authors Melpomeni Konstantinou, Petros Siachos
 */

public class OptimumRoute {

	/**
	 * nodesVisited is an array that will have 0 if the specific node hasn't visited
	 * yet or 1 if it has.
	 */
	int[] nodesVisited;
	/** Initialize this stack for the implementation of VRP */
	private static Stack<Integer> stack;

	public OptimumRoute(int[] visited) throws Exception {
		visited = new int[Customer.getCustomers().size() + 1]; // Visited[1] is the depot (starting point)
		this.nodesVisited = visited;
		stack = new Stack<Integer>();
	}

	public OptimumRoute() {
		super();
	}

	/**
	 * Returns a two-dimensional array of data type int nxn with the distances between all nodes. 
	 * This method uses the method nextInt of class Random in order to
	 * generate random integer numbers that will fill the array of distances
	 * except for the array's main diagonal that will be filled with 0. 
	 * 
	 * @return the two-dimensional nxn array "distances" of data type int filled with the distances
	 * @throws Exception 
	 */
	public static int[][] createDistances() throws Exception {

		int[][] distances; // The array with distances between all customers
		distances = new int[Order.getOrders().size() + 1][Order.getOrders().size() + 1];
		Random randomNumbers = new Random(); // Create an object of class Random
		
		for (int i = 0; i < Order.getOrders().size(); i++) {
			for (int j = 0; j < Order.getOrders().size(); j++) {
				if (i != j) {
					distances[i][j] = 1 + randomNumbers.nextInt(300);
				} else {
					distances[i][j] = 0;
				}
			}
		}
		return distances;
	}

	/**
	 * Returns an array of data type String with the shortest routes.
	 * This method uses the data structure "Stack" in order to 
	 * implement the Vehicle Routing Problem for 1 vehicle that runs multiple routes.
	 * More specifically, there is a loop for each route (index i) and interior loop 
	 * for each customer that will be satisfied for the specific route (index j).
	 * So, for each route and for each customer of this route, the method checks 
	 * which is the minimum distance, push the corresponding index of the node on
	 * the top of the stack and stores the results in an array of String.  
	 * 
	 * @param finalRoutes
	 * @param custVisited
	 * @return the array "result" of data type String with the best (shortest) routes
	 * @throws Exception 
	 */
	public static String[] implementTheVRP(int[][] finalRoutes, int[] custVisited) throws Exception {

		int[][] distanceMatrix; // The array with distances between all customers
		distanceMatrix = createDistances();
		String result[] = new String[finalRoutes.length + 1]; // The array with the result of the
															  // itineraries' shortest routes 	
		result[0] = "The customers will be visited as follows: ";
		for (int i = 0; i < finalRoutes.length; i++) {
			result[i+1] = "Route" + i+1 + ": ";
			custVisited[0] = 1; // Index 1 indicates the depot (starting point) so the "custVisited[1]" takes
								// the value 1 because it has been visited
			stack.push(0); // Push the depot on the top of the stack
			int index; // The node on the top of the stack that will be different each time
			int bestId = 1; 
			boolean flag = false;
			result[i+1] = result[i+1] + "1 -> ";

			while (!stack.isEmpty()) {
				index = stack.peek(); // Take the node that is on the top of the stack
				int min = Integer.MAX_VALUE; // The minimum distance

				for (int j = 0; j < finalRoutes[i].length; j++) {
					if (finalRoutes[i][j] != 0) {
						if (custVisited[j] == 0) {
							if (distanceMatrix[index][j] < min) {
								min = distanceMatrix[index][j];
								bestId = j;
								flag = true;
							}
						}
					}
				}
				if (flag) {
					custVisited[bestId] = 1;
					stack.push(bestId); // Push the specific node (bestId) on the top of the stack
					result[i+1] = result[i+1] + bestId + "->";
					flag = false;
					continue;
				}
				stack.pop();////?????
			}
			result[i+1] = result[i+1] + "1";
		}
		return result;
	}
}