package com.project.movie.booking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.movie.booking.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	@Query(value = "select * from movie where movie_title =?1",nativeQuery = true)
	public Movie findBymovie_title(String movie_title);
	
	@Query(value = "select * from movie where genre=?1",nativeQuery = true)
	public List<Movie> findByegnre(String genre);
	
	
	@Query(value = "select * from movie where release_date =?1",nativeQuery = true)
	public List<Movie> findByrelease_date(LocalDate date);

}
