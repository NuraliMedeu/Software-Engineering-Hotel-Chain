package kz.hotelChain.userType.user;

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
import kz.hotelChain.userType.UserType;
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
@Table(name = "users")
//@IdClass(GuestId.class)
public class User implements Serializable {
	@Id
	private String email;
		
	private String password;
	
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
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_type", referencedColumnName="name")
    private UserType user_type;

    public User() {}
	public User(String email, String password, List<Booking> bookings, String name, String surname, IDType id_type,
			Integer id_typeNum, String id_number, UserType user_type) {
		super();
		this.email = email;
		this.password = password;
		this.bookings = bookings;
		this.name = name;
		this.surname = surname;
		this.id_type = id_type;
		this.id_typeNum = id_typeNum;
		this.id_number = id_number;
		this.user_type = user_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public UserType getUser_type() {
		return user_type;
	}

	public void setUser_type(UserType user_type) {
		this.user_type = user_type;
	}
}
