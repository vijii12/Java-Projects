package com.example.TrainBooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.TrainBooking.repo.SeatAvailableRepository;
import com.example.TrainBooking.repo.TrainRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication

public class TrainBookingApplication implements CommandLineRunner {
	@Autowired 
	private TrainRepository trainRepo;
	
	@Autowired
	private SeatAvailableRepository seatAvailableRepo;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(TrainBookingApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		initializeTrainData();
		
	}
	@Transactional
	private void initializeTrainData() {
		if(trainRepo.count()==0) {
			Train train1=new Train("Express Train","12345","chennai","tenkasi",
					LocalDate.now().plusDays(2),LocalTime.of(8, 0),LocalTime.of(12, 15));
			
			Train train2=new Train("Super Train","12245","chennai","tirunelveli",
					LocalDate.now().plusDays(1),LocalTime.of(6, 30),LocalTime.of(10, 30));
			
			Train train3=new Train("Express Super Train","2112","tenkasi","chennai",
					LocalDate.now().plusDays(2),LocalTime.of(4, 40),LocalTime.of(9, 25));
			
			trainRepo.save(train1);
			trainRepo.save(train2);
			trainRepo.save(train3);
			
			SeatAvailability seat1=new SeatAvailability(train1,SeatClass.FIRSTCLASS,LocalDate.now().plusDays(2),50,250);
			SeatAvailability seat2=new SeatAvailability(train2,SeatClass.FIRSTCLASS,LocalDate.now().plusDays(1),50,250);
			SeatAvailability seat3=new SeatAvailability(train1,SeatClass.SLEEPER,LocalDate.now().plusDays(2),100,200);
			SeatAvailability seat4=new SeatAvailability(train2,SeatClass.SECONDSITTING,LocalDate.now().plusDays(1),25,100);
			SeatAvailability seat5=new SeatAvailability(train3,SeatClass.FIRSTCLASS,LocalDate.now().plusDays(2),50,250);
			SeatAvailability seat6=new SeatAvailability(train3,SeatClass.SLEEPER,LocalDate.now().plusDays(2),120,200);
			
			seatAvailableRepo.saveAll(Arrays.asList(seat1,seat2,seat3,seat4,seat5,seat6));
			
		}
	}
}
