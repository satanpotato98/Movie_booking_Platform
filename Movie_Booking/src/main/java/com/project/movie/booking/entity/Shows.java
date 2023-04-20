package com.project.movie.booking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Shows {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int show_id;
	@ManyToOne
	@JoinColumn(name="show_theatre")
	private Theatre theatre;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="show_movie")	
	private Movie movie;
	private LocalDateTime show_date;
	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public LocalDateTime getShow_date() {
		return show_date;
	}
	public void setShow_date(LocalDateTime show_date) {
		this.show_date = show_date;
	}
	public Shows() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shows(int show_id, Theatre theatre, Movie movie, LocalDateTime show_date) {
		super();
		this.show_id = show_id;
		this.theatre = theatre;
		this.movie = movie;
		this.show_date = show_date;
	}
	
	
}
