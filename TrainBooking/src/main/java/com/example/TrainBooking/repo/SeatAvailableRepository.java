package com.example.TrainBooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrainBooking.SeatAvailability;

@Repository
public interface SeatAvailableRepository extends JpaRepository<SeatAvailability,Long> {

}
