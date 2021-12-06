package kz.hotel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity(name = "IDType")
@Table(name = "identification_types")
public class IDType {
	@Id
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
