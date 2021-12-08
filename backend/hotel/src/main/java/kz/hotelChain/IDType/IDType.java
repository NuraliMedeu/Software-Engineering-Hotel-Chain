package kz.hotelChain.IDType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import kz.hotelChain.user.guest.Guest;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "IDType")
@Table(name = "identification_types")
public class IDType {
	@Id
	private Integer id;
	private String name;
	
//	@OneToOne(targetEntity=Guest.class, cascade=CascadeType.ALL, mappedBy="ID_type")
//    private Guest guest;	
    
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
