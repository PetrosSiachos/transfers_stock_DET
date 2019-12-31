public class Statistics {
  
/*-------------------Statistics of Class Customer-------------------------*/
	
/* 1) AverageCreditworthiness of Customers|| μέση πιστολιπτική ικανότητα πελατών*/
	public static double AverageCreditworthiness() {
		int sum = 0;
		for (Customer cust : Customer.customers) {
			sum = sum + cust.getCreditworthiness();
		}
		return (double) sum/Customer.customers.size();
	}
	
/* 2) Customer with max creditworthiness || πελάτης με μέγιστη πιστολιπτική ικανότητα*/
	public static int[] CustomerMaxCreaditworthiness() {
		int cred = 0;
		int i = 0; 
		int [] array = new int [Customer.customers.size()];
		for (Customer cust : Customer.customers) {
			if (cust.getCreditworthiness() > cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.customers) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}
/* 3) Customer with min creditworthiness || πελάτης με ελάχιστη πιστολιπτική ικανότητα*/
	public static int[] CustomerMinCreaditworthiness() {
		int cred = 0;
		int i = 0; 
		int [] array = new int [Customer.customers.size()];
		for (Customer cust : Customer.customers) {
			if (cust.getCreditworthiness() < cred) {
				cred = cust.getCreditworthiness();
			}
		}
		for (Customer cust : Customer.customers) {
			if (cust.getCreditworthiness() == cred) {
				array[i] = cust.getIdcustomer();
				i++;
			}
		}
		return array;
	}
/* 4) Satisfactory average creditworthiness or not || ικανοποιητική μέση πιστολιπτική ικανότητα ή όχι?*/
	public static boolean SatisfactoryAverageCreditworthiness() {
		boolean sat = false;
		if (Statistics.AverageCreditworthiness() > 0.7) {
			sat = true;
		}
		return sat;
	}
		
	

}
