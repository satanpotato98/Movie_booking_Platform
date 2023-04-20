package com.project.movie.booking.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.project.movie.booking.entity.Movie;
import com.project.movie.booking.entity.Theatre;


public class ShowsDTO {

	private int show_id;
	private int theatre;
	private int movie;
	private LocalDateTime show_date;
	public ShowsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public int getTheatre() {
		return theatre;
	}
	public void setTheatre(int theatre) {
		this.theatre = theatre;
	}
	public int getMovie() {
		return movie;
	}
	public void setMovie(int movie) {
		this.movie = movie;
	}
	public LocalDateTime getShow_date() {
		return show_date;
	}
	public void setShow_date(LocalDateTime show_date) {
		this.show_date = show_date;
	}
	public ShowsDTO(int show_id, int theatre, int movie, LocalDateTime show_date) {
		super();
		this.show_id = show_id;
		this.theatre = theatre;
		this.movie = movie;
		this.show_date = show_date;
	}
	
	}
