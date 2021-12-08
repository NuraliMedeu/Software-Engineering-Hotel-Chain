package kz.hotelChain.userType.user;

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

@RestController
@RequestMapping("/api/user")
public class UserController {
	private final UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<User> getGuests() {
		return this.service.getGuests();
	}
	
	@GetMapping("/{email}")
	public User getGuest(@PathVariable String email) {
		return this.service.getGuest(email);
	}
	
	@PostMapping
	public User addGuest(@RequestBody User guest) {
		return this.service.addGuest(guest);
	}
	
	@PutMapping
	public User updateGues(@RequestBody User guest) {
		return this.service.updateGuest(guest);
	}
	
	@DeleteMapping
	public String deleteGuest(@RequestBody User user) {
		return this.service.deleteGuest(user);
	}
}
