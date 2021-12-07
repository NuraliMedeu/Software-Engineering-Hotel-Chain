package kz.hotelChain.destination;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kz.hotelChain.hotel.Hotel;
import kz.hotelChain.hotel.HotelPhone;

@Entity(name="Destination")
@Table(name="destinations")
public class Destination {
	@Id
//	@JoinColumn(name="city", referencedColumnName="city")
	private String city;

	public Destination() {}
	public Destination(String city) {
		super();
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
//	@OneToMany(targetEntity=Hotel.class, cascade=CascadeType.ALL, mappedBy="city")
//	private List<Hotel> hotels;
}
