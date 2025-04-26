package bankManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankService {
	
	//create Account 
	public void createAccount(Account account,Connection conn) {
		String query="Insert into accounts (account_name,account_number,balance) values (?,?,?)";
		try{
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setString(1, account.getAccountHolderName());
			statement.setString(2, account.getAccountNumber());
			statement.setDouble(3, account.getBalance());
			statement.executeUpdate();
			System.out.println("Account created successfully");
		}
		
		catch(SQLException e) {
			System.out.println("failed to create account: "+e.getMessage());
		}
	}
	
	public void deposit (Account account,double amount,Connection conn) {
		String query="UPDATE accounts SET balance= balance+? WHERE account_number=?";
		try {
			PreparedStatement statement= conn.prepareStatement(query);
			statement.setDouble(1, amount);
			statement.setString(2, account.getAccountNumber());
			statement.executeUpdate();
			System.out.println("Your Money deposited "+account.getAccountHolderName());
			
			Scanner input=new Scanner(System.in);
			System.out.println("Do you want to check your Bank Balance "+account.getAccountHolderName() +"? give Yes/No" );
			
			String getInput=input.nextLine();
			
			
			if(getInput.toLowerCase().equals("yes")) {
				checkBalance(account,conn);
			}
			else {
				System.out.println("Thank you for visiting");
			}
		}
		catch(SQLException e) {
			System.out.println("Can't deposit balance: "+e.getMessage());
		}
		
		
	}

	public void checkBalance(Account account, Connection conn) {
		
		String query="SELECT balance FROM accounts WHERE account_number=?";
		try {
			PreparedStatement statement=conn.prepareStatement(query);
			statement.setString(1,account.getAccountNumber());
			ResultSet result=statement.executeQuery();
			if(result.next()) {
				System.out.println(account.getAccountHolderName()+" your account balance : "+result.getDouble("balance"));
			}
			else {
				System.out.println("Account not found");
			}
		}
		catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void withdraw(Account account,Connection conn,double amount) {
		String query="UPDATE accounts SET balance=? WHERE account_number=?";
		String getBalanceQuery="SELECT balance FROM accounts WHERE account_number=?";
		try {
			PreparedStatement statement=conn.prepareStatement(query);
			PreparedStatement balanceStatement=conn.prepareStatement(getBalanceQuery);
			balanceStatement.setString(1, account.getAccountNumber());
			ResultSet result=balanceStatement.executeQuery();
			if(result.next()) {
				double balance=result.getDouble("balance");
				balance=balance-amount;
				statement.setDouble(1, balance);
				statement.setString(2, account.getAccountNumber());
				statement.executeUpdate();
				System.out.println("WithDrawal Successful!");
				
				
				Scanner input=new Scanner(System.in);
				System.out.println("Do you want to check your Bank Balance "+account.getAccountHolderName() +"? give Yes/No" );
				
				String getInput=input.nextLine();
				
				if(getInput.toLowerCase().equals("yes")) {
					checkBalance(account,conn);
				}
				else {
					System.out.println("Thank you for visiting");
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
