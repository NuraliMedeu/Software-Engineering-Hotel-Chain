package kz.hotelChain.roomType;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class HotelRoomTypeId implements Serializable {
	Integer id;
	String type;
}