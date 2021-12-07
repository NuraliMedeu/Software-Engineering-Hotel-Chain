package kz.hotelChain.guest;

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
	
	public Guest getGuest(Integer id) {
		try {
			return this.repo.findById(id).get();
		} catch(Exception e) {
			System.out.println("In getGuest:");
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
	public Guest updateGuest(Integer id, Guest data) {
		try {
			Guest guest = this.repo.findById(id).get();
			System.out.println("Guest PUT method not implemented.");
			return this.repo.save(guest);
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public String deleteGuest(Integer id) {
		try {
			this.repo.deleteById(id);
			return "Deleted with id: " + id;
		} catch(Exception e) {
			return "Not Found";
		}
	}
}
