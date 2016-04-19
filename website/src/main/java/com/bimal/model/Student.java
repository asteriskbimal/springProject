package com.bimal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/*	To access the database, you will need EJB3 entity beans and the entity manager API.
 *  They are collectively called the Java Persistence API (JPA).
	EJB3 Entity Beans are Plain Old Java Objects (POJOs) that map to relational database tables.
 	For instance, the following entity bean class maps to a relational table named Student.
  	The table has three columns: id,name and rollNumber. 
  	Each instance of the bean corresponds to a row of data in the table.
*/
@Entity
//@Table(name="STU")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7588513853972413545L;

	@Id
	@GeneratedValue
//	@Column(name = "STU_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	@Column(name = "NAME_S")
	@NotEmpty(message = "First name cannot be empty")
	private String name;

//	@Column(name = "ROLL_S")
	@NotEmpty(message = "First name cannot be empty")
	String rollNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

}
