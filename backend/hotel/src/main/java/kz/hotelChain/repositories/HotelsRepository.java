package kz.hotelChain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kz.hotelChain.hotel.Hotel;

@Repository
public interface HotelsRepository extends JpaRepository<Hotel, Integer> {
	@Query("SELECT h FROM Hotel h")
	public List<Hotel> checkQuery();
	
	@Query("SELECT DISTINCT H, HRT FROM Hotel H, HotelRoomType HRT WHERE H.destination LIKE %?1% AND HRT.capacity >= ?2 AND HRT.id=H.id")
	public List<Hotel> search(String dest, Integer capacity);
}
