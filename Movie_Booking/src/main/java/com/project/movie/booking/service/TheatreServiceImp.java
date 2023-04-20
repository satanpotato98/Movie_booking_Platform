package com.project.movie.booking.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.booking.DTO.TheatreDTO;
import com.project.movie.booking.VO.TheatreVO;
import com.project.movie.booking.entity.Shows;
import com.project.movie.booking.entity.Theatre;
import com.project.movie.booking.repository.ShowsRepo;
import com.project.movie.booking.repository.TheatreRepo;

@Service
public class TheatreServiceImp implements ITheatreService {
	
	@Autowired
	TheatreRepo theatre_repo;
	
	@Autowired
	ShowsRepo show_repo;

	@Override
	public Theatre addTheatre(TheatreDTO dto) {
		Theatre theatre=new Theatre();
		theatre.setLocation(dto.getLocation());
		theatre.setTheatre_name(dto.getTheatre_name());
		theatre.setCapacity(dto.getCapacity());
		return theatre_repo.save(theatre);
	}

	@Override
	public void deleteTheatreById(int Theatre_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Theatre> findByLocation(String location) {
		// TODO Auto-generated method stub
		return theatre_repo.findBylocation(location);
	}

	@Override
	public Set<TheatreVO> findByMovie(String movie) {
		// TODO Auto-generated method stub
		List<Shows> shows=show_repo.findAll();
		List<Theatre> theatres = new ArrayList<>();
		shows.forEach((show)-> theatres.add(show.getTheatre()));
		Set<TheatreVO> tvo= new HashSet<>();
		TheatreVO vo=new TheatreVO();
		for (Theatre theatre : theatres){
			vo.setTheatre_id(theatre.getTheatre_id());
			vo.setLocation(theatre.getLocation());
			vo.setTheatre_name(theatre.getTheatre_name());
			tvo.add(vo);
		}
		
		return tvo; 
	}
	

	@Override
	public List<Theatre> findAll() {
		// TODO Auto-generated method stub
		return theatre_repo.findAll();
	}

}
