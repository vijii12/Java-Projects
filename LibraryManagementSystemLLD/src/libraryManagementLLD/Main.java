package libraryManagementLLD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Book book1=new Book("The Great Gatsby", "F. Scott Fitzgerald", "12345");
		Book book2=new Book("1984", "George Orwell", "67890");
		Book book3=new Book("our Beautiful Love Story","viji tom","212");
		Book book4=new Book("vhiueyrt","bhoieur","2345");
		List<Book> bookLists=new ArrayList<>(Arrays.asList(book1,book2,book3));
		BookManager bookmgr=new BookManager(bookLists);
		Member member1=new Member(1,"tom");
		Member member2=new Member(2,"viji");
		Member member3=new Member(3,"kuttytom");
		List<Member> memberLists=Arrays.asList(member1,member2,member3);
		MemberManager membermgr=new MemberManager(memberLists);
		Library library=Library.getInstance(bookmgr, membermgr);
		
		
		library.addbook(new Book("nhiu","asdf","5432"));
		
		library.borrow(member3, book4);
		library.borrow(member3, book4);
		library.returnBook(member3, book4,LocalDate.of(2024,12,15));
		library.borrow(member3, book4);
		library.borrow(member3, book3);
		library.returnBook(member3, book4,LocalDate.of(2025, 1, 14));
		
		
		List<Book> books=library.memberBorrowBooks(member3);
		for(Book book:books) {
			System.out.println(book.getTitle());
		}
		
		
		
	}

}
