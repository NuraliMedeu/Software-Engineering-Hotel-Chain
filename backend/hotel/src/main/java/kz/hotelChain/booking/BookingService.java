package kz.hotelChain.booking;

import java.sql.Date;
import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kz.hotelChain.repositories.BookingsRepository;
import kz.hotelChain.repositories.HotelRoomsRepository;
import kz.hotelChain.room.HotelRoom;

@Service
@Component
public class BookingService {
	public final BookingsRepository repo;
	public final HotelRoomsRepository roomsRepo;
	
	@Autowired
	public BookingService(BookingsRepository repo, HotelRoomsRepository roomsRepo) {
		this.repo = repo;
		this.roomsRepo = roomsRepo;
	}
	
	public List<Booking> getBookings() {
		return this.repo.findAll();
	}
	
	public Booking addBooking(Booking b) {
		try {
			System.out.println(b.toString());
			System.out.println(Date.valueOf("2021-12-10"));
//			if (b.getRoom() == null) {
//				throw new Exception("Room is not chosen");
//			} else if (b.getCheck_in() == null || b.getCheck_out() == null) {
//				throw new Exception("Dates are not chosen");
//			} else {
			HotelRoom room = this.roomsRepo.findById(b.getRoom()).get();
			System.out.println("Found room");
			room.addBooking(b);
			Booking res = this.repo.save(b);
			return res;
//			}
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	//TODO: find all bookings that belong to specific guest
//	public List<Booking> getGuestBookings() {
//		return this.repo.findAll(null);
//	}
}
