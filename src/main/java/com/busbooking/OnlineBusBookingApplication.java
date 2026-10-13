package com.busbooking;
import com.busbooking.model.BusTrip;
import com.busbooking.repository.BusTripRepository;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;
import java.time.*;
@SpringBootApplication
public class OnlineBusBookingApplication {
 public static void main(String[] args){SpringApplication.run(OnlineBusBookingApplication.class,args);}
 @Bean CommandLineRunner seed(BusTripRepository r){return args->{if(r.count()==0){LocalDate d=LocalDate.now().plusDays(1);
 r.save(new BusTrip("Deccan Express Travels","Hyderabad","Bengaluru",d,LocalTime.of(21,0),LocalTime.of(7,0),"AC Sleeper",899.0,28));
 r.save(new BusTrip("Orange Roadlines","Hyderabad","Vijayawada",d,LocalTime.of(8,30),LocalTime.of(13,0),"AC Seater",499.0,32));
 r.save(new BusTrip("GreenLine Coaches","Bengaluru","Chennai",d,LocalTime.of(22,15),LocalTime.of(5,30),"AC Sleeper",749.0,24));
 r.save(new BusTrip("CityLink Travels","Hyderabad","Visakhapatnam",d,LocalTime.of(19,0),LocalTime.of(6,0),"Non-AC Sleeper",699.0,20));
 r.save(new BusTrip("Morning Star Bus","Vijayawada","Hyderabad",d,LocalTime.of(6,0),LocalTime.of(11,0),"AC Seater",449.0,35));}};}
 @Bean WebMvcConfigurer cors(){return new WebMvcConfigurer(){public void addCorsMappings(CorsRegistry r){r.addMapping("/api/**").allowedOrigins("http://localhost:5173").allowedMethods("GET","POST","OPTIONS").allowedHeaders("*");}};}
}
