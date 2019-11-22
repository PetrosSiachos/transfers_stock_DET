/*package ;        */
import java.sql.*;

public class ConnectMySQL {
	private final String dbServer = "195.251.249.131";
	private final String dbServerPort = "3306";
	private final String dbName = "ismgroup28";
	private final String dbusername = "ismgroup28";
	private final String dbpassword = "v9c5dm";

	private Connection conn = null;
	
	
	public Connection getConnection() throws Exception {		

		try {			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (Exception e) {

			throw new Exception("MySQL Driver error: " + e.getMessage());
		}


		try {

			conn = DriverManager.getConnection("jdbc:mysql://" 
				+ dbServer + ":" + dbServerPort + "/" + dbName, dbusername, dbpassword);

			
			return conn;

		} catch (Exception e) {
			
		
			throw new Exception("Could not establish connection with the Database Server: " 
				+ e.getMessage());
		}

	} // End of getConnection

	
	public void close() throws SQLException {

		try {
			if (conn != null)
				conn.close();

		} catch (SQLException e) {

			throw new SQLException("Could not close connection with the Database Server: " 
				+ e.getMessage());
		}
	}
}