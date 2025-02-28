package com.example.TrainBooking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="booking-details")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String trainNumber;
	private String trainName;
	private String departureTime;
	private double fare;
	private String paymentMethod;
	
	@ManyToOne
	@JoinColumn(name="user-id")
	private User user;
	
	
	public Booking() {
		
	}
	public Booking(String trainNumber, String trainName, String departureTime, double fare, String paymentMethod,
			User user) {
		super();
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.departureTime = departureTime;
		this.fare = fare;
		this.paymentMethod = paymentMethod;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
