/**
 * Order
 * 
 * Copyright 2019-2020
 */
package STOCKOVERFLOWPackage;

import java.util.ArrayList;
import java.sql.*;

/**
 * Class Order is being connected with database, with the table Orders and
 * creates a List with the total Orders, a list with orders that we can satisfy
 * (we have an available stock that is bigger than the quantity which the
 * customer wants) and a list with orders that we cannot satisfy ( we do not
 * have an available stock that is bigger than the quantity which the customer
 * wants
 * 
 * @authors Panagiotis Petropoulos, Stamatios Liakos
 */
public class Order {
	/** the id of order */
	Integer idorder;
	/** the id of customer */
	Integer idcustomer;
	/** the name of customer */
	String namecustomer;
	/** the date of order */
	String date_of_order;
	/** the id of the first product */
	Integer idproduct1;
	/** the name of the first product */
	String nameproduct1;
	/** the quantity of the first product */
	Integer quantity1;
	/** the price of the first product */
	Float price1;
	Integer idproduct2;
	String nameproduct2;
	Integer quantity2;
	Float price2;
	Integer idproduct3;
	String nameproduct3;
	Integer quantity3;
	Float price3;
	Integer idproduct4;
	String nameproduct4;
	Integer quantity4;
	Float price4;
	Integer idproduct5;
	String nameproduct5;
	Integer quantity5;
	Float price5;
	Integer a;
	Integer b;

	/** default constructor */
	public Order() {
	}

	public Order(Integer idorder, Integer idcustomer, String namecustomer, String date_of_order, Integer idproduct1,
			String nameproduct1, Integer quantity1, Float price1, Integer idproduct2, String nameproduct2,
			Integer quantity2, Float price2, Integer idproduct3, String nameproduct3, Integer quantity3, Float price3,
			Integer idproduct4, String nameproduct4, Integer quantity4, Float price4, Integer idproduct5,
			String nameproduct5, Integer quantity5, Float price5) {
		super();
		this.idorder = idorder;
		this.idcustomer = idcustomer;
		this.namecustomer = namecustomer;
		this.date_of_order = date_of_order;
		this.idproduct1 = idproduct1;
		this.nameproduct1 = nameproduct1;
		this.quantity1 = quantity1;
		this.price1 = price1;
		this.idproduct2 = idproduct2;
		this.nameproduct2 = nameproduct2;
		this.quantity2 = quantity2;
		this.price2 = price2;
		this.idproduct3 = idproduct3;
		this.nameproduct3 = nameproduct3;
		this.quantity3 = quantity3;
		this.price3 = price3;
		this.idproduct4 = idproduct4;
		this.nameproduct4 = nameproduct4;
		this.quantity4 = quantity4;
		this.price4 = price4;
		this.idproduct5 = idproduct5;
		this.nameproduct5 = nameproduct5;
		this.quantity5 = quantity5;
		this.price5 = price5;
	}

	/** methods get,set for our variables */
	public Integer getIdorder() {
		return idorder;
	}

	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
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

	public String getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(String date_of_order) {
		this.date_of_order = date_of_order;
	}

	public Integer getIdproduct1() {
		return idproduct1;
	}

	public void setIdproduct1(Integer idproduct1) {
		this.idproduct1 = idproduct1;
	}

	public String getNameproduct1() {
		return nameproduct1;
	}

	public void setNameproduct1(String nameproduct1) {
		this.nameproduct1 = nameproduct1;
	}

	public Integer getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(Integer quantity1) {
		this.quantity1 = quantity1;
	}

	public Float getPrice1() {
		return price1;
	}

	public void setPrice1(Float price1) {
		this.price1 = price1;
	}

	public Integer getIdproduct2() {
		return idproduct2;
	}

	public void setIdproduct2(Integer idproduct2) {
		this.idproduct2 = idproduct2;
	}

	public String getNameproduct2() {
		return nameproduct2;
	}

	public void setNameproduct2(String nameproduct2) {
		this.nameproduct2 = nameproduct2;
	}

	public Integer getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(Integer quantity2) {
		this.quantity2 = quantity2;
	}

