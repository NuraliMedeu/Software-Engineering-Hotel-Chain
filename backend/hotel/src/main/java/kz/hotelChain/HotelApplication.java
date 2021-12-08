package kz.hotelChain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kz.hotelChain.IDType.IDType;
import kz.hotelChain.hotel.Hotel;
import kz.hotelChain.hotel.HotelPhone;
import kz.hotelChain.repositories.HotelsRepository;
import kz.hotelChain.repositories.IDTypesRepository;
import kz.hotelChain.repositories.UsersRepository;
import kz.hotelChain.user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@EnableJpaRepositories("kz.hotelChain.repositories")
public class HotelApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
	
	/*
	@Autowired
	private IDTypesRepository idTypesRepo;
	
	@Autowired
	private UsersRepository usersRepo;
	
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
	*/
	
}
