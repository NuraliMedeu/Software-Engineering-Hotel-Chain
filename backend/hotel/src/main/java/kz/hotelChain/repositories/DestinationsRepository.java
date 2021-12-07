package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.hotelChain.destination.Destination;

public interface DestinationsRepository extends JpaRepository<Destination, String> {

}
