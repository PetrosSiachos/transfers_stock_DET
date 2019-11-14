import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*; 

public class VolumeSet {
	int idcust;
	int location;
	int volume;
	static int sumcust = Order.customer;
	static int numDromologia;
	static int c = 820;
	static int[][] SortArray;
	
	
	public ArrayList<Integer> volumes = new ArrayList<Integer> (); // arraylist typou int me idcust, location kai ogkoys

	
	

	
	public VolumeSet(int idcust, int location, int volume, int sumcust, int numDromologia, int[][] sortArray,
			ArrayList<Integer> volumes, int[][] finalBins) {
		super();
		this.idcust = idcust;
		this.location = location;
		this.volume = volume;
		this.sumcust = sumcust;
		this.numDromologia = numDromologia;
		SortArray = sortArray;
		this.volumes = volumes;
		FinalBins = finalBins;
	}


	// method that fills arrayList volumes with idcust,location,volume
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
						
			

			for (int i=0; i<Order.goodOrders.size(); i++) {
				quantity = Order.goodorders.order.quantity.get(i);
				prodid = Order.goodorders.order.id.get(i);
				location = Order.goodorders.location.get(i);
				idcust = Order.goodorders.idcust.get(i);
				
				Connection con = getConnection();
				String query = "SELECT * FROM prodvolumes";

			      // create the java statement
			      Statement st = con.createStatement();
			      
			      // execute the query, and get a java resultset
			      ResultSet rs = st.executeQuery(query);
			      
			      while (rs.next())
			      {
			        int id = rs.getInt("idprod");
			        if (prodid == id) {
			        	numVolume = rs.getInt("volume");
			        }	        		        
			      st.close();
			    }
			    volume = numVolume*quantity;
			// thelei na ftiaksoyme allh mia for loop
			    int SUMvol=SUMvol + volume; // to sinolo tou ogkoy olhs ths paragelias toy enos pelati
			    
			    //arraylist me ton ogko tis paragelias toy kathe pelati
			    volumes.add(SUMvol, idcust);
			    volumeSize = volumes.size();
			}
			
			SortArray = new int[volumeSize][2];
			
			metritis = 0;
			while (volumes.size() != 0) {
			int currentMax =0;
			for (int i=0; i<volumes.size()-1; i++){
				if(currentMax < volumes.SUMvol.get(i)){
					currentMax = volumes.SUMvol.get(i);
					best_i=i;
				}				
				}
				SortArray [metritis][0] = currentMax;
				SortArray [metritis][1] = volumes.idcust.get(best_i);
				metritis++;
				volumes.remove(best_i);
			}
			
			return volumes;
			int sumVolume = 0;
			for (int i=0; i<volumes.size(); i++) 
				sumVolume= sumVolume + volumes.SUMvol.get(i);
			numDromologia = sumVolume / c;
			
			
			
			
}	
		//int[][] BppArray = new int[numDromologia][sumcust+1];
		
		static int  FinalBins [][] = GFG.bestFit(SortArray, numDromologia, c, sumcust+1);
		
		public static void DromologiaPrint () {
			for (int i = 0; i <= numDromologia; i++) {
				System.out.print("Το δρομολόγιο " + FinalBins [i][0] + "θα ικανοποιήσει τους πελάτες με id:" ); 
			
			
	            for (int j = 0; j <  FinalBins.length; j++) {
	            	if (FinalBins [i][j]!=0)
	                System.out.println(FinalBins [i][j]);
	            	}
			}
			}
		
		private Connection getConnection() {
			// TODO Auto-generated method stub
			return null;
		}
		
}

//https://www.geeksforgeeks.org/multidimensional-arrays-in-java/
//https://www.cs.amherst.edu/alglab/exactbinpacklab/index.html
//https://www.geeksforgeeks.org/bin-packing-problem-minimize-number-of-used-bins/
