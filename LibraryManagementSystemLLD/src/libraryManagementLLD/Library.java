package libraryManagementLLD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	
	private static Library libraryInstance;
	
	static BookManager bookManage;
	static MemberManager memberManage;
	static List<Transaction> transactionLists=new ArrayList<>();
	
	private Library(BookManager bm,MemberManager mm) {
		this.bookManage=bm;
		this.memberManage=mm;
	}
	
	public static Library getInstance(BookManager bm,MemberManager mm) {
		if(libraryInstance==null) {
			libraryInstance=new Library(bm,mm);
		}
		return libraryInstance;
	}
	
	public void addbook(Book book) {
		bookManage.addBook(book);
	}
	public void addMember(Member member) {
		memberManage.addMember(member);
	}
	public void removeBook(Book book) {
		bookManage.removeBook(book);
	}
	
	public Book searchBook() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a Search Type --> title/author/isbn:");
		
		String type=input.nextLine();
		Book book=null;
		if(type.equals("title")) {
			book=bookManage.searchBookByTitle(type);
		}
		
		else if(type.equals("author")) {
			 book= bookManage.searchBookByTitle(type);
		}
		
		else if(type.equals("isbn")) {
			 book= bookManage.searchBookByTitle(type);
		}
		
		return book;
	}
	
	public void borrow(Member member ,Book book) {
		if(bookManage.canBorrow(book) && memberManage.memberCanBorrow(member)) {
			memberManage.addBookInborrowList(member, book);
			transactionLists.add(new Transaction(member,book));
			System.out.println("Book borrowed SuccessFully");
		}
		
		else if(!memberManage.memberCanBorrow(member)) {
			System.out.println("you can't borrow book.your borrow limit has exist");
		}
		else {
			System.out.println("you can't borrow book because book not available");
		}
	}
	
	public void returnBook(Member member,Book book,LocalDate returnDate) {
		for(Transaction transaction:transactionLists) {
			if(transaction.gerMember().equals(member) && transaction.getBook() .equals(book)) {
				double fee=transaction.calculateFee(returnDate);
				System.out.println("your fee for delay: "+ fee);
				memberManage.returnBook(member, book);
				bookManage.returnBook(book);
				System.out.println("book returned successfully");
				break;
			}
		}
		
	}
	
	public List<Book> memberBorrowBooks(Member member){
		return memberManage.memberBorrowList(member);
	}
}
