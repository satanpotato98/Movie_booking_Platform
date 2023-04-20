package com.project.movie.booking.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.booking.DTO.MovieDTO;
import com.project.movie.booking.entity.Movie;
import com.project.movie.booking.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	IMovieService movie_service;
	
	@PostMapping("/add")
	public Movie addMovie(@RequestBody MovieDTO movie_dto) {
		return movie_service.addMovie(movie_dto);
		 
	}
	@GetMapping("/get/all")
	public List<Movie> getAllMovie() {
		return movie_service.findAllMovie();
	}
	
	@GetMapping("/get/title/{title}")
	public Movie FindMovieByTitle(@PathVariable String title) {
		return movie_service.findBymovie_title(title);
	}
	
	@GetMapping("/get/genre/{genre}")
	public List<Movie> FindMovieBygenre(@PathVariable String genre) {
		return movie_service.findBygenre(genre);
	}
	
	@GetMapping("/get/release/{date}")
	public List<Movie> FindMovieByTitle(@PathVariable LocalDate date) {
		return movie_service.findByrelease_date(date);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		
		movie_service.deleteById(id);
		return new ResponseEntity<String>("Movie deleted", HttpStatus.OK);
	}
}
