	// Java program to find number 
	// of bins required using 
	// best fit algorithm. 
	public class GFG { 

		
		public GFG() {
			super();
			// TODO Auto-generated constructor stub
		}

		static int[][] bestFit(int weight[][], int n, int c, int k) 
		{
			int[][] BppArray = new int[n][k];
		    // Initialize result (Count of bins) 
		    int res = 0; 
		    
		    // Create an array to store remaining space in bins 
		    // there can be at most n bins 
		    int bin_rem[] = new  int [n];
		    
		    // Place items one by one 
		    for (int i = 0; i < n; i++) { 
		        // Find the best bin that ca\n accomodate 
		        // weight[i] 
		        int j; 
		        int counter=1;
		        // Initialize minimum space left and index 
		        // of best bin 
		        int min = c + 1, bi = 0; 
		  
		        for (j = 0; j < res; j++) { 
		            if (bin_rem[j] >= weight[i][0] && bin_rem[j] - weight[i][0] < min) { 
		                bi = j; 
		                min = bin_rem[j] - weight[i][0]; 
		            } 
		        } 
		  
		        // If no bin could accommodate weight[i], 
		        // create a new bin 
		        if (min == c + 1) { 
		            bin_rem[res] = c - weight[i][0]; 
		            res++;
		            counter=1;
		            BppArray[i][counter]= weight[i][1];
		        	BppArray [i][0] = n;
		        } 
		        else // Assign the item to best bin 
		            bin_rem[bi] = bin_rem [bi] - weight[i][0]; 
		        	BppArray[i][counter]= weight[i][1];
		        	BppArray [i][0] = n;
		        	counter++;
		    } 
		    return BppArray; 
		} 
		  
		} 
	

	

//
