package com.project.movie.booking.DTO;

import java.util.HashSet;
import java.util.Set;

import com.project.movie.booking.entity.Booking;
import com.project.movie.booking.entity.Movie;

public class CustomerDTO {
	private String customer_name;
	private String email;
	private long contact;
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDTO(String customer_name, String email, long contact) {
		super();
		this.customer_name = customer_name;
		this.email = email;
		this.contact = contact;
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


}
