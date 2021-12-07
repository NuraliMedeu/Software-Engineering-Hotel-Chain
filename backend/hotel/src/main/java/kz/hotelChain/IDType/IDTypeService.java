package kz.hotelChain.IDType;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.hotel.Hotel;
import kz.hotelChain.repositories.HotelsRepository;
import kz.hotelChain.repositories.IDTypesRepository;
import kz.hotelChain.repositories.UsersRepository;

@Service
@Component
public class IDTypeService {
	private final IDTypesRepository repo;
	
	@Autowired
	public IDTypeService(IDTypesRepository repo) {
		this.repo = repo;
	}
	
	public List<IDType> getUsers() {
		return this.repo.findAll();
	}
}
