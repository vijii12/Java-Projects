package com.example.TrainBooking;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="seat_availability")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatAvailability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="train_id",nullable=false)
	private Train train;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="seat_class",nullable=false)
	private SeatClass classSeat;
	
	@Column(name="travel_date", nullable=false)
	private LocalDate travelDate;
	
	@Column(name="total_seats",nullable=false)
	private int totalSeats;
	
	@Column(name="available_seats",nullable=false)
	private int availableSeats;
	
	@Column(name="fare")
	private double fare;
	
	public SeatAvailability(Train train, SeatClass classSeat,LocalDate date, int totalSeats,double fare) {
        this.train = train;
        this.classSeat = classSeat;
        this.travelDate=date;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;  // Default available seats = total seats
        this.fare=fare;
    }
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public SeatAvailability() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public SeatClass getClassSeat() {
		return classSeat;
	}
	public void setClassSeat(SeatClass classSeat) {
		this.classSeat = classSeat;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
}

enum SeatClass{
	ALLCLASSES,FIRSTCLASS,SLEEPER,SECONDSITTING
}
