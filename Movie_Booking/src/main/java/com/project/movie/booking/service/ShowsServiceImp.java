package com.project.movie.booking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.booking.DTO.ShowsDTO;
import com.project.movie.booking.VO.ShowsVO;
import com.project.movie.booking.entity.Shows;
import com.project.movie.booking.entity.Theatre;
import com.project.movie.booking.exception.PastDateException;
import com.project.movie.booking.repository.MovieRepo;
import com.project.movie.booking.repository.ShowsRepo;
import com.project.movie.booking.repository.TheatreRepo;

@Service
public class ShowsServiceImp implements IShowsService {
	
	@Autowired
	ShowsRepo shows_repo;
	
	@Autowired
	MovieRepo movie_repo;
	
	@Autowired
	TheatreRepo theatre_repo;
	@Override
	public ShowsVO addShow(ShowsDTO dto) throws PastDateException {
		if(dto.getShow_date().isAfter(LocalDateTime.now())) {
		Shows show=new Shows();
		Theatre theatre=theatre_repo.findById(dto.getTheatre()).orElse(null);
		show.setMovie(movie_repo.findById(dto.getMovie()).orElse(null)) ;
		show.setTheatre(theatre);
		show.setShow_date(dto.getShow_date());
		theatre.addShow(show);
		
		
		show=shows_repo.save(show);	

		ShowsVO vo=new ShowsVO();
		vo.setMovie(movie_repo.findById(dto.getMovie()).orElse(null).getMovie_title());
		vo.setShow_date(dto.getShow_date());
		vo.setTheatre(theatre.getTheatre_name());
		vo.setShow_id(show.getShow_id());
		vo.setLocation(theatre.getLocation());
		return vo;
		}else {
			throw new PastDateException();
		}
	}

	@Override
	public void deleteShowById(int id) {
		shows_repo.deleteById(id);
	}

	@Override
	public void updateShow(ShowsDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Shows> getshowsByTheatreName(String theatre_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shows> getall() {
		// TODO Auto-generated method stub
		return shows_repo.findAll();
	}

}
