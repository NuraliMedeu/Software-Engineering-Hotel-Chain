package kz.hotelChain.hotel;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	private final HotelService service;
	
	@Autowired
	public HotelController(HotelService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Hotel> getHotels() {
		return this.service.getHotels();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Hotel getHotel(@PathVariable Integer id) {
		return this.service.getHotel(id);
	}
	
	@PostMapping
	@ResponseBody
	public Hotel newHotel(@RequestBody Hotel req) throws SQLException {
	    return this.service.addHotel(req);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Hotel putHotel(@PathVariable Integer id, @RequestBody Hotel req) throws SQLException {
	    return this.service.updateHotel(id, req);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deleteHotel(@PathVariable Integer id) throws SQLException {
	    return this.service.deleteHotel(id);
	}
}