	public Float getPrice2() {
		return price2;
	}

	public void setPrice2(Float price2) {
		this.price2 = price2;
	}

	public Integer getIdproduct3() {
		return idproduct3;
	}

	public void setIdproduct3(Integer idproduct3) {
		this.idproduct3 = idproduct3;
	}

	public String getNameproduct3() {
		return nameproduct3;
	}

	public void setNameproduct3(String nameproduct3) {
		this.nameproduct3 = nameproduct3;
	}

	public Integer getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(Integer quantity3) {
		this.quantity3 = quantity3;
	}

	public Float getPrice3() {
		return price3;
	}

	public void setPrice3(Float price3) {
		this.price3 = price3;
	}

	public Integer getIdproduct4() {
		return idproduct4;
	}

	public void setIdproduct4(Integer idproduct4) {
		this.idproduct4 = idproduct4;
	}

	public String getNameproduct4() {
		return nameproduct4;
	}

	public void setNameproduct4(String nameproduct4) {
		this.nameproduct4 = nameproduct4;
	}

	public Integer getQuantity4() {
		return quantity4;
	}

	public void setQuantity4(Integer quantity4) {
		this.quantity4 = quantity4;
	}

	public Float getPrice4() {
		return price4;
	}

	public void setPrice4(Float price4) {
		this.price4 = price4;
	}

	public Integer getIdproduct5() {
		return idproduct5;
	}

	public void setIdproduct5(Integer idproduct5) {
		this.idproduct5 = idproduct5;
	}

	public String getNameproduct5() {
		return nameproduct5;
	}

	public void setNameproduct5(String nameproduct5) {
		this.nameproduct5 = nameproduct5;
	}

	public Integer getQuantity5() {
		return quantity5;
	}

	public void setQuantity5(Integer quantity5) {
		this.quantity5 = quantity5;
	}

	public Float getPrice5() {
		return price5;
	}

	public void setPrice5(Float price5) {
		this.price5 = price5;
	}

	/**
	 * this method is being connected with the database and creates and returns a
	 * list with orders
	 */
	public static ArrayList<Order> getOrders() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */
		String sql = "SELECT * FROM Orders ";

		/*
		 * if (orderByColumn != null && orderByDirection != null) { sql += " ORDER BY "
		 * + orderByColumn + " " + orderByDirection; }
		 */

		DB db = new DB();
		ArrayList<Order> orders = new ArrayList<Order>();

