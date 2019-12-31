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
