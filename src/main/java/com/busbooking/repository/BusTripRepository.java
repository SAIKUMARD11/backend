package com.busbooking.repository;
import com.busbooking.model.BusTrip;import org.springframework.data.jpa.repository.JpaRepository;import java.time.LocalDate;import java.util.List;
public interface BusTripRepository extends JpaRepository<BusTrip,Long>{List<BusTrip> findBySourceCityIgnoreCaseAndDestinationCityIgnoreCaseAndTravelDate(String sourceCity,String destinationCity,LocalDate travelDate);}
