package com.example.TrainBooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainBooking.SearchService;
import com.example.TrainBooking.Train;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/api/trains")
public class SearchController {

	private final SearchService searchService;
	
	@Autowired
	public SearchController (SearchService searchService) {
		this.searchService=searchService;
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Train>> searchTrains(
			@RequestParam String from,
			@RequestParam String to,
			@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date){
		System.out.println("In Controller");
		System.out.println(date);
		from=from.toLowerCase().trim();
		to=to.toLowerCase().trim();
		List<Train> trains=searchService.searchTrains(from, to, date);
//		System.out.println(trains.get(0).getSeatAvailability().get(0));
	
		return ResponseEntity.ok(trains);
		
	}
			
			
	
}
