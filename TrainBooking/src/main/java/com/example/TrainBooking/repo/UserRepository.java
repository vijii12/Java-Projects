package com.example.TrainBooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TrainBooking.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
}
