package kz.hotelChain.userType;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kz.hotelChain.userType.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Entity(name = "UserType")
@Table(name = "user_types")
@Inheritance(strategy=InheritanceType.JOINED)
public class UserType implements Serializable {
	@Id
	String name;

	public UserType() {}
	public UserType(String type) {
		super();
		this.name = type;
	}

	public String getType() {
		return name;
	}

	public void setType(String type) {
		this.name = type;
	}

}
