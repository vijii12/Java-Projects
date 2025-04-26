package libraryManagementLLD;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {
	private List<Member> membersList=new ArrayList<>();
	
	public MemberManager(List<Member> membersList) {
		this.membersList = membersList;
	}
	
	public boolean memberCanBorrow(Member member) {
		if(member.getBorrowedBookLists().size()<3) {
			return true;
		}
		return false;
	}
	
	public void addMember(Member member) {
		membersList.add(member);
		System.out.println("Menber added successfully");
	}
	public void returnBook(Member member,Book book) {
		if(member.getBorrowedBookLists().contains(book)) {
			member.getBorrowedBookLists().remove(book);
		}
	}
	
	public void addBookInborrowList(Member member,Book book) {
		member.getBorrowedBookLists().add(book);
	}
	
	public List<Book> memberBorrowList(Member member){
		return member.getBorrowedBookLists();
	}
	
}
