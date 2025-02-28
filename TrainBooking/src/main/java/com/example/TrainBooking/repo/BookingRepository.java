package com.example.TrainBooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrainBooking.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
	
}
