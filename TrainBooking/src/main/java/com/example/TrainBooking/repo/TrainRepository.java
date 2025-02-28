package com.example.TrainBooking.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TrainBooking.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train,Long> {
	
	@Query("SELECT t from Train t WHERE t.source=:source AND t.destination=:destination AND t.travelDate=:travelDate")
	List<Train> findTrains(@Param("source") String source,@Param("destination") String destination,@Param("travelDate") LocalDate travelDate);

	Train getByTrainName(String trainName);
	
//	List<Train> findBySourceAndDestination(String source, String destination);
	
}
