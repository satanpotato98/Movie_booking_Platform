
  package com.project.movie.booking.repository;
  
  import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.movie.booking.entity.Booking;
import com.project.movie.booking.entity.Movie;

  
  @Repository 
  public interface BookingRepo extends JpaRepository<Booking,Integer>{
	  
	  @Query(value = "select booking_id from booking inner join shows on booking_show=show_id inner join movie on show_movie=movie_id where movie_id=?1 and booking.rating!=0",nativeQuery = true)
		public Set<Integer> findBymovie(int movie_id);
	  
	  

  
  }
 