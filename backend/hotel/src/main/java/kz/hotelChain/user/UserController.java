package kz.hotelChain.user;

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
@RequestMapping("/api/user")
public class UserController {
	private final UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<User> getUsers() {
		return this.service.getUsers();
	}
	
	@GetMapping("/{email}")
	public User getUser(@PathVariable String email) {
		return this.service.getUser(email);
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return this.service.addUser(user);
	}
	
	@PutMapping("/{email}")
	public User updateUser(@PathVariable String email, @RequestBody User user) {
		return this.service.updateUser(email, user);
	}
	
	@DeleteMapping("/{email}")
	public String deleteUser(@PathVariable String email) {
		return this.service.deleteUser(email);
	}
}
