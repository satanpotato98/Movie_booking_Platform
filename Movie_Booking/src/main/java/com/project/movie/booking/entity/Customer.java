package com.project.movie.booking.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customer_id;
	private String customer_name;
	private String email;
	private long contact;
	@OneToMany(mappedBy = "customer_id", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("customer_id")
	private Set<Booking> booking =new HashSet<>();
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Set<Booking> getBooking() {
		return booking;
	}
	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}
	public Customer(int customer_id, String customer_name, String email, long contact, Set<Booking> booking) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.email = email;
		this.contact = contact;
		this.booking = booking;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void addBooking(Booking booking) {
		Set<Booking> bookings=this.getBooking();
		bookings.add(booking);
		
	}
	
	public void deleteBooking(Booking booking) {
		Set<Booking> bookings=this.getBooking();
		bookings.remove(booking);
		
	}
}
