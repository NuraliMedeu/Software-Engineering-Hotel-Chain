package kz.hotelChain.booking;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kz.hotelChain.destination.Destination;
import kz.hotelChain.room.HotelRoom;
import kz.hotelChain.room.HotelRoomId;
import kz.hotelChain.userType.user.User;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity(name = "Booking")
@Table(name = "bookings")
public class Booking implements Serializable {
	@Id
	@SequenceGenerator(
		name = "bookings_id_seq",
		sequenceName="bookings_id_seq",
		allocationSize=1
	)
	@GeneratedValue(
		strategy = SEQUENCE,
		generator = "bookings_id_seq"
	)
	@Column(name="id")
	private Integer booking_id;	
	
	@JoinColumn(name="email", referencedColumnName="email")
	private String email;
	
	private Date check_in;
	private Date check_out;
	

//	@ManyToOne(targetEntity=HotelRoom.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(referencedColumnName="floor", insertable=false, updatable=false),
		@JoinColumn(name="hotel_id", referencedColumnName="room_id"),
		@JoinColumn(referencedColumnName="room_number", insertable=false, updatable=false),
	})
    private HotelRoomId room;


    public Booking() {}
	public Booking(Integer id, String email, String check_in, String check_out, HotelRoomId room) {
		super();
		this.booking_id = id;
		this.email = email;
		this.check_in = Date.valueOf(check_in);
		this.check_out = Date.valueOf(check_out);
		this.room = room;
	}
	public Integer getId() {
		return booking_id;
	}
	public void setId(Integer id) {
		this.booking_id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCheck_in() {
		return check_in;
	}
	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}
	public Date getCheck_out() {
		return check_out;
	}
	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}
	public HotelRoomId getRoom() {
		return room;
	}
	public void setRoom(HotelRoomId room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", email=" + email + ", check_in=" + check_in + ", check_out="
				+ check_out + ", room=" + room + "]";
	}
}
