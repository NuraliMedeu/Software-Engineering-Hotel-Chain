package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.hotelChain.roomType.HotelRoomType;
import kz.hotelChain.roomType.HotelRoomTypeId;

public interface HotelRoomTypesRepository extends JpaRepository<HotelRoomType, HotelRoomTypeId> {

}
