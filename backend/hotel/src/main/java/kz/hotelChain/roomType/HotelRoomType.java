package kz.hotelChain.roomType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Entity(name = "HotelRoomType")
@Table(name = "hotel_room_types")
@IdClass(HotelRoomTypeId.class)
public class HotelRoomType {
	@Id
	@JoinColumn(name="id", referencedColumnName="id")
	private Integer id;
	@Id
//	@JoinColumn(name="type", referencedColumnName="type")
	private String type;
	
	private Integer size;
	private Integer capacity;
	
	public HotelRoomType() {}
	public HotelRoomType(Integer id, String type, Integer size, Integer capacity) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
		this.capacity = capacity;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "HotelRoomType [id=" + id + ", type=" + type + "]";
	}
}
