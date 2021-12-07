package kz.hotelChain.room;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@SuppressWarnings("serial")
@Entity(name = "HotelRoom")
@Table(name = "hotel_rooms")
@IdClass(HotelRoomId.class)
public class HotelRoom implements Serializable {
	@Id
	@JoinColumn(name="id", referencedColumnName="id")
	private Integer id;
	@Id
	@Column(name="room_number")
	private Integer roomNumber;
	@Id
	@Column(name="floor")
	private Integer floor;
	
//	@ManyToOne(targetEntity=HotelRoomType.class, cascade=CascadeType.ALL)
	private String type;
	
	private Boolean available;
	private Boolean cleaned;
	
	public HotelRoom() {}
	public HotelRoom(Integer id, Integer roomNumber, Integer floor, String type, Boolean available, Boolean cleaned) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.type = type;
		this.available = available;
		this.cleaned = cleaned;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
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
	
	
}
