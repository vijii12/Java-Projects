package libraryManagementLLD;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private boolean isAvailable;
	
	public Book(String title,String author,String isbn) {
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.isAvailable=true;
	}
	
	public boolean isBookAvailabe() {
		return isAvailable;
	}
	
	public void setBookAvailable(boolean availability) {
		this.isAvailable=availability;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	
	
}
