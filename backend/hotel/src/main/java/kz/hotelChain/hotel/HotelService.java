package kz.hotelChain.hotel;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.repositories.HotelsRepository;

@Service
@Component
public class HotelService {
	private final HotelsRepository repo;
	
	@Autowired
	public HotelService(HotelsRepository repo) {
		this.repo = repo;
	}
	
	public List<Hotel> getHotels() {
		return repo.findAll();
	}
	
	public Hotel getHotel(Integer id) {
		try {
			return repo.findById(id).get();
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	// TODO
	public Hotel addHotel(Hotel hotel) {
		return this.repo.save(hotel);
	}
	
	//TODO
	public Hotel updateHotel(Integer id, Hotel data) {
		try {
			Hotel hotel = this.repo.findById(id).get();
			hotel.setName(data.getName() != null ? data.getName() : hotel.getName());
			hotel.setDestination(data.getDestination() != null ? data.getDestination() : hotel.getDestination());
			hotel.setPhones(data.getPhones() != null ? data.getPhones() : hotel.getPhones());
			hotel.setRoom_types(data.getRoom_types() != null ? data.getRoom_types() : hotel.getRoom_types());
			hotel.setRooms(data.getRooms() != null ? data.getRooms() : hotel.getRooms());
			
			return this.repo.save(hotel);
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String deleteHotel(Integer id) {
		try {
			this.repo.deleteById(id);
			return "Deleted with id: " + id;
		} catch(Exception e) {
			return "Not Found";
		}
	}
}
