package kz.hotelChain.userType;

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
@RequestMapping("/api/user_types")
public class UserTypeController {
	private final UserTypeService service;
	
	@Autowired
	public UserTypeController(UserTypeService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<UserType> getUsers() {
		return this.service.getUsers();
	}
}
