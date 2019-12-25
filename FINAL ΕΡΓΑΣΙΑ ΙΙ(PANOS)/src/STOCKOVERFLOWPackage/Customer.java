package STOCKOVERFLOWPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	int idcustomer;
	String namecustomer;
	String phone;
	String address;
	int years_of_cooperation;
	double percent_of_stock;
	int creaditworthiness;
	public Customer() {
	}
	
	public Customer(int idcustomer, String namecustomer, String phone, String address, int years_of_cooperation,
			double percent_of_stock, int creaditworthiness) {
		super();
		this.idcustomer = idcustomer;
		this.namecustomer = namecustomer;
		this.phone = phone;
		this.address = address;
		this.years_of_cooperation = years_of_cooperation;
		this.percent_of_stock = percent_of_stock;
		this.creaditworthiness = creaditworthiness;
	}
	
	public int getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(int idcustomer) {
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

	public int getYears_of_cooperation() {
		return years_of_cooperation;
	}

	public void setYears_of_cooperation(int years_of_cooperation) {
		this.years_of_cooperation = years_of_cooperation;
	}

	public double getPercent_of_stock() {
		return percent_of_stock;
	}

	public void setPercent_of_stock(double percent_of_stock) {
		this.percent_of_stock = percent_of_stock;
	}

	public int getCreaditworthiness() {
		return creaditworthiness;
	}

	public void setCreaditworthiness(int creaditworthiness) {
		this.creaditworthiness = creaditworthiness;
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

						customers.add( st );

					}

		 			rs.close(); //closing ResultSet
					stmt.close(); //closing PreparedStatement
				
			return customers;
				
			} catch (Exception e) {

						throw new Exception(e.getMessage());

					} finally {

						if(con != null) // if connection is still open, then close.
							con.close();

					}

		} 
	
}
