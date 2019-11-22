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
	static int sumcust ;
	static int numDromologia;
	static final int c = 820;
	static int[][] SortArray;
	int SUMvol=0;


	static ArrayList<Integer> volumes = new ArrayList<Integer> (); // arraylist typou int me idcust, location kai ogkoys





	public VolumeSet(int idcust, int location, int volume, int sumcust, int numDromologia, int[][] sortArray,
			ArrayList<Integer> volumes, int[][] finalBins) {
		super();
		this.idcust = idcust;
		this.location = location;
		this.volume = volume;
		VolumeSet.sumcust = sumcust;
		VolumeSet.numDromologia = numDromologia;
		SortArray = sortArray;
		VolumeSet.volumes = volumes;
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
				location = Order.goodOrders.get(i).location;
				idcust = Order.goodOrders.get(i).idcust;

			for (int y=0; y < Order.order.size();y++) {
				quantity = Order.goodOrders.get(i).order.get(y).quantity;
				prodid = Order.goodOrders.get(i).order.get(y).id;

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
			    SUMvol=SUMvol + volume; // to sinolo tou ogkoy olhs ths paragelias toy enos pelati
			}
			    //arraylist me ton ogko tis paragelias toy kathe pelati
			    volumes.add(SUMvol, idcust);


			}
			volumeSize = volumes.size();

			SortArray = new int[volumeSize][2];

			metritis = 0;
			while (volumes.size() != 0) {
			int currentMax =0;
			for (int i=0; i<volumes.size()-1; i++){
				if(currentMax < volumes.get(i).SUMvol){
					currentMax = volumes.get(i).SUMvol;
					best_i=i;
				}
				}
				SortArray [metritis][0] = currentMax;
				SortArray [metritis][1] = volumes.get(best_i).idcust;
				metritis++;
				volumes.remove(best_i);
			}

			return volumes;
			int sumVolume = 0;
			for (int i=0; i<volumes.size(); i++)
				sumVolume= sumVolume + volumes.get(i).SUMvol;
			numDromologia = sumVolume / c;




}
		//int[][] BppArray = new int[numDromologia][sumcust+1];   F

		static int  FinalBins [][] = GFG.bestFit(SortArray, numDromologia, c, sumcust+1);

		public static void DromologiaPrint () {
			for (int i = 0; i <= numDromologia; i++) {
				System.out.print("Το δρομολόγιο " + FinalBins [i][0] + "θα ικανοποιήσει τους πελάτες με id:" );


	            for (int j = 0; j <  FinalBins[i].length; j++) {
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

