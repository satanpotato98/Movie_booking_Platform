package com.project.movie.booking.VO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingVO {

	private int booking_id;
	private int customer_id;
	private String customer_name;
	private int show_id;
	private String movie_title;
	private LocalDate booking_date;
	private LocalDateTime show_date;
	private int total_amount;
	private String payment_method;
	public int seats;
	public String status;
	
	
	
	public LocalDateTime getShow_date() {
		return show_date;
	}
	public void setShow_date(LocalDateTime show_date) {
		this.show_date = show_date;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BookingVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingVO(int booking_id, int customer_id, String customer_name, int show_id, String movie_title,
			LocalDate booking_date, int total_amount, String payment_method, int seats,String status, LocalDateTime show_date) {
		super();
		this.booking_id = booking_id;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.show_id = show_id;
		this.movie_title = movie_title;
		this.booking_date = booking_date;
		this.total_amount = total_amount;
		this.payment_method = payment_method;
		this.status=status;
		this.seats = seats;
		this.show_date=show_date;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
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
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
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
	
	
}
