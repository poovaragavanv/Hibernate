package com.emb;

/** @EmbeddedId is used for composite primary key. 
 * i.e. more than one column behaves jointly as primary key. 
 * We need to create an entity as Embeddable and the EmbeddedId 
 * Entity can be embedded in other entity to achieve composite primary key. 
 */

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeInfo")
public class EmployeeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@AttributeOverride(name="firstName", column=@Column(name="f_name"))
	private Person id;
	
	@Column(name="location")
	private String location;
	
	public EmployeeInfo(Person id, String location){
		this.id=id;
		this.location=location;
	}
	public Person getId() {
		return id;
	}
	public void setId(Person id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}