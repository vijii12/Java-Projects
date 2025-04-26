package bankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	private static final String URL="jdbc:mysql://localhost:3306/bank_management";
	private static final String USER="root";
	private static final String PASSWORD="*******";
	
	public static Connection getDbConnection() {
		
		try {
			return DriverManager.getConnection(URL,USER,PASSWORD);
		}
		catch(SQLException e) {
			System.out.println("Database connection failed: "+ e.getMessage());
			return null;
		}
	}
}
