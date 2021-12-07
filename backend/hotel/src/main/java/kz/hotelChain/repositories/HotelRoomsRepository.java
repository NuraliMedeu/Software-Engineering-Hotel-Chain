package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.hotelChain.room.HotelRoom;
import kz.hotelChain.room.HotelRoomId;

public interface HotelRoomsRepository extends JpaRepository<HotelRoom, HotelRoomId> {

}
