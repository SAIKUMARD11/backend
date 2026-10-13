package com.busbooking.model;
import jakarta.persistence.*;import java.time.*;
@Entity public class BusTrip {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String operatorName,sourceCity,destinationCity; private LocalDate travelDate; private LocalTime departureTime,arrivalTime;
 private String busType; private Double fare; private Integer availableSeats;
 public BusTrip(){}
 public BusTrip(String o,String s,String d,LocalDate date,LocalTime dep,LocalTime arr,String type,Double fare,Integer seats){operatorName=o;sourceCity=s;destinationCity=d;travelDate=date;departureTime=dep;arrivalTime=arr;busType=type;this.fare=fare;availableSeats=seats;}
 public Long getId(){return id;} public String getOperatorName(){return operatorName;} public String getSourceCity(){return sourceCity;} public String getDestinationCity(){return destinationCity;}
 public LocalDate getTravelDate(){return travelDate;} public LocalTime getDepartureTime(){return departureTime;} public LocalTime getArrivalTime(){return arrivalTime;} public String getBusType(){return busType;}
 public Double getFare(){return fare;} public Integer getAvailableSeats(){return availableSeats;} public void setAvailableSeats(Integer v){availableSeats=v;}
}
