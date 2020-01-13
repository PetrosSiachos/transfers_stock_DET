
public class Main {
	public static void main (String [] args) throws Exception {
		System.out.println(Stock.getStocks().size());
		System.out.println(Order.getOrders().size());
		System.out.println(Customer.getCustomers().size());
		/*System.out.println("ε");
		
		System.out.println(Order.getNeedProduct(Order.getA()));
		System.out.println("ε");*/
		/*System.out.println(Order.getGoodOrders().size());*/
		/*System.out.println("ε");
		System.out.println(Order.getBlackList().size());
		System.out.println("ε");*/
		
		/*System.out.println(Statistics.rateofgoodorders());*/
		
		System.out.println("22ο στατ: ");
		int [] arr22 = Statistics.CustomerSumOrders();//22 check
		for (int i = 0 ; i < arr22.length ; i++) {
			System.out.println(arr22[i]);
		}
		System.out.println("23ο στατ: ");
		String [] arr23 = Statistics.CustomerMaxOrders();//23 check 
		int k23 = 0;
		for( int i = 0 ; i < arr23.length ; i++) {
			if (arr23[i] == null) {
				break;
			}
			System.out.println(arr23[i]);
			k23++;
		}
		if (k23 == 0) {
			System.out.println(0);
		}
		
		System.out.println("24ο στατ: ");
		String [] arr24 = Statistics.CustomerMinOrders();//24 check 
		int k24 = 0;
		for( int i = 0 ; i < arr24.length ; i++) {
			if (arr24[i] == null) {
				break;
			}
			System.out.println(arr24[i]);
			k24++;
		}
		if (k24 == 0) {
			System.out.println(0);
		}
		
		/*------------------------------------------------------------------------------*/
		
		
		System.out.println("1ο στατ: " + Statistics.AverageCreditworthiness());//1 check
		
		System.out.println("2ο στατ: ");
		String [] arr01 = Statistics.CustomerMaxCreaditworthiness();//2 check 
		int k1 = 0;
		for( int i = 0 ; i < arr01.length ; i++) {
			if (arr01[i] == null) {
				break;
			}
			System.out.println(arr01[i]);
			k1++;
		}
		if (k1 == 0) {
			System.out.println(0);
		}
		
		System.out.println("3ο στατ: ");
		String [] arr02 = Statistics.CustomerMinCreaditworthiness();//3 check
		int n1 = 0;
		for( int i = 0 ; i < arr02.length ; i++) {
			if (arr02[i] == null) {
				break;
			}
			System.out.println(arr02[i]);
			n1++;
		}
		if (n1 == 0) {
			System.out.println(0);
		}
		
		
		System.out.println("4ο στατ: " +Statistics.SatisfactoryAverageCreditworthiness());//4 check
		
		System.out.println("5ο στατ: " +Statistics.AverageYears_of_cooperation());//5 check
		
		System.out.println("6ο στατ: ");
		String [] arr1 = Statistics.CustomerMaxYears_of_cooperation();//6 check onoma
		int k = 0;
		for( int i = 0 ; i < arr1.length ; i++) {
			if (arr1[i] == null) {
				break;
			}
			System.out.println(arr1[i]);
			k++;
		}
		if (k == 0) {
			System.out.println(0);
		}
		
		System.out.println("7ο στατ: ");
		String [] arr2 = Statistics.CustomerMinYears_of_cooperation();//7 check onoma
		int n = 0;
		for( int i = 0 ; i < arr2.length ; i++) {
			if (arr2[i] == null) {
				break;
			}
			System.out.println(arr2[i]);
			n++;
		}
		if (n == 0) {
			System.out.println(0);
		}
		
		System.out.println("8ο στατ: ");
		System.out.println(Statistics.AveragePercent_of_stock());//8 check
		
		System.out.println("9ο στατ: ");
		String [] arr3 = Statistics.CustomerMaxPercent_of_stock();//9 check onoma
		int l = 0;
		for( int i = 0 ; i < arr3.length ; i++) {
			if (arr3[i] == null) {
				break;
			}
			System.out.println(arr3[i]);
			l++;
		}
		if (l == 0) {
			System.out.println(0);
		}
		System.out.println();
		System.out.println("10ο στατ: ");
		String [] arr4 = Statistics.CustomerMinPercent_of_stock();//10 check onoma
		int m = 0;
		for( int i = 0 ; i < arr4.length ; i++) {
			if (arr4[i] == null) {
				break;
			}
			System.out.println(arr4[i]);
			m++;
		}
		if (m == 0) {
			System.out.println(0);
		}
		
		System.out.println("11ο στατ: ");
		double []arr = Statistics.ValueOfCustomers();//11 check
		for (int i = 0 ; i < Statistics.ValueOfCustomers().length ; i ++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("12ο στατ: ");
		String [] arr5 = Statistics.CustomerMostValuable();//12 check ονομα
		int n2 = 0;
		for( int i = 0 ; i < arr3.length ; i++) {
			if (arr5[i] == null) {
				break;
			}
			System.out.println(arr5[i]);
			n2++;
		}
		if (n2 == 0) {
			System.out.println(0);
		}
		
		
		System.out.println("13ο στατ: ");
		String [] arr6 = Statistics.CustomerLessValuable();//13 check ονομα
		int n3 = 0;
		for( int i = 0 ; i < arr6.length ; i++) {
			if (arr6[i] == null) {
				break;
			}
			System.out.println(arr6[i]);
			n3++;
		}
		if (n3 == 0) {
			System.out.println(0);
		}
		
		System.out.println("14ο στατ: ");
		System.out.println(Statistics.HealthyDoingBusiness());//14 check  
			
	}
}


