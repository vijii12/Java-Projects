package libraryManagementLLD;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class Transaction {
	static int feesPerDay=2;
	private Member member;
	private Book book;
	private LocalDate borrowDate;
	private LocalDate returnDate;
	private double fee;
	public Transaction(Member member,Book book) {
		this.book=book;
		this.member=member;
		this.borrowDate=LocalDate.now();
		this.returnDate=null;
		this.fee=0.0;
	}
	
	public Member gerMember() {
		return member;
	}
	public Book getBook() {
		return book;
	}
	public LocalDate getBorrowTime() {
		return borrowDate;
	}
	
	public double calculateFee(LocalDate returnDate) {
		this.returnDate=returnDate;
		long days=ChronoUnit.DAYS.between(borrowDate.plusDays(14), returnDate);
		double fee=days>0 ? (days*feesPerDay) : 0;
		this.fee=fee;
		return fee;
	}
	
	
	
}
