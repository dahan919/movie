package service;

import java.util.List;

import config.DBManager;
import dto.CommentaryDTO;
import mapper.CommentaryMapper;

public class CommentaryService {

	private static CommentaryService instance = new CommentaryService();
	private CommentaryMapper mapper;
	
	private CommentaryService() {
		mapper = DBManager.getInstance().getSession().getMapper(CommentaryMapper.class);
	}
	
	public static CommentaryService getInstance() {
		if(instance == null)
			instance = new CommentaryService();
		return instance;
	}

	public List<CommentaryDTO> selectAllCommentary() {
		return mapper.selectAllCommentary();
	}
	
}
