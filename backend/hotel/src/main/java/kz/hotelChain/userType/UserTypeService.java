package kz.hotelChain.userType;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.hotel.Hotel;
import kz.hotelChain.repositories.HotelsRepository;
import kz.hotelChain.repositories.UserTypesRepository;

@Service
@Component
public class UserTypeService {
	private final UserTypesRepository repo;
	
	@Autowired
	public UserTypeService(UserTypesRepository repo) {
		this.repo = repo;
	}
	
	public List<UserType> getUsers() {
		return this.repo.findAll();
	}
}
