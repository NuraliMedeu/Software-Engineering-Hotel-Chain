package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.hotelChain.booking.Booking;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Integer> {

}
