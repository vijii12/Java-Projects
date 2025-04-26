package bankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankManagementMain {

	public static void main(String[] args) throws SQLException {
		//DataBase Connection
		DataBaseConnection DBConnection=new DataBaseConnection();
		Connection conn=DBConnection.getDbConnection();
		
		BankService bankService=new BankService();
		
		Account account1=new Account("viji","12345",100);
		Account account2=new Account("tom","12346",100);
		Account account3=new Account("kokila","13456",500);
		
		
		bankService.createAccount(account1,conn);
		bankService.createAccount(account2, conn);
		bankService.createAccount(account3, conn);
		
		
		bankService.deposit(account2, 200, conn);
		
		bankService.withdraw(account2, conn, 100);
		bankService.withdraw(account2, conn, 100);
		
		conn.close();
//		

	

	}

}
