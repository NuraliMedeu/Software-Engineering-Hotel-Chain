package kz.hotelChain.hotel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

import kz.hotelChain.destination.Destination;
import kz.hotelChain.room.HotelRoom;
import kz.hotelChain.roomType.HotelRoomType;

@Entity(name = "Hotel")
@Table(name = "hotels")
public class Hotel {
	@Id
	@SequenceGenerator(
		name = "hotels_id_seq",
		sequenceName="hotels_id_seq",
		allocationSize=1
	)
	@GeneratedValue(
		strategy = SEQUENCE,
		generator = "hotels_id_seq"
	)
	private Integer id;
	
	private String name;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "destination", referencedColumnName="city")
	private Destination city;
		
	@OneToMany(targetEntity=HotelPhone.class, cascade=CascadeType.ALL, mappedBy="id")
	private List<HotelPhone> phones;
	
	@OneToMany(targetEntity=HotelRoomType.class, cascade=CascadeType.ALL, mappedBy="id")
	private List<HotelRoomType> room_types;
	
	@OneToMany(targetEntity=HotelRoomType.class, cascade=CascadeType.ALL, mappedBy="id")
	private List<HotelRoom> rooms;
	
	public Hotel() {}

	public Hotel(Integer id, String name, Destination city, List<HotelPhone> phones, List<HotelRoomType> room_types,
			List<HotelRoom> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.phones = phones;
		this.room_types = room_types;
		this.rooms = rooms;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Destination getDestination() {
		return city;
	}

	public void setDestination(Destination destination) {
		this.city = destination;
	}

	public List<HotelPhone> getPhones() {
		return phones;
	}

	public void setPhones(List<HotelPhone> phones) {
		this.phones = phones;
	}

	public List<HotelRoomType> getRoom_types() {
		return room_types;
	}

	public void setRoom_types(List<HotelRoomType> room_types) {
		this.room_types = room_types;
	}

	public List<HotelRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<HotelRoom> rooms) {
		this.rooms = rooms;
	}
	
}
