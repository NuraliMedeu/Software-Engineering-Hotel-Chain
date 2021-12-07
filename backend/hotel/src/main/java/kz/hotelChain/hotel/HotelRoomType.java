package kz.hotelChain.hotel;

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

@SuppressWarnings("serial")
@Embeddable
class HotelRoomTypeId implements Serializable {
	Integer id;
	String type;
}

@Entity(name = "HotelRoomType")
@Table(name = "hotel_room_types")
@IdClass(HotelRoomTypeId.class)
public class HotelRoomType {
	@Id
	@JoinColumn(name="id", referencedColumnName="id")
	@JsonIgnore
	private Integer id;
	@Id
//	@JoinColumn(name="type", referencedColumnName="type")
	private String type;
	
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
	
	@Override
	public String toString() {
		return "HotelRoomType [id=" + id + ", type=" + type + "]";
	}
}
