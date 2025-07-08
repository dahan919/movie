package service;

import java.util.List;

import config.DBManager;
import dto.MovieuserDTO;
import mapper.MovieuserMapper;

public class MovieuserService {
	private static MovieuserService instance = new MovieuserService();
	private MovieuserMapper mapper;
	
	private MovieuserService() {
		mapper= DBManager.getInstance().getSession().getMapper(MovieuserMapper.class);
	}
	
	public static MovieuserService getInstance() {
		if(instance == null)
			instance = new MovieuserService();
		return instance;
	}

	public List<MovieuserDTO> selectAllMovieuser() {
		return mapper.selectAllMovieuser();
	}

}
