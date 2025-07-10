package service;

import config.DBManager;
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
	
}
