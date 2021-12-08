package kz.hotelChain.user.guest;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kz.hotelChain.IDType.IDType;
import kz.hotelChain.booking.Booking;
import kz.hotelChain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Embeddable
class GuestId implements Serializable {
	String id;
	
	public GuestId() {}
	public GuestId(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

@Entity(name = "Guest")
@Table(name = "guests")
//@IdClass(GuestId.class)
public class Guest extends User implements Serializable {
	
    @OneToMany(targetEntity=Booking.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="email")
    private List<Booking> bookings;
	
	private String name;
	private String surname;
	
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "identification_type", referencedColumnName="id", insertable=false, updatable=false)
	@JsonIgnore
	private IDType id_type;
    
    @Column(name="identification_type")
	private Integer id_typeNum;

    @Column(name="identification_number")
	private String id_number;

    public Guest() {}
	public Guest(List<Booking> bookings, String name, String surname, IDType id_type, Integer id_typeNum,
			String id_number) {
		super();
		this.bookings = bookings;
		this.name = name;
		this.surname = surname;
		this.id_type = id_type;
		this.id_typeNum = id_typeNum;
		this.id_number = id_number;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public IDType getId_type() {
		return id_type;
	}
	public void setId_type(IDType id_type) {
		this.id_type = id_type;
	}
	public Integer getId_typeNum() {
		return id_typeNum;
	}
	public void setId_typeNum(Integer id_typeNum) {
		this.id_typeNum = id_typeNum;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
}
