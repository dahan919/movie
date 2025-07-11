package service;

import java.util.List;
import java.util.Map;

import config.DBManager;
import dto.CommentaryDTO;
import mapper.CommentaryMapper;

public class CommentaryService {
	
	private static CommentaryService instance = new CommentaryService();
	private CommentaryMapper mapper;

	public CommentaryService() {
		mapper = DBManager.getInstance().getSession().getMapper(CommentaryMapper.class);
	}
	
	public static CommentaryService getInstance() {
		if(instance == null)
			instance = new CommentaryService();
		return instance;
	}

	public List<CommentaryDTO> select3(Map<String, Object> map) {
		return mapper.select3(map);
	}

	public List<CommentaryDTO> selectBySearch(Map<String, Object> map) {
		return mapper.selectBySearch(map);
	}
	
}
