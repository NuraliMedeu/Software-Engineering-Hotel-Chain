package kz.hotelChain.roomType;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.hotel.Hotel;
import kz.hotelChain.repositories.HotelRoomTypesRepository;
import kz.hotelChain.repositories.HotelsRepository;
import kz.hotelChain.repositories.IDTypesRepository;
import kz.hotelChain.repositories.UsersRepository;

@Service
@Component
public class HotelRoomTypeService {
	private final HotelRoomTypesRepository repo;
	
	@Autowired
	public HotelRoomTypeService(HotelRoomTypesRepository repo) {
		this.repo = repo;
	}
	
	public List<HotelRoomType> getTypes() {
		return this.repo.findAll();
	}
}