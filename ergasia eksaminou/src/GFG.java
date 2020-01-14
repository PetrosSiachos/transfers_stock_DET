/*
 * GFG
 * 
 * Copyright 2019 
 */

/** Places with the right and best way the orders on the routes through the method bestFit that returns the array pbbArray in the class VolumeSet. 
 * 
 * @version 
 * @author Petros Siachos, Melpomeni Konstantinou  
 */

public class GFG {

	public GFG() {
		super();
		// TODO Auto-generated constructor stub
	}

	static int[][] bestFit(int volume[][], int numberOfRoutes, int c, int k) {

		int[][] BppArray = new int[numberOfRoutes][k];

		// Create an array to store remaining space in routes there can be at most numberOfRoutes routes
		int bin_rem[] = new  int [numberOfRoutes];

		// Place orders one by one
		for (int i = 1; i <= numberOfRoutes; i++) {
		    	
		     int counter=2;
		     // Initialize minimum space left and index of best bin
		     int min = c + 1, bi = 0;

		     for (int j = 0; j < volume.length; j++) {
		         if (bin_rem[i] >= volume[j][0] && bin_rem[i] - volume[j][0] < min) {
		            bi = i;
		            min = bin_rem[i] - volume[j][0];
		            BppArray[i][counter] = volume[j][1];
		            counter++;
			        BppArray [i][0] = i;
			        BppArray [i][1] = 1;
			        BppArray [i][k-1] = 1;
		         }
		     }

		 }
		 return BppArray;
		 
	}

}


	

	

//