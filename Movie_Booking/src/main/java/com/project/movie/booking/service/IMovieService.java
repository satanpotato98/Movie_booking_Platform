package com.project.movie.booking.service;

import java.time.LocalDate;
import java.util.List;


import com.project.movie.booking.DTO.MovieDTO;
import com.project.movie.booking.entity.Movie;

public interface IMovieService {
	
	public Movie addMovie(MovieDTO dto);//admin
	
	  public List<Movie> findAllMovie();//admin||user public Movie
	  public Movie  findBymovie_title(String movie_title);//repo //admin||user
	  public void deleteById(int id);
	  public List<Movie>  findBygenre(String genre);//repo //admin||user
	  public List<Movie>  findByrelease_date(LocalDate date);//repo //admin||user
	 	

}
