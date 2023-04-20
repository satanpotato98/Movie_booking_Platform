package com.project.movie.booking.repository;
  
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.movie.booking.entity.Theatre;

  
  @Repository 
  public interface TheatreRepo extends JpaRepository<Theatre,Integer> {
  
	  @Query(value = "select * from theatre where location=?1",nativeQuery = true)
		public List<Theatre> findBylocation(String location);
	  
  }
 