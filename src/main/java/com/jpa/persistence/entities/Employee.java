package com.jpa.persistence.entities;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
//public class Employee{
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8464900903432221052L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String position;

//	@OneToMany(mappedBy = "emp", cascade = CascadeType.REMOVE) // here the remove is used so when the number entity is
//																// deleted, it doesn't remain in the emp entity
//																// and when the emp is deleted, then the number is also
//																// deleted
//	private List<PhoneNumber> phoneNumber;

	@OneToMany(cascade = CascadeType.REMOVE) // here the remove is used so when the number entity is
	// deleted, it doesn't remain in the emp entity
	// and when the emp is deleted, then the number is also
	// deleted
	@JoinColumn(name = "phone_id", referencedColumnName = "id") // cancels the need of making another table in the
																// relation but still there will be additional SQL
																// statements to implement
	private List<PhoneNumber> phoneNumber;

	@ManyToMany(mappedBy = "emps", cascade = CascadeType.PERSIST)
	private Set<Car> cars;

	public Employee() {
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	public Employee(String firstName, String lastName, String position) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
	}

	public Employee(String firstName, String lastName, String position, Address address, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.address = address;
		this.username = firstName + lastName;
		this.password = password;
	}

	public Employee(String firstName, String lastName, String position, Address address, Set<Car> cars) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.address = address;
		this.cars = cars;
		this.username = firstName + lastName;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
	}

	public List<PhoneNumber> getPhoneNumber() {
		return phoneNumber;
	}

	public void addNumber(PhoneNumber num) {
		this.phoneNumber.add(num);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
