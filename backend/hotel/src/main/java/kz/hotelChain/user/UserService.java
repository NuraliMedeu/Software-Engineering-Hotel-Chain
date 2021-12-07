package kz.hotelChain.user;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.hotel.Hotel;
import kz.hotelChain.repositories.HotelsRepository;
import kz.hotelChain.repositories.UsersRepository;

@Service
@Component
public class UserService {
	private final UsersRepository repo;
	
	@Autowired
	public UserService(UsersRepository repo) {
		this.repo = repo;
	}
	
	public List<User> getUsers() {
		return this.repo.findAll();
	}
	
	public User getUser(String email) {
		try {
			return this.repo.findById(email).get();
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public User addUser(User user) {
		try {
			return this.repo.save(user);
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public User updateUser(String email, User data) {
		try {
			User user = this.repo.findById(email).get();
			user.setPassword(data.getPassword() != null ? data.getPassword() : user.getPassword());
			
			return this.repo.save(user);
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String deleteUser(String email) {
		try {
			this.repo.deleteById(email);
			return "Deleted with email: " + email;
		} catch(Exception e) {
			return "Not Found";
		}
	}
}
