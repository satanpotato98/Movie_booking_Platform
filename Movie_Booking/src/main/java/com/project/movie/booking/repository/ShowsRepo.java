
  package com.project.movie.booking.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.project.movie.booking.entity.Shows;
  
  @Repository 
  public interface ShowsRepo extends JpaRepository<Shows, Integer>
  {
  
  }
 