import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.Arrays; 
import java.util.Collections; 

public class BPP {
	// OI DIO PARAKATO KLASEIS SHORTAROYN THN ARRAYLIST 
	// Java program to demonstrate working of Comparator 
	// interface 
	
	// A class to represent a student. 
	class Student 
	{ 
		int rollno; 
		String name, address; 

		// Constructor 
		public Student(int rollno, String name, 
								String address) 
		{ 
			this.rollno = rollno; 
			this.name = name; 
			this.address = address; 
		} 

		// Used to print student details in main() 
		public String toString() 
		{ 
			return this.rollno + " " + this.name + 
							" " + this.address; 
		} 
	} 

	class Sortbyroll implements Comparator<Student> 
	{ 
		// Used for sorting in ascending order of 
		// roll number 
		public int compare(Student a, Student b) 
		{ 
			return a.rollno - b.rollno; 
		} 
	} 

	// Driver class 
	class Main 
	{ 
		public static void main (String[] args) 
		{ 
			Student [] arr = {new Student(111, "bbbb", "london"), 
							new Student(131, "aaaa", "nyc"), 
							new Student(121, "cccc", "jaipur")}; 

			System.out.println("Unsorted"); 
			for (int i=0; i<arr.length; i++) 
				System.out.println(arr[i]); 

			Arrays.sort(arr, new Sortbyroll()); 

			System.out.println("\nSorted by rollno"); 
			for (int i=0; i<arr.length; i++) 
				System.out.println(arr[i]); 
			/*Unsorted
			111 bbbb london
			131 aaaa nyc
			121 cccc jaipur

			Sorted by rollno
			111 bbbb london
			121 cccc jaipur
			131 aaaa nyc  */
		} 
	} 

	// A sample Java program to sort a subarray 
	// in descending order using Arrays.sort(). 
	
	  
	public class SortExample 
	{ 
	    public static void main(String[] args) 
	    { 
	        // Note that we have Integer here instead of 
	        // int[] as Collections.reverseOrder doesn't 
	        // work for primitive types. 
	        Integer[] arr = {13, 7, 6, 45, 21, 9, 2, 100}; 
	  
	        // Sorts arr[] in descending order 
	        Arrays.sort(arr, Collections.reverseOrder()); 
	  
	        System.out.printf("Modified arr[] : %s", 
	                          Arrays.toString(arr)); 
	        /*Modified arr[] : [100, 45, 21, 13, 9, 7, 6, 2] */
	    } 
	} 
	/* https://www.geeksforgeeks.org/collections-sort-java-examples/ */
	int c = 820;
	int sumWeight = 0;
	for (int i=0; i<arr.length; i++) 
		sumWeight= sumWeight + arr.get(i);
	int numDromologia = sumWeight / c;
		
	}
	
}




