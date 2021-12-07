package kz.hotelChain.room;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class HotelRoomId implements Serializable {
	Integer id;
	Integer roomNumber;
	Integer floor;
}
