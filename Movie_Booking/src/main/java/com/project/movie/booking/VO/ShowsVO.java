package com.project.movie.booking.VO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.project.movie.booking.entity.Movie;


public class ShowsVO {
	private int show_id;
	private String theatre;
	private String location;
	private LocalDateTime show_date;
	private String movie;
	
	
	
	public ShowsVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getShow_id() {
		return show_id;
	}



	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}



	public String getTheatre() {
		return theatre;
	}



	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public LocalDateTime getShow_date() {
		return show_date;
	}



	public void setShow_date(LocalDateTime show_date) {
		this.show_date = show_date;
	}



	public String getMovie() {
		return movie;
	}



	public void setMovie(String movie) {
		this.movie = movie;
	}



	public ShowsVO(int show_id, String theatre, String location, LocalDateTime show_date, String movie) {
		super();
		this.show_id = show_id;
		this.theatre = theatre;
		this.location = location;
		this.show_date = show_date;
		this.movie = movie;
	}
	
}
