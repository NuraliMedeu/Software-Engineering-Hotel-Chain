package kz.hotelChain.userType.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.hotelChain.userType.UserType;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private final UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public User getUser(@RequestBody User req) throws Exception {
		return this.service.validateUser(req);
	}
	
	@PostMapping("/login")
	public User authorize(@RequestBody User user) throws Exception {
		return this.service.validateUser(user);
	}

	@PostMapping
	public User addUser(@RequestBody User user) throws Exception {
		return this.service.addUser(user);
	}
	
	@PutMapping
	public User updateGues(@RequestBody User user) {
		return this.service.updateUser(user);
	}
	
	@DeleteMapping
	public User deleteGuest(@RequestBody User user) {
		return this.service.deleteUser(user);
	}
}
