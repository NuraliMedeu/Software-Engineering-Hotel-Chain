package kz.hotelChain.destination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/destination")
public class DestinationController {
	private final DestinationService service;
	
	@Autowired
	public DestinationController(DestinationService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Destination> getDestinations() {
		return this.service.getDestinations();
	}
}
