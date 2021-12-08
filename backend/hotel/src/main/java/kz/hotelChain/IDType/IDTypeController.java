package kz.hotelChain.IDType;

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
@RequestMapping("/api/id_types")
public class IDTypeController {
	private final IDTypeService service;
	
	@Autowired
	public IDTypeController(IDTypeService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<IDType> getUsers() {
		return this.service.getUsers();
	}
}