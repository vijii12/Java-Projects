package libraryManagementLLD;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private int id;
	private String name;
	private List<Book> borrowedBookLists;
	
	public Member(int id,String name) {
		this.id=id;
		this.name=name;
		this.borrowedBookLists=new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Book> getBorrowedBookLists(){
		return borrowedBookLists;
	}
	
	
	
}
