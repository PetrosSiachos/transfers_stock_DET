package STOCKOVERFLOWPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	Integer idcustomer;
	String namecustomer;
	String phone;
	String address;
	Integer years_of_cooperation;
	Float percent_of_stock;
	Integer creditworthiness;
	
	public Customer() {}
	
	public Customer(Integer idcustomer, String namecustomer, String phone, String address, Integer years_of_cooperation,
			Float percent_of_stock, Integer creaditworthiness) {
		super();
		this.idcustomer = idcustomer;
		this.namecustomer = namecustomer;
		this.phone = phone;
		this.address = address;
		this.years_of_cooperation = years_of_cooperation;
		this.percent_of_stock = percent_of_stock;
		this.creditworthiness = creaditworthiness;
	}
	
	public Integer getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Integer idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getNamecustomer() {
		return namecustomer;
	}

	public void setNamecustomer(String namecustomer) {
		this.namecustomer = namecustomer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getYears_of_cooperation() {
		return years_of_cooperation;
	}

	public void setYears_of_cooperation(Integer years_of_cooperation) {
		this.years_of_cooperation = years_of_cooperation;
	}

	public Float getPercent_of_stock() {
		return percent_of_stock;
	}

	public void setPercent_of_stock(Float percent_of_stock) {
		this.percent_of_stock = percent_of_stock;
	}

	public Integer getCreditworthiness() {
		return creditworthiness;
	}

	public void setCreditworthiness(Integer creditworthiness) {
		this.creditworthiness = creditworthiness;
	}

	public static ArrayList<Customer> getCustomers() throws Exception {
		Connection con = null;
		
		/*
		* Builds the sql query
		*/
		
		String sql = "SELECT * FROM Customers ";
		
		/*if (orderByColumn != null && orderByDirection != null) {
			sql += " ORDER BY " + orderByColumn + " " + orderByDirection;
		}*/

		DB db = new DB();
		ArrayList<Customer> customers =  new ArrayList<Customer>();
		
		try {
			// open connection and get Connection object
			
			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Customer st = new Customer( Integer.parseInt(rs.getString("IDCUSTOMER")),
									rs.getString("NAMECUSTOMER"),
									rs.getString("PHONE"),
									rs.getString("ADDRESS"),
									Integer.parseInt(rs.getString("YEARS_OF_COOPERATION")),
									Float.parseFloat(rs.getString("PERCENT_OF_STOCK")),
									Integer.parseInt(rs.getString("CREADITWORTHINESS")));
				
				customers.add(st);
			}
			
		 	rs.close(); //closing ResultSet
			stmt.close(); 
			db.close();//closing PreparedStatement
				
			return customers;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if(con != null) // if connection is still open, then close.
			con.close();
		}
	}
}
