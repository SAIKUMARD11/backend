package com.busbooking.controller;
import com.busbooking.model.*;import com.busbooking.repository.*;import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import org.springframework.web.server.ResponseStatusException;import java.util.UUID;
@RestController @RequestMapping("/api/bookings") public class BusBookingController {
 private final BusBookingRepository bookings;private final BusTripRepository trips;
 public BusBookingController(BusBookingRepository b,BusTripRepository t){bookings=b;trips=t;}
 @PostMapping public BusBooking create(@RequestBody Request q){
 if(q.tripId==null||q.passengerName==null||q.passengerName.isBlank()||q.phone==null||!q.phone.matches("\\d{10}")||q.seats==null||q.seats<1||q.seats>6)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter name, valid 10-digit phone, trip and 1 to 6 seats");
 BusTrip t=trips.findById(q.tripId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Trip not found"));
 if(t.getAvailableSeats()<q.seats)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Not enough seats available");
 t.setAvailableSeats(t.getAvailableSeats()-q.seats);trips.save(t);BusBooking b=new BusBooking();b.setPassengerName(q.passengerName.trim());b.setPhone(q.phone);b.setSeats(q.seats);b.setTotalFare(t.getFare()*q.seats);
 b.setTripId(t.getId());b.setOperatorName(t.getOperatorName());b.setSourceCity(t.getSourceCity());b.setDestinationCity(t.getDestinationCity());b.setTravelDate(t.getTravelDate().toString());
 String ref;do{ref="BUS-"+UUID.randomUUID().toString().substring(0,8).toUpperCase();}while(bookings.existsByBookingReference(ref));b.setBookingReference(ref);return bookings.save(b);}
 @GetMapping("/{reference}") public BusBooking get(@PathVariable String reference){return bookings.findByBookingReferenceIgnoreCase(reference).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Booking not found"));}
 public static class Request{public Long tripId;public String passengerName,phone;public Integer seats;}
}
