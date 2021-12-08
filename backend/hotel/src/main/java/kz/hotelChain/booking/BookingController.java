package kz.hotelChain.booking;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	private final BookingService service;
	
	public BookingController(BookingService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Booking> getBookings() {
		return this.service.getBookings();
	}
	
	@PostMapping
	public Booking addBookings(@RequestBody Booking b) {
		System.out.println(b.toString());
		return this.service.addBooking(b);
	}
}
