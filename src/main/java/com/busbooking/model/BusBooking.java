package com.busbooking.model;
import jakarta.persistence.*;import java.time.*;
@Entity @Table(name="bus_bookings") public class BusBooking {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String bookingReference,passengerName,phone,status="CONFIRMED"; private Integer seats; private Double totalFare; private LocalDateTime bookedAt=LocalDateTime.now();
 private Long tripId; private String operatorName,sourceCity,destinationCity,travelDate;
 public BusBooking(){} public Long getId(){return id;} public String getBookingReference(){return bookingReference;} public String getPassengerName(){return passengerName;}
 public String getPhone(){return phone;} public Integer getSeats(){return seats;} public Double getTotalFare(){return totalFare;} public String getStatus(){return status;}
 public Long getTripId(){return tripId;} public String getOperatorName(){return operatorName;} public String getSourceCity(){return sourceCity;} public String getDestinationCity(){return destinationCity;} public String getTravelDate(){return travelDate;}
 public void setBookingReference(String v){bookingReference=v;} public void setPassengerName(String v){passengerName=v;} public void setPhone(String v){phone=v;} public void setSeats(Integer v){seats=v;} public void setTotalFare(Double v){totalFare=v;}
 public void setTripId(Long v){tripId=v;} public void setOperatorName(String v){operatorName=v;} public void setSourceCity(String v){sourceCity=v;} public void setDestinationCity(String v){destinationCity=v;} public void setTravelDate(String v){travelDate=v;}
}
