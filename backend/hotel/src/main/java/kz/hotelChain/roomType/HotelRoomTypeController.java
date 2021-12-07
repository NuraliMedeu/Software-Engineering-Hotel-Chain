package kz.hotelChain.roomType;

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
@RequestMapping("/api/room_types")
public class HotelRoomTypeController {
	private final HotelRoomTypeService service;
	
	@Autowired
	public HotelRoomTypeController(HotelRoomTypeService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<HotelRoomType> getTypes() {
		return this.service.getTypes();
	}
}