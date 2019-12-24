package STOCKOVERFLOWPackage;
import java.util.ArrayList;
import java.sql.*;

public class Order {
	int idorder;
	int idcustomer;
	String namecustomer;
	String date_of_order;
	int idproduct1;
	String nameproduct1;
	int quantity1;
	double price1;
	int idproduct2;
	String nameproduct2;
	int quantity2;
	double price2;
	int idproduct3;
	String nameproduct3;
	int quantity3;
	double price3;
	int idproduct4;
	String nameproduct4;
	int quantity4;
	double price4;
	int idproduct5;
	String nameproduct5;
	int quantity5;
	double price5;
	int a;
	int b;

	public Order(){
	}

	public Order(int idorder, int idcustomer, String namecustomer, String date_of_order, int idproduct1, String nameproduct1, int quantity1, double price1,
			int idproduct2, String nameproduct2, int quantity2, double price2, int idproduct3,
			String nameproduct3, int quantity3, double price3, int idproduct4, String nameproduct4,
			int quantity4, double price4, int idproduct5, String nameproduct5, int quantity5, double price5) {
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


	public int getIdorder() {
		return idorder;
	}

	public void setIdorder(int idorder) {
		this.idorder = idorder;
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

	public String getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(String date_of_order) {
		this.date_of_order = date_of_order;
	}

	public int getIdproduct1() {
		return idproduct1;
	}

	public void setIdproduct1(int idproduct1) {
		this.idproduct1 = idproduct1;
	}

	public String getNameproduct1() {
		return nameproduct1;
	}

	public void setNameproduct1(String nameproduct1) {
		this.nameproduct1 = nameproduct1;
	}

	public int getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}

	public double getPrice1() {
		return price1;
	}

	public void setPrice1(double price1) {
		this.price1 = price1;
	}

	public int getIdproduct2() {
		return idproduct2;
	}

	public void setIdproduct2(int idproduct2) {
		this.idproduct2 = idproduct2;
	}

	public String getNameproduct2() {
		return nameproduct2;
	}

	public void setNameproduct2(String nameproduct2) {
		this.nameproduct2 = nameproduct2;
	}

	public int getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
	}

	public double getPrice2() {
		return price2;
	}

	public void setPrice2(double price2) {
		this.price2 = price2;
	}

	public int getIdproduct3() {
		return idproduct3;
	}

	public void setIdproduct3(int idproduct3) {
		this.idproduct3 = idproduct3;
	}

	public String getNameproduct3() {
		return nameproduct3;
	}

	public void setNameproduct3(String nameproduct3) {
		this.nameproduct3 = nameproduct3;
	}

	public int getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(int quantity3) {
		this.quantity3 = quantity3;
	}

	public double getPrice3() {
		return price3;
	}

	public void setPrice3(double price3) {
		this.price3 = price3;
	}

	public int getIdproduct4() {
		return idproduct4;
	}

	public void setIdproduct4(int idproduct4) {
		this.idproduct4 = idproduct4;
	}

	public String getNameproduct4() {
		return nameproduct4;
	}

	public void setNameproduct4(String nameproduct4) {
		this.nameproduct4 = nameproduct4;
	}

	public int getQuantity4() {
		return quantity4;
	}

	public void setQuantity4(int quantity4) {
		this.quantity4 = quantity4;
	}

	public double getPrice4() {
		return price4;
	}

	public void setPrice4(double price4) {
		this.price4 = price4;
	}

	public int getIdproduct5() {
		return idproduct5;
	}

	public void setIdproduct5(int idproduct5) {
		this.idproduct5 = idproduct5;
	}

	public String getNameproduct5() {
		return nameproduct5;
	}

	public void setNameproduct5(String nameproduct5) {
		this.nameproduct5 = nameproduct5;
	}

	public int getQuantity5() {
		return quantity5;
	}

	public void setQuantity5(int quantity5) {
		this.quantity5 = quantity5;
	}

	public double getPrice5() {
		return price5;
	}

	public void setPrice5(double price5) {
		this.price5 = price5;
	}

