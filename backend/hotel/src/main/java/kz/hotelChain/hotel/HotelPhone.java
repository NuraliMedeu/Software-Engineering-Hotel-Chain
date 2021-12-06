package kz.hotelChain.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.mapping.Selectable;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@SuppressWarnings("serial")
@Embeddable
class HotelPhoneId implements Serializable {
	Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	String phone_number;
}

@SuppressWarnings("serial")
@Entity(name = "HotelPhone")
@Table(name = "hotel_phones")
@IdClass(HotelPhoneId.class)
public class HotelPhone implements Serializable {
	@Id
	@JoinColumn(name="id", referencedColumnName="id")
	private Integer id;
	@Id
	private String phone_number;
	
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id")
    @MapsId
	private Hotel hotel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	@Override
	public String toString() {
		return "HotelPhone [id=" + id + ", phone_number=" + phone_number + "]";
	}
}
