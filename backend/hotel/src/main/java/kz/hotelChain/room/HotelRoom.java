package kz.hotelChain.room;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kz.hotelChain.booking.Booking;

@SuppressWarnings("serial")
@Entity(name = "HotelRoom")
@Table(name = "hotel_rooms")
@IdClass(HotelRoomId.class)
public class HotelRoom implements Serializable {
	@Id
	@JoinColumn(name="id", referencedColumnName="id")
	@Column(name="id")
	private Integer hotel_id;
	@Id
	@JoinColumn(name="room_number", referencedColumnName="room_number")
	private Integer room_number;
	@Id
	@JoinColumn(name="floor", referencedColumnName="floor")
	private Integer floor;
	
//	@ManyToOne(targetEntity=HotelRoomType.class, cascade=CascadeType.ALL)
	private String type;
	
    @ManyToMany(targetEntity=Booking.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="room")
    @JsonIgnoreProperties("room")
    private List<Booking> bookings;
	
	private Boolean available;
	private Boolean cleaned;
	
	public HotelRoom() {}
	public HotelRoom(Integer id, Integer roomNumber, Integer floor, String type, List<Booking> bookings,
			Boolean available, Boolean cleaned) {
		super();
		this.hotel_id = id;
		this.room_number = roomNumber;
		this.floor = floor;
		this.type = type;
		this.bookings = bookings;
		this.available = available;
		this.cleaned = cleaned;
	}

	public Integer getId() {
		return hotel_id;
	}

	public void setId(Integer id) {
		this.hotel_id = id;
	}

	public Integer getRoomNumber() {
		return room_number;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.room_number = roomNumber;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Boolean getCleaned() {
		return cleaned;
	}

	public void setCleaned(Boolean cleaned) {
		this.cleaned = cleaned;
	}
	
	@Override
	public String toString() {
		return "HotelRoom [id=" + hotel_id + ", roomNumber=" + room_number + ", floor=" + floor + ", type=" + type
				+ ", bookings=" + bookings + ", available=" + available + ", cleaned=" + cleaned + "]";
	}

	public Boolean isAvailableNow() {
		Date now = new Date();
		for (Booking b : bookings) {
			return isAvailable(now, now);
		}
		return true;
	}
	
	public Boolean isAvailable(Date check_in, Date check_out) {
		Date now = new Date();
		for (Booking b : bookings) {
			if ((check_in.after(b.getCheck_in()) && check_in.before(b.getCheck_out())) || 
				(check_out.after(b.getCheck_in()) && check_out.before(b.getCheck_out())) ||
				(check_in.before(b.getCheck_in()) && check_out.after(b.getCheck_out()))) {
				return false;
			} else {
				return true;
			}
		}
		return true;
	}
	
	public void addBooking(Booking b) {
		try {
			this.bookings.add(b);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
