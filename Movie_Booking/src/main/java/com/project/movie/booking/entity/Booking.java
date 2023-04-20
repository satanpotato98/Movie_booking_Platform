package com.project.movie.booking.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int booking_id;
	@ManyToOne
	@JoinColumn(name="booking_customer")
	private Customer customer_id;
	@OneToOne
	@JoinColumn(name="booking_show")
	private Shows show_id;
	private LocalDate booking_date;
	private int total_amount;
	private String payment_method;
	private int seats;

	private boolean canceled;
	private int rating;
	private String review;
	
	
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public Customer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}
	public Shows getShow_id() {
		return show_id;
	}
	public void setShow_id(Shows show_id) {
		this.show_id = show_id;
	}
	public LocalDate getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
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
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Booking(int booking_id, Customer customer_id, Shows show_id, LocalDate booking_date, int total_amount,
			String payment_method, int seats, boolean canceled, int rating, String review) {
		super();
		this.booking_id = booking_id;
		this.customer_id = customer_id;
		this.show_id = show_id;
		this.booking_date = booking_date;
		this.total_amount = total_amount;
		this.payment_method = payment_method;
		this.seats = seats;
		this.canceled = canceled;
		this.rating = rating;
		this.review = review;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
