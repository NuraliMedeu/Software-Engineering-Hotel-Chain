package kz.hotelChain.guest;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kz.hotelChain.IDType.IDType;
import kz.hotelChain.user.User;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Embeddable
class GuestId implements Serializable {
	Integer id;
	
	public GuestId() {}
	public GuestId(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

@Entity(name = "Guest")
@Table(name = "guests")
@IdClass(GuestId.class)
public class Guest implements Serializable {
	@Id
	@SequenceGenerator(
		name = "guests_id_seq",
		sequenceName="guests_id_seq",
		allocationSize=1
	)
	@GeneratedValue(
		strategy = SEQUENCE,
		generator = "guests_id_seq"
	)
	private Integer id;
	
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "email", nullable = false, referencedColumnName="email", insertable=false, updatable=false)
    @JsonIgnore
	private User user;
    
    @Column(name="email")
    private String email;
	
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

	public Guest(Integer id, User user, String email, String name, String surname, IDType id_type, Integer id_typeNum,
			String id_number) {
		super();
		this.id = id;
		this.user = user;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.id_type = id_type;
		this.id_typeNum = id_typeNum;
		this.id_number = id_number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
