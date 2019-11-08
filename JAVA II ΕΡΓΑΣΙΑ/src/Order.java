import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Order {
	private ArrayList<Order> Orders = new ArrayList<Order> ();
	private int code;
	private String name;
	private int quantity;
	private String location;
	private String namecustomer;
	private String surnamecustomer;
	Stock a = new Stock();
	
	public Order() {
		this.code = a.codes[setCoNa()];
		this.name = a.names[setCoNa()];
		this.quantity = setQ();
		this.location = setL();
		this.namecustomer = setNamecustomer();
		this.surnamecustomer = setSurnamecustomer();
		Orders.add(this);
	}
	Scanner in = new Scanner(System.in);
	Random r = new Random();
	
	public int setCoNa() {
		return r.nextInt(2);
	}
	
	public int setQ() {
		return r.nextInt(1000);
	}
	
	public String setL() {
		return in.nextLine();
	}
	

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getNamecustomer() {
		return namecustomer;
	}

	public String setNamecustomer() {
		return in.nextLine();
	}

	public String getSurnamecustomer() {
		return surnamecustomer;
	}

	public String setSurnamecustomer() {
		return in.nextLine();
	}

	@Override
	public String toString() {
		return "Orders [code=" + code + ", name=" + name + ", quantity=" + quantity + ", location=" + location
				+ ", namecustomer=" + namecustomer + ", surnamecustomer=" + surnamecustomer + "]";
	}
	
}

