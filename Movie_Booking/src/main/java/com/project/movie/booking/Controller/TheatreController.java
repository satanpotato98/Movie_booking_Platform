package com.project.movie.booking.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.booking.DTO.TheatreDTO;
import com.project.movie.booking.VO.TheatreVO;
import com.project.movie.booking.entity.Theatre;
import com.project.movie.booking.service.ITheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

	@Autowired
	ITheatreService theatre_service;
	@PostMapping("/add")
	public Theatre addTheatre(@RequestBody TheatreDTO dto) {
		return theatre_service.addTheatre(dto);
	}
	
	@GetMapping("/get/location/{location}")
	public List<Theatre> getBylocation(@PathVariable String location) {
		return theatre_service.findByLocation(location);
	}
	
	@GetMapping("get/all")
	public List<Theatre> findAllTheatre(){
		return theatre_service.findAll();
	}
	
	@GetMapping("get/movie/{movie}")
	public Set<TheatreVO> findByMovie(@PathVariable String movie){

		
		return theatre_service.findByMovie(movie);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		theatre_service.deleteTheatreById(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
}
