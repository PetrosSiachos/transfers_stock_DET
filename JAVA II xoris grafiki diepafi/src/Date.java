import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

//klasi pou periexei tis imerominies gia tis paraggelies

public class Date {
	
	static ArrayList <java.util.Date> dates = new ArrayList<java.util.Date> ();
	
	public static void main(String args[]){
		Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
		java.util.Date myDate = myCalendar.getTime();
		System.out.println(myDate);		//Tue Mar 11 00:00:00 EET 2014
		
		java.util.Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		System.out.println(date);		//Tue Feb 11 00:00:00 EET 2014
		
		System.out.println(parseDate("2014-2-11"));		//Tue Feb 11 00:00:00 EET 2014
		
		System.out.println(getRandomIntBetweenRange(1, 3));		//px 2
		
		System.out.println(parseDate("2014-" + getRandomIntBetweenRange(1, 3) + "-" +getRandomIntBetweenRange(1, 28) + ""));//RANDOM: Tue Feb 11 00:00:00 EET 2014
		System.out.println();
		
		//in order to create to different dates you have to create two different calendars
		// dates of jan, feb, mar
		Calendar myCalendar2 = new GregorianCalendar(2014, getRandomIntBetweenRange(0, 2), getRandomIntBetweenRange(0, 28));//RANDOM: Tue Feb 11 00:00:00 EET 2014
		java.util.Date myDate2 = myCalendar2.getTime();
		System.out.println(myDate2); //Tue Mar 11 00:00:00 EET 2014
		dates.add(myDate2);
		Calendar myCalendar3 = new GregorianCalendar(2014, getRandomIntBetweenRange(0, 2), getRandomIntBetweenRange(0, 28));//RANDOM: Tue Feb 11 00:00:00 EET 2014
		java.util.Date myDate3 = myCalendar3.getTime();
		System.out.println(myDate3); //Tue Mar 11 00:00:00 EET 2014
		dates.add(myDate3);
		dates.add(new GregorianCalendar(2014, getRandomIntBetweenRange(0, 2), getRandomIntBetweenRange(0, 28)).getTime());//RANDOM: Tue Feb 11 00:00:00 EET 2014
		
		for (int x = 0; x < dates.size(); x++) {
		    System.out.println(dates.get(x));
		}
	}
	
	public static java.util.Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	// method that creates random numbers from 1-3
	public static int getRandomIntBetweenRange(int min, int max){
	    int x = (int) ((Math.random()*((max-min)+1))+min);
	    return x;
	}
}
