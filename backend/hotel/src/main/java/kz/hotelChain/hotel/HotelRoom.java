package kz.hotelChain.hotel;

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

@SuppressWarnings("serial")
@Embeddable
class HoteRoomId implements Serializable {
	Integer id;
	Integer roomNumber;
	Integer floor;
}

@SuppressWarnings("serial")
@Entity(name = "HotelRoom")
@Table(name = "hotel_rooms")
@IdClass(HoteRoomId.class)
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
}
