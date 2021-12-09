package kz.hotelChain.userType.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.hotelChain.repositories.UsersRepository;
import kz.hotelChain.userType.UserType;

@Service
public class UserService {
	private final UsersRepository repo;
	
	@Autowired
	public UserService(UsersRepository repo) {
		this.repo = repo;
	}
	
	public List<User> getUsers() {
		return this.repo.findAll();
	}
	
	public User getUser(User user) {
		return this.repo.findById(user.getEmail()).get();
	}
	
	public User validateUser(User req) throws Exception {
		User user = this.repo.findById(req.getEmail()).get();
		if (req.getPassword().equals(user.getPassword())) {
			return user;
		} else {
			throw new Exception("Wrong password");
		}
	}

	public User addUser(User user) throws Exception {
		try {
			getUser(user);
		} catch(Exception e) {
			return this.repo.save(user);
		}
		throw new Exception("User exists");
	}
	
	public User updateUser(User data) {
		User user = this.repo.findById(data.getEmail()).get();
		user.setPassword(data.getPassword() != null ? data.getPassword() : user.getPassword());
		return this.repo.save(user);
	}
	
	public User deleteUser(User user) {
		this.repo.deleteById(user.getEmail());
		return user;
	}
}
