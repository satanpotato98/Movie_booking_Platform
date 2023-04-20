package com.project.movie.booking.Controller;

import java.util.List;

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

import com.project.movie.booking.DTO.ShowsDTO;
import com.project.movie.booking.VO.ShowsVO;
import com.project.movie.booking.entity.Shows;
import com.project.movie.booking.exception.PastDateException;
import com.project.movie.booking.service.IShowsService;

@RestController
@RequestMapping("/show")
public class ShowsController {
	
	@Autowired
	IShowsService show_service;
	
	@PostMapping("/add")
	public ShowsVO addShow(@RequestBody ShowsDTO dto) throws PastDateException {
		return show_service.addShow(dto);
	}
	
	@GetMapping("get/all")
	public List<Shows> getAll(){
		return show_service.getall();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletebyID(@PathVariable int id){
		show_service.deleteShowById(id);
		return new ResponseEntity<String>("Show Deleted",HttpStatus.OK);
	}

}
