package kz.hotelChain.hotel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

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
	private String address;
	
	@OneToMany(targetEntity=HotelPhone.class, cascade=CascadeType.ALL, mappedBy="id")
	private List<HotelPhone> phones;
	
	@OneToMany(targetEntity=HotelRoomType.class, cascade=CascadeType.ALL, mappedBy="id")
	private List<HotelRoomType> room_types;
	
	public Hotel() {}
	public Hotel(String name, String address, List<HotelPhone> phones, List<HotelRoomType> roomTypes) {
		this.name = name;
		this.address = address;
		this.phones = phones;
		this.room_types = roomTypes;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<HotelPhone> getPhones() {
		return phones;
	}
	public void setPhones(List<HotelPhone> phones) {
		this.phones = phones;
	}
	public List<HotelRoomType> getRoomTypes() {
		return room_types;
	}
	public void setRoomTypes(List<HotelRoomType> roomTypes) {
		this.room_types = roomTypes;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", phones=" + phones + ", room_types="
				+ room_types + "]";
	}

}
