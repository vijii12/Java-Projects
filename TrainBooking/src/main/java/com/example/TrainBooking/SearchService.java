package com.example.TrainBooking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainBooking.repo.TrainRepository;

@Service
public class SearchService {
	private final TrainRepository trainRepo;
	
	@Autowired
	public SearchService(TrainRepository trainRepo) {
		this.trainRepo=trainRepo;
	}
	
	public List<Train> searchTrains(String source,String destination,LocalDate travelDate){
		System.out.println("In service"+ source+" ->"+destination+"->"+travelDate);
		
		List<Train> trains= trainRepo.findTrains(source, destination,travelDate);
		
//		List<Train> trains= trainRepo.findBySourceAndDestination(source, destination);
		System.out.println(trains.size());
		return trains;
	}
}
