package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.hotelChain.hotel.Hotel;

@Repository
public interface HotelsRepository extends JpaRepository<Hotel, Integer> {

}
