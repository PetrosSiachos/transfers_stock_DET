/*
 * VRP
 * 
 * Copyright 2019
 */

import java.util.Stack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/** Finds and prints for each itinerary the best (shortest) route between the locations the vehicle needs to visit in order to deliver the orders.
 * 
 * @version 
 * @author Melpomeni Konstantinou, Petros Siachos
 */

public class VRP {
		
	private int numberOfCustomers;
	private int[] nodesVisited;
	private Stack<Integer> stack;
		
	public VRP() {
		// TODO Auto-generated constructor stub
	}
	
	public VRP(int numCust, int[] visited) {
		this.numberOfCustomers = numCust;
		visited = new int[numCust + 1];// visited[1] is the depot. This array will have 0 if the specific node hasn't visited yet or 1 if it has.
		this.nodesVisited = visited;
		stack = new Stack<Integer>();
	}
		
	Connection con;
	String url = "jdbc:odbc:employeedb";
	Class.@forName(sun.jdbc.odbc.JdbcOdbcDriver);
	con = DriverManager.getConnection("jdbc:odbc:employeedb");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT * FROM DistanceMatrix");
	while (rs.next()) {
		// here we will get the elements (distances) from the table DistanceMatrix that will be created in a database.
		st.close();
	}
			
	con.close();
			
	System.out.println("The customers will be visited as follows:");
	VRP myVrp = new VRP();
	myVrp.VehicleRoutingProblem(DistanceMatrix, VolumeSet.finalRoutes, nodesVisited);

	public void VehicleRoutingProblem(int[][] distances, int[][] finalRoutes, int[] custVisited) {

		// loop for each route (index i) and interior loop for each customer that will be satisfied for the specific route (index j)
		for (int i = 1; i <= finalRoutes.length; i++) {
			System.out.printf("Route %d: " + i);
			custVisited[1] = 1;
			stack.push(1);
			int element;
			int bestId = 0;
			boolean flag = false;
			System.out.print(1 + "->");
					
			while (!stack.isEmpty()) {
				element = stack.peek();
				int min = Integer.MAX_VALUE;
						
				for (int j = 1; j < finalRoutes[i].length; j++) {
					if (finalRoutes[i][j] != 0) {
						if (custVisited[j] == 0) {
							if (distances [element][j] < min) {
								min = distances[element][j];
								bestId = j;
								flag = true;
							}
						}
					}
				}
				if (flag) {
					custVisited[bestId] = 1;
					stack.push(bestId);
					System.out.print(bestId + "->");
					flag = false;
				}
			}
			System.out.println(1);
					
		}
	}
		
}

}
