
public class Statistics {
	
	/*---------------------------------------------------------------------*/
	
	/* Ποσοστό επιτυχημένων παραγγελιών */
	public static double rateofgoodorders() throws Exception {
		double rate;
		System.out.println(Order.getGoodOrders().size());
		System.out.println(Order.getOrders().size());
		rate = ((double)Order.getGoodOrders().size())/((double)Order.getOrders().size());
		return rate;
	}
	

	
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
	public static String[] CustomerMaxOrders() throws Exception {
		int max = 0;
		int k = 0 ;
		int [] arr = CustomerSumOrders();
		String [] array = new String [Customer.getCustomers().size()];
		for(int i = 0 ; i < arr.length ; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int idCust = cust.getIdcustomer();
			if (arr[idCust -2] == max) {
				array[k] = cust.getNamecustomer();
				k++;
			}
		}
		return array;
	}
	
	 	
	/* 24) Customer with min Orders || πελάτης με τις λιγότερες παραγγελίες*/
	public static String[] CustomerMinOrders() throws Exception {
		int min = 0;
		int k = 0 ;
		int [] arr = CustomerSumOrders();
		String [] array = new String [Customer.getCustomers().size()];
		for(int i = 0 ; i < arr.length ; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int idCust = cust.getIdcustomer();
			if (arr[idCust -2] == min) {
				array[k] = cust.getNamecustomer();
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
	public static String[] CustomerMaxCreaditworthiness() throws Exception {
		int cred = 0;
		int i = 0; 
		String [] array = new String [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() > cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}
	
	
	/* 3) Customer with min creditworthiness || πελάτης με ελάχιστη πιστολιπτική ικανότητα*/
	public static String[] CustomerMinCreaditworthiness() throws Exception {
		int cred = 0;
		int i = 0; 
		String [] array = new String [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() < cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getNamecustomer();
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
	
	 /*5) AverageYears_of_cooperation of Customers|| μέση τιμή χρόνων συνεργασίας με πελάτες*/
	public static double AverageYears_of_cooperation() throws Exception {
		int sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = sum + cust.getYears_of_cooperation();
		}
		return (double) sum/Customer.getCustomers().size();
	}
	
	/*6) Customer with max Years_of_cooperation || πελάτης με μέγιστη τιμή χρόνων συνεργασίας*/
	public static String[] CustomerMaxYears_of_cooperation() throws Exception {
		int years = 0;
		int i = 0; 
		String [] array = new String [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() > years) {
				years = cust.getYears_of_cooperation();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() == years) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}
	
	
	/* 7) Customer with min Years_of_cooperation || πελάτης με ελάχιστη τιμή χρόνων συνεργασίας*/
	public static String[] CustomerMinYears_of_cooperation() throws Exception {
		int years = 100;
		int i = 0; 
		String [] array = new String [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() < years) {
				years = cust.getYears_of_cooperation();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if (cust.getYears_of_cooperation() == years) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}

	/* 8) AveragePercent_of_stock of Customers|| μέσο ποσοστό μετοχών*/
	public static double AveragePercent_of_stock() throws Exception {
		double sum = 0;
		for (Customer cust : Customer.getCustomers()) {
			sum = (double) (sum + cust.getPercent_of_stock());
		}
		return (double) sum/Customer.getCustomers().size();
	}
	
	/* 9) Customer with max Percent_of_stock || πελάτης με τις περισσότερες μετοχές*/
	public static String[] CustomerMaxPercent_of_stock() throws Exception {
		double stock = 0;
		int i = 0; 
		String [] array = new String [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() > stock) {
				stock = (double) cust.getPercent_of_stock();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() == stock) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}
	
	 /*10) Customer with min Percent_of_stock || πελάτης με τις λιγότερες μετοχές*/
	public static String[] CustomerMinPercent_of_stock() throws Exception {
		double stock = 1000.0;
		int i = 0; 
		String [] array = new String [Customer.getCustomers().size()];
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() < stock) {
				stock = (double) cust.getPercent_of_stock();
			}
		}
		for (Customer cust : Customer.getCustomers()) {
			if ((double)cust.getPercent_of_stock() == stock) {
				array[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array;
	}
	
	 /*11) Array of Value of customers || λίστα με αξία πελατών*/
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
	
	 /*12) Customer with max value || πιο χρήσιμος πελάτης*/
	public static String[] CustomerMostValuable() throws Exception {
		double MaxValue = 0;
		int i = 0; 
		double [] array = Statistics.ValueOfCustomers();
		String [] array2 = new String [Customer.getCustomers().size()];
		for (int k = 0 ; k < array.length ; k ++) {
			if (array[k] > MaxValue) {
				MaxValue = array[k];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int id = cust.getIdcustomer();
			if (array[id - 2] == MaxValue) {
				array2[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array2;
	}
	
	 /*13) Customer with min value || λιγότερο χρήσιμος πελάτης*/
	public static String[] CustomerLessValuable() throws Exception {
		double MinValue = 0;
		int i = 0; 
		double [] array = Statistics.ValueOfCustomers();
		String [] array2 = new String [Customer.getCustomers().size()];
		for (int k = 0 ; k < array.length ; k ++) {
			if (array[k] < MinValue ) {
				MinValue = array[k];
			}
		}
		
		for (Customer cust : Customer.getCustomers()) {
			int id = cust.getIdcustomer();
			if (array[id - 2] == MinValue) {
				array2[i] = cust.getNamecustomer();
				i++;
			}
		}
		return array2;
	}
	
	/* 14) HealthyDoingBusiness: if 60% of customers have creditworthiness above 0.6 then we are ok/else not || αν το 60% των πελατών έχουν πιστοληπτική ικανότητα πάνω από 0.6 είμαστε καλά*/
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
	
}

