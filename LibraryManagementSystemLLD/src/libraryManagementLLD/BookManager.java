package libraryManagementLLD;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
	List<Book> bookLists=new ArrayList<>();
	
	public BookManager(List<Book> books) {
		this.bookLists=books;
	}
	
	public Book searchBookByAuthor(String author) {
		for(Book book:bookLists) {
			if(author.equals(book.getAuthor())){
				return book;
			}
		}
		return null;
	}
	public Book searchBookByTitle(String title) {
		for(Book book:bookLists) {
			if(title.equals(book.getTitle())){
				return book;
			}
		}
		return null;
	}
	public Book searchBookByIsbn(String isbn) {
		for(Book book:bookLists) {
			if(isbn.equals(book.getIsbn())){
				return book;
			}
		}
		return null;
	}
	
	public void addBook(Book book) {
		bookLists.add(book);
		System.out.println("Book added Successfully");
	}
	
	public void removeBook(Book book) {
		for(Book books:bookLists) {
			if((searchBookByTitle(books.getTitle()).equals(book))){
				bookLists.remove(books);
				System.out.println("Book removed SuccessFully");
			}
		}
	}
	
	public Boolean canBorrow(Book book) {
		if(book.isBookAvailabe()) {
			book.setBookAvailable(false);
			return true;
				
		}
		return false;
	}
	
	public void returnBook(Book book) {
		book.setBookAvailable(true);
	}
	
	
}
