	package com.project.movie.booking.DTO;

import java.time.LocalDate;

import com.project.movie.booking.entity.Customer;

public class MovieDTO {

	private int movie_id;
	private String movie_title;
	private String genre;
	private String director;
	private int duration;
	private int rating;
	private LocalDate release_date;

	public MovieDTO() {
		super();
	}


	public MovieDTO(int movie_id, String movie_title, String genre, String director, int duration, int rating,
			Customer customer, LocalDate release_date) {
		super();
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.genre = genre;
		this.director = director;
		this.duration = duration;
		this.rating = rating;
		this.release_date=release_date;
	}

	

	public LocalDate getRelease_date() {
		return release_date;
	}


	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}


	public int getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}


	public String getMovie_title() {
		return movie_title;
	}


	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

}
