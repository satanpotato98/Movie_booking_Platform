package com.project.movie.booking.DTO;

import java.time.LocalDate;

import com.project.movie.booking.entity.Customer;
import com.project.movie.booking.entity.Shows;

public class BookingDTO {

	private int customer_id;
	private int show_id;
	private int total_amount;
	private String payment_method;
	public int seats;
	
	public BookingDTO() {
		super();
	}
	public BookingDTO(int customer_id, int show_id, int total_amount,
			String payment_method, int seats) {
		super();
		this.customer_id = customer_id;
		this.show_id = show_id;
		this.total_amount = total_amount;
		this.payment_method = payment_method;
		this.seats = seats;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}

}
