package com.example.TrainBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainBooking.repo.BookingRepository;
import com.example.TrainBooking.repo.SeatAvailableRepository;
import com.example.TrainBooking.repo.TrainRepository;
import com.example.TrainBooking.repo.UserRepository;

@Service
public class BookingService {
	
	private UserRepository userRepo;
	private BookingRepository bookingRepo;
	private TrainRepository trainRepo;
	private SeatAvailableRepository seatRepo;
	
	@Autowired
	public BookingService(UserRepository userRepo,BookingRepository bookingRepo,
			TrainRepository trainRepo,SeatAvailableRepository seatRepo) {
		this.userRepo=userRepo;
		this.bookingRepo=bookingRepo;
		this.trainRepo=trainRepo;
		this.seatRepo=seatRepo;
	}

	public boolean process(BookingRequest request) {
		// TODO Auto-generated method stub
		System.out.println("In process service");
		
		Train train=trainRepo.getByTrainName(request.getTrainName());
		if(train==null) {
			return false;
		}
		
		SeatClass requestedClass;
		try {
			requestedClass=SeatClass.valueOf(request.getClassSeat().toUpperCase());
			}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		boolean changeSeatCount=false;
		for(SeatAvailability seat:train.getSeatAvailability()) {
			if(seat.getClassSeat()==requestedClass) {
				int availableSeat=seat.getAvailableSeats();
				seat.setAvailableSeats(availableSeat-1);
				changeSeatCount=!changeSeatCount;
				trainRepo.save(train);
				seatRepo.save(seat);
				break;
			}
		}
		
		if(changeSeatCount) {
			User user=new User(request.getName(),request.getAge(),request.getGender());
			userRepo.save(user);
			
			Booking booking=new Booking(request.getTrainNumber(),request.getTrainName(),
					request.getDepartureTime(),request.getFare(),request.getPaymentMethod(),user);
			bookingRepo.save(booking);
		}
		
		return changeSeatCount;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
