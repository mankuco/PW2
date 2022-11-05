package pw.connection;

import java.sql.*;

public class DBConnection {

	protected Connection connection = null;
	
	protected String url = "jdbc:mysql://oraclepr.uco.es:3306/i92curam";

	protected String user = "i92curam";

	protected String password = "pw1234";

	public Connection getConnection(){
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
			System.exit(0);
		}
		catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
			System.exit(0);
		}
		return this.connection;
	}

	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
			}
		}
		catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
			System.exit(0);
		}
	}
}