package kz.hotelChain.destination;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.repositories.DestinationsRepository;

@Service
@Component
public class DestinationService {
	private final DestinationsRepository repo;
	
	@Autowired
	public DestinationService(DestinationsRepository repo) {
		this.repo = repo;
	}
	
	public List<Destination> getDestinations() {
		return this.repo.findAll();
	}
}
