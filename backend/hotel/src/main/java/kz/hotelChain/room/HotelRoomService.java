package kz.hotelChain.room;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.repositories.HotelRoomTypesRepository;
import kz.hotelChain.repositories.HotelRoomsRepository;
import kz.hotelChain.roomType.HotelRoomType;

@Service
@Component
public class HotelRoomService {
	private final HotelRoomsRepository repo;
	
	@Autowired
	public HotelRoomService(HotelRoomsRepository repo) {
		this.repo = repo;
	}
	
	public List<HotelRoom> getRooms() {
		return this.repo.findAll();
	}
}