		try {

			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a
			// ResultSet)

			ResultSet rs3 = stmt.executeQuery();
			while (rs3.next()) {
				Order st = new Order(Integer.parseInt(rs3.getString("IDORDER")),
						Integer.parseInt(rs3.getString("IDCUSTOMER")), rs3.getString("NAMECUSTOMER"),
						rs3.getString("DATE_OF_ORDER"), Integer.parseInt(rs3.getString("IDPRODUCT1")),
						rs3.getString("NAMEPRODUCT1"), Integer.parseInt(rs3.getString("QUANTITY1")),
						Float.parseFloat(rs3.getString("PRICE1")), Integer.parseInt(rs3.getString("IDPRODUCT2")),
						rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2")),
						Float.parseFloat(rs3.getString("PRICE2")), Integer.parseInt(rs3.getString("IDPRODUCT3")),
						rs3.getString("NAMEPRODUCT3"), Integer.parseInt(rs3.getString("QUANTITY3")),
						Float.parseFloat(rs3.getString("PRICE3")), Integer.parseInt(rs3.getString("IDPRODUCT4")),
						rs3.getString("NAMEPRODUCT4"), Integer.parseInt(rs3.getString("QUANTITY4")),
						Float.parseFloat(rs3.getString("PRICE4")), Integer.parseInt(rs3.getString("IDPRODUCT5")),
						rs3.getString("NAMEPRODUCT5"), Integer.parseInt(rs3.getString("QUANTITY5")),
						Float.parseFloat(rs3.getString("PRICE5")));

				orders.add(st);
			}

			rs3.close(); // closing ResultSet
			stmt.close();
			db.close();// closing PreparedStatement
			return orders;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (con != null) // if connection is still open, then close.
				con.close();
		}
	}

	/**
	 * this method is being connected with the database and creates and returns a
	 * list with orders that cannot be satisfied, we do not have the available stock
	 */
	public static ArrayList<Order> getBlackList() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */

		String sql = "SELECT * FROM Orders ";

		/*
		 * if (orderByColumn != null && orderByDirection != null) { sql += " ORDER BY "
		 * + orderByColumn + " " + orderByDirection; }
		 */

		DB db = new DB();
		ArrayList<Order> BlackList = new ArrayList<Order>();
		try {

			// open connection and get Connection object

			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a
			// ResultSet)
			ResultSet rs3 = stmt.executeQuery();

			while (rs3.next()) {
				Order st = new Order(Integer.parseInt(rs3.getString("IDORDER")),
						Integer.parseInt(rs3.getString("IDCUSTOMER")), rs3.getString("NAMECUSTOMER"),
						rs3.getString("DATE_OF_ORDER"), Integer.parseInt(rs3.getString("IDPRODUCT1")),
						rs3.getString("NAMEPRODUCT1"), Integer.parseInt(rs3.getString("QUANTITY1")),
						Float.parseFloat(rs3.getString("PRICE1")), Integer.parseInt(rs3.getString("IDPRODUCT2")),
						rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2")),
						Float.parseFloat(rs3.getString("PRICE2")), Integer.parseInt(rs3.getString("IDPRODUCT3")),
						rs3.getString("NAMEPRODUCT3"), Integer.parseInt(rs3.getString("QUANTITY3")),
						Float.parseFloat(rs3.getString("PRICE3")), Integer.parseInt(rs3.getString("IDPRODUCT4")),
						rs3.getString("NAMEPRODUCT4"), Integer.parseInt(rs3.getString("QUANTITY4")),
						Float.parseFloat(rs3.getString("PRICE4")), Integer.parseInt(rs3.getString("IDPRODUCT5")),
						rs3.getString("NAMEPRODUCT5"), Integer.parseInt(rs3.getString("QUANTITY5")),
						Float.parseFloat(rs3.getString("PRICE5")));
				boolean Flag = false;
				for (int w = 0; w < Stock.getStocks().size(); w++) {
					if (Integer.parseInt(rs3.getString("IDPRODUCT1")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY1")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT2")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY2")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT3")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY3")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT4")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY4")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT5")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY5")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
				}
				if (Flag == true) {
					BlackList.add(st);
				}
			}
			rs3.close(); // closing ResultSet
			stmt.close();
			db.close();// closing PreparedStatement
			return BlackList;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (con != null) // if connection is still open, then close.
				con.close();
		}
	}

	/**
	 * this method helps me find the difference in quantity between the orders and
	 * the available stock .
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Stock> getA() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */

		String sql = "SELECT * FROM Orders ";

		/*
		 * if (orderByColumn != null && orderByDirection != null) { sql += " ORDER BY "
		 * + orderByColumn + " " + orderByDirection; }
		 */

		DB db = new DB();

		ArrayList<Stock> a = new ArrayList<Stock>();

		try {

			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a
			// ResultSet)
			ResultSet rs3 = stmt.executeQuery();

			while (rs3.next()) {

				for (int w = 0; w < Stock.getStocks().size(); w++) {
					if (Integer.parseInt(rs3.getString("IDPRODUCT1")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY1")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							a.add(new Stock(Integer.parseInt(rs3.getString("IDPRODUCT1")),
									rs3.getString("NAMEPRODUCT1"), Integer.parseInt(rs3.getString("QUANTITY1"))
											- Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT2")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY2")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							a.add(new Stock(Integer.parseInt(rs3.getString("IDPRODUCT2")),
									rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2"))
											- Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT3")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY3")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							a.add(new Stock(Integer.parseInt(rs3.getString("IDPRODUCT3")),
									rs3.getString("NAMEPRODUCT3"), Integer.parseInt(rs3.getString("QUANTITY3"))
											- Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT4")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY4")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							a.add(new Stock(Integer.parseInt(rs3.getString("IDPRODUCT4")),
									rs3.getString("NAMEPRODUCT4"), Integer.parseInt(rs3.getString("QUANTITY4"))
											- Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT5")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY5")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							a.add(new Stock(Integer.parseInt(rs3.getString("IDPRODUCT5")),
									rs3.getString("NAMEPRODUCT5"), Integer.parseInt(rs3.getString("QUANTITY5"))
											- Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));
						}
					}
				}
			}
			rs3.close(); // closing ResultSet
			stmt.close();
			db.close();// closing PreparedStatement
			return a;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (con != null) // if connection is still open, then close.
				con.close();
		}
	}

	public static ArrayList<Order> getGoodOrders() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */

		String sql = "SELECT * FROM Orders ";

		/*
		 * if (orderByColumn != null && orderByDirection != null) { sql += " ORDER BY "
		 * + orderByColumn + " " + orderByDirection; }
		 */

		DB db = new DB();
		ArrayList<Order> GoodOrders = new ArrayList<Order>();

		try {

			// open connection and get Connection object
			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a
			// ResultSet)
			ResultSet rs3 = stmt.executeQuery();
			while (rs3.next()) {

				Order st = new Order(Integer.parseInt(rs3.getString("IDORDER")),
						Integer.parseInt(rs3.getString("IDCUSTOMER")), rs3.getString("NAMECUSTOMER"),
						rs3.getString("DATE_OF_ORDER"), Integer.parseInt(rs3.getString("IDPRODUCT1")),
						rs3.getString("NAMEPRODUCT1"), Integer.parseInt(rs3.getString("QUANTITY1")),
						Float.parseFloat(rs3.getString("PRICE1")), Integer.parseInt(rs3.getString("IDPRODUCT2")),
						rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2")),
						Float.parseFloat(rs3.getString("PRICE2")), Integer.parseInt(rs3.getString("IDPRODUCT3")),
						rs3.getString("NAMEPRODUCT3"), Integer.parseInt(rs3.getString("QUANTITY3")),
						Float.parseFloat(rs3.getString("PRICE3")), Integer.parseInt(rs3.getString("IDPRODUCT4")),
						rs3.getString("NAMEPRODUCT4"), Integer.parseInt(rs3.getString("QUANTITY4")),
						Float.parseFloat(rs3.getString("PRICE4")), Integer.parseInt(rs3.getString("IDPRODUCT5")),
						rs3.getString("NAMEPRODUCT5"), Integer.parseInt(rs3.getString("QUANTITY5")),
						Float.parseFloat(rs3.getString("PRICE5")));
				boolean Flag = false;
				for (int w = 0; w < Stock.getStocks().size(); w++) {
					if (Integer.parseInt(rs3.getString("IDPRODUCT1")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY1")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT2")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY2")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT3")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY3")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT4")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY4")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
					if (Integer.parseInt(rs3.getString("IDPRODUCT5")) == Stock.getStocks().get(w).id) {
						if (Integer.parseInt(rs3.getString("QUANTITY5")) > Stock.getStocks().get(w).stock
								- Stock.getStocks().get(w).minQuantity) {
							Flag = true;
						}
					}
				}
				if (Flag == false) {
					GoodOrders.add(st);
				}
			}

			rs3.close(); // closing ResultSet
			stmt.close();
			db.close();// closing PreparedStatement
			return GoodOrders;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (con != null) { // if connection is still open, then close.
				con.close();
			}
		}
	}

	/**
	 * this method is helped from method getA() and finds how much product we need
	 * from every product to satisfy the blacklist
	 * 
	 * @param a
	 * @return
	 */
	public static ArrayList<Stock> getNeedProduct(ArrayList<Stock> a) {
		ArrayList<Stock> NeedProduct = new ArrayList<Stock>();
		int count;
		for (int i = 0; i < a.size(); i++) {
			count = 0;
			for (int x = 0; x < a.size(); x++) {
				if (a.get(i).id == a.get(x).id) {
					count = count + a.get(x).need;
				}
			}
			NeedProduct.add(new Stock(a.get(i).id, a.get(i).name, count));
		}
		return NeedProduct;
	}
}
