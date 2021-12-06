package kz.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class HotelApplication {
	
	@Autowired
	private HotelsRepository hotelsRepo;

	@Autowired
	private IDTypesRepository idTypesRepo;
	
	@Autowired
	private UsersRepository usersRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
	
	@GetMapping("/hotels")
	@ResponseBody
	public List<Hotel> hotels() throws SQLException {
		List<Hotel> hotels = hotelsRepo.findAll();
		return hotels;
	}
	
	@GetMapping("/hotels/{id}")
	@ResponseBody
	public Hotel getHotel(@PathVariable Integer id) throws SQLException {
		Optional<Hotel> hotel = hotelsRepo.findById(id);
		try {
			return hotel.get();
		} catch(Exception e) {
			return null;
		}
	}
	
	@GetMapping("/hotels/{id}/phones")
	@ResponseBody
	public List<HotelPhone> getHotelPhones(@PathVariable Integer id) throws SQLException {
		Optional<Hotel> hotel = hotelsRepo.findById(id);
		try {
			return hotel.get().getPhones();
		} catch(Exception e) {
			return null;
		}
	}
	
	@PostMapping("/hotels")
	@ResponseBody
	public String newHotel(@RequestBody Hotel req) throws SQLException {
	    Hotel hotel = new Hotel(req.getName(), req.getAddress(), req.getPhones(), req.getRoomTypes());
	    return hotelsRepo.save(hotel).toString();
	}
	
	@PutMapping("/hotels/{id}")
	@ResponseBody
	public String putHotel(@PathVariable Integer id, @RequestBody Hotel req) throws SQLException {
	    if (! hotelsRepo.existsById(req.getId())) {
	    	return new String("Hotel with id " + req.getId() + " does not exist");
	    } else {
		    Hotel hotel = hotelsRepo.getById(req.getId());
		    hotel.setName(req.getName());
		    hotel.setAddress(req.getAddress());
		    hotel.setPhones(req.getPhones());
		    return hotelsRepo.save(hotel).toString();
	    }
	}
	
	@DeleteMapping("/hotels")
	@ResponseBody
	public String deleteHotel(@RequestBody Integer id) throws SQLException {
	    try {
		    hotelsRepo.deleteById(id);
		    return "Deleted hotel with id: " + id;
	    } catch(IllegalArgumentException e) {
	    	return "Could not delete hotel with id: " + id;
	    }
	}
	
	@GetMapping("/id_types")
	public List<IDType> getIdTypes() throws SQLException {
		List<IDType> types = idTypesRepo.findAll();
		return types;
	}
	
	@GetMapping("/user")
	public List<User> registerUser() throws SQLException {
		return usersRepo.findAll();
	}
	
	@PostMapping("/user")
	@ResponseBody
	public void registerUser(@RequestBody User req) throws SQLException {
		usersRepo.save(new User(req.getEmail(), req.getPassword()));
	}
	
}
