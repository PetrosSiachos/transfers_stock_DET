/*
 * VolumeSet
 * 
 * Copyright 2019
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

/** Calculates the volume of each order and places the orders on the appropriate route according to their volume in descending order through the method bestFit of class GFG.
 * 
 * @version  
 * @author Petros Siachos, Melpomeni Konstantinou 
 */

public class VolumeSet {
	
	static int sumcust = Order.numberofcustomers();
	static int numRoutes;
	static final int CAPACITY_OF_ROUTE = 820;
	static int[][] sortArray; 
	static ArrayList<Integer> volumes = new ArrayList<Integer> (); // Αrraylist of data type int with customers' id, locations' id and volume
	int sumVolume = 0;
	private int idcust;
	private int location;
	private int volume;
	 
	public VolumeSet(int idcust, int location, int volume, int sumcust, int numRoutes, int[][] sortArray,
			ArrayList<Integer> volumes) {
		super();
		this.idcust = idcust;
		this.location = location;
		this.volume = volume;
		VolumeSet.sumcust = sumcust;
		VolumeSet.numRoutes = numRoutes;
		VolumeSet.sortArray = sortArray;
		VolumeSet.volumes = volumes;
	}

	// method that fills the arrayList volumes with idcust, location and volume
		public ArrayList<Integer> volumes() {
			int location;
			int volume;
			int quantity;
			int prodid;
			int numVolume;
			int idcust;
			int volumeSize;
			int metritis;
			int best_i;

			for (int i = 0; i < Order.goodOrders.size(); i++) {
				location = Order.goodOrders.get(i).location;
				idcust = Order.goodOrders.get(i).idcust;

				for (int y = 0; y < Order.order.size(); y++) {
					quantity = Order.goodOrders.get(i).order.get(y).quantity;
					prodid = Order.goodOrders.get(i).order.get(y).id;

					Connection con = getConnection();
					String query = "SELECT * FROM prodvolumes";

					// create the java statement
					Statement st = con.createStatement();

					// execute the query, and get a java resultset
					ResultSet rs = st.executeQuery(query);

					while (rs.next()) {
						int id = rs.getInt("idprod");
						if (prodid == id) {
							numVolume = rs.getInt("volume");
						}
						st.close();
					}
					volume = numVolume*quantity; 
					sumVolume = sumVolume + volume; // The total volume of a customer's entire order 
				}
			
				// Arraylist with the volume of each customer's order and the corresponding id
				volumes.add(sumVolume, idcust);

			}
			volumeSize = volumes.size();
			sortArray = new int[volumeSize][2];
			metritis = 0;
			
			while (volumes.size() != 0) {
			int currentMax = 0;
				for (int i = 0; i < volumes.size() - 1; i++){
					if(currentMax < volumes.get(i).sumVolume){
						currentMax = volumes.get(i).sumVolume;
						best_i = i;
					}
				}
				sortArray [metritis][0] = currentMax;
				sortArray [metritis][1] = volumes.get(best_i).idcust;
				metritis++;
				volumes.remove(best_i);
			}

			return volumes;
			for (int i = 0; i < volumes.size(); i++)
				sumVolume = sumVolume + volumes.get(i).sumVolume;
			
				numRoutes = sumVolume / CAPACITY_OF_ROUTE;

		}
		
		//int[][] bppArray = new int[numRoutes][sumcust+3];   
		static int  finalRoutes [][] = GFG.bestFit(sortArray, numRoutes, CAPACITY_OF_ROUTE, sumcust+3);

		public static void printRoutes () {
			for (int i = 1; i <= numRoutes; i++) {
				System.out.print("Το δρομολόγιο  " + finalRoutes [i][0] + "θα ικανοποιήσει τους πελάτες μεa id:" );


	            for (int j = 1; j <  finalRoutes[i].length; j++) {
	            	if (finalRoutes [i][j] != 0)
	                System.out.println(finalRoutes [i][j]);
	            }
			}
		}

		private Connection getConnection() {
			// TODO Auto-generated method stub
			return null;
		}

}

