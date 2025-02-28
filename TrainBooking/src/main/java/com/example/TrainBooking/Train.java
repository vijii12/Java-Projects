package com.example.TrainBooking;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="trains")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Train {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,name="train_id")
	private Long id;
	
	@Column(nullable=false,name="train_name")
	private String trainName;
	
	@Column(nullable=false,name="train_number",unique=true)
	private String trainNumber;
	
	@Column(name="source_station")
	private String source;
	
	@Column(name="destination_station")
	private String destination;
	
	@Column(name="travel_date")
	private LocalDate travelDate;
	
	@Column(name="departure_time")
	private LocalTime departureTime;
	
	@Column(name="arrival_time")
	private LocalTime arrivalTime;
	
	private String duration=getDuration();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "train", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<SeatAvailability> seatAvailability;
	 
	public Train() {
		
	}
	public Train( String trainName, String trainNumber, String source, String destination, 
            LocalDate travelDate, LocalTime departureTime, LocalTime arrivalTime) {
	   this.trainName = trainName;
	   this.trainNumber = trainNumber;
	   this.source = source;
	   this.destination = destination;
	   this.travelDate = travelDate;
	   this.departureTime = departureTime;
	   this.arrivalTime = arrivalTime;
	}

	public String getDuration() {
		 if(departureTime!=null && arrivalTime!=null ) {
			 Duration duration=Duration.between(departureTime, arrivalTime);
			 long hours=duration.toHours();
			 long mins=duration.toMinutes()%60;
			 return String.format("%02d:%02d",hours,mins); //5hr 10 min 05:10 (atleast two digits invlove
		 }
		 return "";
	 }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public List<SeatAvailability> getSeatAvailability() {
		return seatAvailability;
	}
	public void setSeatAvailability(List<SeatAvailability> seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
