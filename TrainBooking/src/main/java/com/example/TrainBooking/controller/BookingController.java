package com.example.TrainBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainBooking.BookingRequest;
import com.example.TrainBooking.BookingService;

@RequestMapping("/api/bookings")
@CrossOrigin(origins="*")
@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/confirm")
	public ResponseEntity<String> bookTicket(@RequestBody BookingRequest request) {
		
		System.out.println("In Booking Control");
		if(bookingService.process(request)) {
			return ResponseEntity.ok("Ticket Booked Successfully!!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed to book");
	}
	
}
