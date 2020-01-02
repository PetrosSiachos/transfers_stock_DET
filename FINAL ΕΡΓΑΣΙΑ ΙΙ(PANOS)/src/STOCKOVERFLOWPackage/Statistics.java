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
	
	
	/* 23) Customer with max Orders || πελάτης με τις περισσότερες παραγγελίες*/
	public static int[] CustomerMaxOrders() throws Exception {
		int max = 0;
		int k = 0 ;
		int [] arr = CustomerSumOrders();
		int [] array = new int [Customer.getCustomers().size()];
		for(int i = 0 ; i < arr.length ; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int idCust = cust.getIdcustomer();
			if (arr[idCust -2] == max) {
				array[k] = cust.getIdcustomer();
				k++;
			}
		}
		return array;
	}
	
	 	
	/* 24) Customer with min Orders || πελάτης με τις λιγότερες παραγγελίες*/
	public static int[] CustomerMinOrders() throws Exception {
		int min = 0;
		int k = 0 ;
		int [] arr = CustomerSumOrders();
		int [] array = new int [Customer.getCustomers().size()];
		for(int i = 0 ; i < arr.length ; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int idCust = cust.getIdcustomer();
			if (arr[idCust -2] == min) {
				array[k] = cust.getIdcustomer();
				k++;
			}
		}
		return array;
	}
	
	
	
	 /*-------------------Statistics of Class Customer-------------------------*/
	
	/* 1) AverageCreditworthiness of Customers|| μέση πιστολιπτική ικανότητα πελατών*/
	public static double AverageCreditworthiness() throws Exception {
		int sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = sum + cust.getCreditworthiness();
		}
		return (double) sum/Customer.getCustomers().size();
	}
	
	
	 /*2) Customer with max creditworthiness || πελάτης με μέγιστη πιστολιπτική ικανότητα*/
	public static int[] CustomerMaxCreaditworthiness() throws Exception {
		int cred = 0;
		int i = 0; 
		int [] array = new int [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() > cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}
	
	
	
	/* 3) Customer with min creditworthiness || πελάτης με ελάχιστη πιστολιπτική ικανότητα*/
	public static int[] CustomerMinCreaditworthiness() throws Exception {
		int cred = 0;
		int i = 0; 
		int [] array = new int [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() < cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}
	
	
	 /*4) Satisfactory average creditworthiness or not || ικανοποιητική μέση πιστολιπτική ικανότητα ή όχι?*/
	public static boolean SatisfactoryAverageCreditworthiness() throws Exception {
		boolean sat = false;
		if (Statistics.AverageCreditworthiness() > 70) {
			sat = true;
		}
		return sat;
	}
	
	 
	 
	
	 	

}
