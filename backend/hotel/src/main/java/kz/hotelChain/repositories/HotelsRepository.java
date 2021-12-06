package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.hotelChain.hotel.Hotel;

public interface HotelsRepository extends JpaRepository<Hotel, Integer> {

}
