package kz.hotelChain.room;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class HotelRoomId implements Serializable {
	Integer hotel_id;
	Integer room_number;
	Integer floor;
	@Override
	public String toString() {
		return "HotelRoomId [hotel_id=" + hotel_id + ", room_number=" + room_number + ", floor=" + floor + "]";
	}
	public Integer getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}
	public Integer getRoom_number() {
		return room_number;
	}
	public void setRoom_number(Integer room_number) {
		this.room_number = room_number;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	
	public HotelRoomId() {}
	public HotelRoomId(Integer hotel_id, Integer room_number, Integer floor) {
		super();
		this.hotel_id = hotel_id;
		this.room_number = room_number;
		this.floor = floor;
	}
	
	
}
