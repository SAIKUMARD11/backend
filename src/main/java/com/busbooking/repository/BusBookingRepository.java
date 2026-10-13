package com.busbooking.repository;
import com.busbooking.model.BusBooking;import org.springframework.data.jpa.repository.JpaRepository;import java.util.Optional;
public interface BusBookingRepository extends JpaRepository<BusBooking,Long>{boolean existsByBookingReference(String ref);Optional<BusBooking> findByBookingReferenceIgnoreCase(String ref);}
