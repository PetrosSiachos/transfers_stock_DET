import java.util.Random;

public class VRP {

	private static int numberOfNodes;// count the sum of each route's nodes

	//method that fills an array nxn with the distances of all nodes. If we create this array in a database, then this method will not exist. It is temporary.
	public static void distancesOfNodes(int[][] finalRoutes) {

		Random randomNumbers = new Random();
		int[][] distances; // the array with distances between all customers
		distances = new int[VolumeSet.sumcust][VolumeSet.sumcust];

		// distances will be filled with random integer numbers (1-100) except for the
		// main diagonal (0 in all) because the array is nxn
		for (int i = 0; i < VolumeSet.sumcust; i++) {
			for (int j = 0; j < VolumeSet.sumcust; j++) {
				if (i != j) {
					distances[i][j] = 1 + randomNumbers.nextInt(100);
				} else {
					distances[i][j] = 0;
				}
			}
		}

		VRProblem(distances, finalRoutes);
	}

	//first view of the method that will implement the vehicle routing problem algorithm. It wants much more work.....
	public static void VRProblem(int[][] nodes, int[][] finals) {

		// loop for each route (index i) and interior loop for each customer that will
		// be satisfied for the specific route (index j)
		for (int i = 0; i < finals.length; i++) {
			numberOfNodes = finals[i].length - 1;//we exclude the  first column (route)
			for (int j = 1; j < finals[i].length; j++) {
				if (finals[i][j] == 0) { // some of them may not include a customer (value 0) so we don't count them
					numberOfNodes--;
				}
			}
			
			int min = 101;
			boolean flag = false;
			//in this point there will be possibly a condition (with an additional loop) that will check the right combinations of the nodes (according to the distances)
			
			
		}
		
		}
}