	public static ArrayList<Order> getOrders() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */
		String sql = "SELECT * FROM Orders ";

		/*if (orderByColumn != null && orderByDirection != null) {
			sql += " ORDER BY " + orderByColumn + " " + orderByDirection;
		}*/

		DB db = new DB();
		ArrayList<Order> orders =  new ArrayList<Order>();

		try {
			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
			ResultSet rs3 = stmt.executeQuery();

			while (rs3.next()) {
				Order st = new Order( Integer.parseInt(rs3.getString("IDORDER")),
				 Integer.parseInt(rs3.getString("IDCUSTOMER")),
				 rs3.getString("NAMECUSTOMER"),
				 rs3.getString("DATE_OF_ORDER"),
				Integer.parseInt(rs3.getString("IDPRODUCT1")),
				rs3.getString("NAMEPRODUCT1"),
				Integer.parseInt(rs3.getString("QUANTITY1")),
				 Float.parseFloat(rs3.getString("PRICE1")),
				 Integer.parseInt(rs3.getString("IDPRODUCT2")),
				 rs3.getString("NAMEPRODUCT2"),
				 Integer.parseInt(rs3.getString("QUANTITY2")),
				Float.parseFloat(rs3.getString("PRICE2")),
				 Integer.parseInt(rs3.getString("IDPRODUCT3")),
				 rs3.getString("NAMEPRODUCT3"),
			Integer.parseInt(rs3.getString("QUANTITY3")),
				 Float.parseFloat(rs3.getString("PRICE3")),
				Integer.parseInt(rs3.getString("IDPRODUCT4")),
				 rs3.getString("NAMEPRODUCT4"),
				Integer.parseInt(rs3.getString("QUANTITY4")),
				Float.parseFloat(rs3.getString("PRICE4")),
				Integer.parseInt(rs3.getString("IDPRODUCT5")),
				 rs3.getString("NAMEPRODUCT5"),
				Integer.parseInt(rs3.getString("QUANTITY5")),
				 Float.parseFloat(rs3.getString("PRICE5")));

				orders.add( st );

			}

 			rs3.close(); //closing ResultSet
			stmt.close(); //closing PreparedStatement
	return orders;
	} catch (Exception e) {

				throw new Exception(e.getMessage());

			} finally {

				if(con != null) // if connection is still open, then close.
					con.close();

			}

	}

	public static ArrayList<Order> getBlackList() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */
		String sql = "SELECT * FROM Orders ";

		/*if (orderByColumn != null && orderByDirection != null) {
			sql += " ORDER BY " + orderByColumn + " " + orderByDirection;
		}*/

		DB db = new DB();
		ArrayList<Order> BlackList =  new ArrayList<Order>();
		try {
			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
			ResultSet rs3 = stmt.executeQuery();

			while (rs3.next()) {
				Order st = new Order( Integer.parseInt(rs3.getString("IDORDER")),
				 Integer.parseInt(rs3.getString("IDCUSTOMER")),
				 rs3.getString("NAMECUSTOMER"),
				 rs3.getString("DATE_OF_ORDER"),
				Integer.parseInt(rs3.getString("IDPRODUCT1")),
				rs3.getString("NAMEPRODUCT1"),
				Integer.parseInt(rs3.getString("QUANTITY1")),
				 Float.parseFloat(rs3.getString("PRICE1")),
				 Integer.parseInt(rs3.getString("IDPRODUCT2")),
				 rs3.getString("NAMEPRODUCT2"),
				 Integer.parseInt(rs3.getString("QUANTITY2")),
				Float.parseFloat(rs3.getString("PRICE2")),
				 Integer.parseInt(rs3.getString("IDPRODUCT3")),
				 rs3.getString("NAMEPRODUCT3"),
			Integer.parseInt(rs3.getString("QUANTITY3")),
				 Float.parseFloat(rs3.getString("PRICE3")),
				Integer.parseInt(rs3.getString("IDPRODUCT4")),
				 rs3.getString("NAMEPRODUCT4"),
				Integer.parseInt(rs3.getString("QUANTITY4")),
				Float.parseFloat(rs3.getString("PRICE4")),
				Integer.parseInt(rs3.getString("IDPRODUCT5")),
				 rs3.getString("NAMEPRODUCT5"),
				Integer.parseInt(rs3.getString("QUANTITY5")),
				 Float.parseFloat(rs3.getString("PRICE5")));
				boolean Flag = false;
			for (int w = 0; w < Stock.getStocks().size(); w++) {
				if (Integer.parseInt(rs3.getString("IDPRODUCT1")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY1")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT2")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY2")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT3")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY3")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT4")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY4")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT5")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY5")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
			}
			if (Flag == true) {
				BlackList.add(st);
			}
		}
 			rs3.close(); //closing ResultSet
			stmt.close(); //closing PreparedStatement
	return BlackList;
	} catch (Exception e) {

				throw new Exception(e.getMessage());

			} finally {

				if(con != null) // if connection is still open, then close.
					con.close();

			}
	}
	public static ArrayList<Stock> getA() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */
		String sql = "SELECT * FROM Orders ";

		/*if (orderByColumn != null && orderByDirection != null) {
			sql += " ORDER BY " + orderByColumn + " " + orderByDirection;
		}*/

		DB db = new DB();
		
		ArrayList<Stock> a = new ArrayList<Stock>();
		try {
			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
			ResultSet rs3 = stmt.executeQuery();

			while (rs3.next()) {
				Order st = new Order( Integer.parseInt(rs3.getString("IDORDER")),
				 Integer.parseInt(rs3.getString("IDCUSTOMER")),
				 rs3.getString("NAMECUSTOMER"),
				 rs3.getString("DATE_OF_ORDER"),
				Integer.parseInt(rs3.getString("IDPRODUCT1")),
				rs3.getString("NAMEPRODUCT1"),
				Integer.parseInt(rs3.getString("QUANTITY1")),
				 Float.parseFloat(rs3.getString("PRICE1")),
				 Integer.parseInt(rs3.getString("IDPRODUCT2")),
				 rs3.getString("NAMEPRODUCT2"),
				 Integer.parseInt(rs3.getString("QUANTITY2")),
				Float.parseFloat(rs3.getString("PRICE2")),
				 Integer.parseInt(rs3.getString("IDPRODUCT3")),
				 rs3.getString("NAMEPRODUCT3"),
			Integer.parseInt(rs3.getString("QUANTITY3")),
				 Float.parseFloat(rs3.getString("PRICE3")),
				Integer.parseInt(rs3.getString("IDPRODUCT4")),
				 rs3.getString("NAMEPRODUCT4"),
				Integer.parseInt(rs3.getString("QUANTITY4")),
				Float.parseFloat(rs3.getString("PRICE4")),
				Integer.parseInt(rs3.getString("IDPRODUCT5")),
				 rs3.getString("NAMEPRODUCT5"),
				Integer.parseInt(rs3.getString("QUANTITY5")),
				 Float.parseFloat(rs3.getString("PRICE5")));
			for (int w = 0; w < Stock.getStocks().size(); w++) {
				if (Integer.parseInt(rs3.getString("IDPRODUCT1")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY1")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						a.add( new Stock (Integer.parseInt(rs3.getString("IDPRODUCT1")), rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2"))-Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));		
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT2")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY2")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						a.add( new Stock (Integer.parseInt(rs3.getString("IDPRODUCT1")), rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2"))-Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));		
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT3")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY3")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						a.add( new Stock (Integer.parseInt(rs3.getString("IDPRODUCT1")), rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2"))-Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));		
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT4")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY4")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						a.add( new Stock (Integer.parseInt(rs3.getString("IDPRODUCT1")), rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2"))-Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));		
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT5")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY5")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						a.add( new Stock (Integer.parseInt(rs3.getString("IDPRODUCT1")), rs3.getString("NAMEPRODUCT2"), Integer.parseInt(rs3.getString("QUANTITY2"))-Stock.getStocks().get(w).stock + Stock.getStocks().get(w).minQuantity));		
					}
				}
			}
			
			}
 			rs3.close(); //closing ResultSet
			stmt.close(); //closing PreparedStatement
		return a;
	} catch (Exception e) {

				throw new Exception(e.getMessage());

			} finally {

				if(con != null) // if connection is still open, then close.
					con.close();

			}
	}
	public static ArrayList<Order> getGoodOrders() throws Exception {
		Connection con = null;

		/*
		 * Builds the sql query
		 */
		String sql = "SELECT * FROM Orders ";

		/*if (orderByColumn != null && orderByDirection != null) {
			sql += " ORDER BY " + orderByColumn + " " + orderByDirection;
		}*/

		DB db = new DB();
		ArrayList<Order> GoodOrders =  new ArrayList<Order>();

		try {
			// open connection and get Connection object
			con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);

			// execute the SQL statement (QUERY - SELECT) and get the results in a ResultSet)
			ResultSet rs3 = stmt.executeQuery();

			while (rs3.next()) {
				Order st = new Order( Integer.parseInt(rs3.getString("IDORDER")),
				 Integer.parseInt(rs3.getString("IDCUSTOMER")),
				 rs3.getString("NAMECUSTOMER"),
				 rs3.getString("DATE_OF_ORDER"),
				Integer.parseInt(rs3.getString("IDPRODUCT1")),
				rs3.getString("NAMEPRODUCT1"),
				Integer.parseInt(rs3.getString("QUANTITY1")),
				 Float.parseFloat(rs3.getString("PRICE1")),
				 Integer.parseInt(rs3.getString("IDPRODUCT2")),
				 rs3.getString("NAMEPRODUCT2"),
				 Integer.parseInt(rs3.getString("QUANTITY2")),
				Float.parseFloat(rs3.getString("PRICE2")),
				 Integer.parseInt(rs3.getString("IDPRODUCT3")),
				 rs3.getString("NAMEPRODUCT3"),
			Integer.parseInt(rs3.getString("QUANTITY3")),
				 Float.parseFloat(rs3.getString("PRICE3")),
				Integer.parseInt(rs3.getString("IDPRODUCT4")),
				 rs3.getString("NAMEPRODUCT4"),
				Integer.parseInt(rs3.getString("QUANTITY4")),
				Float.parseFloat(rs3.getString("PRICE4")),
				Integer.parseInt(rs3.getString("IDPRODUCT5")),
				 rs3.getString("NAMEPRODUCT5"),
				Integer.parseInt(rs3.getString("QUANTITY5")),
				 Float.parseFloat(rs3.getString("PRICE5")));
				boolean Flag = false;
			for (int w = 0; w < Stock.getStocks().size(); w++) {
				if (Integer.parseInt(rs3.getString("IDPRODUCT1")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY1")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;	
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT2")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY2")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT3")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY3")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT4")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY4")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
				if (Integer.parseInt(rs3.getString("IDPRODUCT5")) == Stock.getStocks().get(w).id) {
					if (Integer.parseInt(rs3.getString("QUANTITY5")) > Stock.getStocks().get(w).stock -  Stock.getStocks().get(w).minQuantity) {
						Flag = true;
					}
				}
			}
			if (Flag == false) {
				GoodOrders.add(st);
			}
		}
 			rs3.close(); //closing ResultSet
			stmt.close(); //closing PreparedStatement
	return GoodOrders;
	} catch (Exception e) {

				throw new Exception(e.getMessage());

			} finally {

				if(con != null) // if connection is still open, then close.
					con.close();

			}
	}
	
	public static ArrayList<Stock> getNeedProduct( ArrayList<Stock> a){
		ArrayList<Stock> NeedProduct =  new ArrayList<Stock>();
		int	count;
		for (int i = 0 ; i < a.size() ; i++) {
			count = 0;
			for( int x =0 ; x < a.size() ; x++) {
				if ( a.get(i).id == a.get(x).id) {
					count = count + a.get(x).need;
				}
			}
			NeedProduct.add(new Stock(a.get(i).id, a.get(i).name, count));
		}
		return NeedProduct;
	}
}
