package com.project.movie.booking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.booking.DTO.MovieDTO;
import com.project.movie.booking.entity.Movie;
import com.project.movie.booking.repository.MovieRepo;
@Service
public class MovieServiceImp implements IMovieService {
	@Autowired
	MovieRepo movie_repo;

	@Override
	public Movie addMovie(MovieDTO dto) {
		Movie movie=new Movie();
		movie.setMovie_id(dto.getMovie_id());
		movie.setMovie_title(dto.getMovie_title());
		movie.setDuration(dto.getDuration());
		movie.setRating(dto.getRating());
		movie.setGenre(dto.getGenre());
		movie.setDirector(dto.getDirector());
		movie.setRelease_date(dto.getRelease_date());
		
		
		return movie_repo.save(movie);
	}

	@Override
	public List<Movie> findAllMovie() { 
		
		return movie_repo.findAll();
	}

	@Override
	public Movie findBymovie_title(String movie_title) {
		
		return movie_repo.findBymovie_title(movie_title);
	}

	@Override
	public void deleteById(int id) {
		movie_repo.deleteById(id);
		
	}

	@Override
	public List<Movie> findBygenre(String genre) {
		// TODO Auto-generated method stub
		return movie_repo.findByegnre(genre);
	}

	@Override
	public List<Movie> findByrelease_date(LocalDate date) {
		// TODO Auto-generated method stub
		return movie_repo.findByrelease_date(date);
	}



}
