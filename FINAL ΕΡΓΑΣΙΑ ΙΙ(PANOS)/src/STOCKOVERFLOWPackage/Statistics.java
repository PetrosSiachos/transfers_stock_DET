package STOCKOVERFLOWPackage;

public class Statistics {
  /*-------------------Statistics of Class Order-------------------------*/
	
	/* 22) CustomerSumOrders || athroisma paraggelion kathe pelati */
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
	
	
	/* 23) Customer with max Orders || pelatis me perissoteres paraggelies*/
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
	
	 	
	/* 24) Customer with min Orders || pelatis me ligoteres paraggelies*/
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
	
	/* 1) AverageCreditworthiness of Customers|| mesi pistoliptiki ikanotita */
	public static double AverageCreditworthiness() throws Exception {
		int sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = sum + cust.getCreditworthiness();
		}
		return (double) sum/Customer.getCustomers().size();
	}
	
	
	 /*2) Customer with max creditworthiness || pelatis me megisti pistoliptiki ikanotita*/
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
	
	
	
	/* 3) Customer with min creditworthiness || pelatis me elaxisti pistoliptiki ikanotita*/
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
	
	
	 /*4) Satisfactory average creditworthiness or not || ikanopoiitiki pistoliptiki ikanotita i oxi*/
	public static boolean SatisfactoryAverageCreditworthiness() throws Exception {
		boolean sat = false;
		if (Statistics.AverageCreditworthiness() > 70) {
			sat = true;
		}
		return sat;
	}
	
		
	 /*5) AverageYears_of_cooperation of Customers|| mesi timi xronon sunergasias*/
	public static double AverageYears_of_cooperation() throws Exception {
		int sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = sum + cust.getYears_of_cooperation();
		}
		return (double) sum/Customer.getCustomers().size();
	}
	
		
	/*6) Customer with max Years_of_cooperation || pelatis me megista xronia sunergasias*/
	public static int[] CustomerMaxYears_of_cooperation() throws Exception {
		int years = 0;
		int i = 0; 
		int [] array = new int [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() > years) {
				years = cust.getYears_of_cooperation();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() == years) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}
	
	
	
	/* 7) Customer with min Years_of_cooperation || pelatis me elaxista xronia sunergasias*/
	public static int[] CustomerMinYears_of_cooperation() throws Exception {
		int years = 100;
		int i = 0; 
		int [] array = new int [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() < years) {
				years = cust.getYears_of_cooperation();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() == years) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}


	/* 8) AveragePercent_of_stock of Customers|| meso pososton metoxon*/
	public static double AveragePercent_of_stock() throws Exception {
		double sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = (double) (sum + cust.getPercent_of_stock());
		}
		return (double) sum/Customer.getCustomers().size();
	}
	
	
 	
	/* 9) Customer with max Percent_of_stock || pelatis me perissoteres metoxes*/
	public static int[] CustomerMaxPercent_of_stock() throws Exception {
		double stock = 0;
		int i = 0; 
		int [] array = new int [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() > stock) {
				stock = (double) cust.getPercent_of_stock();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() == stock) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}
	
	
	 /*10) Customer with min Percent_of_stock || pelatis me ligoteres metoxes*/
	public static int[] CustomerMinPercent_of_stock() throws Exception {
		double stock = 1000.0;
		int i = 0; 
		int [] array = new int [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() < stock) {
				stock = (double) cust.getPercent_of_stock();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() == stock) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}
	
	 /*11) Array of Value of customers || lista me aksia pelaton*/
	public static double[] ValueOfCustomers() throws Exception {
		int i = 0;
		double [] array = new double [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			int y = cust.getYears_of_cooperation();
			int c = cust.getCreditworthiness();
			double p = cust.getPercent_of_stock();
			array[i] = ((double)y/ 30.0)*0.4 + ((double)c/ 100.0)*0.5 + p *0.1;
			i++;
		}
		return array;
	}
		
	 /*12) Customer with max value || pelatis me megaluteri aksia*/
	public static double[] CustomerMostValuable() throws Exception {
		double MaxValue = 0;
		int i = 0; 
		double [] array = Statistics.ValueOfCustomers();
		double [] array2 = new double [Customer.getCustomers().size()];
		for (int k = 0 ; k < array.length ; k ++) {
			if (array[k] > MaxValue) {
				MaxValue = array[k];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int id = cust.getIdcustomer();
			if (array[id - 2] == MaxValue) {
				array2[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array2;
	}
	
		
	 /*13) Customer with min value || pelatis me mikroteri aksia*/
	public static double[] CustomerLessValuable() throws Exception {
		double MinValue = 0;
		int i = 0; 
		double [] array = Statistics.ValueOfCustomers();
		double [] array2 = new double [Customer.getCustomers().size()];
		for (int k = 0 ; k < array.length ; k ++) {
			if (array[k] < MinValue ) {
				MinValue = array[k];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int id = cust.getIdcustomer();
			if (array[id - 2] == MinValue) {
				array2[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array2;
	}
	
	
	/* 14) HealthyDoingBusiness: if 60% of customers have creditworthiness above 60 then we are ok/else not || an to 60% ton pelaton exoun pistoliptiki ikanotita pano apo 60 eimaste kala*/
	public static boolean HealthyDoingBusiness() throws Exception {
		int count = 0;
		for(Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() > 60) {
				count++;
			}
		}
		double per = count / Customer.getCustomers().size();
		if (per > 0.6) {
			return true;
		}
		return false;
	}
	
	  /*------------------------------------------------------------------*/
	
	 	

}
