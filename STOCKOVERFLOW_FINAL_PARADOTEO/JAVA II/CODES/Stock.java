/**
 * Stock
 * 
 * Copyright 2019
 */
package STOCKOVERFLOWPackage;

import java.util.ArrayList;
import java.sql.*;

/**
 * Class Stock is being connected with database, with the table Stocks and
 * creates a List with the products which our ERP sells.
 * 
 * @authors Panagiotis Petropoulos, Elena Tzerefou, Panagiota Sargenti
 */
public class Stock {
	/** The id of product */
	Integer id;
	/** the name of product */
	String name;
	/** the description of product */
	String description;
	/** the volume of product */
	Integer volume;
	/** the Quantity that our ERP */
	Integer minQuantity;
	/** the stock of the product */
	Integer stock;
	/** the price of the product */
	Float price;
	/** how much product we want - it is correlated with blacklist */
	Integer need;

	/** default constructor */
	public Stock() {
	}

	/**
	 * constructor that helps in class Order to create a list with products we needs
	 * to buy
	 * 
	 * @param id
	 * @param name
	 * @param need
	 */
	public Stock(Integer id, String name, Integer need) {
		this.id = id;
		this.name = name;
		this.need = need;
	}

	public Stock(Integer id, String name, String description, Integer volume, Integer minQuantity, Integer stock,
			Float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.volume = volume;
		this.minQuantity = minQuantity;
		this.stock = stock;
		this.price = price;

		// if quantity given is smaller than minQuantity then quantity=minQuantity!
		// In order to create a stock we are going to set quantity to a specific amount
		// = minQuantity
		// LATER, IF IT GETS LOWER THAN MIN WE MAKE A PUCHASE AND USE METHOD
		// "checkMinQuantity"!!!!!
	}
//we have a method that checks if quantity is smaller than minQuantity.Is this situation, quantity=minQuantity

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNeed() {
		return need;
	}

	public void setNeed(Integer need) {
		this.need = need;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * this method is being connected with the database and creates and returns a
	 * list with products that our ERP sell
	 */
	public static ArrayList<Stock> getStocks() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */
		String sql = "SELECT * FROM Products ";

		/*
		 * if (orderByColumn != null && orderByDirection != null) { sql += " ORDER BY "
		 * + orderByColumn + " " + orderByDirection; }
		 */

		DB db = new DB();
		ArrayList<Stock> stocks = new ArrayList<Stock>();

		try {
			// open connection and get Connection object

			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a
			// ResultSet)
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Stock st = new Stock(Integer.parseInt(rs.getString("IDPRODUCT")), rs.getString("NAMEPRODUCT"),
						rs.getString("DESCRIPTION"), Integer.parseInt(rs.getString("VOLUME")),
						Integer.parseInt(rs.getString("MINQUANTITY")), Integer.parseInt(rs.getString("STOCK")),
						Float.parseFloat(rs.getString("PRICE")));
				stocks.add(st);
			}
			rs.close(); // closing ResultSet
			stmt.close(); // closing PreparedStatement
			db.close();
			return stocks;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (con != null) // if connection is still open, then close.
				con.close();
		}
	} // End of getStudents
}
