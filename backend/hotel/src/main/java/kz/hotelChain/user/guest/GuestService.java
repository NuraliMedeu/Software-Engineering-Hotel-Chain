package kz.hotelChain.user.guest;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.repositories.GuestsRepository;
import kz.hotelChain.user.User;

@Service
@Component
public class GuestService {
	private final GuestsRepository repo;
	
	@Autowired
	public GuestService(GuestsRepository repo) {
		this.repo = repo;
	}
	
	public List<Guest> getGuests() {
		return this.repo.findAll();
	}
	
	public Guest getGuest(String email) {
		try {
			System.out.println(email);
			return this.repo.findById(email).get();
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Guest addGuest(Guest guest) {
		try {
			return this.repo.save(guest);
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	//TODO
	public Guest updateGuest(String email, Guest data) {
		try {
//			Guest guest = this.repo.findById(email).get();
			return null; //this.repo.save(guest);
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String deleteGuest(String email) {
		try {
			this.repo.deleteById(email);
			return "Deleted with id: " + email;
		} catch(Exception e) {
			return "Not Found";
		}
	}
}
