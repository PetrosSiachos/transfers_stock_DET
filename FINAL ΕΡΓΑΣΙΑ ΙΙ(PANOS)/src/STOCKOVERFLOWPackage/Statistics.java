package STOCKOVERFLOWPackage;

public class Statistics {
  /*-------------------Statistics of Class Order-------------------------*/
	
	/* 22) CustomerSumOrders || άθροισμα παραγγελιών κάθε πελάτη */
	public static int[] CustomerSumOrders() throws Exception {
		int [] array = new int [Customer.getCustomers().size()];
		for (int i  = 0 ; i < array.length ; i++) {
			array[i] = 0 ;
		}
		for(Order o : Order.getOrders()) {
			int idCust = o.getIdcustomer();
			array[idCust -2]++; 
		}
		return array;
	}
	

}
