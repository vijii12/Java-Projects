package com.example.TrainBooking;

public class BookingRequest {
	
	private String trainNumber;
    private String trainName;
    private String departureTime;
    private String classSeat;
    private double fare;
    
    
	
	private String paymentMethod;

    private String name;
    private int age;
    private String gender;
    
    
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassSeat() {
		return classSeat;
	}
	public void setClassSeat(String classSeat) {
		this.classSeat = classSeat;
	}
    
    

}
