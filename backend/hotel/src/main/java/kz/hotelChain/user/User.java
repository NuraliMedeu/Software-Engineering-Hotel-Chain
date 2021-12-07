package kz.hotelChain.user;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import kz.hotelChain.guest.Guest;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {
	@Id	
//	@JoinColumn(name="guest_id", nullable=false)
	String email;
	
	String password;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
    private Guest guest;
	
	public User() {}
	public User(String email, String password) {
		this.email = email;
		this.password = password;
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

}
