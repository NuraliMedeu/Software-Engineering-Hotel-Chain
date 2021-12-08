package kz.hotelChain.userType.user;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import kz.hotelChain.repositories.UsersRepository;

@Service
@Component
public class UserService {
	private final UsersRepository repo;
	
	@Autowired
	public UserService(UsersRepository repo) {
		this.repo = repo;
	}
	
	public List<User> getGuests() {
		return this.repo.findAll();
	}
	
	public User getGuest(String email) {
		try {
			System.out.println(email);
			return this.repo.findById(email).get();
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public User addGuest(User user) {
		try {
			if (this.repo.existsById(user.getEmail())) {
				throw new Exception("User exists");
			} else {
				return this.repo.save(user);
			}
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	//TODO
	public User updateGuest(User data) {
		try {
			User user = this.repo.findById(data.getEmail()).get();
			user.setPassword(data.getPassword() != null ? data.getPassword() : user.getPassword());
			return user;
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String deleteGuest(User user) {
		try {
			this.repo.deleteById(user.getEmail());
			return "Deleted user: " + user.getEmail();
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
