package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.hotelChain.user.guest.Guest;

@Repository
public interface GuestsRepository extends JpaRepository<Guest, String> {

}
