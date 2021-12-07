package kz.hotelChain.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.hotelChain.user.User;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
	private final GuestService service;
	
	@Autowired
	public GuestController(GuestService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Guest> getGuests() {
		return this.service.getGuests();
	}
	
	@GetMapping("/{id}")
	public Guest getGuest(@PathVariable Integer id) {
		return this.service.getGuest(id);
	}
	
	@PostMapping
	public Guest addGuest(@RequestBody Guest guest) {
		return this.service.addGuest(guest);
	}
	
	@PutMapping("/{id}")
	public Guest updateGues(@PathVariable Integer id, @RequestBody Guest guest) {
		return this.service.updateGuest(id, guest);
	}
	
	@DeleteMapping("/{id}")
	public String deleteGuest(@PathVariable Integer id) {
		return this.service.deleteGuest(id);
	}
}
